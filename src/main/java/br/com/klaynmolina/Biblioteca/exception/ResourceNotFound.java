package br.com.klaynmolina.Biblioteca.exception;

public class ResourceNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFound(Object id) {
		super("O sistema não conseguiu encontrar o recurso com ID: " + id);
	}

}
