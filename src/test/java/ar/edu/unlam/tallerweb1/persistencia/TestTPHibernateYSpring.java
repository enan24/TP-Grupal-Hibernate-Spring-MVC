package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;

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

}
