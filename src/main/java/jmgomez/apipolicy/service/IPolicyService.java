package jmgomez.apipolicy.service;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;

import java.io.IOException;
import java.util.List;

public interface IPolicyService {
    List<PolicyDto> getPolicies(String dni);
    PolicyDtoCov getPoliciesByIDs(String id);
    List<Accident> getAccidentsByPolicies(String id);
    Accident getAccidentByPolicies(String policyId, String accidentId);
}
