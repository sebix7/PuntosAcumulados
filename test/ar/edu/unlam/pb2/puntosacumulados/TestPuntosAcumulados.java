package ar.edu.unlam.pb2.puntosacumulados;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class TestPuntosAcumulados {

	@Test
	public void testOpcionMenuPrincipalCorrecto() {
		Sistema miSistema = new Sistema();
		Integer vO = 0;

		try {
			vO = miSistema.menuPrincipal();
		} catch (OpcionInvalidaException e) {
			e.printStackTrace();
		}

		Integer vE = 1;
		Assert.assertEquals(vO, vE);

	}

	@Test(expected = OpcionInvalidaException.class)
	public void testOpcionMenuPrincipalIncorrecto() throws OpcionInvalidaException {
		Sistema miSistema = new Sistema();

		miSistema.menuPrincipal();
		// Debe ingresarse un valor menor a 1 o mayor a 5 para que se cumpla lo
		// esperado.
	}

	@Test
	public void testQueVerificaQueUnClienteFueRegistradoSatisfactoriamente() {
		Sistema miSistema = new Sistema();
		String nombre = "Sebastian";
		String apellido = "Rodriguez";
		String nombreDeUsuario = "sebix7";
		String email = "sebeatport@gmail.com";
		String password = "pryda";
		Cliente nuevo = new Cliente(nombre, apellido, null, nombreDeUsuario, email, password);

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
			throws CorreoExistenteException, UsuarioExistenteException {
		Sistema miS = new Sistema();
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Cliente nuevo1 = new Cliente(nombre1, apellido1, null, nombreDeUsuario1, email1, password1);
		String nombre2 = "Mauro";
		String apellido2 = "Perrone";
		String nombreDeUsuario2 = "mantonella";
		String email2 = "sebeatport@gmail.com";
		String password2 = "iloverubius";
		Cliente nuevo2 = new Cliente(nombre2, apellido2, null, nombreDeUsuario2, email2, password2);

		miS.registrarCliente(nuevo1);

		miS.registrarCliente(nuevo2);

		Assert.assertEquals(1, miS.getClientes().size());
	}

	@Test(expected = UsuarioExistenteException.class)
	public void testQueVerificaQueNoSePuedeRegistrarUnClienteConUnUsuarioYaExistente()
			throws CorreoExistenteException, UsuarioExistenteException {
		Sistema miS = new Sistema();
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Cliente nuevo1 = new Cliente(nombre1, apellido1, null, nombreDeUsuario1, email1, password1);
		String nombre3 = "Rodrigo";
		String apellido3 = "Acosta";
		String nombreDeUsuario3 = "sebix7";
		String email3 = "elrodri@gmail.com";
		String password3 = "Dioxis";
		Cliente nuevo3 = new Cliente(nombre3, apellido3, null, nombreDeUsuario3, email3, password3);

		miS.registrarCliente(nuevo1);

		miS.registrarCliente(nuevo3);

		Assert.assertEquals(1, miS.getClientes().size());
	}

	@Test
	public void testQueVerificaQueSePuedeIniciarSesionConUnClienteRegistradoOExistente() {
		Sistema miS = new Sistema();
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Cliente nuevo1 = new Cliente(nombre1, apellido1, null, nombreDeUsuario1, email1, password1);

		try {
			miS.registrarCliente(nuevo1);
		} catch (UsuarioExistenteException e1) {
			e1.printStackTrace();
		} catch (CorreoExistenteException e1) {
			e1.printStackTrace();
		}

		try {
			Assert.assertTrue(miS.iniciarSesion(email1, password1));
		} catch (DatosDeUsuarioNoValidosException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = DatosDeUsuarioNoValidosException.class)
	public void testQueVerificaQueNoSePuedeIniciarSesionConUnClienteNoRegistradoOInexistente()
			throws DatosDeUsuarioNoValidosException {
		Sistema miS = new Sistema();

		String email = "sebeatport@gmail.com";
		String password = "pryda";

		miS.iniciarSesion(email, password);

	}

	@Test
	public void testOpcionSubmenuCorrecto() {
		Sistema miSistema = new Sistema();
		Integer vO = 0;

		try {
			vO = miSistema.submenu();
		} catch (OpcionInvalidaException e) {
			e.printStackTrace();
		}

		Integer vE = 1;
		Assert.assertEquals(vO, vE);

	}

	@Test(expected = OpcionInvalidaException.class)
	public void testOpcionSubmenuIncorrecto() throws OpcionInvalidaException {
		Sistema miSistema = new Sistema();

		miSistema.submenu(); // Debe ingresarse un valor distinto de 1 o 2 para quese cumpla lo esperado.
	}

}
