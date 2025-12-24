package org.formation.projet_maria_khvatova.dto;

public record ClientDto(
        Long id,
        String nom,
        String prenom,
        String adresse,
        String codePostal,
        String ville,
        String telephone,
        CompteCourantDto compteCourant,
        CompteEpargneDto compteEpargne
) {}
