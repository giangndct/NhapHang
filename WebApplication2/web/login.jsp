<%-- 
    Document   : login.jsp
    Created on : 30-10-2023, 22:35:31
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link 
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/boot
            strap.min.css" rel="stylesheet" integrity="sha384-
            Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi
            " crossorigin="anonymous">
        <title>Dang Nhap</title>
    </head>
    <body>
        <h1>Đăng nhập</h1>
        <form action="login" method="post">
            <div class="form-control" style="border: 0px">
                <label for="username">Tài khoản:</label>
                <input type="text" id="username" name="username"value="${param.username}"/>
            </div>
            <div class="form-control" style="border: 0px">
                <label for="password">Mật khẩu:</label>
                <input type="text" id="password" name="password"value="${param.password}"/></br>
            </div> 
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </form>
        <!-- <%
         String err = (String) request.getAttribute("err");
         if (err != null){
        %>
        <div style="color: red"><%= err%></div>
        <%
        }
        %> -->
        <div style="color: red">${requestScope.err}</div>
    </body>
</html>
