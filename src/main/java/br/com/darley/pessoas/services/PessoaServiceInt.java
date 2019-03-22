package br.com.darley.pessoas.services;

import java.util.*;



import br.com.darley.pessoas.modelo.Pessoa;


public interface PessoaServiceInt {
    List<Pessoa> listaPessoas();
    Pessoa cadastrar(Pessoa pessoa);
    void delete (String  id);
}
