package com.handex.representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties
@Entity(name = "industry_betas")
public class IndustryBetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "industry_name")
    public String industryName;

    @Column(name = "eh_equivalent_industry_name_english")
    public String ehEquivalentIndustryNameEnglish;

    @Column(name = "eh_equivalent_industry_name_germany")
    public String getEhEquivalentIndustryNameGermany;

    @Column(name = "eh_nace")
    public Integer ehNace;

    @Column(name = "true_nace")
    public String trueNace;

    @Column(name = "levered_beta")
    public Double leveredBeta;

    @Column(name = "average_levered_beta")
    public String averageLeveredBeta;

    public IndustryBetas(){

    }

    @Override
    public String toString() {
        return "IndustryBetas{" +
                "id=" + id +
                ", industryName='" + industryName + '\'' +
                ", ehEquivalentIndustryNameEnglish='" + ehEquivalentIndustryNameEnglish + '\'' +
                ", getEhEquivalentIndustryNameGermany='" + getEhEquivalentIndustryNameGermany + '\'' +
                ", ehNace=" + ehNace +
                ", trueNace='" + trueNace + '\'' +
                ", leveredBeta=" + leveredBeta +
                ", averageLeveredBeta='" + averageLeveredBeta + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getEhEquivalentIndustryNameEnglish() {
        return ehEquivalentIndustryNameEnglish;
    }

    public void setEhEquivalentIndustryNameEnglish(String ehEquivalentIndustryNameEnglish) {
        this.ehEquivalentIndustryNameEnglish = ehEquivalentIndustryNameEnglish;
    }

    public String getGetEhEquivalentIndustryNameGermany() {
        return getEhEquivalentIndustryNameGermany;
    }

    public void setGetEhEquivalentIndustryNameGermany(String getEhEquivalentIndustryNameGermany) {
        this.getEhEquivalentIndustryNameGermany = getEhEquivalentIndustryNameGermany;
    }

    public Integer getEhNace() {
        return ehNace;
    }

    public void setEhNace(Integer ehNace) {
        this.ehNace = ehNace;
    }

    public String getTrueNace() {
        return trueNace;
    }

    public void setTrueNace(String trueNace) {
        this.trueNace = trueNace;
    }

    public Double getLeveredBeta() {
        return leveredBeta;
    }

    public void setLeveredBeta(Double leveredBeta) {
        this.leveredBeta = leveredBeta;
    }

    public String getAverageLeveredBeta() {
        return averageLeveredBeta;
    }

    public void setAverageLeveredBeta(String averageLeveredBeta) {
        this.averageLeveredBeta = averageLeveredBeta;
    }
}
