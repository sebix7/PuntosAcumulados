package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.NombreDeUsuarioNoValidoException;

public class testCompra {

	@Test
	public void testGeneradorDeNumeroDeOrdenSumaUnoEnCadaCompra() throws NombreDeUsuarioNoValidoException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto);
		miSistema.nuevaCompra(miUsuario, miProducto);
		miSistema.nuevaCompra(miUsuario, miProducto);
		miSistema.nuevaCompra(miUsuario, miProducto);
		
		assertEquals(4, miSistema.getNumeroCompra().size());
	}
	
	@Test
	public void enCadaCompraSeAgregaUnProducto() throws NombreDeUsuarioNoValidoException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto);
		miSistema.nuevaCompra(miUsuario, miProducto);
	
		assertEquals(2, miSistema.getProductos().size());
	}
	
	@Test
	public void cadaCompraGeneraPuntos() throws NombreDeUsuarioNoValidoException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto);
		
		assertEquals(17500, miSistema.getCompra().getCantidadPuntos(),0.01);
	}
	
	@Test
	public void lasComprasAcumulanPuntos() throws NombreDeUsuarioNoValidoException {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		miSistema.getListaUsuarios().add(miUsuario);
		miSistema.nuevaCompra(miUsuario, miProducto);
		miSistema.nuevaCompra(miUsuario, miProducto);
		
		assertEquals(35000, miSistema.getCliente().getPuntos(),0.01);
	}
	
	

}
