package jmgomez.policyapi.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.http.HttpServletResponse;
import jmgomez.policyapi.feignClient.PolicyClient;
import jmgomez.policyapi.mapper.AccidentMapper;
import jmgomez.policyapi.mapper.PolicyMapper;
import jmgomez.policyapi.model.dto.AccidentDto;
import jmgomez.policyapi.model.dto.PolicyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    @Autowired
    private PolicyClient policyClient;

    @Autowired
    private PolicyMapper policyMapper;

    @Autowired
    private AccidentMapper accidentMapper;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Override
    @CircuitBreaker(name = "policiesCB", fallbackMethod = "fallBackGetPolicies")
    public List<PolicyDto> getPolicies(String userId) {
        return policyMapper.toListDto(policyClient.getPolicies(userId));
    }

    @Override
    @Cacheable("policies")
    @CircuitBreaker(name = "policyCB", fallbackMethod = "fallBackGetPolicy")
    public PolicyDto getPolicyByIDs(String policyId)  {
        return policyMapper.toDto(policyClient.getPolicyByIDs(policyId));
    }

    @Override
    @CircuitBreaker(name = "accidentsCB", fallbackMethod = "fallBackGetAccidents")
    public List<AccidentDto> getAccidents(String policyId) {
        return accidentMapper.toListDto(policyClient.getAccidents(policyId));
    }

    @Override
    @Cacheable("accidents")
    @CircuitBreaker(name = "accidentCB", fallbackMethod = "fallBackGetAccident")
    public AccidentDto getAccidentByIDs(String policyId, String accidentId) {
        return accidentMapper .toDto(policyClient.getAccidentByIDs(accidentId));
    }

    public List<PolicyDto> fallBackGetPolicies(HttpServletResponse response, Throwable t) throws IOException {
        List<PolicyDto> policy = new ArrayList<>();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, t.getMessage());
        return policy;
    }

    public PolicyDto fallBackGetPolicy(HttpServletResponse response, Throwable t) throws IOException {
        PolicyDto policy = new PolicyDto();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, t.getMessage());
        return policy;
    }

    public List<AccidentDto> fallBackGetAccidents(HttpServletResponse response, Throwable t) throws IOException {
        List<AccidentDto> accident = new ArrayList<>();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, t.getMessage());
        return accident;
    }

    public AccidentDto fallBackGetAccident(HttpServletResponse response, Throwable t) throws IOException {
        AccidentDto accident = new AccidentDto();
        response.sendError(HttpServletResponse.SC_NOT_FOUND, t.getMessage());
        return accident;
    }
}
