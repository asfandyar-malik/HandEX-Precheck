package com.handex.persistence;

import com.handex.representations.IndustryBeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IndustryBetaDao extends JpaRepository<IndustryBeta, Long> {

//    @Query("SELECT a FROM IndustryBetas a WHERE LOWER(a.industry_name) = (:industry_name)")
//    IndustryBetas findByIndustry_name(@Param("industry_name") String industry_name);

//    @Query("SELECT u FROM IndustryBetas u WHERE (u.ehNace) = (:ehNace)")
//    IndustryBetas findByEh_nace(@Param("ehNace") Long ehNace);

//    @Query("SELECT u FROM IndustryBetas u WHERE (u.ehNace) = (:ehNace)")
//    IndustryBetas findBySpecificId(@Param("ehNace") Long ehNace);
//
//    @Query("SELECT u FROM Person u WHERE LOWER(u.email) = LOWER(:email)")
//    IndustryBetas findByEHNace(@Param("email") String email);

//    @Query("SELECT u FROM LocationPerson u WHERE (u.person_id) = (:person_id)")
//    LocationPerson findByPerson_id(@Param("person_id") Long person_id);

//    @Query("SELECT u FROM IndustryBetas u WHERE u.eh_nace = :eh_nace")
//    ArrayList<IndustryBetas> findByEhNace(@Param("eh_nace") Integer eh_nace);
}