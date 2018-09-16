package ar.edu.unlam.tallerweb1.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pais;

public class TestTPHibernateYSpring extends SpringTest {

	@Test @Transactional @Rollback
	public void testQueTraePaisesDeHablaInglesa() {
		Pais Argentina = new Pais();
		Pais Chile = new Pais();
		Pais EEUU = new Pais();
		Pais Canadá = new Pais();
		
		Argentina.setIdioma("Español");
		Chile.setIdioma("Español");
		EEUU.setIdioma("Ingles");
		Canadá.setIdioma("Ingles");
		
		Session session = getSession();
		
		session.save(Argentina);
		session.save(Chile);
		session.save(EEUU);
		session.save(Canadá);
		
		List<Pais> paisesHablaInglesa = getSession().createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "Ingles")).list();
		
		assertThat(paisesHablaInglesa.size()).isEqualTo(2);
		
	}

}
