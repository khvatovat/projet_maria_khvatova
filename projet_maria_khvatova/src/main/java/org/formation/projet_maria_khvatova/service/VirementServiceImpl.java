package org.formation.projet_maria_khvatova.service;

import lombok.RequiredArgsConstructor;
import org.formation.projet_maria_khvatova.dto.VirementDto;
import org.formation.projet_maria_khvatova.entity.CompteBancaire;
import org.formation.projet_maria_khvatova.repository.CompteBancaireRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VirementServiceImpl implements VirementService {

    private final CompteBancaireRepository compteBancaireRepository;

    @Override
    @Transactional
    public boolean effectuerVirement(VirementDto virementDto) {
        CompteBancaire compteSource = compteBancaireRepository
                .findById(virementDto.compteSourceId())
                .orElseThrow(() -> new RuntimeException("Compte source non trouvé"));

        CompteBancaire compteDestination = compteBancaireRepository
                .findById(virementDto.compteDestinationId())
                .orElseThrow(() -> new RuntimeException("Compte destination non trouvé"));

        boolean prelevementOk = compteSource.prelever(virementDto.montant());

        if (!prelevementOk) {
            return false;
        }

        compteDestination.deposer(virementDto.montant());

        return true;
    }
}
