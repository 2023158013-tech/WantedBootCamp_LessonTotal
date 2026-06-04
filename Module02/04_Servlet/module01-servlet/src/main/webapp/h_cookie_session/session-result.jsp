<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>세션 확인!</h1>
    <p>로그인된 사용자 ID: ${loggedInUser}</p>
    <p>로그인된 사용자 PWD: ${pwd}</p>
    <a href="/h_cookie_session/cookie_session.html">이전으로...</a>
    <a href="/expire">세션 강제로 만료시키기</a>
</body>
</html>
