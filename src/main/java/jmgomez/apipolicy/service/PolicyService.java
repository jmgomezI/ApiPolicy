package jmgomez.apipolicy.service;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.User;
import jmgomez.apipolicy.model.dto.PolicyDto;
import jmgomez.apipolicy.model.dto.PolicyDtoCov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    @Autowired
    private RestTemplate restTemplate;

    List<User> users = new ArrayList<>(Arrays.asList(
            new User("00000000T","12345"),
            new User("00000000R", "54321")
    ));

    private final String url = "http://localhost:8081";

    @Override
    public PolicyDto[] getPolicies() {
        String url = this.url + "/polizas";
        //users.stream().filter(user -> user.getDni())
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

//    @Override
//    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
//        String urlPolicy = this.url + "/polizas/" + dni;
//
//
//        return User.withUsername(user.getDni())
//                ;
//    }
}
