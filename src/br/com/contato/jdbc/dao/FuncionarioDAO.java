package br.com.contato.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.contato.jdbc.ConnectionFactory;
import br.com.contato.jdbc.modelo.Funcionario;

public class FuncionarioDAO {

	private Connection connection;
	
	public FuncionarioDAO(){
		
		this.connection = new ConnectionFactory().getConnection();
		System.out.println("Conectado Agora ! \n");
	}
	
	public void adiciona(Funcionario funcionario){
		
		String sql = "insert into funcionarios(nome,usuario,senha) values (?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Funcionario funcionario){
		
		String sql = "update funcionarios set nome=?, set usuario=?, set senha=? where id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Funcionario funcionario){
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id=?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getLista(){
		
		try {
			
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
			java.sql.ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				funcionarios.add(funcionario);
			}
			
			rs.close();
			stmt.close();
			return funcionarios;
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
}
