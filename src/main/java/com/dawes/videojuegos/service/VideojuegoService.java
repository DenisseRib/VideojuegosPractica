package com.dawes.videojuegos.service;


import com.dawes.videojuegos.DTO.videojuegosDTO;
import com.dawes.videojuegos.interfaz.IVideojuegoDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class VideojuegoService {
	private final IVideojuegoDAO videojuegosDAO;

	public VideojuegoService(IVideojuegoDAO videojuegosDAO) {
		this.videojuegosDAO = videojuegosDAO;

	}

	public ArrayList<videojuegosDTO> buscarVideojuegos( Integer id, String titulo, Integer id_Desarrolladora,  Integer fechaLanzamiento,  Integer  pegiMax,  Integer Copias ) throws SQLException {
		return videojuegosDAO.buscarVideojuegos(  id,  titulo,  id_Desarrolladora,  fechaLanzamiento,  pegiMax,  Copias);
	}


}
