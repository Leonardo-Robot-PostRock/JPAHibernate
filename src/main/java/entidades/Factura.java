package entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fecha")
	private String fecha;

	@Column(name="numero")
	private int numero;
	
	@Column(name="total")
	private int total;

	public Factura(String fecha, int numero, int total) {
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Long getId() {
		return id;
	}
	
	
}
