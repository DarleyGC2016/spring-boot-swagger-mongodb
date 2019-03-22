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

import br.com.darley.pessoas.modelo.Endereco;
import br.com.darley.pessoas.responses.Response;
import br.com.darley.pessoas.services.EnderecoService;
import io.swagger.annotations.ApiOperation;

//@Api(value = "API REST Pessoas")
//@RestController
//@RequestMapping(path = "/pessoas/endereco")
public class EnderecoControle {

	@Autowired
	private EnderecoService es;
	/*
	@ApiOperation(value = "Retorna uma  de um endereco")
	@GetMapping
	public ResponseEntity<Response<List<Endereco>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<Endereco>>(this.es.listAll()));
	}*/
	
	@ApiOperation(value = "Retorna o cadastro de um endereco")
	@PostMapping
	public ResponseEntity<Response<Endereco>> cadastar(@Valid @RequestBody Endereco endereco,BindingResult result) {
		
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Endereco>(erros));
		}
			
		return ResponseEntity.ok(new  Response<Endereco>(this.es.cadastrar(endereco)));
	}
	
	@ApiOperation(value = "Exclui um endereco")
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		this.es.delete(id);
		
	}
}
