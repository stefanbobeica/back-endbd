package com.backend.projectBD.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "stadion")
public class Stadion {
    @Id
    @Column(name = "id_stadion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stadionId;
    @Column(name="locatie")
    private String locatie;
    @Column (name="denumire")
    private String denumire;

}
