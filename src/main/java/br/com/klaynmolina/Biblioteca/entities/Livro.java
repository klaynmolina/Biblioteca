package br.com.klaynmolina.Biblioteca.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "livro")
@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private int ano;

	@ManyToOne
	private Autor autor;

	@ManyToOne
	private Editora editora;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(String titulo, int ano, Autor autor1, Editora editora1) {
		this.titulo = titulo;
		this.ano = ano;
		this.autor = autor1;
		this.editora = editora1;
	}

}
