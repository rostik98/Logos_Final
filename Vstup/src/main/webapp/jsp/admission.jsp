<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

<title>Marks</title>
</head>
<body>
<div class="container">
        <div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1>Adding Your Marks</h1>
			</div>
			<div class="w3-container">
			 
           <form method="POST" action="${contextPath}/admission">
           	<c:forEach items="${subjects}" var="currentSubject">
							<label>Mark for ${currentSubject.name}</label>
							<input name="value${currentSubject.id}"/>
							<input type="hidden" name="subject${currentSubject.id}" value="${currentSubject.id}"/>
							</c:forEach>
							<input type="submit" value="Submit" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						
				</form>
				

				
            </div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>