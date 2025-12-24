package org.formation.projet_maria_khvatova.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientCreateDto(
        @NotBlank(message = "Le nom est obligatoire")
        String nom,
        @NotBlank(message = "Le prénom est obligatoire")
        String prenom,
        String adresse,
        String codePostal,
        String ville,
        String telephone
) {}
