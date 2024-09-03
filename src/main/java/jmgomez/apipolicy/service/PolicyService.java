package jmgomez.apipolicy.service;

import jmgomez.apipolicy.feignClient.PolicyClient;
import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.dto.AccidentDto;
import jmgomez.apipolicy.model.dto.PolicyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    @Autowired
    private PolicyClient policyClient;

    @Override
    public List<PolicyDto> getPolicies(String userId) {
        return policyClient.getPolicies(userId).stream().map(policy -> changePolicyToPolicyDto(policy)).toList();
    }
    //@PreAuthorize("#id == authentication.name")
    @Override
    public PolicyDto getPolicyByIDs(String policyId)  {
        return changePolicyToPolicyDto(policyClient.getPolicyByIDs(policyId));
    }

    @Override
    public List<AccidentDto> getAccidents(String policyId) {
        return policyClient.getAccidents(policyId).stream().map(accident -> changeAccidentToAccidentDto(accident)).toList();
    }

    @Override
    public AccidentDto getAccidentByIDs(String policyId, String accidentId) {
        return changeAccidentToAccidentDto(policyClient.getAccidentByIDs(accidentId));
    }

    public PolicyDto changePolicyToPolicyDto(Policy policy) {
        return new PolicyDto(policy.getPolicyId(), policy.getDescription());
    }

    public AccidentDto changeAccidentToAccidentDto(Accident accident) {
        return new AccidentDto(accident.getSinisterId(), accident.getStatus());
    }
}
