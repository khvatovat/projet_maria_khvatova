package org.formation.projet_maria_khvatova.entity;

import lombok.Data;

@Data
public class CompteCourant extends CompteBancaire {

    private double autorisationDecouvert = 1000.00;

    @Override
    public boolean prelever(double montant) {
        if (getSolde() - montant >= -autorisationDecouvert) {
            setSolde(getSolde() - montant);
            return true;
        }
        return false;
    }
}
