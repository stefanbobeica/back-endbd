package com.backend.projectBD.controller;

import com.backend.projectBD.entity.Antrenor;
import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.JucatorView;
import com.backend.projectBD.service.AntrenorServiceImpl;
import com.backend.projectBD.service.JucatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value="/jucator")
public class JucatorController {
    @Autowired
    private JucatorServiceImpl jucatorService;

    @GetMapping(value= "/getAll")
    public List<Jucator> getJucatori(){

        return this.jucatorService.getJucatori();
    }

    @PostMapping(value="/insert")
    public int insertJucator(@RequestBody Jucator jucator){

        return this.jucatorService.insertJucator(jucator);
    }
    @PostMapping(value = "/delete")
    public int deleteJucator(@RequestBody Jucator jucator){

        return this.jucatorService.deleteJucator(jucator.getNumeJucator());
    }

    @PostMapping(value = "/update")
    public int updateAntrenor(@RequestParam(value = "nume") String nume, @RequestBody Jucator newJucator){
        return this.jucatorService.updateJucator(nume, newJucator);
    }

    @GetMapping(value= "/searchJucator")
    public JucatorView searchJucator(@RequestParam String numeJucator){
        return  this.jucatorService.searchJucator(numeJucator);
    }

    @GetMapping(value= "/goluriMarcate")
    public Integer goluriMarcate(@RequestParam String numeJucator){
        return  this.jucatorService.getGoluriMarcateByNume(numeJucator);
    }

}
