package com.backend.projectBD.service;

import com.backend.projectBD.entity.Stadion;
import com.backend.projectBD.repository.StadionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadionServiceImpl  implements  StadionService{
    @Autowired
    StadionRepository stadionRepository;

    @Override
    public Stadion getStadionByEchipa(int idMeci) {
        return this.stadionRepository.getStadionByEchipa(idMeci);
    }
}
