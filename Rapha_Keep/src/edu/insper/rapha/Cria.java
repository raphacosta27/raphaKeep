package edu.insper.rapha;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;

@WebServlet("/cria")
public class Cria extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RECEBI POST AQUI cria");
		DAO dao = new DAO();
		String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Notas nota = new Notas();
		try {
			JSONObject json = new JSONObject(output);
			nota.setUser(json.getString("user"));
			nota.setTexto(json.getString("texto"));
			System.out.println(json);
			dao.adiciona(nota);
			dao.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}
}
