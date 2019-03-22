package br.com.darley.pessoas.modelo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String rua;	
	private String casa;
	private String quadra;
	private String cidade;	

	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@NotBlank(message = "Rua não pode deixar vazio")
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@NotBlank(message = "Casa não pode deixar vazio")
	public String getCasa() {
		return casa;
	}
	
	public void setCasa(String casa) {
		this.casa = casa;
	}
	
	@NotBlank(message = "Quadra não pode deixar vazio")
	public String getQuadra() {
		return quadra;
	}
	
	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}
	
	@NotBlank(message = "Quadra não pode deixar vazio")
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
