package com.dawes.videojuegos.interfaz;

import com.dawes.videojuegos.DTO.videojuegosDTO;

import java.sql.SQLException;
import java.util.ArrayList;


	public interface IVideojuegoDAO {
		ArrayList<videojuegosDTO> buscarVideojuegos(Integer id, String titulo, Integer id_Desarrolladora,
		                                            Integer fechaLanzamiento, Integer pegiMax, Integer Copias) throws SQLException;

	}

