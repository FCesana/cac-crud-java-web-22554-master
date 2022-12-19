<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="Mostrando a ${alumnoAMostrar.nombreCompleto}" />
</jsp:include>

<jsp:include page="WEB-INF/pages/comunes/navbar.jsp" />

<section class="container">
    <div class="row py-3 align-items-center justify-content-center">
        <div class="col-12" >
            <h1 class="display-1">Los </h1>
            <p class="lead">
                
                
            </p>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/app">Volver</a>
        </div>
    </div>
</section>


<jsp:include page="WEB-INF/pages/comunes/footer.jsp"/>
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp"/>