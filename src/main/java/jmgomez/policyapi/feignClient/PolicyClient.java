package jmgomez.policyapi.feignClient;

import jmgomez.policyapi.model.Accident;
import jmgomez.policyapi.model.Policy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "policyClient", url = "${policyApi.services.policies.baseURL}")
public interface PolicyClient {

    @GetMapping(value = "/polizas?dni={userId}")
    List<Policy> getPolicies(@PathVariable("userId") String id);

    @GetMapping(value = "/polizas/{policyId}")
    Policy getPolicyByIDs(@PathVariable("policyId") String id);

    @GetMapping(value = "/polizas/{policyId}/siniestros")
    List<Accident> getAccidents(@PathVariable("policyId") String policyId);

    @GetMapping(value = "/siniestros/{accidentId}")
    Accident getAccidentByIDs(@PathVariable("accidentId") String accidentId);
}
