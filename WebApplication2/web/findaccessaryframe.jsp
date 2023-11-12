<%-- 
    Document   : findaccessaryframe
    Created on : 31-10-2023, 21:26:03
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm phụ tùng vào hóa đơn</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    </head>
    <body>
        <h1>Tìm phụ tùng để nhập</h1>
        <form action="findacc">
            <div class="form-control" style="border: 0px">
                Nhập tên: <input type="text" name="accessary"/>
                <button type="submit" class="btn btn-primary">Tìm</button>
                <a href="addaccessaryframe.jsp"
                   class="btn btn-primary">Thêm mới phụ tùng</a>
            </div> 
        </form>

        <c:if test="${requestScope.listAcc.size() > 0}">
            <form action="invoice" method="get">
                <table class="table">
                    <thead>
                        <tr> 
                            <td>#</td>
                            <td>Mã</td>
                            <th>Tên</th>
                            <th>Hãng</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="acc"
                                   items="${requestScope.listAcc}">
                            <tr>
                                <td><input type="radio"
                                           name="accessaryid" value="${acc.id}"/>
                                <td>${acc.id}</td>
                                <td>${acc.name}</td>
                                <td>${acc.company}</td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="form-control" style="border: 0px">Số lượng: <input type="text" name="amount"/></div>
                <div class="form-control" style="border:0px">Đơn giá: <input type="text" name="price"/></div>
                <button type="submit" class="btn btn-primary">Xác nhận</button> 
            </form>
        </c:if> 


    </body>
</html>
