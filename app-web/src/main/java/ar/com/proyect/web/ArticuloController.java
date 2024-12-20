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
//----------------------------------------------------------
//		consulto por id
//		Articulo articulo = serviceArticulo.getById(2l);
//		System.out.println(articulo);
//		
//		Categoria categoria = serviceCategotia.getById(1l);
//		System.out.println(categoria);
		
		
//----------------------------------------------------------
//		me traigo todos los articulos
//		articulos = serviceArticulo.findAll();
//		System.out.println(articulos);
//		
//		categorias = serviceCategotia.findAll();
//		System.out.println(categorias);
		
//----------------------------------------------------------
//		creo un objetos
//		Categoria categoria = new Categoria("otra");
//		serviceCategotia.create(categoria);
//		System.out.println(categorias);
//		
//		categorias = serviceCategotia.findAll();
//		System.out.println(categoria);
//		
//		Articulo articulo = new Articulo("articulo creado",1300.0, "create generico", "3x3", "la mejor imagen",2l);
//		serviceArticulo.create(articulo);
//		System.out.println(articulo);
//		
//		articulos = serviceArticulo.findAll();
//		System.out.println(articulos);

//----------------------------------------------------------
//		puedo eliminar
//		serviceArticulo.delete(8l);
//		serviceCategotia.delete(5l);
		
		
//----------------------------------------------------------
//		puedo editar
//		Articulo articuloEditar = serviceArticulo.getById(7l);
//		articuloEditar.setDescripcion("articulo editado");
//		serviceArticulo.update(articuloEditar);
//		Articulo corroboroArticulo = serviceArticulo.getById(7l);
//		
//		System.out.println(corroboroArticulo);
//
//		Categoria categoriaEditar = serviceCategotia.getById(3l);
//		categoriaEditar.setNombre("categoria editada");
//		serviceCategotia.update(categoriaEditar);
//		Categoria corroboroCategoria= serviceCategotia.getById(3l);
//		
//		System.out.println(corroboroCategoria);
		

	}
}