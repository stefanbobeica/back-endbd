package com.backend.projectBD.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "echipa")
public class Echipa {
    @Id
    @Column(name = "id_echipa", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer echipaId;
    @Column (name = "nume")
    private String numeEchipa;
    @Column (name = "link_sigla")
    private String linkSigla;
    @OneToOne(targetEntity = Antrenor.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_antrenor")
    private  Antrenor antrenor;
    @OneToMany(
            targetEntity = Jucator.class, cascade = CascadeType.ALL
    )
    @JoinColumn (name = "id_jucator")
    List<Jucator> jucatori;
}
