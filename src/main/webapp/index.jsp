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
        <div class="container-fluid">
            <div class="row py-2 bg-dark">
                <div class="col-8">
                    <h2 class="mt-2 ml-3 text-white">Generador de captchas ingenieria cunoc</h2>
                </div>
            </div>
        </div>

        <div class="row pt-5">
            <div class="col-2"></div>
            <div class="col-8">
                <div class="my-2">
                    <label for="archivoEntrada" class="font-weight-bold">Seleccione un archivo de entrada:</label>
                    <input type="file" class="form-control-file border" name="archivoEntrada" id="archivoEntrada" accept=".txt" onchange="processFile(this.files);">
                </div>
            </div>
        </div>
        
        <form id="inputForm" action="${pageContext.request.contextPath}/analizar" method="POST">
            <div class="row pt-3">
                <div class="col-2"></div>
                <div class="col-8">
                    <div id="textEditor" class="container border my-3" style="height: 500px; width: 100%">
                        
                    </div>
                </div>
            </div>
            
            <div class="row pt-3">
                <div class="col-4"></div>
                <div class="col-4">
                    <button type="submit" class="btn btn-primary btn-block">Analizar</button>
                </div>
            </div>
            
            <div class="row pt-3">
                <div class="col-4"></div>
                <div class="col-4">
                    <button type="reset" class="btn btn-info btn-block" id="reset">Limpiar</button>
                </div>
            </div>
            
            <div class="row pt-3">
                <div class="col-4"></div>
                <div class="col-4">
                    <button type="button" class="btn btn-success btn-block" id="print">Print</button>
                </div>
            </div>
        </form>

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
