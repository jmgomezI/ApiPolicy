package jmgomez.wiremock.service;

import jmgomez.wiremock.model.Policy;
import jmgomez.wiremock.model.Sinister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PolicyService implements IPolicyService {

    @Autowired
    private RestTemplate restTemplate;

    private final String urlPolicy = "http://localhost:8081";

    @Override
    public Policy[] getPoliciesByUsers(String dni)  {
        String url = urlPolicy + "/polizas?dni=" + dni;
        return this.restTemplate.getForObject(url, Policy[].class);
    }

    @Override
    public Policy getPoliciesByIDs(String id)  {
        String url = urlPolicy + "/polizas/" + id;
        return this.restTemplate.getForObject(url, Policy.class);
    }

    @Override
    public Sinister[] getAccidentsByPolicies(String id) {
        String url = urlPolicy + "/polizas/" + id + "/siniestros";
        return this.restTemplate.getForObject(url, Sinister[].class);
    }


}
