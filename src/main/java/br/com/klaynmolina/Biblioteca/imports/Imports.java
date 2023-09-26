package br.com.klaynmolina.Biblioteca.imports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.klaynmolina.Biblioteca.entities.Autor;
import br.com.klaynmolina.Biblioteca.entities.Editora;
import br.com.klaynmolina.Biblioteca.entities.Livro;
import br.com.klaynmolina.Biblioteca.repositories.AutorRepository;
import br.com.klaynmolina.Biblioteca.repositories.EditoraRepository;
import br.com.klaynmolina.Biblioteca.repositories.LivroRepository;

@Configuration
public class Imports implements CommandLineRunner{
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Override
	public void run(String... args) throws Exception {


		Autor autor1 = new Autor("Cassandra Clare", "Americana");
        Autor autor2 = new Autor("Stephenie Meyer", "Americana");
        Autor autor3 = new Autor("Becca Fitzpatrick", "Americana");
        
        autorRepository.save(autor1);
        autorRepository.save(autor2);
        autorRepository.save(autor3);


        Editora editora1 = new Editora("Galera", "Rua Argentina, 171 – São Cristovão - Rio de Janeiro/RJ");
        Editora editora2 = new Editora("Intrínseca", "Gávea, Rio de Janeiro");
        
        editoraRepository.save(editora1);
        editoraRepository.save(editora2);


        Livro livro1 = new Livro("Cidade dos Ossos", 2007, autor1, editora1);
        Livro livro2 = new Livro("Crepúsculo", 2005, autor2, editora2);
        Livro livro3 = new Livro("Hush, Hush", 2009, autor3, editora2);
        
        livroRepository.save(livro1);
        livroRepository.save(livro2);
        livroRepository.save(livro3);

		
	}

}
