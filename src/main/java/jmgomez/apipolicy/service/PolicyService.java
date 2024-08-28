package jmgomez.apipolicy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jmgomez.apipolicy.feignClient.PolicyClient;
import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    private final PolicyClient policyClient;

    @Autowired
    private ObjectMapper defaultObject;

    @Autowired
    public PolicyService(PolicyClient policyClient) {
        this.policyClient = policyClient;
    }

    @Override
    public List<Policy> getPolicies(String id) {
        return policyClient.getPolicies(id);
    }

    @Override
    public Policy getPolicyByIDs(String id, String userId)  {
        if(!("12345" + userId).equals(id)) {
            return null;
        } else {
            return policyClient.getPolicyByIDs(id);
        }
    }

    @Override
    public List<Accident> getAccidents(String id, String userId) {
        if(!("12345" + userId).equals(id)) {
            return null;
        } else {
            return policyClient.getAccidents(id);
        }
    }

    @Override
    public Accident getAccidentByIDs(String policyId, String accidentId, String userId) {
        if(!("12345" + userId).equals(policyId) || !("A12345" + userId).equals(accidentId)) {
            return null;
        } else {
            return policyClient.getAccidentByIDs(accidentId);
        }
    }


}
