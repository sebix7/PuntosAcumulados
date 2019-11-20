package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.OpcionInvalidaException;

public class TestMenuPrincipal {

	@Test
	public void testOpcionMenuPrincipalCorrecto() {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
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
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);

		miSistema.menuPrincipal();
		// Debe ingresarse un valor menor a 1 o mayor a 5 para que se cumpla lo
		// esperado.
	}

}
