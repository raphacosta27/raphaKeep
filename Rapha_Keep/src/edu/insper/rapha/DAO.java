package edu.insper.rapha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
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
			stmt = connection.prepareStatement("SELECT * FROM Notas ORDER BY date DESC");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setId(rs.getInt("id"));
				nota.setTexto(rs.getString("texto"));
				nota.setData(rs.getTimestamp("date"));
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
	
	public List<Users> getUsers(){
		
		List<Users> users = new ArrayList<Users>();
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Users");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setUser(rs.getString("user"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void singIn(Users user) {
		String sql = "INSERT INTO Users" +
		"(user, password) values(?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUser());
			stmt.setString(2, user.getPassword()); 
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adiciona(Notas nota) {
		String sql = "INSERT INTO Notas" +
		"(texto, date) values(?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getTexto());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			stmt.setObject(2, timestamp); 
			System.out.println(timestamp);
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
