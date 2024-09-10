package jmgomez.apipolicy.service;

import jmgomez.apipolicy.feignClient.PolicyClient;
import jmgomez.apipolicy.mapper.AccidentMapper;
import jmgomez.apipolicy.mapper.PolicyMapper;
import jmgomez.apipolicy.model.dto.AccidentDto;
import jmgomez.apipolicy.model.dto.PolicyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    @Autowired
    private PolicyClient policyClient;

    @Autowired
    private PolicyMapper policyMapper;

    @Autowired
    private AccidentMapper accidentMapper;

    @Override
    public List<PolicyDto> getPolicies(String userId) {
        return policyMapper.toListDto(policyClient.getPolicies(userId));
    }

    @Override
    @Cacheable("policies")
    public PolicyDto getPolicyByIDs(String policyId)  {
        return policyMapper.toDto(policyClient.getPolicyByIDs(policyId));
    }

    @Override
    public List<AccidentDto> getAccidents(String policyId) {
        return accidentMapper.toListDto(policyClient.getAccidents(policyId));
    }

    @Override
    @CachePut("accidents")
    public AccidentDto getAccidentByIDs(String policyId, String accidentId) {
        return accidentMapper .toDto(policyClient.getAccidentByIDs(accidentId));
    }
}
