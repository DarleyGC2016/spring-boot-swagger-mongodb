package br.com.darley.pessoas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.darley.pessoas.modelo.Endereco;

public interface EnderecoRepository extends MongoRepository<Endereco, String>{

}
