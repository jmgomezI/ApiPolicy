package jmgomez.policyapi.mapper;

import jmgomez.policyapi.model.Policy;
import jmgomez.policyapi.model.dto.PolicyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PolicyMapper {

    PolicyDto toDto(Policy policy);

    List<PolicyDto> toListDto(List<Policy> policies);

}
