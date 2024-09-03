package jmgomez.apipolicy.controller;

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
        return policyService.getPolicies(getUserId());
    }

    @GetMapping("/policies/{policyId}")
    public PolicyDto getPolicyByIDs(@PathVariable("policyId") String id) {
        return policyService.getPolicyByIDs(id);
    }

    @GetMapping("/policies/{policyId}/accidents")
    public List<AccidentDto> getAccidents(@PathVariable("policyId") String policyId){
        return policyService.getAccidents(policyId);
    }

    @GetMapping("/policies/{policyId}/accidents/{accidentId}")
    public AccidentDto getAccidentByIDs(@PathVariable("policyId") String policyId, @PathVariable("accidentId") String accidentId){
        return policyService.getAccidentByIDs(policyId, accidentId);
    }

    public String getUserId(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
