package com.handex.representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonIgnoreProperties
@Entity(name = "country_risk_premiums")
public class CompanyRiskPremiums {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    public String country;

    @Column(name = "rating_based_default_spread")
    public String ratingBasedDefaultSpread;

    @Column(name = "total_equity_risk_premium")
    public String total_equity_riskPremium;

    @Column(name = "country_risk_premium")
    public String countryRiskPremium;

    @Override
    public String toString() {
        return "CompanyRiskPremiums{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", ratingBasedDefaultSpread='" + ratingBasedDefaultSpread + '\'' +
                ", total_equity_riskPremium='" + total_equity_riskPremium + '\'' +
                ", countryRiskPremium='" + countryRiskPremium + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRatingBasedDefaultSpread() {
        return ratingBasedDefaultSpread;
    }

    public void setRatingBasedDefaultSpread(String ratingBasedDefaultSpread) {
        this.ratingBasedDefaultSpread = ratingBasedDefaultSpread;
    }

    public String getTotal_equity_riskPremium() {
        return total_equity_riskPremium;
    }

    public void setTotal_equity_riskPremium(String total_equity_riskPremium) {
        this.total_equity_riskPremium = total_equity_riskPremium;
    }

    public String getCountryRiskPremium() {
        return countryRiskPremium;
    }

    public void setCountryRiskPremium(String countryRiskPremium) {
        this.countryRiskPremium = countryRiskPremium;
    }
}
