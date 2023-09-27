package br.com.klaynmolina.Biblioteca.exceptionhandler.erros;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError implements Serializable{

private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Date timestamp;
	private Integer status;
	private String message;
	
	public StandardError() {
	}

	public StandardError(Date timestamp, Integer status, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}

}
