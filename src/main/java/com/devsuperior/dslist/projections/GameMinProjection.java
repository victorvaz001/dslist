package com.devsuperior.dslist.projections;

public interface GameMinProjection {
	
	/*Metodos get para cada da consulta SQL*/
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
