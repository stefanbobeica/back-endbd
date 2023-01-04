package com.backend.projectBD.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Embeddable
public class MarcatoriKey implements Serializable {
    @Column(name = "id_marcator", nullable = false)
    private Integer marcatorId ;

    @Column(name = "id_meci", nullable = false)
    private Integer meciId;

}
