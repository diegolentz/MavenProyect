package ar.com.proyect.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.proyect.daos.ArticuloDao;
import ar.com.proyect.daos.DB.AdminConexiones;
import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.domain.Articulo;

public class ArticuloDaoIMPL implements ArticuloDao {
	private Connection connection;

	public ArticuloDaoIMPL() {
		try {
			this.connection = AdminConexiones.obtenerConexion();
		} catch (GenericException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}

	@Override
	public Articulo save(Articulo articulo) {

		return articulo;

	}

	@Override
	public Articulo getByPK(Long id) throws GenericException {

		try (Statement st = this.connection.createStatement()) {

			// execute del sql
			// ResultSet
			System.out.println("SELECT * FROM ARTICULOS WHERE ID = " + id);
			try (ResultSet rs = st.executeQuery("SELECT * FROM ARTICULOS WHERE ID = " + id)) {
				Articulo articulo = null;
				if (rs.next()) {

					// extraigo datos
					Long idArticulo = rs.getLong("id");
					String descripcion = rs.getString("descripcion");
					Double precio = rs.getDouble("precio");
					String titulo = rs.getString("titulo");
					String dimension = rs.getString("dimension");
					String imagen = rs.getString("imagen");
					Long categoria = rs.getLong("categoria_id");

					// return articulo
					articulo = new Articulo(idArticulo, descripcion, precio,titulo, dimension, imagen, categoria);
				}
				return articulo;
			}
		} catch (Exception e) {
			throw new GenericException("Error al obtener el articulo con id: " + id, e);
		}

	}

	@Override
	public Articulo update(Articulo orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
