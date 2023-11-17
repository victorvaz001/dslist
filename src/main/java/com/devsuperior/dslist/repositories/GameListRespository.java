package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

public interface GameListRespository extends JpaRepository<GameList, Long> {

}
