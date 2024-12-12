package ar.com.proyect.domain;

public class Marca {
	private Long id;
	private String nombre;
	
	
	public Marca(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
