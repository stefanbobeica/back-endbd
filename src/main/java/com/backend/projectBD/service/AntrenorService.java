package com.backend.projectBD.service;

import com.backend.projectBD.entity.Antrenor;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AntrenorService {
    public List<Antrenor> getAntrenori();
    public int insertAntrenor(String numeA,  LocalDate dataA);
    public int deleteAntrenor(String numeA);
    public int updateAntrenor( String oldName, String newName,  LocalDate newDate);
    public String getAntrenorByJucator(String numeJucator);
}
