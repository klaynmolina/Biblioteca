package br.com.klaynmolina.Biblioteca.exceptionhandler;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("O sistema não conseguiu encontrar o recurso com ID: " + id);
	}

}
