package com.handex.persistence;

import com.handex.representations.CompanyRiskPremium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRiskPremiumDao extends JpaRepository<CompanyRiskPremium, Long> {
}

