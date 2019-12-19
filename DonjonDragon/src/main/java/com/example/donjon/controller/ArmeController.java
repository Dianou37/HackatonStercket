package com.example.donjon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.donjon.entity.Arme;
import com.example.donjon.repository.ArmeRepository;

@Controller
public class ArmeController {
	
	@Autowired
	private ArmeRepository armeRepository;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Arme> armes = armeRepository.findAll();
		model.addAttribute("armes",armes );
		return "list";
	}
	
	@GetMapping("/addArme")
	public String displayForm(Model model) {
		Arme arme = new Arme();
		model.addAttribute("arme",arme);
		return "arme_form";
	}
	@PostMapping("/addArme")
	public String addArme(@Valid Arme arme, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "arme_form";
		}
		armeRepository.save(arme);
		return "redirect:/list";
	}
		
}