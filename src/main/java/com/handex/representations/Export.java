package com.handex.representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties
@Entity(name = "export")
public class Export {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdat", updatable = false)
    @CreationTimestamp
    public Date createdat;

    @Column(name = "company_name")
    public String companyName;

    @Column(name = "email")
    public String email;

    @Column(name = "importer_country")
    public String importerCountry;

    @Column(name = "payment_term")
    public String paymentTerm;

    @Column(name = "contract_value")
    public Integer contractValue;

    @Column(name = "industry_type")
    public String industryType;

    @Column(name = "project_description")
    public String projectDescription;

    public Export(Date createdat, String companyName, String email, String importerCountry, String paymentTerm, Integer contractValue, String industryType, String projectDescription) {
        this.createdat = createdat;
        this.companyName = companyName;
        this.email = email;
        this.importerCountry = importerCountry;
        this.paymentTerm = paymentTerm;
        this.contractValue = contractValue;
        this.industryType = industryType;
        this.projectDescription = projectDescription;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImporterCountry() {
        return importerCountry;
    }

    public void setImporterCountry(String importerCountry) {
        this.importerCountry = importerCountry;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public Integer getContractValue() {
        return contractValue;
    }

    public void setContractValue(Integer contractValue) {
        this.contractValue = contractValue;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
