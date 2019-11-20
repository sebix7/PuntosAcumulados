package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.CorreoExistenteException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.NullException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.UsuarioExistenteException;

public class TestRegistrarCliente {

	@Test
	public void testQueVerificaQueUnClienteFueRegistradoSatisfactoriamente() throws NullException {
		Local miLocal = new Local("Pizzeria Los hijos de puta");
		Sistema miSistema = new Sistema();
		String nombre = "Sebastian";
		String apellido = "Rodriguez";
		String nombreDeUsuario = "sebix7";
		String email = "sebeatport@gmail.com";
		String password = "pryda";
		Double saldo= 0.0;
		Cliente nuevo = new Cliente(nombre, apellido, null, nombreDeUsuario, email, password,saldo,9000);

		try {
			Assert.assertTrue(miSistema.registrarCliente(nuevo));
		} catch (UsuarioExistenteException e) {
			e.printStackTrace();
		} catch (CorreoExistenteException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(1, miSistema.getClientes().size());
	}
	
	@Test(expected = CorreoExistenteException.class)
	public void testQueVerificaQueNoSePuedeRegistrarUnClienteConUnEmailYaExistente()
			throws CorreoExistenteException, UsuarioExistenteException, NullException {
		Local miLocal = new Local("Pizzeria Los hijos de puta");
		Sistema miS = new Sistema();
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Double saldo1 = 0.0;
		Cliente nuevo1 = new Cliente(nombre1, apellido1, null, nombreDeUsuario1, email1, password1,saldo1,9000);
		String nombre2 = "Mauro";
		String apellido2 = "Perrone";
		String nombreDeUsuario2 = "mantonella";
		String email2 = "sebeatport@gmail.com";
		String password2 = "iloverubius";
		Double saldo2 = 0.0;
		Cliente nuevo2 = new Cliente(nombre2, apellido2, null, nombreDeUsuario2, email2, password2,saldo2,9000);

		miS.registrarCliente(nuevo1);

		miS.registrarCliente(nuevo2);

		Assert.assertEquals(1, miS.getClientes().size());
	}
	
	@Test(expected = UsuarioExistenteException.class)
	public void testQueVerificaQueNoSePuedeRegistrarUnClienteConUnUsuarioYaExistente()
			throws CorreoExistenteException, UsuarioExistenteException, NullException {
		Local miLocal = new Local("Pizzeria Los hijos de puta");
		Sistema miS = new Sistema();
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Double saldo1 = 0.0;
	
		Cliente nuevo1 = new Cliente(nombre1, apellido1, null, nombreDeUsuario1, email1, password1,saldo1,9000);
		String nombre3 = "Rodrigo";
		String apellido3 = "Acosta";
		String nombreDeUsuario3 = "sebix7";
		String email3 = "elrodri@gmail.com";
		String password3 = "Dioxis";
		Double saldo2 = 0.0;
		Cliente nuevo3 = new Cliente(nombre3, apellido3, null, nombreDeUsuario3, email3, password3,saldo2,9000);

		miS.registrarCliente(nuevo1);

		miS.registrarCliente(nuevo3);

		Assert.assertEquals(1, miS.getClientes().size());
	}


}
