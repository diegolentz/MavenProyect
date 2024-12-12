package ar.com.proyect.services.impl;

import ar.com.proyect.daos.ArticuloDao;
import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.daos.impl.ArticuloDaoIMPL;
import ar.com.proyect.domain.Articulo;
import ar.com.proyect.services.ArticuloService;
import ar.com.proyect.services.exceptions.ServiceException;

public class ArticuloServiceImpl implements ArticuloService {
	
	private ArticuloDao dao;
	
	public ArticuloServiceImpl() {
        this.dao = new ArticuloDaoIMPL();
        }

	@Override
	public Articulo getById(Long id) throws ServiceException {
		try {
			return dao.getByPK(id);
		} catch (GenericException e) {
			throw new ServiceException("No se pudo consultar el articulo ",e);
		}
	}

}
