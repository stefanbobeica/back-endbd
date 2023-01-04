package com.backend.projectBD.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class TopScorers {
    private String nume;
    private Integer nr_goluri;
}
