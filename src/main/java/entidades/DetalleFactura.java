package entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "subtotal")
	private int subtotal;

	public DetalleFactura() {

	}

	public DetalleFactura(int cantidad, int subtotal) {
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public Long getId() {
		return id;
	}

}
