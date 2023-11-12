<%-- 
    Document   : informationclient
    Created on : 04-11-2023, 10:41:43
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Accessary205"%>
<%@page import="Entity.Service205"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin chi tiêt</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <h1>Thông tin chi tiết</h1>
        <div>
            <div>
                <c:if test="${sp!=null}">
                    <p>Thông tin Dịch vụ</p>
                    <div class="col">
                        <div class="col-md-6">Mã dịch vụ: ${sessionScope.sp.id}</div>
                        <div class="col-md-6">Tên dịch vụ: ${sessionScope.sp.name}</div>
                        <div class="col-md-6">Mô tả:${sessionScope.sp.description}</div>
                    </div>
                    
                </c:if>
            </div>


            <div>
                <c:if test="${acc!=null}">
                    <p>Thông tin Phụ tùng</p>
                    <div class="col">
                        <div class="col-md-6">Mã phụ tùng: ${sessionScope.acc.id}</div>
                        <div class="col-md-6">Tên phụ tùng: ${sessionScope.acc.name}</div>
                        <div class="col-md-6">Mô tả:${sessionScope.acc.company}</div>
                        <div class="col-md-6">Đơn giá:${sessionScope.acc.price}</div>
                    </div>            
                </c:if>
            </div>


        </div>

    </body>
</html>
