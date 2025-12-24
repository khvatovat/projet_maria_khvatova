package org.formation.projet_maria_khvatova.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.formation.projet_maria_khvatova.dto.DepotDto;
import org.formation.projet_maria_khvatova.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @PostMapping("/depot")
    public ResponseEntity<Map<String, Object>> deposer(@RequestBody @Valid DepotDto depotDto) {
        double nouveauSolde = compteService.deposer(depotDto);

        return ResponseEntity.ok(Map.of(
                "message", "Dépôt effectué avec succès",
                "nouveauSolde", nouveauSolde
        ));
    }
}