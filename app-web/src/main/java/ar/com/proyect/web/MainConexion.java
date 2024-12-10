package ar.com.proyect.web;

import ar.com.proyect.daos.ArticuloDao;
import ar.com.proyect.daos.impl.ArticuloDaoIMPL;
import ar.com.proyect.domain.Articulo;

public class MainConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArticuloDao dao = new ArticuloDaoIMPL();
		
		Articulo o = new Articulo(1l, "Orden de prueba", 150f);
		dao.create(o);

	}

}
