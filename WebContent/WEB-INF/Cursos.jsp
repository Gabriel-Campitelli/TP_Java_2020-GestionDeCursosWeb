<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Curso" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <%
  	SimpleDateFormat formatter =new SimpleDateFormat("yyyy-mm-dd"); 
	Object opcion = new Object();
    opcion = request.getAttribute("pageName");
    LinkedList<Curso> cursos = new LinkedList<>();
    LinkedList<Integer> likes = (LinkedList<Integer>) request.getAttribute("likes");
	if(opcion != "Mis Cursos") {
	cursos = (LinkedList<Curso>)request.getAttribute("cursos");
	}
	else {
	cursos = (LinkedList<Curso>)request.getSession().getAttribute("userCursos");
	}
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
    <h1 class="mt-4 mb-3"><%= opcion %>
    </h1>
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active"><%= opcion %></li>
    </ol>

<!-- Cursos -->

	<%if (cursos != null) { %>
    
   <% for(int i = 0; i <= cursos.size() -1; i++) { %>
    
	  
		   <div class="row">
			   <div class="col-md-7">
				   <a href="#">
				   		<img class="img-fluid rounded mb-3 mb-md-0" src="<%= cursos.get(i).getUrl()%>" alt="">
				   </a>
	    	   </div>
      		   <div class="col-md-5">
			       <h3><%= cursos.get(i).getNombre()%></h3>
			       <p><%= cursos.get(i).getDescripcion() %></p>
			       <p>Comienza: <%= formatter.format(cursos.get(i).getFecha_inicio()) %></p>
			       <p>Finaliza: <%= formatter.format(cursos.get(i).getFecha_fin()) %></p>
			       <p><%=cursos.get(i).getLikes() %> Likes</p>
			       
			       <a class="btn btn-primary" href="cursodetail?curso=<%= cursos.get(i).getId()%>">Ver Curso
			         <span class="glyphicon glyphicon-chevron-right"></span>
			       </a>  			       
			        <%if(opcion == "Mis Cursos") { %> 
		        	   <%if(likes.get(i) == 0) { %> 
		               	   <a href="like?idCurso=<%=cursos.get(i).getId() %>&param=mis-cursos" class="btn btn-primary" >
		          		    	<i class="fa fa-thumbs-up" style="color:white;" ></i> like
		       			   </a>
		       		   <% } %>
		        	   <%if(likes.get(i) == 1) { %>   
		        		    <a href="like?idCurso=<%=cursos.get(i).getId() %>&param=mis-cursos" class="btn btn-danger">
		          		    	<i class="fa fa-thumbs-down" style="color:white;" ></i> dislike		       			   
		          		    </a>	
		       		   <% } %>
        	   <% } %>
        	  
      		   </div>
            </div>    <!-- /.row -->
    <hr>
    <%  }%>
<% }%>
<%if(cursos == null) { %> 
	<h2>No hay Cursos</h2>
<% } %>
    <!-- Pagination -->
    <ul class="pagination justify-content-center">
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Previous</span>
        </a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">1</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">2</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">3</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>
    </ul>

  </div>
  <!-- /.container -->

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
