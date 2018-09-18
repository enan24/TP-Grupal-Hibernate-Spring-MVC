package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {
@Id @GeneratedValue

	private String nombre;
	
	@ManyToOne (cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private Pais pais;
	
	@OneToOne (cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private Ubicacion ubicacionGeografica;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Ubicacion getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(Ubicacion ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	

}
