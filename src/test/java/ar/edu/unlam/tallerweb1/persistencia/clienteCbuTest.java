package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.CBU;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

public class clienteCbuTest extends SpringTest {

	@Test @Transactional @Rollback
	public void crearClienteTest(){
		
		Cliente clienteUno= new Cliente();
		CBU cbu=new CBU();
		
		cbu.setCbu("12456487");
		clienteUno.setNombre("juan");
		clienteUno.setCbu(cbu);
		
		Session session=getSession();
		session.save(clienteUno);
		
		Cliente clienteBuscado= session.get(Cliente.class, clienteUno.getId());
		assertThat(clienteBuscado).isNotNull();
		assertThat(clienteBuscado.getCbu().getId()).isNotNull();
	}
	
	@Test @Transactional @Rollback
	public void modicarClienteTest(){
		
		Cliente clienteUno= new Cliente();
		CBU cbu=new CBU();
		
		cbu.setCbu("12456487");
		clienteUno.setNombre("juan");
		clienteUno.setCbu(cbu);
		
		Session session=getSession();
		session.save(clienteUno);
		
		Cliente clienteBuscado= session.get(Cliente.class, clienteUno.getId());
		
		assertThat(clienteBuscado).isNotNull();
		assertThat(clienteBuscado.getCbu().getId()).isNotNull();
	}
	
}
