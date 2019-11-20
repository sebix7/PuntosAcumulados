package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class SinClientesException extends Exception {

	public SinClientesException() {
		JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
	}

}
