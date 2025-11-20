package org.formation.projet_maria_khvatova.repository;

import org.formation.projet_maria_khvatova.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByName(String nom, String prenom);
}
