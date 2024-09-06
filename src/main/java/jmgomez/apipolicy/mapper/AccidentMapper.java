package jmgomez.apipolicy.mapper;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.dto.AccidentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccidentMapper {

    AccidentDto toDto(Accident accident);

    List<AccidentDto> toListDto(List<Accident> accident);
}
