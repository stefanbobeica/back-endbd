package com.backend.projectBD.repository;

import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.Meci;
import com.backend.projectBD.entity.Rezultat;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Map;

@Repository
public interface MeciRepository extends JpaRepository<Meci, Integer> {
    @Query(
            value = "SELECT * FROM meci",
            nativeQuery = true)
    List<Meci> getMeci();

    @Query(
        value = "select  j.nume  from jucator j, marcatori m where\n" +
                "j.id_jucator = m.id_marcator and j.nume IN \n" +
                "(select jucator.nume from jucator inner join echipa on jucator.id_nationala = echipa.id_echipa where echipa.nume = ?1  ) group by j.nume order by SUM(m.numar_goluri) desc",
        nativeQuery = true
    )
    List<String> getNumeMarcatoriByEchipa(String numeEchipa);

    @Query(
            value = "select SUM(m.numar_goluri)   from jucator j, marcatori m where\n" +
                    "j.id_jucator = m.id_marcator and j.nume IN \n" +
                    "(select jucator.nume from jucator inner join echipa on jucator.id_nationala = echipa.id_echipa where echipa.nume = ?1  ) group by j.nume order by SUM(m.numar_goluri) desc",
            nativeQuery = true
    ) // 1/4 QUERRY subcerere
    List<Integer> getGoluriMarcatoriByEchipa(String numeEchipa);


    @Query(
            value = "select j.nume from jucator j where j.id_jucator \n" +
            "in (select mar.id_marcator from marcatori mar where mar.id_meci \n" +
            "in (select me.id_oaspeti from meci me where id_oaspeti \n" +
            ") and mar.id_meci = ?1 )",
            nativeQuery = true
    ) // 3/4 QUERRY subcerere
    List<String> getMarcatoriByMeci(Integer id);


}
