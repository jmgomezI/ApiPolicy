package jmgomez.apipolicy.mapper;

import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.dto.PolicyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PolicyMapper {

    PolicyDto toDto(Policy policy);

    List<PolicyDto> toListDto(List<Policy> policies);

}
