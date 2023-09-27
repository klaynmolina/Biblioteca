package br.com.klaynmolina.Biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.klaynmolina.Biblioteca.entities.Livro;
import br.com.klaynmolina.Biblioteca.exceptionhandler.ResourceNotFoundException;
import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.DatabaseException;
import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.RemovalException;
import br.com.klaynmolina.Biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
    
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro criar(Livro livro) {
        try {
			return livroRepository.save(livro);
		} catch (Exception e) {
			throw new DatabaseException(livro.getId());
		}
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Livro atualizar(Long id, Livro livro) {
        try {
			Livro livroExistente = buscarPorId(id);
			if (livroExistente != null) {
			    livro.setId(id);
			    return livroRepository.save(livro);
			}
		} catch (Exception e) {
			throw new DatabaseException(livro.getId());
		}
        return null;
    }

    public void excluir(Long id) throws RemovalException {
        try {
			livroRepository.deleteById(id);
		} catch (Exception e) {
			throw new RemovalException(id);
		}
    }
}
