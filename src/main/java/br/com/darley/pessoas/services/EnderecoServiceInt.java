package br.com.darley.pessoas.services;

import java.util.List;

import br.com.darley.pessoas.modelo.Endereco;

public interface EnderecoServiceInt {
    List<Endereco> listAll();
    Endereco cadastrar(Endereco endereco);
    void cadastra(Endereco endereco);
    void delete(String id);
}
