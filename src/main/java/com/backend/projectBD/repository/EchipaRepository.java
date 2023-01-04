package com.backend.projectBD.repository;

import com.backend.projectBD.entity.Antrenor;
import com.backend.projectBD.entity.Echipa;
import com.backend.projectBD.entity.Jucator;
import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public interface EchipaRepository  extends JpaRepository<Echipa,Integer> {
    @Query(
            value = "SELECT * FROM echipa",
            nativeQuery = true)
    List<Echipa> getEchipe();

    @Query(
            value="SELECT antrenor.nume FROM antrenor  INNER JOIN echipa ON echipa.id_antrenor = antrenor.antrenor_id WHERE echipa.nume = ?1 ;",
            nativeQuery = true
    ) //1/6 JOIN
    String getNumeAntrenorByEchipa(String numeEchipa);

    @Query(
            value="SELECT jucator.nume FROM jucator INNER JOIN echipa ON echipa.id_echipa = jucator.id_nationala WHERE echipa.nume = ?1 and jucator.nume IS NOT NULL  ;",
            nativeQuery = true
    ) //2/6 JOIN
    List<String> getNumeJucatoriByEchipa(String numeEchipa);

    @Query(
            value="SELECT jucator.pozitie FROM jucator INNER JOIN echipa ON echipa.id_echipa = jucator.id_nationala WHERE echipa.nume = ?1 and jucator.nume IS NOT NULL  ;",
            nativeQuery = true
    )
    List<String> getPozitieJucatoriByEchipa(String numeEchipa);

    @Query(
            value="SELECT DATE(jucator.data_nastere) FROM jucator INNER JOIN echipa ON echipa.id_echipa = jucator.id_nationala WHERE echipa.nume = ?1 and jucator.nume IS NOT NULL  ;",
            nativeQuery = true
    )
    ArrayList<Date> getDataNastereJucatoriByEchipa(String numeEchipa);


    @Query(
            value = "UPDATE echipa SET id_antrenor = ?2   WHERE id_antrenor = ?1    ",
            nativeQuery = true)
    int setIdAntrenor(Integer oldId, Integer newId);



    @Query(
            value = " Select s.denumire from stadion s where s.id_stadion in (select m.id_stadion from meci m where id_oaspeti \n" +
                    "in (Select e.id_echipa from echipa e where e.nume = 'Romania') or id_gazde in (Select e.id_echipa from echipa e where e.nume = ?1))",
            nativeQuery = true)
            // 2/4 QUERRY COMPLEX
    List <String> getStadioaneByEchipa(String numeEchipa);


}
