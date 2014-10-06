<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Zappos WMS</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">

            <c:forEach items="${boxCount}" var="boxCounts">

                <h1>${boxCounts}</h1>

            </c:forEach>
            <c:forEach items="${webPrinter}" var="webPrint">

                <h4>${webPrint}</h4>
            </c:forEach>
        </div>
    </div>
</section>
</body>
</html>
