package org.formation.projet_maria_khvatova.dto;

public record ClientUpdateDto(
        String nom,
        String prenom,
        String adresse,
        String codePostal,
        String ville,
        String telephone
) {}
