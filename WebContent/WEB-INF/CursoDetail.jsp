<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Curso" %>
<%@ page import="entities.Comision" %>
<%@ page import="java.util.LinkedList" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern Business - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">
	
  <% Curso curso = (Curso)request.getAttribute("curso"); 
  	 LinkedList<Comision> lc = (LinkedList<Comision>) request.getAttribute("comisionesAInscribirme");
     LinkedList<Curso> misCursos = (LinkedList<Curso>) request.getSession().getAttribute("userCursos");
     LinkedList<Curso> cursosRecomendados =   (LinkedList<Curso>) request.getAttribute("cursosRecomendados");
     boolean ocultar = (boolean) request.getAttribute("ocultar");
    

  	 %>
</head>

<body>							 
 <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="home?param=home">Gestión de Cursos</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="home?param=mis-cursos">Mis Cursos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="home?param=cursos">Todos los Cursos</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Detalle del Curso
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">Detalle</li>
    </ol>

    <!-- Portfolio Item Row -->
    <div class="row">

      <div class="col-md-8">
        <img class="img-fluid" src="<%= curso.getUrl() %>" alt="">
      </div>

      <div class="col-md-4">
        <h3 class="my-3"><%= curso.getNombre() %></h3>
        <p><%=curso.getDescripcion()%></p>
        <p>Comienza: <%=curso.getFecha_inicio()%></p>
        <p>Finaliza: <%=curso.getFecha_fin()%></p>
        <p><%=curso.getLikes()%> Likes</p>
        <%if(!ocultar) { %>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
		  Inscribirme
		</button>
		<% } %>
		 <%if(ocultar) { %>
		 	<h5><span class="badge badge-success">Inscripto al curso</span></h5>
	 <% } %>
      </div>

    </div>
    <!-- /.row -->

    <!-- Related Projects Row -->
	    <h3 class="my-4">Cursos Populares</h3>
	<% if(! cursosRecomendados.isEmpty()) {%>
    <div class="row">
		<% for(Curso cr : cursosRecomendados) { %>
      <div class="col-md-3 col-sm-6 mb-4">
        <a href="cursodetail?curso=<%= cr.getId()%>">
          <img class="img-fluid" src="<%=cr.getUrl()%>" alt="">
        </a>
      </div>
       <% } %> 
	<% } %> 
    </div>
    <!-- /.row -->

  </div>
	
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Inscribirme</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    <%if(lc.isEmpty()) {%>  
    <div class="modal-body">
		<h3>No hay comisiones disponibles</h3>
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Aceptar</button>
      </div>
      <% } %>  
      	 
	 <%if (!ocultar) { %>
      <% if(!lc.isEmpty()) {%>    
	      <form action="inscripcion" method="post">
	      <div class="modal-body">
	      	    
	          <div class="form-group">
	            <label for="exampleFormControlSelect2">Comisiones</label>
	            <select class="form-control" name="item">
	              <% for(Comision c : lc) { %>
	    			<option value="<%=c.getIdComision()%>">
	        			<%= c.getDiaSemana() + " " + c.getHoraInicio() + " a " + c.getHoraFin()%>
	    			</option>
				  <% } //Cerrar FOR %>
	            </select>
	            <input type="hidden" name="curso.id" value="<%= curso.getId() %>">
	   			<input type="hidden" name="curso.nombre" value="<%= curso.getNombre() %>">
	   			<input type="hidden" name="curso.desc" value="<%= curso.getDescripcion() %>">
	   			<input type="hidden" name="curso.url" value="<%= curso.getUrl() %>">
	            <input type="hidden" name="curso.inicio" value="<%= curso.getFecha_inicio() %>">
	            <input type="hidden" name="curso.fin" value="<%= curso.getFecha_fin() %>">       
	            <input type="hidden" name="curso.likes" value="<%= curso.getLikes() %>">    
	          </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" name="action" value="inscripcion"class="btn btn-primary">Aceptar</button>
	      </div>
	    </form>
    <% } %>
    <% } %>
    </div>
  </div>
</div>
	

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>