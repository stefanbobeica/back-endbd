package com.backend.projectBD.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "jucator")
public class Jucator {
    @Id
    @Column(name = "id_jucator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jucatorId;
    @Column(name = "nume")
    private String numeJucator;
    @Column(name= "data_nastere")
    private LocalDate dataNastere;
    @Column(name="pozitie")
    private String pozitie;
    @Column(name ="id_nationala")
    private Integer idEchipa;


}
