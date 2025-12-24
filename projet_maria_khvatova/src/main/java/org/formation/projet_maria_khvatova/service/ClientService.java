package org.formation.projet_maria_khvatova.service;

import org.formation.projet_maria_khvatova.dto.ClientCreateDto;
import org.formation.projet_maria_khvatova.dto.ClientDto;
import org.formation.projet_maria_khvatova.dto.ClientUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientDto createClient(ClientCreateDto dto);
    Optional<ClientDto> getClient(Long id);
    List<ClientDto> getAllClients();
    Optional<ClientDto> updateClient(Long id, ClientUpdateDto dto);
    void deleteClient(Long id);
}
