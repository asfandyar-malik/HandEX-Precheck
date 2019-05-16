package com.handex.persistence;

import com.handex.representations.IndustryBetas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustryBetasDao extends JpaRepository<IndustryBetas, Long> {
}

