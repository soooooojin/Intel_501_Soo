<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP2 - M_login.jsp</title>
</head>
<body>

<c:if test="${param.result == 'error'}">
<h1>로그인 에러</h1>
</c:if>

<form action="/M_login" method="post">
    <input type="text" name="id" placeholder="아이디를 입력해주세요.">
    <input type="number" name="pw"placeholder="패스워드를 입력해주세요.">
    <label for="auto">자동 로그인</label>
    <input type="checkbox" name="auto" id="auto">
    <button type="submit">로그인</button>
</form>
<form action="/M_signup" method="get">
    <button type="submit">회원가입</button>
</form>

</body>
</html>
