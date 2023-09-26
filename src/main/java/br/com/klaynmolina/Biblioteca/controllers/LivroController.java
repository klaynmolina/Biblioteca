package br.com.klaynmolina.Biblioteca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.klaynmolina.Biblioteca.entities.Livro;
import br.com.klaynmolina.Biblioteca.repositories.LivroRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping
	public ResponseEntity<List<Livro>> listarLivros() {
		List<Livro> livros = livroRepository.findAll();
		return ResponseEntity.ok(livros);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
		Livro novoLivro = livroRepository.save(livro);
		return ResponseEntity.ok(novoLivro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Livro>> buscarLivroPorId(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
		Livro livroAtualizado = livroRepository.save(livro);
		if (livroAtualizado != null) {
			return ResponseEntity.ok(livroAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
