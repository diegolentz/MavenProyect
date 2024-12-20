package ar.com.proyect.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import ar.com.proyect.daos.ArticuloDao;
import ar.com.proyect.daos.DB.AdminConexiones;
import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.domain.Articulo;

public class ArticuloDaoMySQLIMPL extends JDBCBaseDao<Articulo> implements ArticuloDao {

	public ArticuloDaoMySQLIMPL() {
		super("articulos");

	}

	@Override
	public void save(Articulo articulo) throws GenericException {
	    String sql = "INSERT INTO articulos (descripcion, precio, titulo, dimension, imagen, categoria_id) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection con = AdminConexiones.obtenerConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, articulo.getDescripcion());
	        ps.setDouble(2, articulo.getPrecio());
	        ps.setString(3, articulo.getTitulo());
	        ps.setString(4, articulo.getDimension());
	        ps.setString(5, articulo.getImagen());
	        ps.setLong(6, articulo.getCategoria());

	        ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new GenericException("Error al guardar el artículo", e);
	    }
	}



	@Override
	public void update(Articulo articuloToUpdate) throws GenericException {
		StringBuffer sql = new StringBuffer("UPDATE articulos SET ");
		
		if (articuloToUpdate.getDescripcion() != null) {
			sql.append("descripcion=?").append(", ");
		}
		if (articuloToUpdate.getPrecio() != null) {
			sql.append("precio=?").append(", ");
		}
		if (articuloToUpdate.getTitulo() != null) {
			sql.append("titulo=?").append(", ");
		}
		if (articuloToUpdate.getDimension() != null) {
			sql.append("dimension=?").append(", ");
		}
		if (articuloToUpdate.getImagen() != null) {
			sql.append("imagen=?").append(", ");
		}
		if (articuloToUpdate.getCategoria() != null) {
			sql.append("categoria_id=?").append(",");
		}

		sql = new StringBuffer(sql.substring(0, sql.length() - 1));

		sql.append(" where id=?");

		try (Connection con2 = AdminConexiones.obtenerConexion()) {

			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {

				// puedo setear atributo=valor con el tipo correcto

				if (articuloToUpdate.getDescripcion() != null) {
					st.setString(1, articuloToUpdate.getDescripcion());
				}
				if (articuloToUpdate.getPrecio() != null) {
					st.setDouble(2, articuloToUpdate.getPrecio());
				}
				if (articuloToUpdate.getTitulo() != null) {
					st.setString(3, articuloToUpdate.getTitulo());
				}
				if (articuloToUpdate.getDimension() != null) {
					st.setString(4, articuloToUpdate.getDimension());
				}
				if (articuloToUpdate.getImagen() != null) {
					st.setString(5, articuloToUpdate.getImagen());
				}
				if (articuloToUpdate.getCategoria() != null) {
					st.setLong(6, articuloToUpdate.getCategoria());
				}

				st.setLong(7, articuloToUpdate.getId());

				st.execute();// alt+shift+m
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}
	}

	// -------------------------------------------------- metodos secundarios

	public Articulo fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idArticulo = rs.getLong("id");
		String descripcion = rs.getString("descripcion");
		Double precio = rs.getDouble("precio");
		String titulo = rs.getString("titulo");
		String dimension = rs.getString("dimension");
		String imagen = rs.getString("imagen");
		Long categoria = rs.getLong("categoria_id");
		return new Articulo(idArticulo, descripcion, precio, titulo, dimension, imagen, categoria);
	}

}
