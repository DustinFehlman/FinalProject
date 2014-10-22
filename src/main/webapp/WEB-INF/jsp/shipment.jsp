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
<body style="background-color: #EEEEEE">
     <!-- jQuery (necessary for Bootstraps JavaScript plugins) -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
     <!-- Include all compiled plugins (below), or include individual files as needed -->
     <script src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
<section class="container">
    <div class="row" style="background-color: #FFFFFF; border-style: solid">
    <div class="col-lg-12">
    <h1 style="text-align:center"><img src="../../resources/bootstrap/images/Zappos_logo-1.jpg" style="height:50px; weight:100px"> WMS SHIPMENT SORTER</h1>
    </div>
    </div>
    <div class="row" style="padding-bottom:100px">

        <h1>${count}</h1>
        <c:forEach items="${items}" var="items" varStatus="loopStatus">
            <c:if test="${loopStatus.index % 2 == 0}"><div class="row"></div></c:if>
            <div class="col-md-6" style="padding-bottom: 15px;" >
            <pre style="background-color: #FFEECC; box-shadow: 10px 10px 5px #888888; font-size: 18px; font-weight: bold; font-family:verdana">${items}</pre>
        </div>
        </c:forEach>
   </div>
   <div>
        <a href=" <spring:url value="/cancel?orderNumber=${orderNumber}" />" class="btn btn-danger btn-lg" id="Skip" role="button" style="position:fixed;right:50px;bottom:20px">Cancel</a>
        <a href=" <spring:url value= "/shipment/all" /> " class="btn btn-primary btn-lg" id="History" role="button" style="position:fixed;right:150px;bottom:20px">Order History</a>
        <a href=" <spring:url value= "/order" /> " class="btn btn-success btn-lg" id="Done" role="button" style="position:fixed;right:300px;bottom:20px">Next Order</a>
   </div>
</section>
</body>
</html>
