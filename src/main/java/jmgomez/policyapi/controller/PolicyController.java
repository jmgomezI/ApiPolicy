package jmgomez.policyapi.controller;

import jmgomez.policyapi.model.dto.AccidentDto;
import jmgomez.policyapi.model.dto.PolicyDto;
import jmgomez.policyapi.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping("/policies")
    public List<PolicyDto> getPolicies() {
            return policyService.getPolicies(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/policies/{policyId}")
    public PolicyDto getPolicyByIDs(@PathVariable("policyId") String policyId) {
            return policyService.getPolicyByIDs(policyId);

    }

    @GetMapping("/policies/{policyId}/accidents")
    public List<AccidentDto> getAccidents(@PathVariable("policyId") String policyId){
            return policyService.getAccidents(policyId);
    }

    @GetMapping("/policies/{policyId}/accidents/{accidentId}")
    public AccidentDto getAccidentByIDs(@PathVariable("policyId") String policyId, @PathVariable("accidentId") String accidentId){
            return policyService.getAccidentByIDs(policyId, accidentId);
    }
}
