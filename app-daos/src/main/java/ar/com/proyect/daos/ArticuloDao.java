package ar.com.proyect.daos;
import java.sql.SQLException;

import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.domain.Articulo;

//dao -> data acces object, es el intermediario entre la base de datos y el modelo de datos

public interface ArticuloDao {
	
	public Articulo save(Articulo orden);
	public Articulo getByPK(Long pk) throws GenericException;
	public Articulo update(Articulo orden);
	public void delete(Long pk);
	

}
