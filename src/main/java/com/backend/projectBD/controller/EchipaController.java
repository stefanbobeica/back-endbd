package com.backend.projectBD.controller;

import com.backend.projectBD.entity.Antrenor;
import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.Rezultat;
import com.backend.projectBD.service.EchipaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/echipa")
public class EchipaController {
    @Autowired
    EchipaServiceImpl echipaService;

    @GetMapping(value = "/getJucatoriByEchipa")
    public List<Jucator> getJucatoriByEchipa(@RequestParam String nume){
        return this.echipaService.getJucatoriByEchipa(nume);
    }
    @GetMapping(value= "/getNumeAntrenorByEchipa")
    public Map<String,String> getNumeAntrenorByEchipa(@RequestParam String numeEchipa){
        HashMap<String, String> map = new HashMap<>();
        map.put("numeAntrenor",echipaService.getNumeAntrenorByEchipa(numeEchipa));
        return map;
    }
    @GetMapping(value = "/getRezultate")
    public List<Rezultat> getRezultate(){
        return this.echipaService.getRezultate();
    }
    @GetMapping(value = "/getStadioaneByEchipa")
    public List<String> getStadioaneByEchipa(@RequestParam String numeEchipa){
        return this.echipaService.getStadioaneByEchipa(numeEchipa);
    }

}
