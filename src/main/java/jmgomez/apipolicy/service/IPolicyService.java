package jmgomez.apipolicy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;

import java.io.IOException;

public interface IPolicyService {
    PolicyDto[] getPolicies(String dni);
    PolicyDtoCov getPoliciesByIDs(String id);
    Accident[] getAccidentsByPolicies(String id);
    Accident getAccidentByPolicies(String policyId, String accidentId);
}
