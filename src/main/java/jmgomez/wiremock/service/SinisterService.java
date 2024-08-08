package jmgomez.wiremock.service;

import jmgomez.wiremock.model.Sinister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SinisterService implements ISinisterService{

    @Autowired
    private RestTemplate restTemplate;

    private final String urlPolicy = "http://localhost:8081";

    @Override
    public Sinister getSinisterByPolicies(String id) {
        String url = urlPolicy + "/siniestros/" + id;
        return this.restTemplate.getForObject(url, Sinister.class);
    }
}
