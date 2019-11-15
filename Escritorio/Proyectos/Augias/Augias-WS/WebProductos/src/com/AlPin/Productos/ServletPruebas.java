package com.AlPin.Productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletPruebas
 */
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Definir el pool de conexiones o DataSource
	
	@Resource(name="jdbc/Productos")
	DataSource pool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Creamos el objero printwriter
		PrintWriter salida = response.getWriter();
		
		response.setContentType("text/plain");
		
		//Creamos la conexion para la bbdd
		
		Connection conexion = null;
		
		Statement miStatement = null;
		
		ResultSet resultado = null;
		
		try {
			
			conexion = pool.getConnection();
			String miSql = "Select * from productos";
			resultado = miStatement.executeQuery(miSql);
			
			while(resultado.next()) {
				
				String nombreArticulo = resultado.getString(3);
				
				salida.println(nombreArticulo);				
				
			}			
			
		}catch(Exception e){
		
			e.printStackTrace();
			
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
