package br.com.contato.teste;

import java.util.Calendar;

import br.com.contato.jdbc.dao.ContatoDao;
import br.com.contato.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {

		Contato contato = new Contato();
		contato.setNome("GeovaneDouglas");
		contato.setEmail("geovanedsilveira@gmail.com");
		contato.setEndereco("RuaLadainha,669");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado com Sucesso!");
	}

}
