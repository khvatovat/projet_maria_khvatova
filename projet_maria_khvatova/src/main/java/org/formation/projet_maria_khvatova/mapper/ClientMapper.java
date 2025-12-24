package org.formation.projet_maria_khvatova.mapper;

import org.formation.projet_maria_khvatova.dto.*;
import org.formation.projet_maria_khvatova.entity.*;

import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    // Entity -> DTO
    ClientDto toDto(Client client);
    CompteCourantDto toDto(CompteCourant compte);
    CompteEpargneDto toDto(CompteEpargne compte);

    // DTO -> Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "compteCourant", ignore = true)
    @Mapping(target = "compteEpargne", ignore = true)
    Client toEntity(ClientCreateDto dto);

    // Update entity from DTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "compteCourant", ignore = true)
    @Mapping(target = "compteEpargne", ignore = true)
    void updateEntity(@MappingTarget Client entity, ClientUpdateDto dto);
}
