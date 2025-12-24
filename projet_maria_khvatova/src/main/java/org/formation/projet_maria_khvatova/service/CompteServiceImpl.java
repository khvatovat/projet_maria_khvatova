package org.formation.projet_maria_khvatova.service;

import lombok.RequiredArgsConstructor;
import org.formation.projet_maria_khvatova.dto.DepotDto;
import org.formation.projet_maria_khvatova.entity.CompteBancaire;
import org.formation.projet_maria_khvatova.repository.CompteBancaireRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteBancaireRepository compteBancaireRepository;

    @Override
    @Transactional
    public double deposer(DepotDto depotDto) {
        CompteBancaire compte = compteBancaireRepository
                .findById(depotDto.numeroCompte())
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        compte.deposer(depotDto.montant());

        return compte.getSolde();
    }
}