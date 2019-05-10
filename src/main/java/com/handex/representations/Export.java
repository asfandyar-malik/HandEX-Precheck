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
    private Date createdat;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "email")
    private String email;

    @Column(name = "importer_country")
    private String importerCountry;

    @Column(name = "payment_term")
    private String paymentTerm;

    @Column(name = "contract_value")
    private Integer contractValue;

    @Column(name = "industry_type")
    private String industryType;

    @Column(name = "projectDescription")
    private String projectDescription;

}
