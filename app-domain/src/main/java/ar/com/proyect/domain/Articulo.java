package ar.com.proyect.domain;

public class Articulo {
	
	private Long id;
	private String descripcion;
	private float precio;
	
	public Articulo(Long id, String descripcion, float precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
