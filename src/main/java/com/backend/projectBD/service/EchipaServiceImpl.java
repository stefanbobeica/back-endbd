package com.backend.projectBD.service;

import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.Rezultat;
import com.backend.projectBD.repository.EchipaRepository;
import com.backend.projectBD.repository.MeciRepository;
import com.backend.projectBD.repository.RezultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EchipaServiceImpl implements  EchipaService {
    @Autowired
    private EchipaRepository echipaRepository;
    @Autowired
    private RezultatRepository rezultatRepository;
    @Override
    public List<Jucator> getJucatoriByEchipa(String numeEchipa){
        ArrayList <Jucator> jucatori = new ArrayList<Jucator>();

        for(int i = 0; i < echipaRepository.getNumeJucatoriByEchipa(numeEchipa).size(); i++ ){
          List<String> nume = echipaRepository.getNumeJucatoriByEchipa(numeEchipa);
            List<String> pozitie = echipaRepository.getPozitieJucatoriByEchipa(numeEchipa);
           // List<Date> date = echipaRepository.getDataNastereJucatoriByEchipa(numeEchipa);
            Jucator aux = new Jucator().builder()
                    .numeJucator(nume.get(i))
                    .pozitie(pozitie.get(i))
                    .build();
            jucatori.add(aux);
        }

        return jucatori;
    }

    public String getNumeAntrenorByEchipa(String numeEchipa ){
        return this.echipaRepository.getNumeAntrenorByEchipa(numeEchipa);
    }

    public List<Rezultat> getRezultate(){
        return this.rezultatRepository.getRezultate();
    }
    public List<String> getStadioaneByEchipa(String numeEchipa){
        return this.echipaRepository.getStadioaneByEchipa(numeEchipa);
    }
}
