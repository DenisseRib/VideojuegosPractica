package com.dawes.videojuegos.Repository;

import com.dawes.videojuegos.DTO.videojuegosDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public class videojuegoRepository {
	private static final Logger logger =
			LoggerFactory.getLogger(videojuegoRepository.class);
	private final DataSource dataSource;


	public videojuegoRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public ArrayList<videojuegosDTO> buscarVideojuegos(String titulo, Integer idDesarrolladora,
	                                                   Integer anioDesde, Integer pegiMax, boolean soloConCopias) {

		StringBuilder sql = new StringBuilder(
				"SELECT v.id, v.titulo, v.fecha_lanzamiento, v.pegi, "
						+ "v.id_desarrolladora, d.nombre AS desarrolladora "
						+ "FROM videojuegos v JOIN desarrolladoras d ON v.id_desarrolladora = d.id "
						+ "WHERE v.titulo LIKE ? ");

		ArrayList<Object> params = new ArrayList<>();
		params.add("%" + (titulo == null ? "" : titulo.trim()) + "%");

		if (idDesarrolladora != null && idDesarrolladora > 0) {
			sql.append("AND v.id_desarrolladora = ? ");
			params.add(idDesarrolladora);
		}
		if (anioDesde != null) {
			sql.append("AND YEAR(v.fecha_lanzamiento) >= ? ");
			params.add(anioDesde);
		}
		if (pegiMax != null) {
			sql.append("AND v.pegi <= ? ");
			params.add(pegiMax);
		}
		if (soloConCopias) {
			sql.append("AND EXISTS (SELECT 1 FROM copias c "
					+ "WHERE c.id_videojuego = v.id AND c.disponible = 1) ");
		}
		sql.append("ORDER BY v.titulo");

		ArrayList<videojuegosDTO> listaVideojuegos = new ArrayList<>();

		Object Conexion = null;
		try (Connection con = Conexion.getConexion();
		     PreparedStatement ps = con.prepareStatement(sql.toString())) {

			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					videojuegosDTO v = new videojuegosDTO();
					v.setId(rs.getInt("id"));
					v.setTitulo(rs.getString("titulo"));
					v.setFechaLanzamiento(rs.getDate("fecha_lanzamiento").toLocalDate());
					v.setPegi(rs.getInt("pegi"));
					v.setIdDesarrolladora(rs.getInt("id_desarrolladora"));
					v.setDesarrolladora(rs.getString("desarrolladora"));
					listaVideojuegos.add(v);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaVideojuegos;
	}
}
