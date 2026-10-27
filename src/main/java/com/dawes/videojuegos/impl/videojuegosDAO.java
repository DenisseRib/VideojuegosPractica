package com.dawes.videojuegos.impl;

import com.dawes.videojuegos.DTO.videojuegosDTO;
import com.dawes.videojuegos.Repository.videojuegoRepository;
import com.dawes.videojuegos.interfaz.IVideojuegoDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;


	@Repository
	public class videojuegosDAO  implements IVideojuegoDAO {
		private final videojuegoRepository videojuegoRepository;
		public videojuegosDAO( videojuegoRepository videojuegoRepository) {
			this.videojuegoRepository = videojuegoRepository;
			;
		}


		@Override
		public ArrayList<videojuegosDTO> buscarVideojuegos(Integer id, String titulo, Integer id_Desarrolladora, Integer fechaLanzamiento, Integer pegiMax, Integer Copias) throws SQLException {
			return videojuegoRepository.buscarVideojuegos( id,  titulo,  id_Desarrolladora,  fechaLanzamiento,  pegiMax, Copias);
		}
	}


