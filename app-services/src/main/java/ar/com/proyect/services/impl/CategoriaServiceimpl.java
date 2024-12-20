package ar.com.proyect.services.impl;

import ar.com.proyect.daos.impl.CategoriaDaoMySQLIMPL;
import ar.com.proyect.domain.Categoria;
import ar.com.proyect.services.CategoriaService;

public class CategoriaServiceimpl extends GenericBaseService<Categoria> implements CategoriaService {

	public CategoriaServiceimpl() {
		super(new CategoriaDaoMySQLIMPL());
	}

}
