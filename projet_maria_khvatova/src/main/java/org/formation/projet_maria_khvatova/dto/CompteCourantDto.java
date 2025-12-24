package org.formation.projet_maria_khvatova.dto;

import java.time.LocalDate;

public record CompteCourantDto(
        Long numeroCompte,
        double solde,
        LocalDate dateOuverture,
        double autorisationDecouvert
) {}
