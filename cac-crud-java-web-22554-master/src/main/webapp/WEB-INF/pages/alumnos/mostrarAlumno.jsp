<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="Mostrando a ${alumnoAMostrar.nombreCompleto}" />
</jsp:include>

<jsp:include page="../comunes/navbar.jsp" />



<section class="container">
    <div class="row py-3 align-items-center justify-content-center">
        <div class="col-12" >
            <h1 class="display-1">Datos de ${alumnoAMostrar.nombreCompleto} </h1>
            
            <div class="row">
                
            <div class="col-lg-4 " >
             
                <jsp:include page="partes/dataCardAlumno.jsp">
                 <jsp:param name="fotoAlumno" value="${alumnoAMostrar.foto}" />
                </jsp:include>
            
            </div>   
                
            <div class="col-lg-8" >
                
            <h3>Id : ${alumnoAMostrar.getId()}</h3>
            <h3>Nombre : ${alumnoAMostrar.getNombre()}</h3>
            <h3>Apellido : ${alumnoAMostrar.getApellido()}</h3>
            <h3>Fecha de nacimiento: ${alumnoAMostrar.getFechaNacimiento()}</h3>
            <h3>Edad : ${alumnoAMostrar.getEdad()}</h3>
            <h3>Email : ${alumnoAMostrar.getMail()}</h3>
            </div>
            
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/app">Volver</a>
            
            
            
        
     </div>
     </div>  
     </div>
           
</section>

<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHTML.jsp"/>