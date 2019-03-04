<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<form action="${ctx}/user/login" method="post">
    <table border="0" align="center">
        <caption>
            用户登录
        </caption>
        <tr>
            <th>用户名：</th>
            <td><input type="text" name="username" placeholder="请输入您的用户名"/></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="password" placeholder="请输入您的用户名"/></td>
        </tr>
        <tr>
            <td align="center" colspan="3">
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
    <%--<input type="text" name="username" placeholder="请输入您的用户名"/><br>--%>
    <%--<input type="password" name="password" placeholder="请输入您的用户名"/><br>--%>
    <%--<input type="submit" value="登录">--%>
</form>
</body>
</html>
