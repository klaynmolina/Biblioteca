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
@Table(name = "editora")
public class Editora {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "editora")
    private List<Livro> livrosPublicados;
    
    public Editora() {
		// TODO Auto-generated constructor stub
	}

	public Editora(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

}
