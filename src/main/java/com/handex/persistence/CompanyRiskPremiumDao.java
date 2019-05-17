package com.handex.persistence;

import com.handex.representations.CompanyRiskPremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRiskPremiumDao extends JpaRepository<CompanyRiskPremium, Long> {

    @Query("SELECT a FROM country_risk_premium a WHERE LOWER(a.country) = (:country)")
    CompanyRiskPremium findByCountry(@Param("country") String country);

}

