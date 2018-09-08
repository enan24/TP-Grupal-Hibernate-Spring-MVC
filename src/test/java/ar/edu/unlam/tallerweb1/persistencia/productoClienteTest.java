package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Producto;


public class productoClienteTest extends SpringTest{
	
	@Test @Transactional @Rollback
	public void productosClienteTest(){
		
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		
		Cliente cliente1 = new Cliente();
		
		Session session = getSession();
		
		producto1.setCliente(cliente1);
		producto2.setCliente(cliente1);
		producto3.setCliente(cliente1);
		
		session.save(producto1);
		session.save(producto2);	
		
		Producto productoBuscado= session.get(Producto.class, producto1.getId());
		Producto productoBuscado2= session.get(Producto.class, producto2.getId());

		assertThat(productoBuscado.getCliente()).isEqualTo(productoBuscado2.getCliente());
		
		
	}
	
}
