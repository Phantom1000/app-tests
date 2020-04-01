<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% for (int i = 1; i < 5; i++) { %> 
    <label>Вопрос № <%= i %></label><br />
    <input type="text" name="questions" /><br /><br />
<% } %>
<button type="submit">Сохранить</button>
