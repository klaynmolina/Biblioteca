package br.com.klaynmolina.Biblioteca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.klaynmolina.Biblioteca.entities.Editora;
import br.com.klaynmolina.Biblioteca.repositories.EditoraRepository;

@RestController
@RequestMapping(value = "/editoras")
public class EditoraController {

	@Autowired
	private EditoraRepository editoraRepository;

	public EditoraController(EditoraRepository editoraRepository) {
		this.editoraRepository = editoraRepository;
	}

	@GetMapping
	public ResponseEntity<List<Editora>> listarEditoras() {
		List<Editora> editoras = editoraRepository.findAll();
		return ResponseEntity.ok(editoras);
	}

	@PostMapping
	public ResponseEntity<Editora> criarEditora(@RequestBody Editora editora) {
		Editora novaEditora = editoraRepository.save(editora);
		return ResponseEntity.ok(novaEditora);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Editora>> buscarEditoraPorId(@PathVariable Long id) {
		Optional<Editora> editora = editoraRepository.findById(id);
		if (editora != null) {
			return ResponseEntity.ok(editora);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Editora> atualizarEditora(@PathVariable Long id, @RequestBody Editora editora) {
		Editora editoraAtualizada = editoraRepository.save(editora);
		if (editoraAtualizada != null) {
			return ResponseEntity.ok(editoraAtualizada);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirEditora(@PathVariable Long id) {
		editoraRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
