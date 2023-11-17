package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.entities.dto.GameMinDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRespository;



@Service
public class GameService {
	
	@Autowired
	public GameRespository gameRespository;
	
	@Transactional(readOnly = true)  
	public GameDTO findById (Long id) {
		
		Game result = gameRespository.findById(id).get(); 	
		return new GameDTO(result); 
	}
	
	@Transactional(readOnly = true)  
	public List<GameMinDTO> findAll(){
				
		List<Game> result = gameRespository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)  
	public List<GameMinDTO> findByList(Long listId){
				
		List<GameMinProjection> result = gameRespository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
