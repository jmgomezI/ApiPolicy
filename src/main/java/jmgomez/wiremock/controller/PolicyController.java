package jmgomez.wiremock.controller;

import jmgomez.wiremock.model.Policy;
import jmgomez.wiremock.model.Sinister;
import jmgomez.wiremock.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/policies")
    public ResponseEntity<Policy[]> getPoliciesByUsers(@RequestParam String dni) {
        return ResponseEntity.ok(policyService.getPoliciesByUsers(dni));
    }

    @GetMapping("/policies/{id}")
    public ResponseEntity<Policy> getPoliciesByIDs(@PathVariable String id) {
        return ResponseEntity.ofNullable(policyService.getPoliciesByIDs(id));
    }

    @GetMapping("/policies/{id}/accidents")
    public ResponseEntity<Sinister[]> getAccidentsByPolicies(@PathVariable String id){
        return ResponseEntity.ofNullable(policyService.getAccidentsByPolicies(id));
    }

    @GetMapping("/policies/{policyId}/accidents/{sinisterId}")
    public ResponseEntity<Sinister> getSinisterByPolicies(@PathVariable String policyId, @PathVariable String sinisterId){
        return ResponseEntity.ofNullable(policyService.getSinisterByPolicies(policyId, sinisterId));
    }
}
