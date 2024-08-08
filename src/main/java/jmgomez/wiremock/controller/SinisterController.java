package jmgomez.wiremock.controller;

import jmgomez.wiremock.model.Sinister;
import jmgomez.wiremock.service.SinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SinisterController {

    @Autowired
    private SinisterService sinisterService;

    @GetMapping("/siniestros/{id}")
    public ResponseEntity<Sinister> getSinisterByPolicies(@PathVariable String id){
        return ResponseEntity.ofNullable(sinisterService.getSinisterByPolicies(id));
    }
}
