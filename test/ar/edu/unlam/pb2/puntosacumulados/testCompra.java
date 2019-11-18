package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCompra {

	@Test
	public void testGeneradorDeNumeroDeOrdenSumaUnoEnCadaCompra() {
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
	public void testAcumularPuntosEnCadaCompra() {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto(101,"Perfume Menemista",1750.0);
		Usuario miUsuario = new Usuario("Dioxis");
		Cliente miCliente = new Cliente("Nombre","Apellido",20, "Dioxis","email","pass", 8000.0);
		miSistema.nuevaCompra(miUsuario, miProducto);
		miSistema.nuevaCompra(miUsuario, miProducto);
		
		assertEquals(350000, miCliente.getPuntos(),0.01);
		
	}

}
