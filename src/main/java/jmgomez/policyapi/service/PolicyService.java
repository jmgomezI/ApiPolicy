package jmgomez.policyapi.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jmgomez.policyapi.feignClient.PolicyClient;
import jmgomez.policyapi.mapper.AccidentMapper;
import jmgomez.policyapi.mapper.PolicyMapper;
import jmgomez.policyapi.model.dto.AccidentDto;
import jmgomez.policyapi.model.dto.PolicyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PolicyService implements IPolicyService {

    private final PolicyClient policyClient;

    private final PolicyMapper policyMapper;

    private final AccidentMapper accidentMapper;

    @Override
    @CircuitBreaker(name = "policyServiceCB")
    public List<PolicyDto> getPolicies(String userId) {
        return policyMapper.toListDto(policyClient.getPolicies(userId));
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
