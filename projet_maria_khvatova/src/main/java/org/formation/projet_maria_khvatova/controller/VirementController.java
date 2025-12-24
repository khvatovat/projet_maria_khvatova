package org.formation.projet_maria_khvatova.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.projet_maria_khvatova.dto.VirementDto;
import org.formation.projet_maria_khvatova.service.VirementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("virements")
@RequiredArgsConstructor
public class VirementController {

    private final VirementService virementService;

    @PostMapping
    public ResponseEntity<String> effectuerVirement(@RequestBody @Valid VirementDto virementDto) {
        boolean success = virementService.effectuerVirement(virementDto);

        if (success) {
            return ResponseEntity.ok("Virement effectué avec succès");
        } else {
            return ResponseEntity.badRequest().body("Virement refusé: fonds insuffisants");
        }
    }
}
