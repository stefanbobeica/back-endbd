package com.backend.projectBD.controller;

import com.backend.projectBD.entity.Rezultat;
import com.backend.projectBD.entity.Stadion;
import com.backend.projectBD.service.StadionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/stadion")
public class StadionController {
    @Autowired
    StadionServiceImpl stadionService;

    @GetMapping(value = "/getStadion")
    public Stadion getStadion(@RequestParam  int numeGazde){
        return this.stadionService.getStadionByEchipa(numeGazde);
    }
}
