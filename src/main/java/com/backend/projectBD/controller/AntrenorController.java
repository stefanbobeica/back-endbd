package com.backend.projectBD.controller;

import com.backend.projectBD.entity.Antrenor;
import com.backend.projectBD.service.AntrenorService;
import com.backend.projectBD.service.AntrenorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="/antrenor")
public class AntrenorController {
    @Autowired
    private AntrenorServiceImpl antrenorService;

    @GetMapping(value= "/getAll")
    public List<Antrenor> getAntrenori(){

        return this.antrenorService.getAntrenori();
    }

    @PostMapping(value="/insert")
    public int insertAntrenor(@RequestBody Antrenor antrenor){

        return this.antrenorService.insertAntrenor(antrenor.getNumeAntrenor(),antrenor.getDataNastere());
    }
    @PostMapping(value = "/delete")
    public int deleteAntrenor(@RequestBody Antrenor antrenor){
        System.out.println(antrenor.getNumeAntrenor());
        return this.antrenorService.deleteAntrenor(antrenor.getNumeAntrenor());
    }

    @PostMapping(value = "/update")
    public int updateAntrenor(@RequestParam String nume, @RequestBody Antrenor newAntrenor){
        return this.antrenorService.updateAntrenor(nume, newAntrenor.getNumeAntrenor(), newAntrenor.getDataNastere());
    }

    @GetMapping(value = "/getAntrenorByJucator")
    public Map<String,String> getStadioaneByEchipa(@RequestParam String numeJucator){
        HashMap<String, String> map = new HashMap<>();
        map.put("numeAntrenor", antrenorService.getAntrenorByJucator(numeJucator));
        return  map;
    }


}
