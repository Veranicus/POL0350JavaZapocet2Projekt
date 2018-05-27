<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form for adding new values</title>
</head>
<body>
<h2>${requestScope.userLoggingCredential.loggingName}</h2><br/><br/>


<form action="./UserDataControlServlet" method="POST">
    <h1>Enter new information: </h1><br>
    Name: <input type="text" name="userName"><br/>
    Year Of Birth: <input type="text" name="yearOfBirth"><br/>
    Place: <input type="text" name="userPlace"><br/><br/>
    <input type = "text" name = "loggingName" value="${requestScope.userLoggingCredential.loggingName}" style="display:none">
    <input type="submit" value="add values">
</form>

</body>
</html>
