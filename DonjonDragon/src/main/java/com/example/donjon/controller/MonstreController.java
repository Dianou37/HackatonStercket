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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.donjon.entity.Monstre;
import com.example.donjon.repository.MonstreRepository;

@Controller
public class MonstreController {
		
		@Autowired
		private MonstreRepository monstreRepository;
		
		@RequestMapping("/listMonstre")
		public String list(Model model) {
			List<Monstre> monstres = monstreRepository.findAll();
			model.addAttribute("monstres",monstres);
			return "listMonstre";
		}
	
		@GetMapping("/add")
		public String displayForm(Model model) {
			Monstre monstre = new Monstre();
			model.addAttribute("monstre",monstre);
			return "monstre_form";
		}
	
		@PostMapping("/add")
		public String addMonstre(@Valid Monstre monstre, BindingResult bindingResult, Model model) {
			if(bindingResult.hasErrors()) {
				return "monstre_form";
			}
			monstreRepository.save(monstre);
			return "redirect:/listMonstre";
		}
		
		@RequestMapping("/show/{id}")
		public String show(@PathVariable long id, Model model) {
			Optional<Monstre> result = monstreRepository.findById(id);
			if(result.isPresent()) {
			model.addAttribute("monstre", result.get());
			return "show";
	}
	throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Monstre inexistant");
	}
}
