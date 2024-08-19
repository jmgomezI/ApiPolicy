package jmgomez.apipolicy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String[] coverages;
    @JsonProperty("condiciones")
    private String[] conditions;
    @JsonProperty("siniestros")
    private Accident[] accidents;
}
