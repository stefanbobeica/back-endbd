package com.backend.projectBD.service;

import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.JucatorView;
import com.backend.projectBD.repository.JucatorRepository;
import com.backend.projectBD.repository.JucatorViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JucatorServiceImpl implements  JucatorService{
    @Autowired
    JucatorRepository jucatorRepository;
    @Autowired
    JucatorViewRepository jucatorViewRepository;
    @Override
    public List<Jucator> getJucatori() {
        return this.jucatorRepository.getJucatori();
    }

    @Override
    public int insertJucator(Jucator jucator) {
        return this.jucatorRepository.insertJucator(
                jucator.getNumeJucator(),
                jucator.getDataNastere(),
                jucator.getPozitie(),
                jucator.getIdEchipa()
        );
    }

    @Override
    public int updateJucator(String oldName,Jucator jucator) {
        return this.jucatorRepository.updateJucator(
                oldName,
                jucator.getNumeJucator(),
                jucator.getDataNastere(),
                jucator.getPozitie(),
                jucator.getIdEchipa()
        );
    }

    @Override
    public int deleteJucator(String nume) {
        return  this.jucatorRepository.deleteJucator(nume);
    }

    @Override
    public String getEchipaByJucator(String numeJucator) {
        return this.jucatorRepository.getEchipaByJucator(numeJucator);
    }

    @Override
    public JucatorView searchJucator(String numeJucator) {
        return this.jucatorViewRepository.searchJucator(numeJucator);
    }

    @Override
    public Integer getGoluriMarcateByNume(String numeJucator) {
        return this.jucatorRepository.getGoluriMarcateByNumeJucator(numeJucator);
    }

}
