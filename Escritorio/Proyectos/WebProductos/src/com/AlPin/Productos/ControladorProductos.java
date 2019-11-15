package com.AlPin.Productos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModeloProductos modeloProductos;
	@Resource(name = "jdbc/Productos")
	DataSource pool;

	public void init() throws ServletException {

		super.init();

		try {

		} catch (Exception e) {

			throw new ServletException(e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtener la lista de productos desde el modelo

		List<Productos> productos;

		try {

			productos = modeloProductos.getProductos();

			// Agregamos la lista de productos al request

			request.setAttribute("listaProductos", productos);

			// Enviamos request a la pagina JSP

			RequestDispatcher dis = request.getRequestDispatcher("listaProductos.jsp");

			dis.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
