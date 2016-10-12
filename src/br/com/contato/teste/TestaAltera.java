package br.com.contato.teste;

import java.util.Calendar;

import br.com.contato.jdbc.dao.ContatoDao;
import br.com.contato.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {

		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();

		contato.setNome("Kenia Santos");
		contato.setEmail("keniaSantos@gmail.com");
		contato.setEndereco("Rua Ladainha,669-Palmares B");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long) 1);
		dao.altera(contato);
		
	}

}
