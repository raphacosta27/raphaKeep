package edu.insper.rapha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.*;

public class DAO {
	
private Connection connection = null;

public DAO() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "Katchin98");
		
	} catch (ClassNotFoundException | SQLException  e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public List<Notas> getLista(){
		
		List<Notas> notas = new ArrayList<Notas>();
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Notas");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setId(rs.getInt("id"));
				nota.setTexto(rs.getString("texto"));
				notas.add(nota);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notas;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void adiciona(Notas nota) {
		String sql = "INSERT INTO Notas" +
		"(texto) values(?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getTexto());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void altera(Notas nota) {
		System.out.println(nota.getTexto());
		String sql = "UPDATE Notas SET " + "texto=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getTexto());
			stmt.setInt(2, nota.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer getCount(){
		Integer total = null;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = connection.prepareStatement("SELECT count(*) FROM Notas");
			rs = stmt.executeQuery();
			while (rs.next()) {
				total = rs.getInt("count(*)");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
		
	}
	//fazer GetId para descobrir quantas notas existem
	
	public void remove(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(String.format("DELETE FROM Notas WHERE id=%s",id));
			System.out.println("DELETANDO ID " + id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
