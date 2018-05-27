
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show entered Values</title>
</head>

<body>
<h1>Entered values: </h1><br/><br/>
<p>nick - userName - YearOfBirth - Place</p>
${requestScope.completeInfo.informations} <!--zobrazenie dat -->


</body>
</html>