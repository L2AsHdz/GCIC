<%-- 
    Document   : test
    Created on : 16/05/2021, 12:09:27
    Author     : asael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GCIC</title>

        <!--CSS-->
        <jsp:include page="/WEB-INF/extras/extrasCSS.jsp"/>
    </head>
    <body>
        <div class="container-fluid fixed-bottom">
            <div class="row bg-light py-2">
                <div class="col-2">
                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseTable" aria-expanded="false" aria-controls="collapseTable">
                        Ver tabla de simbolos
                    </button>
                </div>
                <div class="col-8">
                    <div class="collapse" id="collapseTable">
                        <div style="height: 450px; width: 100%; overflow-y: scroll;">
                            <table class="table table-bordered table-dark">
                                <thead class="thead-light">
                                    <tr>
                                        <th>Posicion</th>
                                        <th>Tipo</th>
                                        <th>Identificador</th>
                                        <th>Valor actual</th>
                                        <th>Modo</th>
                                        <th>Proceso</th>
                                        <th>No. Ejecucion</th>
                                    </tr>
                                </thead>
                                <tbody id="tableBody">
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>asdasd</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                        <td>asldkjasld</td>
                                    </tr>
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
