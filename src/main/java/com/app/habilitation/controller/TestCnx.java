package com.app.habilitation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlet")
public class TestCnx  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// établir la connexion à mysql :
		
		String user="nawfel";
		String password="hr";
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:XE?useSSL=false&serverTimezone=UTC";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		try {
			
			PrintWriter out= response.getWriter();
			out.println("Connection à  la base de donnée :"+jdbcUrl);
			
			Class.forName(driver);
			Connection cnx;
			cnx=DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("Success !!!!!!!!!");
			
			cnx.close();
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}


}
