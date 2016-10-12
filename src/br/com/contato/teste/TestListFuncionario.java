package br.com.contato.teste;

import java.util.List;

import br.com.contato.jdbc.dao.FuncionarioDAO;
import br.com.contato.jdbc.modelo.Funcionario;

public class TestListFuncionario {

	public static void main(String[] args) {

		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.getLista();
		
		for (Funcionario funcionario : funcionarios){
			
			System.out.println("Nome:" + funcionario.getNome());
			System.out.println("Usuário:" + funcionario.getUsuario() + "\n");
			
		}
	}

}
