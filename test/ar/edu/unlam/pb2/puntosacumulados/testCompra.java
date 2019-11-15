package ar.edu.unlam.pb2.puntosacumulados;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCompra {

	@Test
	public void testGeneradorDeNumeroDeOrdenSumaUnoEnCadaCompra() {
		Sistema miSistema = new Sistema();
		Producto miProducto = new Producto("Perfume Menemista",750.0,201,15000);
		Compra miCompra = new Compra(miProducto);
		Compra miCompra2 = new Compra(miProducto);
		
		miSistema.nuevaCompra(miCompra);
		miSistema.nuevaCompra(miCompra2);
		
		
		assertEquals(2, miSistema.getNumeroCompra().size());
	}

}
