package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRespository;

@Service
public class GameService {
	
	@Autowired
	public GameRespository gameRespository;
	
	public List<GameMinDTO> findAll(){
				
		List<Game> result = gameRespository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
