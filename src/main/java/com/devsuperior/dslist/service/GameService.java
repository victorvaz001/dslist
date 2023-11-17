package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.entities.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRespository;



@Service
public class GameService {
	
	@Autowired
	public GameRespository gameRespository;
	
	@Transactional(readOnly = true)  /*Assegura que o banco não sera bloqueado por escrita(fica mais rapido), mportar do springframework*/
	public GameDTO findById (Long id) {
		
		Game result = gameRespository.findById(id).get(); /*.get() para pegar o game que está dentro do optional*/	
		return new GameDTO(result); /*Convertendo para DTO*/
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
				
		List<Game> result = gameRespository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
