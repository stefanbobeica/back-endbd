package com.backend.projectBD.controller;

import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.TopScorers;
import com.backend.projectBD.service.MeciServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/meci")
public class MeciController {
    @Autowired
    MeciServiceImpl meciService;

    @GetMapping(value = "/getTopScorersByEchipa")
    public List<TopScorers> getTopScorersByEchipa(@RequestParam String numeEchipa){
        return this.meciService.getTopMarcatoriByEchipa(numeEchipa);
    }
    @GetMapping(value = "/getMarcatoriByMeci")
    public List<String> getMarcatoriByMeci(@RequestParam Integer idMeci){
        return this.meciService.getNumeMarcatoriByMeci(idMeci);
    }
}
