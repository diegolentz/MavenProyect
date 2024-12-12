package ar.com.proyect.services.exceptions;

public class ServiceException extends Exception {
	
	public ServiceException(String msj, Throwable e) {
		super(msj, e);
	}

}
