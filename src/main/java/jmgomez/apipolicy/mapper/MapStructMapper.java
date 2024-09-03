package jmgomez.apipolicy.mapper;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.dto.AccidentDto;
import jmgomez.apipolicy.model.dto.PolicyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    @Mapping(target = "policyId", source = "polizaId")
    @Mapping(target = "description", source = "descripcion")
    PolicyDto mapPolicyToPolicyDto(Policy policy);

    @Mapping(target = "sinisterId", source = "siniestroId")
    @Mapping(target = "status", source = "estado")
    AccidentDto mapAccidentToAccidentDto(Accident accident);
}
