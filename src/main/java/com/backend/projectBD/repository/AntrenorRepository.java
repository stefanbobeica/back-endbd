package com.backend.projectBD.repository;

import com.backend.projectBD.entity.Antrenor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface AntrenorRepository extends JpaRepository<Antrenor,Integer> {

    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO antrenor (nume,data_nastere)  VALUES( ?1,?2) ",
            nativeQuery = true)
    int insertAntrenor(@Param("numeA") String numeA, @Param("dataA")LocalDate dataA);

    @Query(
            value = "SELECT * FROM antrenor",
            nativeQuery = true)
    List<Antrenor> getAntrenori();

    @Transactional
    @Modifying
    @Query(
          value = "UPDATE antrenor SET data_nastere = ?3 , nume = ?2 WHERE nume = ?1 ",
            nativeQuery = true
    )

    int updateAntrenor(@Param("oldName") String oldName, @Param("newName") String newName, @Param("newData") LocalDate newDate);

    @Transactional
    @Modifying
    @Query(
           value = "DELETE FROM antrenor  WHERE nume = ?1",
            nativeQuery = true
    )
    int deleteAntrenor(@Param("name") String name);

    @Query(
            value = "select a.nume from antrenor a  where\n" +
                    "a.antrenor_id in (select e.id_antrenor from echipa e inner join jucator j on e.id_echipa = j.id_nationala where j.nume =?1 )  \n",
            nativeQuery = true
    ) // 4/4 QUERRY-uri COMPLEXE
    String getAntrenorByJucator(String numeJucator);


}
