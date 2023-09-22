package br.com.klaynmolina.Biblioteca.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "livro")
public class Livro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int ano;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editora_id")
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
