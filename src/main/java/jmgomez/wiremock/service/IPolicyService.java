package jmgomez.wiremock.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jmgomez.wiremock.model.Policy;
import jmgomez.wiremock.model.Sinister;

import java.io.IOException;
import java.util.List;

public interface IPolicyService {
    Policy[] getPoliciesByUsers(String dni) throws IOException;
    Policy getPoliciesByIDs(String id) throws JsonProcessingException;
    Sinister[] getAccidentsByPolicies(String id);
    Sinister getSinisterByPolicies(String policyId, String sinisterId);
}
