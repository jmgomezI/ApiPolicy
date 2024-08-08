package jmgomez.wiremock.service;

import jmgomez.wiremock.model.Sinister;
import org.springframework.stereotype.Service;

public interface ISinisterService {

    Sinister getSinisterByPolicies(String id);
}
