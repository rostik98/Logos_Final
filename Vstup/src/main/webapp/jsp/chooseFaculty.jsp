<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>jlgfh;idyfgjhl</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">


		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container">
			 
<form method="POST" action="${contextPath}/chooseFaculty">
           	<c:forEach items="${FACULTIES}" var="currentEntrant">
							<h3>${currentEntrant.name}</h3>
								<p>${currentEntrant.budgetPlaces}</p>
								<p>${currentEntrant.passingScore}</p>
							</c:forEach>
							<input name="name"/>
							<input type="submit" value="Submit" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

				</form>

				
            </div>

		</div>


	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>