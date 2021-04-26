<div>
    <nav class="navbar navbar-expand-xl fixed-top bg-primary navbar-dark">
        <a href="${pageContext.request.contextPath}/index.jsp" class="navbar-brand">
            <i class="fas fa-code"></i>
            GCIC
        </a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Generar captcha</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/captcha?accion=use">Utilizacion de captchas</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/captcha?accion=listar">Listado de captchas</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="py-4 mb-2"></div>
