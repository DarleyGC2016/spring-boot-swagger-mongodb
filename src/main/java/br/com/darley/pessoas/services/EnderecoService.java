package br.com.darley.pessoas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.darley.pessoas.modelo.Endereco;
import br.com.darley.pessoas.repository.EnderecoRepository;

@Service
public class EnderecoService implements EnderecoServiceInt{

	@Autowired
	private EnderecoRepository er;
	
	@Override
	public List<Endereco> listAll() {
		// TODO Auto-generated method stub
		return this.er.findAll();
	}

	@Override
	public Endereco cadastrar(Endereco endereco) {
		// TODO Auto-generated method stub
		return this.er.save(endereco);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.er.delete(id);
	}

	@Override
	public void cadastra(Endereco endereco) {
		// TODO Auto-generated method stub
		this.er.save(endereco);
	}

}
