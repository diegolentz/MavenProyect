package ar.com.proyect.daos;
import ar.com.proyect.domain.Articulo;

//dao -> data acces object, es el intermediario entre la base de datos y el modelo de datos

public interface ArticuloDao {
	
	public Articulo create(Articulo orden);
	public Articulo read(Long id);
	public Articulo update(Articulo orden);
	public void delete(Long id);
	

}
