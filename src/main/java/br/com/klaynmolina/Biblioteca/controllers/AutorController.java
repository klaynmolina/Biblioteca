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

import br.com.klaynmolina.Biblioteca.entities.Autor;
import br.com.klaynmolina.Biblioteca.repositories.AutorRepository;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@GetMapping
	public ResponseEntity<List<Autor>> listarAutores() {
		List<Autor> autores = autorRepository.findAll();
		return ResponseEntity.ok(autores);
	}

	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor) {
		Autor novoAutor = autorRepository.save(autor);
		return ResponseEntity.ok(novoAutor);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Autor>> buscarAutorPorId(@PathVariable Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		if (autor != null) {
			return ResponseEntity.ok(autor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
		Autor autorAtualizado = autorRepository.save(autor);
		if (autorAtualizado != null) {
			return ResponseEntity.ok(autorAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirAutor(@PathVariable Long id) {
		autorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
