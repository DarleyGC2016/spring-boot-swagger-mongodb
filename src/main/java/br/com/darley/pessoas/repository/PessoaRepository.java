package br.com.darley.pessoas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.darley.pessoas.modelo.Pessoa;


public interface PessoaRepository extends MongoRepository<Pessoa,String> {

	

}
