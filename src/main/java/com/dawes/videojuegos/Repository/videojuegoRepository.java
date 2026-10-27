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

import java.util.ArrayList;

@Repository
public class videojuegoRepository {
	private static final Logger logger =
			LoggerFactory.getLogger(videojuegoRepository.class);
	private final DataSource dataSource;


	public videojuegoRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public ArrayList<videojuegosDTO> buscarVideojuegos(Integer id, String titulo, Integer id_Desarrolladora,
	                                                   Integer fechaLanzamiento, Integer pegiMax, Integer Copias) throws SQLException {

		String sql =
				"SELECT v.id, v.titulo, v.fecha_lanzamiento, v.pegi, "
						+ "v.id_desarrolladora, d.nombre AS desarrolladora "
						+ "FROM videojuegos v JOIN desarrolladoras d ON v.id_desarrolladora = d.id "
						+ "WHERE v.titulo LIKE ? ";

		ArrayList<videojuegosDTO> listaVideojuegos = new ArrayList<>();

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + titulo + "%");
		ps.setString(2, "%" + id_Desarrolladora + "%");
		ps.setInt(3,  fechaLanzamiento );
		ps.setInt(4, pegiMax);
		ps.setInt(5, Copias );

			logger.debug("Query a ejecutar: {}", ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listaVideojuegos.add(mapearVideojuego(rs));
			}
			connection.close();
		} catch (SQLException e) {
			logger.error("Error al buscar videojuego", e);
			cerrarConexion(connection);
		}
		return listaVideojuegos;
	}
	private videojuegosDTO mapearVideojuego(ResultSet rs) throws SQLException {
		return new videojuegosDTO(
				rs.getInt( "id_Desarrolladora" ),
				rs.getString("titulo" ),

		rs.getInt("fechaLanzamiento" ),
		rs.getInt("pegiMax"),
				rs.getInt( "Copias" )
		);

	}

	private void cerrarConexion(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

}
