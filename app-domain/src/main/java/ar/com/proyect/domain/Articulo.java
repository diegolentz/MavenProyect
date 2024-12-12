package ar.com.proyect.domain;

public class Articulo {

	private Long id;
	private String descripcion;
	private Double precio;
	private String titulo;
	private String dimension;
	private String imagen;
	private Long categoria;

//constructor para consultas
	public Articulo(Long id, String descripcion, Double precio, String titulo, String dimension, String imagen,
			Long categoria) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.titulo = titulo;
		this.dimension = dimension;
		this.imagen = imagen;
		this.categoria = categoria;
	}

	// constructor para crear
	public Articulo(String descripcion, Double precio, String titulo, String dimension, String imagen, Long categoria) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.titulo = titulo;
		this.dimension = dimension;
		this.imagen = imagen;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", titulo=" + titulo
				+ ", dimension=" + dimension + ", imagen=" + imagen + ", categoria=" + categoria + "]";
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

}
