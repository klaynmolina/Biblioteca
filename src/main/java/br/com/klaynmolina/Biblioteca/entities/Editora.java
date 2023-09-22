package br.com.klaynmolina.Biblioteca.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Livro> getLivrosPublicados() {
		return livrosPublicados;
	}

	public void setLivrosPublicados(List<Livro> livrosPublicados) {
		this.livrosPublicados = livrosPublicados;
	}
    
}
