package jmgomez.apipolicy.controller;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
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

    @GetMapping("/policies/{id}")
    public PolicyDtoCov getPolicyByIDs(@PathVariable("id") String id) {
        return policyService.getPoliciesByIDs(id);
    }

    @GetMapping("/policies/{id}/accidents")
    public List<Accident> getAccidentsByPolicies(@PathVariable("id") String id){
        return policyService.getAccidentsByPolicies(id);
    }

    @GetMapping("/policies/{policyId}/accidents/{accidentId}")
    public Accident getAccidentByPolicies(@PathVariable("policyId") String policyId, @PathVariable("accidentId") String accidentId){
        return policyService.getAccidentByPolicies(policyId, accidentId);
    }

    public String getUserId(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
