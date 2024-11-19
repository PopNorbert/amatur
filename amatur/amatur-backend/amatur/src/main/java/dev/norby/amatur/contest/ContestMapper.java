package dev.norby.amatur.contest;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContestMapper {
    ContestMapper INSTANCE = Mappers.getMapper(ContestMapper.class);

    ContestDTO toDTO(Contest contest);

    Contest toEntity(ContestDTO contestDTO);
}
