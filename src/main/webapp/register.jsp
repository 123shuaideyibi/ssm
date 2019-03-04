<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<button id="demo" onclick="">按钮</button>
<form action="${ctx}/user/register" method="post" id="form" class="form">
    <table border="0" align="center">
        <caption>
            用户注册
        </caption>
        <tr>
            <th>用户名：</th>
            <td><input type="text" name="username" id="username" placeholder="请输入您的用户名"/></td>
            <td colspan="1"><span id="tip_username">*用户名不能为空</span></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="password" id="password" placeholder="请输入您的密码"/></td>
            <td colspan="1"><span id="tip_password">*密码不能为空</span></td>
        </tr>
        <tr>
           <td align="center" colspan="3">
               <%--合并两列--%>
               <input type="submit" class="submit" value="注册"/>
               <%--<input type="reset" class="reset" value="重置"/>--%>
           </td>
        </tr>
    </table>
</form>
</body>
</html>
