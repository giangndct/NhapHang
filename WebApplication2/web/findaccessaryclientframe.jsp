<%-- 
    Document   : findaccessaryclientframe
    Created on : 01-11-2023, 07:49:16
    Author     : Admin
--%>
<%@page import="Entity.Accessary"%>
<%@page import="Entity.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm kiếm dịch vụ/phụ tùng</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
    <body>
        <p>Nhập tên</p>
        <form action="findclient">
            <div class="form-control" style="border: 0px">
                <input type="text" name="accessary"/>
                <button type="submit" class="btn btn-primary">Tìm</button>     
            </div> 
        </form> 
        <div>
            <div>
                <p>Phụ Tùng</p>
                <c:if test="${requestScope.listAcc.size() > 0}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Mã</th>
                                <th>Tên</th>
                                <th>Hãng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="acc"
                                       items="${requestScope.listAcc}">
                                <tr>
                                    <td>${acc.id}</td>
                                    <td><a 
                                            href="info?accessaryid=${acc.id}">${acc.name}
                                        </a></td>
                                    <td>${acc.company}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
            <div>
                <p>Dịch vụ</p>
                <c:if test="${requestScope.listService.size() > 0}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Mã</th>
                                <th>Tên</th>
                                <th>Mô tả</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ser"
                                       items="${requestScope.listService}">
                                <tr>
                                    <td>${ser.id}</td>
                                    <td><a 
                                            href="info?serviceid=${ser.id}">${ser.name}
                                        </a></td>
                                    <td>${ser.description}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>                    
            </div>                   
        </div>
    </body>
</body>
</html>
