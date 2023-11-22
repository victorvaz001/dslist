package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.entities.dto.GameListDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRespository;
import com.devsuperior.dslist.repositories.GameRespository;


import jakarta.transaction.Transactional;



@Service
public class GameListService {
	
	@Autowired
	private GameListRespository gameListRespository;
	
	@Autowired
	private GameRespository gameRespository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
				
		List<GameList> result = gameListRespository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRespository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRespository.updateBelongingPosition(listId, list.get(i).getId(), i );
		}
	}
}
