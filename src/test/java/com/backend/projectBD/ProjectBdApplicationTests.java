package com.backend.projectBD;

import com.backend.projectBD.entity.Jucator;
import com.backend.projectBD.entity.Rezultat;
import com.backend.projectBD.repository.*;
import com.backend.projectBD.service.AntrenorServiceImpl;
import com.backend.projectBD.service.EchipaService;
import com.backend.projectBD.service.MeciServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectBdApplicationTests {
	@Autowired
	private AntrenorRepository antrenorRepository;
	@Autowired
	private EchipaService echipaService;
	@Autowired
	private JucatorRepository jucatorRepository;
	@Autowired
	private AntrenorServiceImpl antrenorService;
	@Autowired
	private MeciServiceImpl meciService;
	@Autowired
	private RezultatRepository rezultatRepository;
	@Autowired
	private JucatorViewRepository jucatorViewRepository;
	@Test
	void contextLoads() {
	}



	@Test
	public void basicTest(){
		System.out.println(jucatorViewRepository.searchJucator("Martinez Lautaro"));

	}
}
