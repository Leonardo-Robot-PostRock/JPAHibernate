package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "denominacion")
	private String denominacion;

	@Column(name = "precio")
	private int precio;

	@OneToMany(mappedBy = "articulo")
	private List<DetalleFactura> detalleFactura;

	public Articulo() {

	}

	public Articulo(int cantidad, String denominacion, int precio) {
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
