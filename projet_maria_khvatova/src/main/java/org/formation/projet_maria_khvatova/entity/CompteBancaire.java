package org.formation.projet_maria_khvatova.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public abstract class CompteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroCompte;

    private double solde;

    private LocalDate dateOuverture;

    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
        }
    }

    public abstract boolean prelever(double montant);
}