package org.formation.projet_maria_khvatova.service;

import org.formation.projet_maria_khvatova.dto.VirementDto;

public interface VirementService {
    boolean effectuerVirement(VirementDto virementDto);
}
