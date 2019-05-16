package com.handex.persistence;

import com.handex.representations.IndustryBetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IndustryBetasDao extends JpaRepository<IndustryBetas, Long> {

    @Query("SELECT u FROM IndustryBetas u WHERE LOWER(u.industry_name) = (:industry_name)")
    IndustryBetas findByIndustryName(@Param("industry_name") String industryName);

//    @Query("SELECT u FROM IndustryBetas u WHERE u.eh_nace = :eh_nace")
//    ArrayList<IndustryBetas> findByEhNace(@Param("eh_nace") Integer eh_nace);

//    @Query("SELECT u FROM Person u WHERE LOWER(u.email) = LOWER(:email)")
//    Person findByEmail(@Param("email") String email);
}

