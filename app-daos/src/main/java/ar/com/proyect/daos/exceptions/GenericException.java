package ar.com.proyect.daos.exceptions;

public class GenericException extends Exception {
	
	public GenericException(String msj, Throwable e) {
		super(msj,e);
	}

}
