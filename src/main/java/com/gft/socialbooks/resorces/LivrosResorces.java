package com.gft.socialbooks.resorces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft.socialbooks.domain.Livro;
import com.gft.socialbooks.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosResorces {
	@Autowired
	private LivrosRepository livrosRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar() {
		return livrosRepository.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Livro livro) {
		livrosRepository.save(livro);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Livro> buscar(@PathVariable("id") Long id) {
		return livrosRepository.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable("id") Livro livro) {
		this.livrosRepository.delete(livro);
		return "Livro excluido com sucesso";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		livrosRepository.save(livro);
		return "Livro atualizado com sucesso!";
	}
}