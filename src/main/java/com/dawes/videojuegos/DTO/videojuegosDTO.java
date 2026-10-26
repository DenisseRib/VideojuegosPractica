package com.dawes.videojuegos.DTO;

import java.time.LocalDate;

public class videojuegosDTO {
private int id;
private String titulo;
LocalDate fechaNacimiento;
private int pegi;
private int id_Desarrolladora;
private int id_Copia;

	public videojuegosDTO(int id, String titulo, LocalDate fechaNacimiento, int pegi, int id_Desarrolladora) {
		this.id = id;
		this.titulo = titulo;
		this.fechaNacimiento = fechaNacimiento;
		this.pegi = pegi;
		this.id_Desarrolladora = id_Desarrolladora;
	}


}
