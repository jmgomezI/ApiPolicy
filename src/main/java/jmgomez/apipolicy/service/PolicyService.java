package jmgomez.apipolicy.service;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class PolicyService implements IPolicyService {

    @Autowired
    private RestTemplate restTemplate;

    private final String url = "http://localhost:8081";

    @Override
    public PolicyDto[] getPolicies(String id) {
        String url = this.url + "/polizas?dni=" + id;
        return this.restTemplate.getForObject(url, PolicyDto[].class);
    }

    @Override
    public PolicyDtoCov getPoliciesByIDs(String id)  {
        String url = this.url + "/polizas/" + id;
        return this.restTemplate.getForObject(url, PolicyDtoCov.class);
    }

    @Override
    public Accident[] getAccidentsByPolicies(String id) {
        String url = this.url + "/polizas/" + id + "/siniestros";
        return this.restTemplate.getForObject(url, Accident[].class);
    }

    @Override
    public Accident getAccidentByPolicies(String policyId, String accidentId) {
        String url = this.url + "/siniestros/" + accidentId;
        return this.restTemplate.getForObject(url, Accident.class);
    }

    public PolicyDto fromPolicyToPolicyDto(Policy policy){
        PolicyDto policyDto = new PolicyDto();
        policyDto.setId(policy.getId());
        policyDto.setDescription(policy.getDescription());
        return policyDto;
    }

    public PolicyDtoCov fromPolicyToPolicyDtoCov(Policy policy){
        PolicyDtoCov policyDtoCov = new PolicyDtoCov();
        policyDtoCov.setId(policy.getId());
        policyDtoCov.setDescription(policy.getDescription());
        policyDtoCov.setCoverages(policy.getCoverages());
        return policyDtoCov;
    }

//    @Override
//    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
//        String urlPolicy = this.url + "/polizas/" + dni;
//
//
//        return User.withUsername(user.getDni())
//                ;
//    }
}
