package org.formation.projet_maria_khvatova.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.formation.projet_maria_khvatova.entity.Client;
import org.formation.projet_maria_khvatova.entity.CompteBancaire;
import org.formation.projet_maria_khvatova.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client updateClient(Client client) {
        if (client.getId() == null || clientRepository.findById(client.getId()).isEmpty()) {
            throw new RuntimeException("Client not found.");
        }
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Optional<Client> clientOpt = clientRepository.findById(id);

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            clientRepository.delete(client);
            System.out.println("Client with Id " + id + " deleted.");

        } else {
            System.out.println("Attempted to delete non-existent client with ID: " + id);
        }
    }
}
