package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pais {
@Id @GeneratedValue

    private Long id;
    private String nombre;
	private Long habitantes;
	private String idioma;
	
	@OneToOne (cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private Ciudad capital;
	
	@ManyToOne (cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private Continente continente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Continente getContinente() {
		return continente;
	}
	public void setContinente(Continente continente) {
		this.continente = continente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(Long habitantes) {
		this.habitantes = habitantes;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Ciudad getCapital() {
		return capital;
	}
	public void setCapital(Ciudad capital) {
		this.capital = capital;
	}
	
}
