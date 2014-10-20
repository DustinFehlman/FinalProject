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
            <h1>ZAPPOS WMS SHIPMENT SORTER</h1>
        </div>
    </div>
    <div class="row">

        <div class="col-md-6" style="padding-bottom: 15px">
            <c:forEach items="${orderInfo}" var="orderTally">
                <h2>${orderTally}</h2>
            </c:forEach>
            <a href=" <spring:url value= "/order" /> " class="btn btn-lg btn-primary" id="Home" role="button" >Home</a>
            <a href=" <spring:url value= "/order/all" /> " class="btn btn-lg btn-primary" id="All" role="button" >Back to Orders</a>
        </div>
    </div>

</section>
</body>
</html>
