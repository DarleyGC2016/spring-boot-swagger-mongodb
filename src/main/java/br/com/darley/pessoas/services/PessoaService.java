package br.com.darley.pessoas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.darley.pessoas.modelo.Pessoa;
import br.com.darley.pessoas.repository.PessoaRepository;


@Service
public class PessoaService implements PessoaServiceInt{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@Override
	public List<Pessoa> listaPessoas() {
		// TODO Auto-generated method stub
		return this.pessoaRepository.findAll();
	}

	
	@Override
	public Pessoa cadastrar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return this.pessoaRepository.save(pessoa);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		 this.pessoaRepository.delete(id);
	}


	

}
