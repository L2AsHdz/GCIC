<%-- 
   Document   : index
   Created on : 21/04/2021, 01:51:55
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
        <!-- Barra de navegacion -->
        <jsp:include page="/WEB-INF/gcic/navBar.jsp"/>

        <div class="container-fluid">

            <div class="row pt-5">
                <div class="col-1"></div>
                <div class="col-4">
                    <div class="my-2">
                        <input type="file" class="form-control-file border" name="archivoEntrada" id="archivoEntrada" accept=".txt" onchange="processFile(this.files);">
                    </div>
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-info btn-block">
                        <i class="fas fa-chevron-circle-right"></i> Analizar
                    </button>
                </div>
                <div class="col-2">
                    <button type="reset" class="btn btn-danger btn-block" id="reset">
                        <i class="fas fa-trash"></i> Limpiar
                    </button>
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-success btn-block" form="exportForm">
                        <i class="fas fa-file-download"></i> Guardar archivo
                    </button>
                </div>
            </div>

            <form id="exportForm" action="${pageContext.request.contextPath}/textEditor?accion=export" method="POST">
                <textarea rows="10" class="d-none" name="inputText" id="inputText"></textarea>
            </form>
            <form id="inputForm" action="${pageContext.request.contextPath}/analizar" method="POST">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div id="textEditor" class="border my-3" style="height: 480px; width: 100%"></div>
                    </div>
                </div>

                <div class="row pt-3">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div class="form-group">
                            <textarea rows="10" class="form-control bg-dark text-white" name="areaInfo" readonly></textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <!-- Ace Editor Libraries -->
        <script src="${pageContext.request.contextPath}/js/ace-editor/src-min/ace.js"></script>    
        <script src="${pageContext.request.contextPath}/js/ace-editor/src-min/mode-text.js"></script>

        <!-- Custom Scripts -->
        <script src="${pageContext.request.contextPath}/js/editor.js"></script>
        <script src="${pageContext.request.contextPath}/js/readFile.js"></script>

        <!--JS--> 
        <jsp:include page="/WEB-INF/extras/extrasJS.jsp"/>
    </body>
</html>
