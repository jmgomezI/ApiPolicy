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

    private final String url = "http://localhost:8081";

    @Override
    public Policy[] getPoliciesByUsers(String dni) {
        String url = this.url + "/polizas?dni=" + dni;
        if (dni == null){
            return null;
        }
        return this.restTemplate.getForObject(url, Policy[].class);
    }

    @Override
    public Policy getPoliciesByIDs(String id)  {
        String url = this.url + "/polizas/" + id;
        return this.restTemplate.getForObject(url, Policy.class);
    }

    @Override
    public Sinister[] getAccidentsByPolicies(String id) {
        String url = this.url + "/polizas/" + id + "/siniestros";
        return this.restTemplate.getForObject(url, Sinister[].class);
    }

    @Override
    public Sinister getSinisterByPolicies(String policyId, String sinisterId) {
        String url = this.url + "/siniestros/" + sinisterId;
        return this.restTemplate.getForObject(url, Sinister.class);
    }
}
