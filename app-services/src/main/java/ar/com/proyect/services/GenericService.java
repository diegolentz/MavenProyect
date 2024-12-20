package ar.com.proyect.services;

import java.util.List;

import ar.com.proyect.services.exceptions.ServiceException;

public interface GenericService<T> {

	public T getById(Long id) throws ServiceException;

	public void delete(Long id) throws ServiceException;

	public void update(T entity) throws ServiceException;

	public List<T> findAll() throws ServiceException;

	public void create(T nuevo) throws ServiceException;

}
