<%-- 
    Document   : addsupplierframe
    Created on : 31-10-2023, 20:23:12
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Them nha cung cap</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    </head>
    <body>
        <h1>Thêm nhà cung cấp</h1>
        <form action="addsup" method="post">
            <div class="form-control border-0">Tên: </br><input 
                    type="text" name="name"/> </div>
            <div class="form-control border-0">Địa chỉ:
                </br><input type="text" name="address"/> </div>
            <div class="form-control border-0">SĐT: </br><input 
                    type="text" name="phone"/> </div>
            <div class="form-control border-0">STK: </br><input 
                    type="text" name="bank"/> </div>
            <button type="submit">Thêm</button>
        </form>
    </body>
    <div style="color: red">${requestScope.err}</div>
</html>
