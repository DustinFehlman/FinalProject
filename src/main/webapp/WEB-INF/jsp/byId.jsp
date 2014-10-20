<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Zappos WMS</title>
</head>
<body>
<!-- jQuery (necessary for Bootstraps JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
<section class="container">
    <div class="row">
        <div class="col-lg-12">
    <h1 style="text-align:center"><img src="../../resources/bootstrap/images/Zappos_logo-1.jpg" style="height:50px; weight:100px"> WMS SHIPMENT SORTER</h1>
        </div>
    </div>
    <div class="row" style="padding-bottom:100px">
        <h1>Shipment for Order # ${orderNumber}</h1>
        <h1>${count}</h1>
        <c:forEach items="${items}" var="items">
            <div class="col-md-6" style="padding-bottom: 15px" >
                <pre style="background-image: url(../../resources/bootstrap/images/Open%20Box.jpg)">${items}</pre>
            </div>
        </c:forEach>
    </div>
        <div>
            <a href=" <spring:url value= "/order" /> " class="btn btn-lg btn-primary" id="Home" role="button" >Home</a>
            <a href=" <spring:url value= "/shipment/all" /> " class="btn btn-lg btn-primary" id="All" role="button" >Back to Orders</a>
        </div>

</section>
</body>
</html>
