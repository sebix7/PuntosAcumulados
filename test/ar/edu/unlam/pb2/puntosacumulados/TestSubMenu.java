package ar.edu.unlam.pb2.puntosacumulados;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class TestSubMenu {

	@Test
	public void testOpcionSubmenuCorrecto() {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
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
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);

		miSistema.submenu(); // Debe ingresarse un valor distinto de 1 o 2 para quese cumpla lo esperado.
	}

}
