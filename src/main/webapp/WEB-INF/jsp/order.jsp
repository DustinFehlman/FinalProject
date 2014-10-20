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

    <h1 style="text-align:center"><img src="../../resources/bootstrap/images/Zappos_logo-1.jpg" style="height:50px; weight:100px"> WMS SHIPMENT SORTER</h1>

    </div>
    <div class="row">

   <div class="col-md-6" style="padding-bottom: 15px">
       <c:forEach items="${orderInfo}" var="orderTally">
           <h2>${orderTally}</h2>
       </c:forEach>
       <a href=" <spring:url value= "/shipment?orderNumber=${orderNumber}" /> " class="btn btn-success btn-lg" id="Pack" role="button" >Pack</a>
       <a href=" <spring:url value= "/skip?orderNumber=${orderNumber}" /> " class="btn btn-danger btn-lg" id="Skip" role="button" >Skip</a>


   </div>
   <div class="col-md-6" style="padding:100px">
        <img src="../../resources/bootstrap/images/derpdog.gif" />
   </div>
   </div>

</section>
</body>
</html>
