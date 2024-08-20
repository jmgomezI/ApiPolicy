package jmgomez.apipolicy.controller;

import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
import jmgomez.apipolicy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/policies")
    public PolicyDto[] getPolicies() {
        return policyService.getPolicies(getUserId());
    }

    @GetMapping("/policies/{id}")
    public PolicyDtoCov getPolicyByIDs(@PathVariable String id) {
        return policyService.getPoliciesByIDs(getUserId());
    }

    @GetMapping("/policies/{id}/accidents")
    public Accident[] getAccidentsByPolicies(@PathVariable String id){
        return policyService.getAccidentsByPolicies(getUserId());
    }

    @GetMapping("/policies/{policyId}/accidents/{accidentId}")
    public Accident getAccidentByPolicies(@PathVariable String policyId, @PathVariable String accidentId){
        return policyService.getAccidentByPolicies(getUserId(), getUserId());
    }

    public String getUserId(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
