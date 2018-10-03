package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class TestTPHibernateYSpring extends SpringTest {

	@Test @Transactional @Rollback
	public void testQueTraePaisesDeHablaInglesa() {
		
		Pais Argentina = new Pais();
		Pais Chile = new Pais();
		Pais EEUU = new Pais();
		Pais Canada = new Pais();
		
		Argentina.setIdioma("Espanol");
		Chile.setIdioma("Espanol");
		EEUU.setIdioma("Ingles");
		Canada.setIdioma("Ingles");
		
		Session session = getSession();
		
		session.save(Argentina);
		session.save(Chile);
		session.save(EEUU);
		session.save(Canada);
		
		List<Pais> paisesHablaInglesa = getSession().createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "Ingles")).list();
		
		assertThat(paisesHablaInglesa.size()).isEqualTo(2);
		
	}
	
	@Test @Transactional @Rollback
	public void testQueBuscaLosPaisesDelContinenteEuropeo(){
		 
		Continente primerContinente = new Continente();
		Continente segundoContinente = new Continente();
		Continente tercerContinente = new Continente();
		
		primerContinente.setNombre("Africano");
		segundoContinente.setNombre("Europeo");
		tercerContinente.setNombre("Africano");
		
		Pais primerPais = new Pais();
		Pais segundoPais = new Pais();
		Pais tercerPais = new Pais();
		
		primerPais.setContinente(primerContinente);
		segundoPais.setContinente(segundoContinente);
		tercerPais.setContinente(tercerContinente);
		
		Session session = getSession();
		
		session.save(primerPais);
		session.save(segundoPais);
		session.save(tercerPais);
		
		List <Pais> listaQueGuardaPaisesDelContinenteEuropeo = getSession().createCriteria(Pais.class)
				.createAlias("continente", "continenteBuscado")
				.add(Restrictions.eq("continenteBuscado.nombre", "Europeo")).list();
		
		assertThat(listaQueGuardaPaisesDelContinenteEuropeo.size()).isEqualTo(1);
		
	}
	
	@Test @Transactional @Rollback
	public void testQueBusquePaisesAlNorteDelTropicoDeCancer() {
		Pais Brasil = new Pais();
		Pais EEUU = new Pais();
		Pais Canada = new Pais();
		Pais Espania = new Pais();
		Ciudad Brasilia = new Ciudad();
		Ciudad Washington = new Ciudad();
		Ciudad Ottawa = new Ciudad();
		Ciudad Madrid = new Ciudad();
		Ubicacion uBrasilia = new Ubicacion();
		Ubicacion uWashington = new Ubicacion();
		Ubicacion uOttawa = new Ubicacion();
		Ubicacion uMadrid = new Ubicacion();
		
		uBrasilia.setLatitud(-15.7801);
		uBrasilia.setLongitud(-47.9292);
		uWashington.setLatitud(38.9041);
		uWashington.setLongitud(77.0171);
		uOttawa.setLatitud(45.4208);
		uOttawa.setLongitud(-75.69);
		uMadrid.setLatitud(40.4167);
		uMadrid.setLongitud(-3.70325);
		
		Brasilia.setNombre("Brasilia");
		Brasilia.setPais(Brasil);
		Brasilia.setUbicacionGeografica(uBrasilia);
		Washington.setNombre("Washington");
		Washington.setPais(EEUU);
		Washington.setUbicacionGeografica(uWashington);
		Ottawa.setNombre("Ottawa");
		Ottawa.setPais(Canada);
		Ottawa.setUbicacionGeografica(uOttawa);
		Madrid.setNombre("Madrid");
		Madrid.setPais(Espania);
		Madrid.setUbicacionGeografica(uMadrid);
		
		Brasil.setNombre("Brasil");
		Brasil.setCapital(Brasilia);
		EEUU.setNombre("EEUU");
		EEUU.setCapital(Washington);
		Canada.setNombre("Canada");
		Canada.setCapital(Ottawa);
		Espania.setNombre("Espa�a");
		Espania.setCapital(Madrid);
		
		Session session = getSession();
		
		session.save(uMadrid);
		session.save(uBrasilia);
		session.save(uOttawa);
		session.save(uWashington);
		session.save(Madrid);
		session.save(Washington);
		session.save(Ottawa);
		session.save(Brasilia);
		session.save(Brasil);
		session.save(Espania);
		session.save(EEUU);
		session.save(Canada);
		
		List <Pais> listaPaises = getSession().createCriteria(Pais.class)
				.createAlias("capital", "ciudad")
				.createAlias("ciudad.ubicacionGeografica", "ubicacion")
				.add(Restrictions.gt("ubicacion.latitud", 23.0)).list();
		
		assertThat(listaPaises.size()).isEqualTo(3);
	}

}
