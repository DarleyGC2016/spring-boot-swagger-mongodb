package br.com.darley.pessoas.controle;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.darley.pessoas.modelo.Endereco;
import br.com.darley.pessoas.modelo.Pessoa;
import br.com.darley.pessoas.responses.Response;
import br.com.darley.pessoas.services.EnderecoServiceInt;
import br.com.darley.pessoas.services.PessoaServiceInt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Pessoas")
@RestController
@RequestMapping(path = "/pessoas")
public class PessoaControle {
   
	@Autowired
	private PessoaServiceInt serviceInt;
	@Autowired
	private EnderecoServiceInt es;

	/*
	@GetMapping
	public ResponseEntity<Response<List<Pessoa>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<Pessoa>>(this.serviceInt.listaPessoas()));
	}
	*/
	@ApiOperation(value = "Cadastra as pessoas e seus endereços.")
	@PostMapping
	public ResponseEntity<Response<Pessoa>> cadastar(@Valid @RequestBody Pessoa pessoa,BindingResult result) {
		
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Pessoa>(erros));
		}
		for(Endereco endereco:pessoa.getEnderecos()) {
			es.cadastrar(endereco);
		}
		return ResponseEntity.ok(new  Response<Pessoa>(this.serviceInt.cadastrar(pessoa)));
	}
	
	@ApiOperation(value = "Exclui uma pessoa pelo seu id ")
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		this.serviceInt.delete(id);

	}
	@ApiOperation(value = "Exclui um endereço.")
	@DeleteMapping(path = "/endereco/{idEndereco}")
	public void deleteEnd(@PathVariable(name = "idEndereco") String idEndereco) {
				this.es.delete(idEndereco);		
	}
	
}
