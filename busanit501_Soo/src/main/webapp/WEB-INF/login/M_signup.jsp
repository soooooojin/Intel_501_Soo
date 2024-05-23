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

<form action="/M_signup" method="post">
    <input type="text" name="id" placeholder="아이디를 입력해주세요.">
    <input type="text" name="name" placeholder="이름을 입력해주세요.">
    <input type="password" name="pw" placeholder="패스워드를 입력해주세요.">
    <input type="password" name="pw2" placeholder="패스워드를 확인해주세요.">
    <button type="submit">회원가입</button>
    <br>
    <button type="reset">초기화</button>
</form>

</body>
</html>
