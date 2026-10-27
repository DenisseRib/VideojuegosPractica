package com.dawes.videojuegos.interfaz;

import com.dawes.videojuegos.DTO.videojuegosDTO;

import java.util.ArrayList;

public class IVideojuego {
	public interface IVideojuegoDAO {
		ArrayList<videojuegosDTO> buscarVideojuegos(int id, String titulo, int id_Desarrolladora,
		                                           int fechaLanzamiento, int pegiMax, int Copias);

	}
}
