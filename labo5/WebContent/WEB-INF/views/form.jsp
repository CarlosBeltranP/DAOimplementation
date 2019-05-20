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
	<h1>Agregar nuevo usuario </h1>
	<form:form  action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="student">
	
		<label>Ingrese un nombre : </label>
		<form:input type="text" name="name" path="sName"/>
		<br>
		
		<label>Ingrese un Apellido: </label>
		<form:input type="text" name="lName" path="lName"/>
		<br>
		
		<label>Ingrese edad: </label>
		<form:input type="text" name="age" path="sAge"/>
		<br>
		
		<label>Estado del Estudiante: </label>
		<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label><br>
		<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label><br>
		
		<input type="submit" value="Agregar Estudiante">
	</form:form>
</body>
</html>