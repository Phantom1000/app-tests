<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Test</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  </head>
  <body>
    <h2>Tests</h2>
    <ul>
      <c:forEach items="${tests}" var="test">
        <li>
          <a href="<c:url value='?test=${test.id}' />">Тест ${test.id}</a>
          <form action="<c:url value='destroy?id=${test.id}' />" method="POST">
            <button type="submit">Удалить</button>
          </form>
        </li>
      </c:forEach>
    </ul>
    <a href="<c:url value='create.jsp' />">Создать тест</a>
  </body>
</html>
