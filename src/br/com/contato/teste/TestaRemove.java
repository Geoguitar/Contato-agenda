package br.com.contato.teste;

import br.com.contato.jdbc.dao.ContatoDao;
import br.com.contato.jdbc.modelo.Contato;

public class TestaRemove {

	public static void main(String[] args) {

		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		contato.setId((long) 3);
		dao.remove(contato);
	}
}
