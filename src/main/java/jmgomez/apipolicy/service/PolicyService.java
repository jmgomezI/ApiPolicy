package jmgomez.apipolicy.service;

import jmgomez.apipolicy.feignClient.PolicyClient;
import jmgomez.apipolicy.mapper.MapStructService;
import jmgomez.apipolicy.model.dto.AccidentDto;
import jmgomez.apipolicy.model.dto.PolicyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    @Autowired
    private PolicyClient policyClient;

    @Autowired
    private MapStructService mapStructService;

    @Override
    public List<PolicyDto> getPolicies(String userId) {
        return policyClient.getPolicies(userId).stream().map(policy -> mapStructService.mapPolicyToPolicyDto(policy)).toList();
    }
    //@PreAuthorize("#id == authentication.name")
    @Override
    public PolicyDto getPolicyByIDs(String policyId)  {
        return mapStructService.mapPolicyToPolicyDto(policyClient.getPolicyByIDs(policyId));
    }

    @Override
    public List<AccidentDto> getAccidents(String policyId) {
        return policyClient.getAccidents(policyId).stream().map(accident -> mapStructService.mapAccidentToAccidentDto(accident)).toList();
    }

    @Override
    public AccidentDto getAccidentByIDs(String policyId, String accidentId) {
        return mapStructService.mapAccidentToAccidentDto(policyClient.getAccidentByIDs(accidentId));
    }
}
