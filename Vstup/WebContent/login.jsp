<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<link href="style.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div id="login">
<h3 class="text-center text-white pt-5">Login form</h3>
<div class="container">
  <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
    <form method="POST" action="${contextPath}/login" class="form-signin" id="login-form">
        <h3 class="text-center text-info">Login</h3>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
            <input id="username" name="email" type="text" class="form-control" placeholder="Email"
                   autofocus="true"/>
                   </div>
                   <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
            <input id="password" name="password" type="password" class="form-control" placeholder="Password"/>
            </div>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<div class="form-group">
            <button class="btn btn-lg btn-primary btn-block btn-info btn-md" type="submit">Log In</button>
            </div>
             <div id="register-link" class="text-right">
                                <a href="${contextPath}/registration" class="text-info">Register here</a>
                            </div>
        </div>

    </form>
    </div>
    </div>
    </div>

</div>
<!-- /container -->
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html> 