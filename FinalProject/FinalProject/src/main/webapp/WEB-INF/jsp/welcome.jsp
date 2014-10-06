<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Zappos WMS</title>
</head>
<body>
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
