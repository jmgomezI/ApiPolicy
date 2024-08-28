package jmgomez.apipolicy.controller;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.dto.AccidentDto;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/policies")
    public List<PolicyDto> getPolicies() {
        return policyService.getPolicies(getUserId()).stream().map(this::changePolicyToPolicyDto).toList();
    }

    @GetMapping("/policies/{id}")
    public PolicyDto getPolicyByIDs(@PathVariable("id") String id) {
        return changePolicyToPolicyDto(policyService.getPolicyByIDs(id, getUserId()));
    }

    @GetMapping("/policies/{id}/accidents")
    public List<AccidentDto> getAccidents(@PathVariable("id") String id){
        return policyService.getAccidents(id, getUserId()).stream().map(this::changeAccidentToAccidentDto).toList();
    }

    @GetMapping("/policies/{policyId}/accidents/{accidentId}")
    public AccidentDto getAccidentByIDs(@PathVariable("policyId") String policyId, @PathVariable("accidentId") String accidentId){
        return changeAccidentToAccidentDto(policyService.getAccidentByIDs(policyId, accidentId, getUserId()));
    }

    public String getUserId(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public PolicyDto changePolicyToPolicyDto(Policy policy) {
        return new PolicyDto(policy.getPolicyId(), policy.getDescription());
    }

    public AccidentDto changeAccidentToAccidentDto(Accident accident) {
        return new AccidentDto(accident.getSinisterId(), accident.getStatus());
    }
}
