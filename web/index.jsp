<%--
  Created by IntelliJ IDEA.
  User: zqh
  Date: 2017/11/28
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>home</title>
    <script>
      function doLogout() {
          //访问LogoutServlet注销当前用户
          window.location.href="LogoutServlet";
      }

    </script>
  </head>
  <body>
  <h1>颜皇伊的网站</h1>
  <hr/>
  <%--使用jsp标签判断session scope中的user对象是否为null，为null则代表未登录，则不展示注销登录按钮--%>
<c:if test="${user==null}">
  <a href="RegisterUIServlet" target="_blank">注册</a>
  <a href="LoginUIServlet">登录</a>
</c:if>
  <c:if test="${user!=null}">
    欢迎您:${user.userName}
    <input type="button" value="sign out" onclick="doLogout()">
  </c:if>
  </body>
</html>
