package jmgomez.apipolicy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDto {
    private String policyId;
    private String description;
}
