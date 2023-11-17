package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.entities.dto.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRespository;



@Service
public class GameListService {
	
	@Autowired
	public GameListRespository gameListRespository;
	
	public List<GameListDTO> findAll(){
				
		List<GameList> result = gameListRespository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
