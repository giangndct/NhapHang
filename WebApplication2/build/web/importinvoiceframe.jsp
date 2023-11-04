<%-- 
    Document   : importinvoice
    Created on : 31-10-2023, 20:57:01
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoa don nhap phu tung</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    </head>
    <body>
        <div class="row">
            <div class="col-md-6">  <p >Hóa đơn nhập phụ tùng</p></div>
            <div class="col-md-6">
               <form action="Homeframe.jsp" method="post" >
                <button type="submit" class="btn btn-primary">Quay ve trang chủ</button>
            </form>  
            </div>
             
        </div>

        <div class="row">
            <div class="col">
                <div class="col-md-6">Mã nhà cung cấp: ${sessionScope.invoice.supplier.id}</div>
                <div class="col-md-6">Nhà cung cấp: ${sessionScope.invoice.supplier.name}</div>
                <div class="col-md-6">SĐT:${sessionScope.invoice.supplier.phone}</div>
                <div class="col-md-6">Địa chỉ:${sessionScope.invoice.supplier.address}</div> 
            </div>
            <div class="col">
                <div class="col-md-6">Mã nhân viên kho: ${sessionScope.invoice.user.id}</div>
                <div class="col-md-6">Tên nhân viên kho: ${sessionScope.invoice.user.name}</div>
            </div>
        </div>

        <a href="findacc" class="btn btn-primary">Thêm phụ tùng </a>
        <table class="table">
            <thead>
                <tr>
                    <td>Mã</td> 
                    <td>Tên</td> 
                    <td>Hãng</td> 
                    <td>Số lượng</td> 
                    <td>Đơn giá</td> 
                    <td>Thành tiền</td> 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pii"
                           items="${sessionScope.invoice.listAccessarys}">
                    <tr>
                        <td>${pii.accessary.id}</td>
                        <td><a 
                                href="findacc?accessaryid=${pii.accessary.id}?amount=${pii.amount}?
                                price=${pii.price}">${pii.accessary.name}</a></td>
                        <td>${pii.accessary.company}</td>
                        <td>${pii.amount}</td>
                        <td>${pii.price}</td>
                        <td>${(pii.amount * pii.price)}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>Tổng tiền: ${sessionScope.invoice.totalMoney}</div>
        <form action="invoice" method="post" onsubmit="showSuccessMessage()">
            <button type="submit" class="btn btn-primary">Lưu hoá đơn</button>
            <div style="color: green">${requestScope.message}</div>
        </form>

        <div style="color: red">${requestScope.err}</div>
    </body>

</html>
