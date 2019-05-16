package com.handex.persistence;

import com.handex.representations.CompanyRiskPremiums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRiskPremiumsDao extends JpaRepository<CompanyRiskPremiums, Long> {
}

