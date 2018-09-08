package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
@Id @GeneratedValue 

private Long Id;
private String nombre;
	
@OneToOne (cascade={CascadeType.ALL})
private CBU cbu;

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public CBU getCbu() {
	return cbu;
}

public void setCbu(CBU cbu) {
	this.cbu = cbu;
}

}


