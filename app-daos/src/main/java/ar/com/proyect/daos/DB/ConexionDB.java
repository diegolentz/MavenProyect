package ar.com.proyect.daos.DB;

import ar.com.proyect.daos.exceptions.ConnectionException;
//autoclseable cierra la app
public class ConexionDB implements AutoCloseable {

	private boolean open;

	public ConexionDB(String username, String password) {
//		this.open = false;
	}

	public ConexionDB open() throws ConnectionException{
		if (!isOpen()) {
			System.out.println("Conectando a la base de datos");
			this.open = true;
			return this;
		} else {
			throw new ConnectionException("Conexion ya abierta");
		}
	}

	public boolean isOpen() {
		return this.open;
	}

	public void close() {
		if (this.open) {
			System.out.println("Cerrando conexion a la base de datos");
			this.open = false;
		}
	}

	public void connect() {
		if (!isOpen()) {
			this.open = true;
		} else {
			System.out.println("Ya está conectado a la base de datos");
		}
	}

}
