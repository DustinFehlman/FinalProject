<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order</title>
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Zappos WMS</title>
</head>
<body>
     <!-- jQuery (necessary for Bootstraps JavaScript plugins) -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
     <!-- Include all compiled plugins (below), or include individual files as needed -->
     <script src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
<section>
    <div  style = "float: left; padding-left: 150px">

            <c:forEach items="${boxCount}" var="boxCounts">

                <h1>${boxCounts}</h1>

            </c:forEach>

            <c:forEach items="${webPrinter}" var="webPrint">

                <h4>${webPrint}</h4>
            </c:forEach>
    </div>

   <div style = "float: right; padding-right: 400px">
       <c:forEach items="${orderInfo}" var="orderTally">


           <h2>${orderTally}</h2>

       </c:forEach>
       <input type="button" value="Pack" id="Pack" >
       <input type="button" value="Skip" id="Skip" >
   </div>

</section>
</body>
</html>
