package ar.com.proyect.web;

import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.domain.Articulo;
import ar.com.proyect.services.ArticuloService;
import ar.com.proyect.services.exceptions.ServiceException;
import ar.com.proyect.services.impl.ArticuloServiceImpl;

public class ArticuloController {
	
	public static void main(String[] args) throws ServiceException, GenericException {

	
		ArticuloService service = new ArticuloServiceImpl();
		
		try {
			Articulo articulo = service.getById(1l);
			
			System.out.println(articulo);
		} catch (ServiceException e) {
			e.printStackTrace();
	}
	}

}
