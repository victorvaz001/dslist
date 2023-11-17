package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.entities.dto.GameListDTO;
import com.devsuperior.dslist.entities.dto.GameMinDTO;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	public GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll (){
		
		List<GameListDTO> result = gameListService.findAll();		
		return result;
	}
	
}
