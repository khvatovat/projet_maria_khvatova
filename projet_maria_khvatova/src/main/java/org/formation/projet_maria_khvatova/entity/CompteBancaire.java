package org.formation.projet_maria_khvatova.entity;

import lombok.Data;

import java.util.Date;

@Data
public abstract class  CompteBancaire {
    private Long numeroCompte;
    private double solde;
    private String nomProprietaire;
    private Date dateOuverture;

    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
        }
    }

    public abstract boolean prelever(double montant);
}
