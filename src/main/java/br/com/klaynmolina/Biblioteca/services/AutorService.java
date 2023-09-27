package br.com.klaynmolina.Biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.klaynmolina.Biblioteca.entities.Autor;
import br.com.klaynmolina.Biblioteca.exceptionhandler.ResourceNotFoundException;
import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.RemovalException;
import br.com.klaynmolina.Biblioteca.repositories.AutorRepository;

@Service
public class AutorService {
    
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor criar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Autor atualizar(Long id, Autor autor) {
        Autor autorExistente = buscarPorId(id);
        if (autorExistente != null) {
            autor.setId(id);
            return autorRepository.save(autor);
        }
        return null;
    }

    public void excluir(Long id) throws RemovalException {
    	try {
			autorRepository.deleteById(id);
		} catch (Exception e) {
			throw new RemovalException(id);
		}
    }
}
