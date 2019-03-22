package br.com.darley.pessoas.responses;

import java.util.List;

public class Response<T> {
     
	private T data;
	private List<String> erros;
	
	
	
	public T getData() {
		return data;
	}



	public void setData(T data) {
		this.data = data;
	}



	public List<String> getErros() {
		return erros;
	}



	public void setErros(List<String> erros) {
		this.erros = erros;
	}



	public Response(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}



	public Response(List<String> erros) {
		super();
		this.erros = erros;
	}
	
	
}
