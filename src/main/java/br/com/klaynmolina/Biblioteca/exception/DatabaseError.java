package br.com.klaynmolina.Biblioteca.exception;

public class DatabaseError extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DatabaseError(String msg) {
		super(msg);
	}

}
