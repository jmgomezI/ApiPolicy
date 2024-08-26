package jmgomez.apipolicy.service;

import jmgomez.apipolicy.feignClient.PolicyClient;
import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    private final PolicyClient policyClient;

    @Autowired
    public PolicyService(PolicyClient policyClient) {
        this.policyClient = policyClient;
    }

    @Override
    public List<PolicyDto> getPolicies(String id) {
        return policyClient.getPolicies(id);
    }

    @Override
    public PolicyDtoCov getPoliciesByIDs(String id)  {
        return policyClient.getPolicyByIDs(id);
    }

    @Override
    public List<Accident> getAccidentsByPolicies(String id) {
        return policyClient.getAccidentsByPolicies(id);
    }

    @Override
    public Accident getAccidentByPolicies(String policyId, String accidentId) {
        return policyClient.getAccidentByPolicies(policyId, accidentId);
    }
}
