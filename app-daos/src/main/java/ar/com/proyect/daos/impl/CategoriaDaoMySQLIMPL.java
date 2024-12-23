package ar.com.proyect.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import ar.com.proyect.daos.CategoriasDao;
import ar.com.proyect.daos.DB.AdminConexiones;
import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.domain.Categoria;

public class CategoriaDaoMySQLIMPL extends JDBCBaseDao<Categoria> implements CategoriasDao {

	public CategoriaDaoMySQLIMPL() {
		super("categorias");
		// TODO Auto-generated constructor stub
	}

	@Override
	 public void save(Categoria categoria) throws GenericException {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
        try (Connection connection = AdminConexiones.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new GenericException("Error saving Categoria", e);
        }
    }

	@Override
	public void update(Categoria CategoriasToUpdate) throws GenericException {
		StringBuffer sql = new StringBuffer("UPDATE categorias SET ");

		if (CategoriasToUpdate.getNombre() != null) {
			sql.append("nombre=?");
		}

//		sql = new StringBuffer(sql.substring(0, sql.length() - 1));

		sql.append(" where id=?");

		try (Connection con2 = AdminConexiones.obtenerConexion()) {

			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {

				if (CategoriasToUpdate.getNombre() != null) {
					st.setString(1, CategoriasToUpdate.getNombre());
				}
				
				st.setLong(2, CategoriasToUpdate.getId());

				st.execute();// alt+shift+m
				
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}
	}

	@Override
	public Categoria fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idCategorias = rs.getLong("id");
		String nombre = rs.getString("nombre");
		return new Categoria(idCategorias, nombre);
	}

}
