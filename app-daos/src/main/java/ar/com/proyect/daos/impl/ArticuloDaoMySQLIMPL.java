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

		try (Connection con = AdminConexiones.obtenerConexion()) {

			StringBuffer sql = new StringBuffer(
					"INSERT INTO articulos (descripcion,precio, titulo, dimension, imagen,categoria) VALUES(");
			sql.append("?,?,?,?,?,?)");

			try (PreparedStatement st = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {

				st.setString(1, articulo.getDescripcion());
				st.setDouble(2, articulo.getPrecio());
				st.setString(4, articulo.getTitulo());
				st.setString(5, articulo.getDimension());
				st.setString(7, articulo.getImagen());
				st.setLong(3, articulo.getCategoria());

				st.execute();

				try (ResultSet rs = st.getGeneratedKeys()) {

					if (rs.next()) {

						Long id = rs.getLong(1);

						articulo.setId(id);
					}
				}
			}
		} catch (GenericException | SQLException ge) {
			throw new GenericException(ge.getMessage(), ge);
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
			sql.append("categoria=?").append(",");
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
