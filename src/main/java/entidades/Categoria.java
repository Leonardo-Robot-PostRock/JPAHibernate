package entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "denominacion")
	private String denominacion;

	public Categoria() {

	}

	public Categoria(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public Long getId() {
		return id;
	}

}
