package br.com.klaynmolina.Biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.klaynmolina.Biblioteca.entities.Editora;
import br.com.klaynmolina.Biblioteca.exceptionhandler.ResourceNotFoundException;
import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.RemovalException;
import br.com.klaynmolina.Biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
	
    private final EditoraRepository editoraRepository;

    @Autowired
    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public List<Editora> listarTodos() {
        return editoraRepository.findAll();
    }

    public Editora criar(Editora editora) {
        return editoraRepository.save(editora);
    }

    public Editora buscarPorId(Long id) {
        return editoraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Editora atualizar(Long id, Editora editora) {
    	Editora editoraExistente = buscarPorId(id);
        if (editoraExistente != null) {
        	editora.setId(id);
            return editoraRepository.save(editora);
        }
        return null;
    }

    public void excluir(Long id) throws RemovalException {
    	try {
			editoraRepository.deleteById(id);
		} catch (Exception e) {
			throw new RemovalException(id);
		}
    }
}
