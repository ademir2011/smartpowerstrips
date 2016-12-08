package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Database;

public class Componente {

	public Componente(String nome, String descricao, String imageFilePath) {
		this.nome = nome;
		this.descricao = descricao;
		this.imageFilePath = imageFilePath;
	}

	public void addComponente(String login) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO powerstripsdb.componentes(usuario_login, nome, descricao, imageFilePath) VALUES ('"
				+ login + "','" + this.nome + "'" + "," + "'" + this.descricao + "'" + ",'" + this.imageFilePath + "'"
				+ ");";
		System.out.println(sql);
		Database.update(sql);
	}

	public void delComponente() throws ClassNotFoundException, SQLException {
		String sql = "delete from componentes where nome = '"+this.nome+"'";
		System.out.println(sql);
		Database.update(sql);
	}
	
	public static List<Componente> componentes(String login) throws ClassNotFoundException, SQLException {
		ResultSet rs = Database.query("select * from componentes where usuario_login = '" + login + "'");
		List<Componente> componentes = new ArrayList<Componente>();
		while (rs.next()) {
			Componente componente = new Componente(rs.getString("nome"), rs.getString("descricao"),
					rs.getString("imageFilePath"));
			componentes.add(componente);
		}

		return componentes;
	}

	public List<Estatistica> getComponenteEstatisticas() throws ClassNotFoundException, SQLException {
		List<Estatistica> estatisticas = Estatistica.estatisticas(this.nome);
		return estatisticas;
	}

	public void setComponenteEstatisticas(List<Estatistica> componenteEstatisticas) {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	private String nome;
	private String descricao;
	private String imageFilePath;
}