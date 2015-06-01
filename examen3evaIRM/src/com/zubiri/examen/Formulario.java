package com.zubiri.examen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulario
 */
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_BD="jdbc:mysql://localhost/formulario";
	private static final String USUARIO="root";
	private static final String CONTRA="zubiri";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String dni=request.getParameter("dni");
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String ano=request.getParameter("ano");
		
		//1
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<td>dni</td><td>nombre</td><td>apellido</td><td>año nacimiento</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>"+dni+"</td><td>"+nombre+"</td><td>"+apellido+"</td><td>"+ano+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<a href=index.html>volver</a>");
		out.println("</body>");
		out.println("</html>");
		
		Connection con = null;
		Connection crear = null;
		Statement sentencia = null;
		Statement sentencia2 = null;
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("conexion");
			//2
			con = DriverManager.getConnection(URL_BD,USUARIO,CONTRA);
			sentencia = con.createStatement();
			String sql="";
			
			//3
			sql="CREATE TABLE IF NOT EXISTS personas (dni VARCHAR(10),nombre VARCHAR(20),apellido VARCHAR(20),ano VARCHAR(4), PRIMARY KEY (dni))";
			sentencia.executeUpdate(sql);
			
			//INSERT INTO personas(dni,nombre,apellido,ano) VALUES ("123456789E","iosu","recalde","1992");
			sql="INSERT INTO personas(dni,nombre,apellido,ano) VALUES (\""+dni+"\",\""+nombre+"\",\""+apellido+"\",\""+ano+"\")";
			System.out.println(sql);
			int insertar=sentencia.executeUpdate(sql);
			
			if(insertar==1){
				System.out.println("persona anadida");
			}else{
				System.out.println("error al anadir a persona");
			}
		}catch(Exception e){
			System.out.println("error al conectar");
			System.out.println("error "+e);
			try{
				System.out.println("creacion de bd");	
				crear = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=zubiri"); 
				sentencia2 = crear.createStatement();
				//3
				sentencia2.executeUpdate("CREATE DATABASE IF NOT EXISTS formulario");				
				String sql;
				
				con = DriverManager.getConnection(URL_BD,USUARIO,CONTRA);
				sentencia2 = con.createStatement();
	
				sql="CREATE TABLE IF NOT EXISTS personas (dni VARCHAR(10),nombre VARCHAR(20),apellido VARCHAR(20),ano VARCHAR(4), PRIMARY KEY (dni))";
				sentencia2.executeUpdate(sql);
				
				//4
				sql="INSERT INTO personas(dni,nombre,apellido,ano) VALUES (\""+dni+"\",\""+nombre+"\",\""+apellido+"\",\""+ano+"\")";
				
				System.out.println(sql);
				int insertar=sentencia2.executeUpdate(sql);
				
				if(insertar==1){
					System.out.println("persona anadida");
				}else{
					System.out.println("error al anadir a persona");
				}
			
			}catch(Exception excepcion){
				System.out.println("error en la creacion de la bd");
				System.out.println("error "+excepcion);
			}
		}
	}

}
