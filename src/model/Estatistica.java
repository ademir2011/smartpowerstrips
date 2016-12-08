package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Database;

public class Estatistica {
	
	public Estatistica(Date horario, boolean valor){
		this.horario = horario;
		this.valor = valor;
	}
	
	public void addEstatistica(String nomeDoComponente) throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO powerstripsdb.estatisticas(componente_nome,horario,valor) VALUES ('"+nomeDoComponente+"',"+this.horario+","+this.valor+");";
		System.out.println(sql);
		Database.update(sql);
	}	
	
	public static List<Estatistica> estatisticas(String nomeDoComponente) throws ClassNotFoundException, SQLException{
		ResultSet rs = Database.query("select * from estatisticas where componente_nome = '"+ nomeDoComponente+"'");
		List<Estatistica> estatisticas = new ArrayList<Estatistica>();
		while(rs.next()) {
			Estatistica estatistica = new Estatistica(rs.getDate("horario"), rs.getBoolean("valor"));
			estatisticas.add(estatistica);
		} 
		
		return estatisticas;
	}
	
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public boolean isValor() {
		return valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}
	
	private Date horario;
	private boolean valor;
}
