package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Database;

public class Usuario {
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Componente> getUsuarioComponentes() throws ClassNotFoundException, SQLException{
		List<Componente> componentes = Componente.componentes(this.login);
		return componentes;
	}

	public void setUsuarioComponentes(List<Componente> usuarioComponentes) {
	}
	
	public Usuario(String login, String senha){
		this.login = login;
		this.senha = senha;	
	}
	
	public boolean autenticate() throws ClassNotFoundException, SQLException{
		ResultSet rs = Database.query("select * from usuarios");
		while(rs.next()) {
			String auxLogin = rs.getString("login");
			String auxPassword = rs.getString("senha");
			
			if(this.login.equals(auxLogin) && this.senha.equals(auxPassword)){
				return true;
			}
		} 
		
		return false;
	}
	
	public void addUsuario() throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO powerstripsdb.usuarios(login,senha) VALUES ("+"'"+this.login+"'"+","+"'"+this.senha+"');";
		System.out.println(sql);
		Database.update(sql);
	}

	private String login;
	private String senha;
}