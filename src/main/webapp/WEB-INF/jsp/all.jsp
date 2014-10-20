<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <title>All Orders</title>
</head>
<body>
<!-- jQuery (necessary for Bootstraps JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
<div class="container">
    <div class = "row">
        <h1>My History</h1>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </div>
<a href=" <spring:url value= "/order" /> " class="btn btn-primary btn-lg" id="Home" role="button" >Home</a>
<div class = "row">
<c:forEach items="${orderNumbers}" var="orderNumber">
    <a href=" <spring:url value= "/order/byId?orderNumber=${orderNumber}" /> " class="btn btn-default btn-block" id="Pack" role="button" style="max-width: 400px; margin: 0 auto 10px;">Order ID: ${orderNumber}</a>
</c:forEach>
</div>
</div>

</body>
</html>