package org.formation.projet_maria_khvatova.dto;

import java.time.LocalDate;

public record CompteEpargneDto(
        Long numeroCompte,
        double solde,
        LocalDate dateOuverture,
        double tauxRemuneration
) {}
