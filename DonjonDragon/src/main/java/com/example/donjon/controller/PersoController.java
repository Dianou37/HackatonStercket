package com.example.donjon.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

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
	
	@PostMapping("/addPerso") 
	public String addPerso(@Valid Perso perso, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "perso_form";
		}
		persoRepository.save(perso);
		return "redirect:/listPerso";
		
	}
	 
	@RequestMapping("/showPerso/{id}")
	public String showPerso(@PathVariable long id, Model model) {
		Optional<Perso> result = persoRepository.findById(id);
		if(result.isPresent()) {
			model.addAttribute("perso", result.get());
			return "showPerso";
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Personnage inexistant");
	}
	

}
