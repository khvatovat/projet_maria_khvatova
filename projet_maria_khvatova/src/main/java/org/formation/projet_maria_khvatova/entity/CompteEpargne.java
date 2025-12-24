package org.formation.projet_maria_khvatova.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CompteEpargne extends CompteBancaire {

    private double tauxRemuneration = 0.03;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public boolean prelever(double montant) {
        if (getSolde() - montant >= 0) {
            setSolde(getSolde() - montant);
            return true;
        }
        return false;
    }
}