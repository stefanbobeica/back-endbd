package com.backend.projectBD.service;

import com.backend.projectBD.entity.TopScorers;

import java.util.List;

public interface MeciService {
    List<TopScorers> getTopMarcatoriByEchipa(String numeEchipa);
    List<String> getNumeMarcatoriByMeci(Integer meciId);
}
