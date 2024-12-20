package ar.com.proyect.daos;

import java.sql.SQLException;
import java.util.List;

import ar.com.proyect.daos.exceptions.GenericException;

public interface GenericDao <T>{
	
	
	public List<T> findAll() throws GenericException;
	public void save(T orden) throws GenericException;
	public T getByPK(Long pk) throws GenericException;
	public void update(T ordenToUpdate) throws GenericException;
	public void delete(Long pk) throws GenericException;

}
