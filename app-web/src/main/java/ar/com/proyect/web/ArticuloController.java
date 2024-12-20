package ar.com.proyect.web;

import java.util.ArrayList;
import java.util.List;

import ar.com.proyect.daos.exceptions.GenericException;
import ar.com.proyect.domain.Articulo;
import ar.com.proyect.domain.Categoria;
import ar.com.proyect.services.ArticuloService;
import ar.com.proyect.services.CategoriaService;
import ar.com.proyect.services.exceptions.ServiceException;
import ar.com.proyect.services.impl.ArticuloServiceImpl;
import ar.com.proyect.services.impl.CategoriaServiceimpl;

public class ArticuloController {

//	caminito 
//	
//	interfaz dao -> 
//	dao impl
//	service
//	controller
//	

	public static void main(String[] args) throws ServiceException, GenericException {

		ArticuloService serviceArticulo = new ArticuloServiceImpl();
		CategoriaService serviceCategotia= new CategoriaServiceimpl();
		
		List<Articulo> articulos = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		
//		consulto por id
//		Articulo articulo = serviceArticulo.getById(2l);
//		System.out.println(articulo);
//		
//		Categoria categoria = serviceCategotia.getById(1l);
//		System.out.println(categoria);
		
		
		//me traigo todos los articulos
//		articulos = serviceArticulo.findAll();
//		System.out.println(articulos);
//		
//		categorias = serviceCategotia.findAll();
//		System.out.println(categorias);

		

	}
}