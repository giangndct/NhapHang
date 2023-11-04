<%-- 
    Document   : addaccessaryframe
    Created on : 31-10-2023, 21:32:10
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Them phu tung</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    </head>
    <body>
        <h1>Thêm phụ tùng</h1>
        <form action="addacc" method="post">
            <div class="form-control border-0" >
                <label for="name">Tên:</label> </br>
                <input type="text" name="name" id="name"/>
            </div>
            <div class="form-control border-0">
                <label for="company">Hãng: </label></br>
                <input type="text" name="company" id="company"/>
            </div>
            <div class="form-control border-0">
                <label for="description">Mô tả: </label></br>
                <input type="text" name="description"
                       id="description"/>
            </div>
            <div class="form-control border-0">
                <label for="price">Giá bán: </label></br>
                <input type="text" name="price" id="price"/>
            </div> 
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </body>
</html>
