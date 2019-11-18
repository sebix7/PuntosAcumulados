package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.NombreDeUsuarioNoValidoException;
import ar.edu.unlam.pb2.puntosacumulados.excepciones.SaldoInsuficienteException;

public class TestCompra {

	@Test
	public void testGeneradorDeNumeroDeOrdenSumaUnoEnCadaCompra() throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		
		assertEquals(4, miSistema.getNumeroCompra().size());
	}
	
	@Test
	public void enCadaCompraSeAgregaUnProductoALaLista() throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
	
		assertEquals(2, miSistema.getProductos().size());
	}
	
	@Test
	public void cadaCompraGeneraPuntos() throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		
		assertEquals(17500, miSistema.getCompra().getCantidadPuntos(),0.01);
	}
	
	@Test
	public void lasComprasAcumulanPuntos() throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		miSistema.nuevaCompra(miUsuario, miProducto,1);
		
		assertEquals(35000, miSistema.getCliente().getPuntos(),0.01);
	}
	
	@Test(expected = NombreDeUsuarioNoValidoException.class) //tira excepcion y da verde
	public void comprarUsandoUnUsuarioQueNoExisteEnLaLista() throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		Usuario miUsuario2 = new Usuario("Rodri182");
		//agrego usuario 1 a al lista.
		miSistema.getListaUsuarios().add(miUsuario);
		//utilizo el usuario dos para comprar, el cual no se encuentra registrado
		miSistema.nuevaCompra(miUsuario2, miProducto,1);
		
	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void noHaySaldoSuficienteParaRealizarUnaCompra() throws NombreDeUsuarioNoValidoException, SaldoInsuficienteException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Auto Menemista",1000000.0);
		Usuario miUsuario = new Usuario("Dioxis");
		Usuario miUsuario2 = new Usuario("Rodri182");
		//agrego usuario 1 a al lista.
		miSistema.getListaUsuarios().add(miUsuario);
		//utilizo el usuario dos para comprar, el cual no se encuentra registrado
		miSistema.nuevaCompra(miUsuario, miProducto,1);
	}

}
