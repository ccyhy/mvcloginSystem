<%--
  Created by IntelliJ IDEA.
  User: zqh
  Date: 2017/11/28
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up</title>
</head>
<body style="text-align: center;">
<form action="RegisterServlet" method="post">
    <table width="60%" border="1">
        <tr>
            <td>用户名</td>
            <td>

                <input type="text" name="userName" value="${bean.userName}">${bean.errors.userName}
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="userPwd" value="${bean.userPwd}">${bean.errors.userPwd}
            </td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td>
                <input type="password" name="confirmPwd" value="${bean.confirmPwd}">${bean.errors.confrimPwd}
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email" value="${bean.email}">${bean.errors.email}
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="text" name="birthday" value="${bean.birthday}">${bean.errors.birthday}
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="清空">
            </td>
            <td>
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
