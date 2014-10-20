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
        <h1 style="text-align:center"><img src="../../resources/bootstrap/images/Zappos_logo-1.jpg" style="height:50px; weight:100px"> WMS SHIPMENT SORTER</h1>
        <h1>My History</h1>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </div>
<a href=" <spring:url value= "/order" /> " class="btn btn-primary btn-lg" id="Home" role="button" >Home</a>
<div class = "row">
<div class="col-md-6" style="padding-top: 15px">
    <c:forEach items="${orderNumbers}" var="orderNumber">
        <a href=" <spring:url value= "/shipment/byId?orderNumber=${orderNumber}" /> " class="btn btn-default btn-block" id="Pack" role="button" style="max-width: 400px">Order ID: ${orderNumber}</a>
    </c:forEach>
</div>
<div class="col-md-6" style="padding: 100px">
     <img src="../../resources/bootstrap/images/derpdog.gif" />
</div>
</div>
</div>

</body>
</html>