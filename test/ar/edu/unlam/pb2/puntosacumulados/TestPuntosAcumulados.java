package ar.edu.unlam.pb2.puntosacumulados;

import org.junit.Assert;
import org.junit.Test;

public class TestPuntosAcumulados {

	@Test
	public void testOpcionMenuPrincipalCorrecto() {
		Local miP = new Local();
		Sistema miSistema = new Sistema(miP);
		Integer vO = 0;
		
		try {
			vO = miSistema.menuPrincipal();
		} catch (OpcionMenuPrincipalInvalidaException e) {
			e.printStackTrace();
		}
		
		Integer vE = 1;
		Assert.assertEquals(vO, vE);
		
	}
	
	@Test(expected = OpcionMenuPrincipalInvalidaException.class)
	public void testOpcionMenuPrincipalIncorrecto() throws OpcionMenuPrincipalInvalidaException{
		Local miP = new Local();
		Sistema miSistema = new Sistema(miP);
		
		miSistema.menuPrincipal();
		
	}
	
	@Test
	public void testQueVerificaQueUnClienteFueRegistradoSatisfactoriamente() {
		Local miP = new Local();
		Sistema miSistema = new Sistema(miP);
		
		String nombre = "Sebastian";
		String apellido = "Rodriguez";
		String nombreDeUsuario = "sebix7";
		String email = "sebeatport@gmail.com";
		String password = "pryda";
		Cliente nuevo = new Cliente(nombre, apellido, null, nombreDeUsuario, email, password);
		
		try {
			miSistema.registro(nuevo);
		} catch (UsuarioExistenteException e) {
			e.printStackTrace();
		} catch (CorreoExistenteException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(1, miSistema.getLocal().getClientes().size());
	}

	@Test(expected = CorreoExistenteException.class)
	public void testQueVerificaQueNoSePuedeRegistrarUnClienteConUnEmailYaExistente() throws CorreoExistenteException, UsuarioExistenteException {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
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
		
		try {
			miS.registro(nuevo1);
		} catch (UsuarioExistenteException e) {
			e.printStackTrace();
		} catch (CorreoExistenteException e) {
			e.printStackTrace();
		}
		
		miS.registro(nuevo2);
		
		Assert.assertEquals(1, miS.getLocal().getClientes().size());
	}

	@Test(expected = UsuarioExistenteException.class)
	public void testQueVerificaQueNoSePuedeRegistrarUnClienteConUnUsuarioYaExistente() throws CorreoExistenteException, UsuarioExistenteException {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
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
		
		try {
			miS.registro(nuevo1);
		} catch (UsuarioExistenteException e) {
			e.printStackTrace();
		} catch (CorreoExistenteException e) {
			e.printStackTrace();
		}
		
		miS.registro(nuevo3);
		
		Assert.assertEquals(1, miS.getLocal().getClientes().size());
	}
	
	@Test
	public void testQueVerificaQueSePuedeIniciarSesionConUnClienteRegistrado() {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
		String nombre1 = "Sebastian";
		String apellido1 = "Rodriguez";
		String nombreDeUsuario1 = "sebix7";
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		Cliente nuevo1 = new Cliente(nombre1, apellido1, null, nombreDeUsuario1, email1, password1);
		
		try {
			miS.registro(nuevo1);
		} catch (UsuarioExistenteException e) {
			e.printStackTrace();
		} catch (CorreoExistenteException e) {
			e.printStackTrace();
		}
		
		try {
			Assert.assertTrue(miS.iniciarSesion(email1, password1));
		} catch (DatosDeUsuarioInexistenteException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = DatosDeUsuarioInexistenteException.class)
	public void testQueVerificaQueNoSePuedeIniciarSesionConUnClienteNoRegistrado() throws DatosDeUsuarioInexistenteException {
		Local miP = new Local();
		Sistema miS = new Sistema(miP);
		
		String email1 = "sebeatport@gmail.com";
		String password1 = "pryda";
		
		miS.iniciarSesion(email1, password1);
	}
	
	/*@Test
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
