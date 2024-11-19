package dev.norby.amatur.match;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    MatchDTO toDTO(Match match);
    Match toEntity(MatchDTO matchDTO);
}
