package br.com.klaynmolina.Biblioteca.exceptionhandler.erros;

public class RemovalException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public RemovalException(Object id) {
		super("Não foi possível deletar o recurso de ID: " + id);
	}
	
}
