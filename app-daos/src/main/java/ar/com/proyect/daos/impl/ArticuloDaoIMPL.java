package ar.com.proyect.daos.impl;

import ar.com.proyect.daos.ArticuloDao;
import ar.com.proyect.daos.DB.ConexionDB;
import ar.com.proyect.domain.Articulo;

public class ArticuloDaoIMPL implements ArticuloDao {
	private ConexionDB connection;

	public ArticuloDaoIMPL() {
		this.connection = new ConexionDB("root", "1234");
	}

	@Override
	public Articulo create(Articulo orden) {
		try (ConexionDB conn = this.connection.open()) {
			orden.setId(1L);
		} catch (Exception e) {
			e.getMessage();
		}
		return orden;

	}

	@Override
	public Articulo read(Long id) {
		// TODO Auto-generated method stub
		return null;
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
