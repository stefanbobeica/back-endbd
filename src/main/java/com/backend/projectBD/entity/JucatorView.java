package com.backend.projectBD.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JucatorView {
    @Id
    @Column(name = "id_jucator")
    private Integer idJucator;
    @Column(name = "nume")
    private String nume;
    @Column( name = "varsta")
    private Integer varsta;
    @Column (name = "pozitie")
    private String pozitie;
    @Column(name = "nume_echipa")
    private String numeEchipa;

}
