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


        Autor autor1 = new Autor("Autor 1", "Nacionalidade 1");
        Autor autor2 = new Autor("Autor 2", "Nacionalidade 2");
        Autor autor3 = new Autor("Autor 3", "Nacionalidade 3");
        
        autorRepository.save(autor1);
        autorRepository.save(autor2);
        autorRepository.save(autor3);


        Editora editora1 = new Editora("Editora 1", "Endereço 1");
        Editora editora2 = new Editora("Editora 2", "Endereço 2");
        Editora editora3 = new Editora("Editora 3", "Endereço 3");
        
        editoraRepository.save(editora1);
        editoraRepository.save(editora2);
        editoraRepository.save(editora3);


        Livro livro1 = new Livro("Livro 1", 2023, autor1, editora1);
        Livro livro2 = new Livro("Livro 2", 2022, autor2, editora2);
        Livro livro3 = new Livro("Livro 3", 2021, autor3, editora3);
        
        livroRepository.save(livro1);
        livroRepository.save(livro2);
        livroRepository.save(livro3);

		
	}

}
