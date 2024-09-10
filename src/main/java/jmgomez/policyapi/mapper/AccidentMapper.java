package jmgomez.policyapi.mapper;

import jmgomez.policyapi.model.Accident;
import jmgomez.policyapi.model.dto.AccidentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccidentMapper {

    AccidentDto toDto(Accident accident);

    List<AccidentDto> toListDto(List<Accident> accident);
}
