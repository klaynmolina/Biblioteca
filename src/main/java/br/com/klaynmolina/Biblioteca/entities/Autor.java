package br.com.klaynmolina.Biblioteca.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livrosEscritos;
    
    public Autor() {
		// TODO Auto-generated constructor stub
	}

	public Autor(String nome, String nacionalidade) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}

}

