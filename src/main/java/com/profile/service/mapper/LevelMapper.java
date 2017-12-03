package com.profile.service.mapper;

import com.profile.domain.*;
import com.profile.service.dto.LevelDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Level and its DTO LevelDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LevelMapper extends EntityMapper<LevelDTO, Level> {

    

    @Mapping(target = "profiles", ignore = true)
    Level toEntity(LevelDTO levelDTO);

    default Level fromId(Long id) {
        if (id == null) {
            return null;
        }
        Level level = new Level();
        level.setId(id);
        return level;
    }
}
