package com.backend.projectBD.service;

import com.backend.projectBD.entity.TopScorers;
import com.backend.projectBD.repository.MeciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeciServiceImpl implements  MeciService {
    @Autowired
    private MeciRepository meciRepository;


    @Override
    public ArrayList<TopScorers> getTopMarcatoriByEchipa(String numeEchipa) {
        ArrayList<TopScorers> list = new ArrayList<TopScorers>();
        TopScorers aux;
        for(int i = 0; i < meciRepository.getGoluriMarcatoriByEchipa(numeEchipa).size(); i++){
            aux = new TopScorers(meciRepository.getNumeMarcatoriByEchipa(numeEchipa).get(i),meciRepository.getGoluriMarcatoriByEchipa(numeEchipa).get(i));
            list.add(aux);
        }

        return list;
    }

    @Override
    public List<String> getNumeMarcatoriByMeci(Integer meciId) {
        return this.meciRepository.getMarcatoriByMeci(meciId);
    }
}
