package jmgomez.apipolicy.service;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;

import java.util.List;

public interface IPolicyService {
    List<Policy> getPolicies(String dni);
    Policy getPolicyByIDs(String id, String userId);
    List<Accident> getAccidents(String id, String userId);
    Accident getAccidentByIDs(String policyId, String accidentId, String userId);
}
