package jmgomez.policyapi.service;

import jmgomez.policyapi.model.dto.AccidentDto;
import jmgomez.policyapi.model.dto.PolicyDto;

import java.util.List;

public interface IPolicyService {
    List<PolicyDto> getPolicies(String dni);
    PolicyDto getPolicyByIDs(String id);
    List<AccidentDto> getAccidents(String id);
    AccidentDto getAccidentByIDs(String policyId, String accidentId);
}
