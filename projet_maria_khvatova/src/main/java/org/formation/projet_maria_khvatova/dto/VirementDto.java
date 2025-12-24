package org.formation.projet_maria_khvatova.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record VirementDto(
        @NotNull(message = "Le compte source est obligatoire")
        Long compteSourceId,
        @NotNull(message = "Le compte destination est obligatoire")
        Long compteDestinationId,
        @Min(value = 1, message = "Le montant doit être supérieur à 0")
        double montant
) {}
