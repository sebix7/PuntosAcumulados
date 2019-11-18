package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVerPerfilCliente {

	@Test
	public void verPerfilDeCliente() {

		Sistema miSistema = new Sistema();
		Cliente miCliente = new Cliente("Naruto", "Uzumaki", 20, "NarutoHokage", "naruto@gmail.com","12345", 1500.0);
		miSistema.getClientes().add(miCliente);
		miSistema.verPerfilUsuario(miCliente);
		assertEquals(1, miSistema.getClientes().size());
		
	}

}
