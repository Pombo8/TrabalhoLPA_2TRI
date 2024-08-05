package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

	public class PessoaDAO {
	private DataSource dataSource;
		
		public PessoaDAO(DataSource dataSource) {
			super();
			this.dataSource = dataSource;
		}
		public boolean inserirPessoa(String nome, char sexo, LocalDate dataNasc, String rg, String cpf, double salario, int tempoContribuicao, String areaTrabalho){
			
			Connection conexao = null;
			PreparedStatement statement = null;
			int resultado;
			
			try {
				Date date = java.sql.Date.valueOf(dataNasc);
				String sexoP = String.valueOf(sexo);
				
				conexao = dataSource.getConnection();
				
				String sql = "INSERT INTO `pessoa`( `nome`, `sexo`, `dataNasc`, `rg`,`cpf`, `salario`, `tempoContribuicao`, `areaTrabalho`) VALUES (?,?,?,?,?,?,?,?)";
				statement = conexao.prepareStatement(sql);
				statement.setString(1, nome);
				statement.setString(2, sexoP);
				statement.setDate(3, (java.sql.Date) date);
				statement.setString(4,rg);
				statement.setString(5, cpf);
				statement.setDouble(6, salario);
				statement.setInt(7, tempoContribuicao);
				statement.setString(8, areaTrabalho);
				resultado = statement.executeUpdate();
			}
			catch(SQLException e){
					e.printStackTrace();
					resultado = 0;
			}
			finally {
				fecharConexao(conexao,statement,null);
			}
			return resultado == 1;
		}
		
		public boolean excluirPessoa(String cpf){
			Connection conexao = null;
			PreparedStatement statement = null;
			int resultado;
			
			try {
				conexao = dataSource.getConnection();
				String sql = "delete from pessoa where cpf = ?;";
				statement = conexao.prepareStatement(sql);
				statement.setString(1, cpf);
				resultado = statement.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
				resultado = 0;
			}
			finally {
				fecharConexao(conexao,statement,null);
			}
			return resultado == 1;
		}
		
		public ArrayList<Pessoa> consultarPessoas(){
			
			ArrayList<Pessoa> listaPessoas = new ArrayList<>();
			Connection conexao = null;
			PreparedStatement statement = null;
			ResultSet resultado = null;
			
			try {
				conexao = dataSource.getConnection();
				String sql = "select * from pessoa";
				statement = conexao.prepareStatement(sql);
				resultado = statement.executeQuery();
				
				while(resultado.next()) {
					String nome = resultado.getString("nome");
					char sexo = resultado.getString("sexo").charAt(0);
					String rg = resultado.getString("rg");
					String cpf = resultado.getString("cpf");
					LocalDate dataNasc = resultado.getDate("dataNasc").toLocalDate();
					double salario = resultado.getDouble("salario");
					int tempoContribuicao = resultado.getInt("tempoContribuicao");
					String areaTrabalho = resultado.getString("areaTrabalho");
				
					
					Pessoa pessoa = new Pessoa(nome,sexo, dataNasc, rg, cpf, salario, tempoContribuicao, areaTrabalho);
					listaPessoas.add(pessoa);
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}finally {
				fecharConexao(conexao,statement,resultado);
			}
			return listaPessoas;
		}
		
		
		public boolean modificarPessoa(String nome, char sexo, LocalDate dataNasc, String rg, String cpf, double salario, int tempoContribuicao, String areaTrabalho){
			Connection conexao = null;
			PreparedStatement statement = null;
			int resultado;
			
			try {
				Date date = java.sql.Date.valueOf(dataNasc);
				conexao = dataSource.getConnection();
				String sql = "UPDATE `pessoa` SET `nome`=?,`sexo`=?,`dataNasc`=?,`salario`=?,`tempoContribuicao`=?,`areaTrabalho`=? WHERE cpf = ?";
				statement = conexao.prepareStatement(sql);
				statement.setString(1, nome);
				statement.setString(2, String.valueOf(sexo));
				statement.setDate(3,(java.sql.Date) date);
				statement.setDouble(4, salario);
				statement.setInt(5,tempoContribuicao);
				statement.setString(6, areaTrabalho);
				statement.setString(7, cpf);
				resultado = statement.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
				resultado = 0;
			}finally {
				fecharConexao(conexao,statement,null);
			}
			return resultado == 1;
			
		}
		private void fecharConexao(Connection conexao, PreparedStatement statement, ResultSet resultado) {
			try {
				if(conexao != null)
					conexao.close();
				if(statement != null)
					statement.close();
				if(resultado != null)
					statement.close();
			}catch(SQLException e){
				e.printStackTrace();	
			}
		
		}
		public Pessoa procurarPessoa(String cpf) {
			Pessoa pessoa = null;
			Connection conexao = null;
			PreparedStatement statement = null;
			ResultSet resultado = null;
			
			try {
				conexao = dataSource.getConnection();
				String sql = "select * from pessoa where cpf = ?;";
				statement = conexao.prepareStatement(sql);
				statement.setString(1, cpf);
				resultado = statement.executeQuery();
				
				if(resultado.next()){
					String nome = resultado.getString("nome");
					char sexo = resultado.getString("sexo").charAt(0);
					LocalDate dataNasc = resultado.getDate("dataNasc").toLocalDate();
					String rg = resultado.getString("rg");
					double salario = resultado.getDouble("salario");
					int tempoContribuicao = resultado.getInt("tempoContribuicao");
					String areaTrabalho = resultado.getString("areaTrabalho");
					pessoa = new Pessoa(nome,sexo,dataNasc,rg,cpf,salario,tempoContribuicao,areaTrabalho);
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally {
				fecharConexao(conexao,statement,resultado);
			}
			return pessoa;
		}
}
