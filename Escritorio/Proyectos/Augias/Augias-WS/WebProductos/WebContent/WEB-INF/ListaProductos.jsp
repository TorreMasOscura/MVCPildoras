<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.* , com.AlPin.Productos.* "%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%

//Obtiene los productos del controlador

List<Productos> losProductos = (List<Productos>)request.getAttribute("ListaProductos");

%>

<body>

<%=

losProductos

%>

</body>
</html>