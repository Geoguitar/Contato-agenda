package br.com.contato.jdbc.modelo;

import java.util.Calendar;

public class Contato {
	
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	public String getNome(){
		
		return this.nome;
	}
	
	public void setNome(String novoNome){
		
		this.nome = novoNome;
	}
	
	public String getEmail(){
		
		return this.email;
	}
	
	public void setEmail(String novoEmail){
		
		this.email = novoEmail;
	}
	
	public String getEndereco(){
		
		return this.endereco;
	}
	
	public void setEndereco(String novoEndereco){
		
		this.endereco = novoEndereco;
	}
	
	public Long getId(){
		
		return this.id;
	}
	
	public void setId(Long i){
		
		this.id = i;
	}
	
	public Calendar getDataNascimento(){
		
		return this.dataNascimento;
	}
	
	public void setDataNascimento(Calendar dataNascimento){
		
		this.dataNascimento = dataNascimento;
	}
	
}
