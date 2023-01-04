package com.backend.projectBD.repository;

import com.backend.projectBD.entity.Meci;
import com.backend.projectBD.entity.Rezultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RezultatRepository extends JpaRepository<Rezultat, Integer> {

    @Query(
            value = "SELECT a.id_meci, b.nume AS nume_gazda, goluri_gazda ,a.goluri_oaspeti, c.nume AS nume_oaspeti \n" +
                    "FROM meci a\n" +
                    "INNER JOIN echipa b ON a.id_gazde = b.id_echipa\n" +
                    "INNER JOIN echipa c ON a.id_oaspeti = c.id_echipa",
            nativeQuery = true
    ) //3/6 JOIN
    List<Rezultat> getRezultate();
}
