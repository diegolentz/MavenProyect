package ar.com.proyect.services;

import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.domain.Articulo;
import ar.com.proyect.services.exceptions.ServiceException;

public interface ArticuloService {
	
	public Articulo getById(Long id) throws ServiceException;
	
	

}
