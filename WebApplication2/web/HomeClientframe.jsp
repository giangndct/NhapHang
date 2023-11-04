<%-- 
    Document   : HomeClientframe
    Created on : 01-11-2023, 07:40:55
    Author     : Admin
--%>
<%@page import="Entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu khach hang</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <% User u = (User) session.getAttribute("user"); %>
        <div>Xin chào, <%= u.getName() %></div>
        <ul style="list-style-type: none;">
            <li><a 
                    href="findclient" class="btn btn-primary">Tim kiem thong tin dich vu/phu tung</a></li>
        </ul>
    </body>
</html>
