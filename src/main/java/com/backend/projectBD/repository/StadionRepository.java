package com.backend.projectBD.repository;

import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.Stadion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StadionRepository extends JpaRepository<Stadion, Integer> {
    @Query(
            value = "SELECT * FROM stadion",
            nativeQuery = true)
    List<Stadion> getStadioane();

    @Query(
            value = "select s.id_stadion, s.locatie, s.denumire from stadion s  inner join meci m  on m.id_stadion= s.id_stadion where m.id_meci = ?1",
            nativeQuery = true) // 5/6 JOIN
    Stadion getStadionByEchipa(int idMeci);


}
