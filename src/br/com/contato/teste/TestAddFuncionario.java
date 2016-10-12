package br.com.contato.teste;

import br.com.contato.jdbc.dao.FuncionarioDAO;
import br.com.contato.jdbc.modelo.Funcionario;

public class TestAddFuncionario {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Kiko Santos");
		funcionario.setUsuario("kiko@santos");
		funcionario.setSenha("dog123");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.adiciona(funcionario);
		System.out.println("Funcionário gravado com sucesso!");
	
	}

}
