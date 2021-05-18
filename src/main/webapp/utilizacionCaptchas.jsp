<%-- 
    Document   : utilizacionCaptchas
    Created on : 18/05/2021, 12:38:50
    Author     : asael
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GCIC</title>

        <!--CSS-->
        <jsp:include page="/WEB-INF/extras/extrasCSS.jsp"/>
    </head>
    <body onload="loadText();">
        <!-- Barra de navegacion -->
        <jsp:include page="/WEB-INF/gcic/navBar.jsp"/>
        
        <div class="container-fluid">
            <div class="row mt-5">
                <div class="col-1"></div>
                <div class="col-10">
                    <div class="card">
                        <div class="card-header">
                            <h4>Utilizacion de captchas</h4>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Id</th>
                                        <th>Nombre</th>
                                        <th>Usos</th>
                                        <th>Aciertos</th>
                                        <th>Fallos</th>
                                        <th>Ultima utilizacion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="c" items="${captchas}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${c.id}</td>
                                            <td>${c.name}</td>
                                            <td>${c.use}</td>
                                            <td>${c.hits}</td>
                                            <td>${c.faults}</td>
                                            <td>${c.lastDate}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!--JS--> 
        <jsp:include page="/WEB-INF/extras/extrasJS.jsp"/>
    </body>
</html>