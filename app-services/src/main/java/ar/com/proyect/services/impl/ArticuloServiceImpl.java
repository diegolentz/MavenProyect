package ar.com.proyect.services.impl;

import ar.com.proyect.daos.impl.ArticuloDaoMySQLIMPL;
import ar.com.proyect.domain.Articulo;
import ar.com.proyect.services.ArticuloService;

public class ArticuloServiceImpl extends GenericBaseService<Articulo> implements ArticuloService {

	public ArticuloServiceImpl() {
		super(new ArticuloDaoMySQLIMPL());
	}

}
