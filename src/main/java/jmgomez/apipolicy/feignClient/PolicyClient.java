package jmgomez.apipolicy.feignClient;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "policyClient", url = "http://localhost:8081")
public interface PolicyClient {

    @GetMapping(value = "/polizas?dni={id}")
    List<Policy> getPolicies(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{id}")
    Policy getPolicyByIDs(@PathVariable("id") String id);

    @GetMapping(value = "/polizas/{id}/siniestros")
    List<Accident> getAccidents(@PathVariable("id") String id);

    @GetMapping(value = "/siniestros/{accidentId}")
    Accident getAccidentByIDs(@PathVariable("accidentId") String accidentId);
}
