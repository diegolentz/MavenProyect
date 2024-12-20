package ar.com.proyect.services.impl;

import java.util.List;

import ar.com.proyect.daos.GenericDao;
import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.services.GenericService;
import ar.com.proyect.services.exceptions.ServiceException;

public abstract class GenericBaseService<T> implements GenericService<T> {

	protected GenericDao<T> dao;
	
	public GenericBaseService(GenericDao<T> dao) {
		this.dao = dao;
	}
	
	@Override
	public T getById(Long id) throws ServiceException {
		try {
			return dao.getByPK(id);
		} catch (GenericException e) {			
			throw new ServiceException("Error al consutlar T",e);
		}
	}
	
	@Override
	public void delete(Long id) throws ServiceException {
		try {
			dao.delete(id);
		} catch (GenericException e) {			
			throw new ServiceException("Error al eliminar el T",e);
		}				
	}
	
	@Override
	public void update(T entity) throws ServiceException {
		try {
			dao.update(entity);
		} catch (GenericException e) {			
			throw new ServiceException("Error al eliminar el T",e);
		}		
	}
	
	@Override
	public List<T> findAll() throws ServiceException {
		try {
			return dao.findAll();
		} catch (GenericException e) {			
			throw new ServiceException("Error consutlando Ts",e);
		}
	}
	
	@Override
	public void create(T nuevo) throws ServiceException {
		try {
			dao.save(nuevo);
		} catch (GenericException e) {			
			throw new ServiceException("Error creando Ts",e);
		}
	}

}
