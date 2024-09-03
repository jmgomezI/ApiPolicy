package jmgomez.apipolicy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    private String polizaId;
    private String descripcion;
}
