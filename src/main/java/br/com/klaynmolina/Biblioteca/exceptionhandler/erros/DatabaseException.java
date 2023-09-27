package br.com.klaynmolina.Biblioteca.exceptionhandler.erros;

public class DatabaseException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(Object id) {
		super("Não foi possível criar/alterar o recurso com ID: " + id);
	}

}
