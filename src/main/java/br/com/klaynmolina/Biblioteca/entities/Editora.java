package br.com.klaynmolina.Biblioteca.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "editora")
@Entity
public class Editora implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String nome;
    private String endereco;

    @JsonIgnore
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
