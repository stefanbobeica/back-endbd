package com.backend.projectBD.repository;

import com.backend.projectBD.entity.Echipa;
import com.backend.projectBD.entity.Jucator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface JucatorRepository  extends JpaRepository<Jucator,Integer> {
    @Query(
            value = "SELECT * FROM jucator",
            nativeQuery = true)
    List<Jucator> getJucatori();

    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO jucator (nume, data_nastere, pozitie, id_nationala) VALUES (?1,?2,?3, ?4)"  ,
            nativeQuery = true)
    int insertJucator(@Param("numeJ") String numeJ,
                      @Param("dataJ") LocalDate dataJ,
                      @Param("pozitie") String pozitie,
                      @Param("id") Integer id_Nationala );

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE jucator SET data_nastere = ?3 , nume = ?2 , pozitie =?4 , id_nationala=?5 WHERE nume = ?1 ",
            nativeQuery = true
    )

    int updateJucator(@Param("oldName") String oldName,
                       @Param("newName") String newName,
                       @Param("newData") LocalDate newDate,
                       @Param("newPozitie")String newPozitie,
                        @Param("newEchipa") Integer idNewEchipa);


    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM jucator WHERE nume = ?1",
            nativeQuery = true
    )
    int deleteJucator(@Param("name") String name);

    @Query(
            value = "select echipa.nume from echipa inner join jucator on jucator.id_nationala = id_echipa where jucator.nume =?1",
            nativeQuery = true
    )
    String getEchipaByJucator(@Param("name") String name);

    @Query(
            value = "Select SUM(marc.numar_goluri) from marcatori marc  inner join jucator j on marc.id_marcator = j.id_jucator WHERE j.nume =?1",
            nativeQuery = true
    ) // 6/6 QUERRY-uri JOIN
   Integer getGoluriMarcateByNumeJucator(String numeJucator);

}
