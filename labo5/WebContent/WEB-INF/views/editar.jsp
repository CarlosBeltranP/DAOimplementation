<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Informacion de Usuario</h1>
	<form:form  action="${pageContext.request.contextPath}/edit" method="POST" modelAttribute="students">
		<form:input type="hidden" id="cStudent" path="cStudent" />
		<label>Nombre : </label>
		<form:input type="text" name="name" path="sName"/>
		<br>
		
		<label>Apellido: </label>
		<form:input type="text" name="lName" path="lName"/>
		<br>
		
		<label>Edad: </label>
		<form:input type="text" name="age" path="sAge"/>
		<br>
		
		<label>Estado: </label>
		<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label><br>
		<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label><br>
		
		<input type="submit" value="Guardar Cambios">
	</form:form>
</body>
</html>