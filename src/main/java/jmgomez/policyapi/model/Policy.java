package jmgomez.policyapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @JsonProperty("polizaId")
    private String policyId;
    @JsonProperty("descripcion")
    private String description;
}
