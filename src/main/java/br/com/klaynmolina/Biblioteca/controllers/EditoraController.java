package br.com.klaynmolina.Biblioteca.controllers;

import java.util.List;

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
import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.RemovalException;
import br.com.klaynmolina.Biblioteca.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private final EditoraService editoraService;

    @Autowired
    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras() {
        List<Editora> editoras = editoraService.listarTodos();
        return ResponseEntity.ok(editoras);
    }

    @PostMapping
    public ResponseEntity<Editora> criarEditora(@RequestBody Editora editora) {
        Editora novaEditora = editoraService.criar(editora);
        return ResponseEntity.ok(novaEditora);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarEditoraPorId(@PathVariable Long id) {
        Editora editora = editoraService.buscarPorId(id);
        if (editora != null) {
            return ResponseEntity.ok(editora);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> atualizarEditora(@PathVariable Long id, @RequestBody Editora editora) {
        Editora editoraAtualizada = editoraService.atualizar(id, editora);
        if (editoraAtualizada != null) {
            return ResponseEntity.ok(editoraAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEditora(@PathVariable Long id) throws RemovalException {
        editoraService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
