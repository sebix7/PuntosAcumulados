package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.CorreoExistenteException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.UsuarioExistenteException;

public class testEliminarUsuario {

	@Test
	public void testEliminarUsuario() throws CorreoExistenteException, UsuarioExistenteException, NullException {
		Sistema miSistema = new Sistema();
		Cliente c1 = new Cliente("nombre", "Apellido", 30, "nombreDeUsuario", "email", "password",0.0);
		Cliente c2 = new Cliente("nombre2", "Apellido2", 30, "nombreDeUsuario2", "email2", "password2",0.0);
		miSistema.registrarCliente(c1);
		miSistema.registrarCliente(c2);
		assertEquals(2, miSistema.getListaUsuarios().size());
		
		assertTrue(miSistema.eliminarUsuario("email2"));
		
	}

}
