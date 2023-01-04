package com.backend.projectBD.service;

import com.backend.projectBD.entity.Jucator;

import java.util.ArrayList;
import java.util.List;


public interface EchipaService {
    public List<Jucator> getJucatoriByEchipa(String numeEchipa);
    public String getNumeAntrenorByEchipa(String numeEchipa);
    public List<String> getStadioaneByEchipa(String numeEchipa);
}
