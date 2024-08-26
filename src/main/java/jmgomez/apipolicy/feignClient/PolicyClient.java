package jmgomez.apipolicy.feignClient;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "policyClient", url = "http://localhost:8081")
public interface PolicyClient {

    @GetMapping(value = "/polizas?dni={id}")
    List<PolicyDto> getPolicies(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{id}")
    PolicyDtoCov getPolicyByIDs(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{id}/siniestros")
    List<Accident> getAccidentsByPolicies(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{policyId}/siniestros/{accidentId}")
    Accident getAccidentByPolicies(@PathVariable("policyId") String policyId, @PathVariable("accidentId") String accidentId);
}
