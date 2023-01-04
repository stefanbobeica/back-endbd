package com.backend.projectBD.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Rezultat {
    @Id
    @Column(name = "id_meci")
    private Integer id;
    @Column(name = "nume_gazda")
    private String numeGazda;
    @Column(name = "goluri_gazda")
    private Integer goluriGazda;
    @Column(name = "goluri_oaspeti")
    private Integer goluriOaspeti;
    @Column(name = "nume_oaspeti")
    private String numeOaspeti;


}
