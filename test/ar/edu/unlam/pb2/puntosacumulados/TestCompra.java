package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.NombreDeUsuarioNoValidoException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.OpcionInvalidaException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.SaldoInsuficienteException;

public class TestCompra {

	@Test
	public void testGeneradorDeNumeroDeOrdenSumaUnoEnCadaCompra()
			throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException, OpcionInvalidaException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 20000.0,
				9000);
		miSistema.getClientes().add(miCliente);

		miSistema.comprar(miCliente);
		miSistema.comprar(miCliente);

		assertEquals(2, miSistema.getNumeroCompra().size());
	}

	@Test
	public void enCadaCompraSeAgregaUnProductoALaLista()
			throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException, OpcionInvalidaException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 20000.0,
				9000);
		miSistema.getClientes().add(miCliente);
		miSistema.comprar(miCliente);
		miSistema.comprar(miCliente);

		assertEquals(2, miSistema.getProductos().size());
	}

	@Test
	public void cadaCompraGeneraPuntos()
			throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException, OpcionInvalidaException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 20000.0,
				9000);
		miSistema.getClientes().add(miCliente);
		miSistema.comprar(miCliente);

		assertEquals(900, miSistema.getCompra().getCantidadPuntos(), 0.01);
	}

	@Test
	public void lasComprasEnEfectivoAcumulanPuntos()
			throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException, OpcionInvalidaException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 20000.0,
				9000);
		miSistema.getClientes().add(miCliente);
		miSistema.comprar(miCliente);
		miSistema.comprar(miCliente);

		assertEquals(1800, miSistema.getCliente().getPuntos(), 0.01);
	}

	@Test(expected = NombreDeUsuarioNoValidoException.class) // tira excepcion y da verde
	public void comprarUsandoUnUsuarioQueNoExisteEnLaLista()
			throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException, OpcionInvalidaException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Producto miProducto = new Producto("Perfume Menemista", 1750.0);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 20000.0,
				9000);
		Cliente miCliente2 = new Cliente("Jan", "Erischen", 40, "Jan", "jan@gmail.com", "12345", 10000.0, 9000);
		// agrego usuario 1 a al lista.
		miSistema.getClientes().add(miCliente);
		// utilizo el usuario dos para comprar, el cual no se encuentra registrado
		miSistema.comprar(miCliente2);

	}

	@Test(expected = SaldoInsuficienteException.class)
	public void noHaySaldoSuficienteParaRealizarUnaCompra()
			throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException, OpcionInvalidaException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 80.0,
				9000);
		// agrego usuario 1 a al lista.
		miSistema.getClientes().add(miCliente);
		// no tiene saldo disponible para la compra
		miSistema.comprar(miCliente);
	}

	@Test
	public void comprasEnEfectivoRestanElSaldo()
			throws OpcionInvalidaException, SaldoInsuficienteException, NombreDeUsuarioNoValidoException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 100.0,
				9000);
		miSistema.getClientes().add(miCliente);
		miSistema.comprar(miCliente);
		// elegir opcion 1 para que la resta de correcta.
		assertEquals(10.0, miCliente.getUsuarioCliente().getSaldo(), 0.01);
	}

	@Test
	public void comprasConPuntosRestanElTotalDeLosPuntos()
			throws OpcionInvalidaException, SaldoInsuficienteException, NombreDeUsuarioNoValidoException {
		Local miLocal = new Local("Perfumeria Penelope Glamour");
		Sistema miSistema = new Sistema(miLocal);
		Cliente miCliente = new Cliente("Rodrigo", "Acosta", 30, "Dioxis", "jracosta1991@gmail.com", "12345", 100.0,
				1000);
		miSistema.getClientes().add(miCliente);
		miSistema.comprar(miCliente);
		assertEquals(100, miCliente.getPuntos(), 0.01);
	}

}
