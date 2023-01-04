package com.backend.projectBD.service;


import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.JucatorView;

import java.util.List;

public interface JucatorService {
    public List<Jucator> getJucatori();
    public  int insertJucator(Jucator jucator);
    public  int updateJucator(String oldName,Jucator jucator);
    public    int deleteJucator(String nume);
    public String getEchipaByJucator(String numeJucator);
    public JucatorView searchJucator(String numeJucator);
    public Integer getGoluriMarcateByNume(String numeJucator);
}
