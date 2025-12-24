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
public class CompteCourant extends CompteBancaire {

    private double autorisationDecouvert = 1000.00;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public boolean prelever(double montant) {
        if (getSolde() - montant >= -autorisationDecouvert) {
            setSolde(getSolde() - montant);
            return true;
        }
        return false;
    }
}