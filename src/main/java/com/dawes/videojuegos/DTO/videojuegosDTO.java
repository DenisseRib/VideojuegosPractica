package com.dawes.videojuegos.DTO;

import java.time.LocalDate;

public class videojuegosDTO {
private int id;
private String titulo;
LocalDate fechaLanzamiento;
private int pegi;
private int id_Desarrolladora;
private int id_Copia;

	public videojuegosDTO(int id, String titulo, LocalDate fechaLanzamiento, int pegi, int id_Desarrolladora) {
		this.id = id;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.pegi = pegi;
		this.id_Desarrolladora = id_Desarrolladora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getfechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setfechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public int getId_Desarrolladora() {
		return id_Desarrolladora;
	}

	public void setId_Desarrolladora(int id_Desarrolladora) {
		this.id_Desarrolladora = id_Desarrolladora;
	}

	public int getId_Copia() {
		return id_Copia;
	}

	public void setId_Copia(int id_Copia) {
		this.id_Copia = id_Copia;
	}
}
