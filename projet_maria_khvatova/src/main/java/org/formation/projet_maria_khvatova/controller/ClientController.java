package org.formation.projet_maria_khvatova.controller;

import lombok.RequiredArgsConstructor;
import org.formation.projet_maria_khvatova.entity.Client;
import org.formation.projet_maria_khvatova.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("clients")
    List<Client> getClients() {
        return clientService.getAllClients();
    }

    @PostMapping("clients")
    Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("clients/{id}")
    ResponseEntity<Client> getClient(@PathVariable Long id) {
        Optional<Client> client = clientService.getClient(id);
        return client.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("clients/{id}")
    ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        client.setId(id);

        try {
            Client updatedClient = clientService.updateClient(client);
            return ResponseEntity.ok(updatedClient);
        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("clients/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}