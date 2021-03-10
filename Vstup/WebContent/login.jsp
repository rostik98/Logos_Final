<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">



<link href="style.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
<div id="login">
<div class="container">
  <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                <h2 class="form-heading"><spring:message code="login.title"/></h2>
                    <div id="login-box" class="col-md-12">
    <form method="POST" action="${contextPath}/login" class="form-signin" id="login-form">
        <h3 class="text-center text-info">Login</h3>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
            <input id="username" name="email" type="text" class="form-control" placeholder="<spring:message code='login.email'/>"
                   autofocus="true"/>
                   </div>
                   <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
            <input id="password" name="password" type="password" class="form-control" placeholder="<spring:message code='login.password'/>"/>
            </div>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<div class="form-group">
            <button class="btn btn-lg btn-primary btn-block btn-info btn-md" type="submit"><spring:message code='login.signin'/></button>
            </div>
           
             
        </div>

    </form>
     <div>
				<fieldset>
					<label><spring:message code="login.choose_language" /></label> <select
						id="locales">
						<option value="en"><spring:message code='login.english'/></option>
						<option value="uk"><spring:message code='login.ukrainian'/></option>

					</select>
				</fieldset>
			</div>
    <div id="register-link" class="text-right">
                                <a href="${contextPath}/registration" class="text-info"><spring:message code='login.create_account'/></a>
                            </div>
    </div>
    </div>
    </div>

</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>
</body>
</html> 