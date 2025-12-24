package org.formation.projet_maria_khvatova.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DepotDto(
        @NotNull(message = "Le numéro de compte est obligatoire")
        Long numeroCompte,
        @Min(value = 1, message = "Le montant doit être supérieur à 0")
        double montant
) {}