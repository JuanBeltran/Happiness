package co.gov.igac.ciaf.especializacion.poo.cbo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bicicleta")
public class Bicicleta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "lugar")
	private String lugar;
	@Column(name = "marca")
	private String marca;

	public Bicicleta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bicicleta(int id, String nombre, String lugar, String marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lugar = lugar;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}