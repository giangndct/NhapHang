<%-- 
    Document   : findsupplierframe
    Created on : 30-10-2023, 23:21:43
    Author     : Admin
--%>
<%@page import="Entity.Supplier"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

        <title>Hóa đơn nhập phụ tùng</title>
    </head>
    <body>
        <h1>Tìm nhà cung cấp</h1>
        <form action="findsup">
            <div class="form-control" style="border: 0px" >
                <input type="text" name="supplier" />
                <button type="submit" class="btn btn-primary">Tìm</button>
                <a 
                    href="addsupplierframe.jsp" class="btn btn-primary">Thêm nhà cung cấp</a>
            </div> 
        </form> 
    <c:if test="${requestScope.listSupplier.size() > 0}">
        <table class="table">
            <thead>
                <tr>
                    <th>Mã</th>
                    <th>Tên</th>
                    <th>Địa chỉ</th>
                    <th>SĐT</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="sup"
                       items="${requestScope.listSupplier}">
                <tr>
                    <td>${sup.id}</td>
                    <td><a 
                            href="invoice?supplierid=${sup.id}">${sup.name}
                        </a></td>
                    <td>${sup.address}</td>
                    <td>${sup.phone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
