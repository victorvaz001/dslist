package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.entities.dto.GameMinDTO;
import com.devsuperior.dslist.service.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	public GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll (){
		
		List<GameMinDTO> result = gameService.findAll();		
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById (@PathVariable Long id){
		
		GameDTO result = gameService.findById(id);		
		return result;
	}
}
