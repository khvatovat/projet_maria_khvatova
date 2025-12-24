package org.formation.projet_maria_khvatova.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private CompteCourant compteCourant;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private CompteEpargne compteEpargne;
}
