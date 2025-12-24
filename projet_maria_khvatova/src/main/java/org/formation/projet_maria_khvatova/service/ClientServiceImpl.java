package org.formation.projet_maria_khvatova.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.formation.projet_maria_khvatova.dto.ClientCreateDto;
import org.formation.projet_maria_khvatova.dto.ClientDto;
import org.formation.projet_maria_khvatova.dto.ClientUpdateDto;
import org.formation.projet_maria_khvatova.entity.Client;
import org.formation.projet_maria_khvatova.entity.CompteCourant;
import org.formation.projet_maria_khvatova.entity.CompteEpargne;
import org.formation.projet_maria_khvatova.mapper.ClientMapper;
import org.formation.projet_maria_khvatova.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public ClientDto createClient(ClientCreateDto dto) {
        Client client = clientMapper.toEntity(dto);

        CompteCourant compteCourant = new CompteCourant();
        compteCourant.setClient(client);
        compteCourant.setDateOuverture(LocalDate.now());
        compteCourant.setSolde(0);
        client.setCompteCourant(compteCourant);

        CompteEpargne compteEpargne = new CompteEpargne();
        compteEpargne.setClient(client);
        compteEpargne.setDateOuverture(LocalDate.now());
        compteEpargne.setSolde(0);
        client.setCompteEpargne(compteEpargne);

        Client saved = clientRepository.save(client);
        return clientMapper.toDto(saved);
    }

    @Override
    public Optional<ClientDto> getClient(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto);
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public Optional<ClientDto> updateClient(Long id, ClientUpdateDto dto) {
        return clientRepository.findById(id)
                .map(client -> {
                    clientMapper.updateEntity(client, dto);
                    return clientMapper.toDto(client);
                });
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
