package org.formation.projet_maria_khvatova.entity;

import lombok.Data;

@Data
public class CompteEpargne extends CompteBancaire {

    private double tauxRemuneration = 0.03;

    @Override
    public boolean prelever(double montant) {
        if (getSolde() - montant >= 0) {
            setSolde(getSolde() - montant);
            return true;
        }
        return false;
    }
}
