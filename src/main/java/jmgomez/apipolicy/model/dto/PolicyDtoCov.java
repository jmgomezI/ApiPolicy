package jmgomez.apipolicy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDtoCov {
    @JsonProperty("polizaId")
    private String id;
    @JsonProperty("descripcion")
    private String description;
    @JsonProperty("coberturas")
    private List<String> coverages;
}
