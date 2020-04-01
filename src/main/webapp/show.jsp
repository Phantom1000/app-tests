<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Test ${id}</title>
  </head>
  <body>
    <h2>Test ${id}</h2>
    <ul>
      <c:forEach items="${questions}" var="question" varStatus="status">
        <li>
          <h3>Вопрос № ${status.index + 1}</h3>
          <p>
            ${question.text}
          </p>
        </li>
      </c:forEach>
    </ul>
  </body>
</html>
