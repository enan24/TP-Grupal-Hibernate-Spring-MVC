package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import static org.assertj.core.api.Assertions.*;

public class usuarioTest extends SpringTest
{
	@Test @Transactional @Rollback
	public void guardarUsuarioTest(){
		
		Usuario pepe=new Usuario();
		
		pepe.setEmail("pepe@hotmail.com");
		pepe.setPassword("hola");
		pepe.setRol("administrador");
		
		Session session=getSession();
		session.save(pepe);
		
		Usuario buscado= session.get(Usuario.class, pepe.getId());
		
		assertThat(buscado).isNotNull();
		
		
		
	}
	
	@Test @Transactional @Rollback
	public void modificarUsuarioTest(){
		
		Usuario pepe=new Usuario();
		
		pepe.setEmail("pepe@hotmail.com");
		pepe.setPassword("hola");
		pepe.setRol("administrador");
		
		Session session=getSession();
		session.save(pepe);
		
		pepe.setEmail("pepito@hotmail.com");
		
		session.update(pepe);
		
		
		Usuario buscado= session.get(Usuario.class, pepe.getId());
		assertThat(buscado.getEmail()).isEqualTo(pepe.getEmail());
		
	}
	
	
	@Test @Transactional @Rollback
	public void eliminarUsuarioTest(){
		
		Usuario pepe=new Usuario();
		
		pepe.setEmail("pepe@hotmail.com");
		pepe.setPassword("hola");
		pepe.setRol("administrador");
		
		Session session=getSession();
		session.save(pepe);
		
		session.delete(pepe);
		
		Usuario buscado= session.get(Usuario.class, pepe.getId());
		assertThat(buscado).isNull();
		
	}

	
}
