<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringJPA</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/ask" method="post">
  	Id del alumno a buscar:<br>
  	<input type="number" name="cod"><br>

  	<input type="submit" value="Buscar">
  	</form>
</body>
</html>