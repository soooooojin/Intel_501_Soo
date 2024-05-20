<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoUpd</title>
</head>
<body>
<h1><%= "todoUpd.jsp" %>
</h1>
<br/>
<h1><%= "임시 todoUpd 화면." %>
</h1>
<form method="post" action="/todo/update">
  <button type="submit">수정적용하기</button>
</form>

<form method="post" action="/todo/delete">
  <button type="submit">삭제</button>
</form>
</body>
</html>
