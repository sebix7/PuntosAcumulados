package ar.edu.unlam.pb2.puntosacumulados;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.Cliente;
import ar.edu.unlam.pb2.puntosacumulados.Local;
import ar.edu.unlam.pb2.puntosacumulados.Sistema;

public class TestPuntosAcumulados {

	/*@Test
	public void testQueVerificaQueUnClienteFueRegistrado() {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
		String nombre = "Sebastian";
		String apellido = "Rodriguez";
		String nombreDeUsuario = "sebix7";
		String email = "sebeatport@gmail.com";
		String password = "pryda";
		Cliente nuevo = new Cliente(nombre, apellido, nombreDeUsuario, email, password);
		Assert.assertTrue(miS.registro(nuevo));
		Assert.assertEquals(1, miS.getPerfumeria().getClientes().size());
	}

	@Test
	public void testQueVerificaQueNoSePuedeRegistrarUnClienteConUnNombreDeUsuarioOUnEmailYaExistente() {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Cliente nuevo1 = new Cliente(nombre1, apellido1, nombreDeUsuario1, email1, password1);
		String nombre2 = "Mauro";
		String apellido2 = "Perrone";
		String nombreDeUsuario2 = "mantonella";
		String email2 = "sebeatport@gmail.com";
		String password2 = "iloverubius";
		Cliente nuevo2 = new Cliente(nombre2, apellido2, nombreDeUsuario2, email2, password2);
		String nombre3 = "Rodrigo";
		String apellido3 = "Acosta";
		String nombreDeUsuario3 = "sebix7";
		String email3 = "elrodri@gmail.com";
		String password3 = "Dioxis";
		Cliente nuevo3 = new Cliente(nombre3, apellido3, nombreDeUsuario3, email3, password3);
		Assert.assertTrue(miS.registro(nuevo1));
		Assert.assertFalse(miS.registro(nuevo2));
		Assert.assertFalse(miS.registro(nuevo3));
		Assert.assertEquals(1, miS.getPerfumeria().getClientes().size());
	}

	@Test
	public void testQueVerificaQueSePuedeIniciarSesionConUnClienteYaRegistrado() {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Cliente nuevo1 = new Cliente(nombre1, apellido1, nombreDeUsuario1, email1, password1);
		miS.registro(nuevo1);
		miS.cerrarSesion();
		//Assert.assertTrue(miS.iniciarSesion(email1, password1));
	}

	@Test
	public void testQueVerificaQueNoSePuedeIniciarSesionConUnClienteNoRegistrado() {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Cliente nuevo1 = new Cliente(nombre1, apellido1, nombreDeUsuario1, email1, password1);
		miS.registro(nuevo1);
		miS.cerrarSesion();
		//Assert.assertFalse(miS.iniciarSesion("nadie@nada.com.mx", "blablabla"));
	}
*/
}
