package org.formation.projet_maria_khvatova.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.projet_maria_khvatova.dto.ClientCreateDto;
import org.formation.projet_maria_khvatova.dto.ClientDto;
import org.formation.projet_maria_khvatova.dto.ClientUpdateDto;
import org.formation.projet_maria_khvatova.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto createClient(@RequestBody @Valid ClientCreateDto dto) {
        return clientService.createClient(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return clientService.getClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id,
                                                  @RequestBody @Valid ClientUpdateDto dto) {
        return clientService.updateClient(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
