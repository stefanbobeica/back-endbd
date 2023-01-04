package com.backend.projectBD.repository;

import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.Trofeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrofeuRepository extends JpaRepository<Trofeu,Integer> {
    @Query(
            value = "SELECT * FROM trofeu",
            nativeQuery = true)
    List<Trofeu> getTrofee();
}
