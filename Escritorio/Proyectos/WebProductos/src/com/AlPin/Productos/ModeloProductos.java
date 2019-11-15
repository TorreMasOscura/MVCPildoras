package com.AlPin.Productos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos) {
		
		this.origenDatos = origenDatos;
		
	}
	
	public List<Productos> getProductos() throws Exception{
		
		List<Productos> productos= new ArrayList<Productos>();
		
		Connection conexion = null;
		
		Statement miStatement = null;
		
		ResultSet resultado = null;
		
		//Establecer conexion
		
		conexion = origenDatos.getConnection();
		
		//Crear sentencia
		
		String sql = "Select * from productos";
		miStatement = conexion.createStatement();
		
		//Ejecutar sentencia
		
		resultado = miStatement.executeQuery(sql);		
		
		//Recorrer resultset obtenido
		
		while(resultado.next()) {
			
			String c_art = resultado.getString("CÓDIGOARTÍCULO");
			String seccion = resultado.getString("SECCIÓN");
			String n_art = resultado.getString("NOMBREARTÍCULO");
			double precio = resultado.getDouble("PRECIO");
			Date fecha = resultado.getDate("FECHA");
			String importado = resultado.getString("IMPORTADO");
			String p_orig = resultado.getString("PAÍSDEORIGEN");
			
			Productos temProductos = new Productos(c_art, seccion, n_art, precio, fecha, importado, p_orig);
			
			productos.add(temProductos);			
			
		}
		
		return productos;
	}
}
