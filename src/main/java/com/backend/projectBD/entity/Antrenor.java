package com.backend.projectBD.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "antrenor")
public class Antrenor {
    @Id
    @Column(name = "antrenor_id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer antrenorId;
    @Column(name = "nume")
    private String numeAntrenor;
    @Column(name = "data_nastere")
    private LocalDate dataNastere;
}
