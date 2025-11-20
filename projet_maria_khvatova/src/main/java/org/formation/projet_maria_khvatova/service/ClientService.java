package org.formation.projet_maria_khvatova.service;

import org.formation.projet_maria_khvatova.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllClients();
    Client createClient(Client client);
    Optional<Client> getClient(Long id, String nom, String prenom);

    void updateClient(Client client, Long id, String nom, String prenom);
}
