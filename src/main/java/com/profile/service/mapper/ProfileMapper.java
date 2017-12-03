package com.profile.service.mapper;

import com.profile.domain.*;
import com.profile.service.dto.ProfileDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Profile and its DTO ProfileDTO.
 */
@Mapper(componentModel = "spring", uses = {LocationMapper.class, SubjectMapper.class, LanguageMapper.class, LevelMapper.class})
public interface ProfileMapper extends EntityMapper<ProfileDTO, Profile> {

    @Mapping(source = "location.id", target = "locationId")
    ProfileDTO toDto(Profile profile); 

    @Mapping(source = "locationId", target = "location")
    @Mapping(target = "educations", ignore = true)
    @Mapping(target = "experiences", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "awards", ignore = true)
    Profile toEntity(ProfileDTO profileDTO);

    default Profile fromId(Long id) {
        if (id == null) {
            return null;
        }
        Profile profile = new Profile();
        profile.setId(id);
        return profile;
    }
}
