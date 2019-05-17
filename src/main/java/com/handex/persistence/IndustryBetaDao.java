package com.handex.persistence;

import com.handex.representations.IndustryBeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndustryBetaDao extends JpaRepository<IndustryBeta, Long> {

    @Query("SELECT a FROM industry_beta a WHERE LOWER(a.industryName) = (:industryName)")
    IndustryBeta findByIndustryName(@Param("industryName") String industryName);

    @Query("SELECT a FROM industry_beta a WHERE a.ehNace = :ehNace")
    List<IndustryBeta> findByEHNace(@Param("ehNace") Long ehNace);

    @Query("SELECT v.industryName FROM industry_beta v")
    List<String> findAllIndustryName();

//    @Query("SELECT u FROM IndustryBetas u WHERE (u.ehNace) = (:ehNace)")
//    IndustryBetas findByEh_nace(@Param("ehNace") Long ehNace);

}