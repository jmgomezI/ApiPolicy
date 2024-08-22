package jmgomez.apipolicy.feignClient;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "policyClient", url = "http://localhost:8081")
public interface PolicyClient {

    @GetMapping(value = "/polizas?dni={id}", headers = "Accept-application/json")
    PolicyDto[] getPolicies(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{id}", headers = "Accept-application/json")
    PolicyDtoCov getPolicyByIDs(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{id}/siniestros", headers = "Accept-application/json")
    Accident[] getAccidentsByPolicies(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{policyId}/siniestros/{accidentId}", headers = "Accept-application/json")
    Accident getAccidentByPolicies(@PathVariable("policyId") String policyId, @PathVariable("accidentId") String accidentId);
}
