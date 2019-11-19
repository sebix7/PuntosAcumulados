package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class SaldoInsuficienteException extends Exception {
	
	public SaldoInsuficienteException() {
		JOptionPane.showMessageDialog(null, "Saldo o puntos insuficientes para realizar la compra");
	}
}
