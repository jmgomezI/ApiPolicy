package jmgomez.wiremock.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jmgomez.wiremock.model.Policy;
import jmgomez.wiremock.model.Sinister;
import jmgomez.wiremock.service.PolicyService;
import jmgomez.wiremock.service.SinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/polizas")
    public ResponseEntity<Policy[]> getPoliciesByUsers(@RequestParam String dni) throws JsonProcessingException {
        return ResponseEntity.ok(policyService.getPoliciesByUsers(dni));
    }

    @GetMapping("/polizas/{id}")
    public ResponseEntity<Policy> getPoliciesByIDs(@PathVariable String id) throws JsonProcessingException {
        return ResponseEntity.ofNullable(policyService.getPoliciesByIDs(id));
    }

    @GetMapping("/polizas/{id}/siniestros")
    public ResponseEntity<Sinister[]> getAccidentsByPolicies(@PathVariable String id){
        return ResponseEntity.ofNullable(policyService.getAccidentsByPolicies(id));
    }


}
