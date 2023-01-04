package com.backend.projectBD.repository;

import com.backend.projectBD.entity.JucatorView;
import com.backend.projectBD.entity.Rezultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JucatorViewRepository extends JpaRepository<JucatorView, Integer> {

    @Query(
            value = "select j.id_jucator, j.nume, TIMESTAMPDIFF(YEAR, j.data_nastere, CURDATE()) AS  varsta, j.pozitie, e.nume as nume_echipa  from jucator j inner join echipa e on j.id_nationala = e.id_echipa where j.nume = ?1",
            nativeQuery = true)
    JucatorView searchJucator(String nume);
            //4/6 QUERRY JOIN
}
