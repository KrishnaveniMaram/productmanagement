<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1">

		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th>
			
			</tr>
		</thead>


<tbody>
		<c:forEach items="${allcustomers}" var="customers">
	
				<tr>
					<td>${customers.id }</td>
					<td>${customers.name }</td>
				 	<td>${customers.email }</td>
				 	<td>${customers.phone }</td>
				
				</tr>
			</c:forEach>
		</tbody>


</table>
</body>
</html>