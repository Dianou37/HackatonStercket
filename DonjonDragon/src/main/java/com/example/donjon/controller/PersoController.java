package com.example.donjon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.donjon.entity.Perso;
import com.example.donjon.repository.PersoRepository;

@Controller
public class PersoController {
	
	@Autowired
	private PersoRepository persoRepository;
	
	@RequestMapping("/listPerso")
	public String list(Model model) {
		List<Perso> persos = persoRepository.findAll();
		model.addAttribute("persos", persos);
		return "listPerso";
	}
	
	@GetMapping("/addPerso")
	public String persoForm(Model model) {
		Perso perso = new Perso();
		model.addAttribute("perso", perso);
		return "perso_form";
	}

}
