package jmgomez.apipolicy.service;

import jmgomez.apipolicy.feignClient.PolicyClient;
import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService implements IPolicyService {

    private final PolicyClient policyClient;

    @Autowired
    public PolicyService(PolicyClient policyClient) {
        this.policyClient = policyClient;
    }

    @Override
    public PolicyDto[] getPolicies(String id) {
        return policyClient.getPolicies(id);
    }

    @Override
    public PolicyDtoCov getPoliciesByIDs(String id)  {
        return policyClient.getPolicyByIDs("12345" + id);
    }

    @Override
    public Accident[] getAccidentsByPolicies(String id) {
        return policyClient.getAccidentsByPolicies("12345" + id);
    }

    @Override
    public Accident getAccidentByPolicies(String policyId, String accidentId) {
        return policyClient.getAccidentByPolicies("12345" + policyId, accidentId);
    }
}
