package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ciudad {
@Id @GeneratedValue

    private Long id;
	private String nombre;
	private String ubicacionGeografica;
	private String pais;
	
	@ManyToOne (cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private Pais idPais;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Pais getIdPais() {
		return idPais;
	}
	public void setIdPais(Pais idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacionGeografica() {
		return ubicacionGeografica;
	}
	public void setUbicacionGeografica(String ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
}
