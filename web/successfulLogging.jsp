<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successfully Logged In</title>
</head>
<body>

<h1>${requestScope.userLoggingCredential.loggingName}</h1><br/><br/>
<form action="./EnterNewValuesServlet" method="POST">
    <input type="submit" value="enter new value">
    <input type = "text" name = "loggingName" value="${requestScope.userLoggingCredential.loggingName}" style="display:none">
</form>
<form action="./ShowEnteredValuesServlet" method="POST">
    <input type="submit" value="show entered values">
    <input type = "text" name = "loggingName" value="${requestScope.userLoggingCredential.loggingName}" style="display:none">
</form>
<button type="button" onclick="window.location.href='index.html'">Logout</button>
</body>
</html>

