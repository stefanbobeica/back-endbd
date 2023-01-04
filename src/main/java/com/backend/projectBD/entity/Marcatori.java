package com.backend.projectBD.entity;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "marcatori")
public class Marcatori {

    @EmbeddedId
    private  MarcatoriKey myKey;
    @Column(name = "numar_goluri")
    private  Integer numarGoluri;

}
