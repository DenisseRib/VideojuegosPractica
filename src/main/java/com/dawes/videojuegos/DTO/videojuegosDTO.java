package com.dawes.videojuegos.DTO;

public class videojuegosDTO {
	private Integer id;
	private String titulo;
	private Integer fechaLanzamiento;
	private Integer pegiMax;
	private Integer id_Desarrolladora;
	private Integer copia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Integer fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Integer getPegiMax() {
		return pegiMax;
	}

	public void setPegiMax(Integer pegiMax) {
		this.pegiMax = pegiMax;
	}

	public Integer getId_Desarrolladora() {
		return id_Desarrolladora;
	}

	public void setId_Desarrolladora(Integer id_Desarrolladora) {
		this.id_Desarrolladora = id_Desarrolladora;
	}

	public Integer getCopia() {
		return copia;
	}

	public void setCopia(Integer copia) {
		this.copia = copia;
	}

	public videojuegosDTO(Integer id, String titulo, Integer fechaLanzamiento, Integer pegiMax, Integer id_Desarrolladora) {
		this.id = id;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.pegiMax = pegiMax;
		this.id_Desarrolladora = id_Desarrolladora;
		this.copia = copia;
	}
}