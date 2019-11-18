package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.CorreoExistenteException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.DatosDeUsuarioNoValidosException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.UsuarioExistenteException;

public class TestIniciarSesion {

	@Test
	public void testQueVerificaQueSePuedeIniciarSesionConUnClienteRegistradoOExistente() throws NullException {
		Local miLocal = new Local("Pizzeria Los hijos de puta");
		Sistema miS = new Sistema();
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Double saldo1 = 0.0;
		Cliente nuevo1 = new Cliente(nombre1, apellido1, null, nombreDeUsuario1, email1, password1,saldo1);

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
		Local miLocal = new Local("Pizzeria Los hijos de puta");
		Sistema miS = new Sistema();

		String email = "sebeatport@gmail.com";
		String password = "pryda";

		miS.iniciarSesion(email, password);

	}

}
