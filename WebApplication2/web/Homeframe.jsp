<%-- 
    Document   : Homeframe
    Created on : 30-10-2023, 22:37:48
    Author     : Admin
--%>
<%@page import="Entity.User205"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <title>Trang chu</title>
    </head>
    <body>
        <div class="row">
            <div class="col">
               <h1>Trang Chủ</h1> 
            </div>
            <div class="col">
               <form action="login.jsp" method="post" >
                    <button type="submit" class="btn btn-primary">Đăng xuất</button>
                </form>
            </div>
        </div>
        
        <% User205 u = (User205) session.getAttribute("user"); %>
        <div>Xin chào, <%= u.getName() %></div>
        <ul style="list-style-type: none;">
            <li><a 
                    href="findsup" class="btn btn-primary">Quản lý nhập phụ tùng</a></li>
        </ul>
    </body>
</html>
