package ar.edu.unlam.pb2.puntosacumulados;

public class OpcionMenuPrincipalInvalidaException extends Exception {

	public OpcionMenuPrincipalInvalidaException() {
		super();
		System.out.println("Error. Elija una opci�n del 1 al 4.");
	}
}
