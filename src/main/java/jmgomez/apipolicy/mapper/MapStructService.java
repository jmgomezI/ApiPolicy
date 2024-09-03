package jmgomez.apipolicy.mapper;

import jmgomez.apipolicy.model.Accident;
import jmgomez.apipolicy.model.Policy;
import jmgomez.apipolicy.model.dto.AccidentDto;
import jmgomez.apipolicy.model.dto.PolicyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapStructService {

    private final MapStructMapper mapStructMapper;

    @Autowired
    public MapStructService(MapStructMapper mapStructMapper) {
        this.mapStructMapper = mapStructMapper;
    }

    public PolicyDto mapPolicyToPolicyDto(Policy policy) {
        return mapStructMapper.mapPolicyToPolicyDto(policy);
    }

    public AccidentDto mapAccidentToAccidentDto(Accident accident) {
        return mapStructMapper.mapAccidentToAccidentDto(accident);
    }
}
