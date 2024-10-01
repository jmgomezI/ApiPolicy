package jmgomez.policyapi.service;

import feign.RetryableException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jmgomez.policyapi.exception.ServiceUnavailableException;
import jmgomez.policyapi.feignclient.PolicyClient;
import jmgomez.policyapi.mapper.AccidentMapper;
import jmgomez.policyapi.mapper.PolicyMapper;
import jmgomez.policyapi.model.dto.AccidentDto;
import jmgomez.policyapi.model.dto.PolicyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyService implements IPolicyService {

    private final PolicyClient policyClient;
    private final PolicyMapper policyMapper;
    private final AccidentMapper accidentMapper;

    @Override
    @CircuitBreaker(name = "policyServiceCB")
    public List<PolicyDto> getPolicies(String userId) {
        try {
            return policyMapper.toListDto(policyClient.getPolicies(userId));
        } catch (RetryableException e) {
            throw new ServiceUnavailableException("Service unavailable");
        }
    }

    @Override
    @Cacheable("policies")
    @CircuitBreaker(name = "policyServiceCB")
    public PolicyDto getPolicyByIDs(String policyId) {
        return policyMapper.toDto(policyClient.getPolicyByIDs(policyId));
    }

    @Override
    @CircuitBreaker(name = "policyServiceCB")
    public List<AccidentDto> getAccidents(String policyId) {
        return accidentMapper.toListDto(policyClient.getAccidents(policyId));
    }

    @Override
    @Cacheable("accidents")
    @CircuitBreaker(name = "policyServiceCB")
    public AccidentDto getAccidentByIDs(String policyId, String accidentId) {
        return accidentMapper.toDto(policyClient.getAccidentByIDs(accidentId));

    }
}
