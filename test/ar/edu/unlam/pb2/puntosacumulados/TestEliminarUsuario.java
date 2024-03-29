package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.CorreoExistenteException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.NullException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.UsuarioExistenteException;

public class TestEliminarUsuario {

	@Test
	public void testEliminarUsuario() throws CorreoExistenteException, UsuarioExistenteException, NullException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente c1 = new Cliente("nombre", "Apellido", 30, "nombreDeUsuario", "email", "password", 0.0, 9000);
		Cliente c2 = new Cliente("nombre2", "Apellido2", 30, "nombreDeUsuario2", "email2", "password2", 0.0, 9000);
		miSistema.registrarCliente(c1);
		miSistema.registrarCliente(c2);
		assertEquals(2, miSistema.getListaUsuarios().size());

		assertTrue(miSistema.eliminarUsuario("email2"));

	}

}
