<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit test</title>
</head>
<body>
    <h2>Edit test</h2>
    <form action="<c:url value='update?test=${id}' />" method="POST">
        <c:import url="form.jsp" />
    </form>
</body>
</html>