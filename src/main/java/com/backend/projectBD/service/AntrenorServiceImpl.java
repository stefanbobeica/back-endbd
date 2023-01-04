package com.backend.projectBD.service;

import com.backend.projectBD.entity.Antrenor;
import com.backend.projectBD.repository.AntrenorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class AntrenorServiceImpl implements  AntrenorService{
    @Autowired
    private AntrenorRepository antrenorRepository;

    @Override
    public List<Antrenor> getAntrenori() {

        return  this.antrenorRepository.getAntrenori();
    }

    @Override
    public int insertAntrenor(String numeA,  LocalDate dataA){
        return this.antrenorRepository.insertAntrenor(numeA,dataA);
    }

    @Override
    public int deleteAntrenor(String numeA){
        return this.antrenorRepository.deleteAntrenor(numeA);
    }

    @Override
    public int updateAntrenor( String oldName, String newName,  LocalDate newDate){
        return this.antrenorRepository.updateAntrenor(oldName, newName, newDate);
    }

    @Override
    public String getAntrenorByJucator(String numeJucator) {
        return this.antrenorRepository.getAntrenorByJucator(numeJucator);
    }
}
