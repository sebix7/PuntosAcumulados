package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

public class DatosDeUsuarioNoValidosException extends Exception {

	public DatosDeUsuarioNoValidosException() {
		JOptionPane.showMessageDialog(null, "Usuario y/o password inválido, ingrese nuevamente los datos");
	}
}
