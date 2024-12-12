package ar.com.proyect.daos.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.proyect.daos.exceptions.GenericException;

public class AdminConexiones {

	public static Connection obtenerConexion() throws GenericException {

		String host = "localhost";
		String password = "root";
		String user = "root";
		String dbName = "proyecto-java";
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://" + host + "/" + dbName + "?serverTimeZone=UTC&userSSL=false";

		// no puedo hacer new de esta clase, es para cargarla dinamicamente con
		// Class.forName
		try {
			Class.forName(driverName);

			Connection connection = DriverManager.getConnection(url, user, password);

			return connection;
		} catch (SQLException sqe) {
			throw new GenericException("No se ha podido conectar a: " + url, sqe);
		} catch (ClassNotFoundException cnfe) {
			throw new GenericException("No se ha encontrado el driver:" + driverName, cnfe);
		}
	}
}
