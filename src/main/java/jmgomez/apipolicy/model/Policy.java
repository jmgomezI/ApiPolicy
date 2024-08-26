package jmgomez.apipolicy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    private User user;
    @JsonProperty("polizaId")
    private String id;
    @JsonProperty("descripcion")
    private String description;
    @JsonProperty("coberturas")
    private List<String> coverages;
    @JsonProperty("condiciones")
    private List<String> conditions;
    @JsonProperty("siniestros")
    private List<Accident> accidents;
}
