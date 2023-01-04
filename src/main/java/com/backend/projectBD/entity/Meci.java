package com.backend.projectBD.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "meci")

public class Meci {
    @Id
    @Column(name = "id_meci")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer meciId;
    @Column(name="id_stadion")
    private Integer stadionId;
    @Column(name="goluri_gazda")
    private Integer goluriGazda;
    @Column(name="goluri_oaspeti")
    private Integer goluriOaspeti;
    @Column(name= "id_oaspeti")
    private Integer idOaspeti;
    @Column (name="id_gazde")
    private Integer idGazde;
}
