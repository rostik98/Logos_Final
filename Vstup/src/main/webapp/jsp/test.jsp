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

    <title>Periodicals</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container">


                <c:forEach items="${marks}" var="currentEntrant">

                    <div class="w3-card-4" style="width: 20%; margin:2%" >
                        <img src="https://kaverisias.com/wp-content/uploads/2018/01/catalog-default-img.gif" alt="Norway" style="width: 100%">
                        <div class="w3-container w3-center">
                            <h3>${currentEntrant.value}</h3>
                            <h3>${currentEntrant.id}</h3>
                            <p>${currentEntrant.entrant.id}</p>
                            <p>${currentEntrant.entrant.firstName}</p>
                        </div>
                        <button class="w3-button w3-block w3-dark-grey">see info about entrant</button>
                            <button class="w3-button w3-block w3-dark-grey" onclick="/delete?markId=${currentEntrant.id}">delete</button>
                        </form>
                    </div>

                </c:forEach>
        </div>

<!-- /container -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>