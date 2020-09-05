<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>UTN Cursos</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">

  <!-- jQuery-->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>



  <!-- Script para MasterPage -->
  <script language="javascript" type="text/javascript" >
  
  $(document).ready(function (){
		
		AgregarNav();
		AgregarMenu();
		AgregarFooter();
	})

	function AgregarMenu(){
		
		var menu = document.getElementById("Menu");
		menu.innerHTML = 
		      '<!-- Sidebar Column --> '+
		      
		        '<div class="list-group"> '+
				  '<a class="list-group-item" href="admin-home?param=admin-cursos">Cursos</a>'+
		          '<a class="list-group-item" href="admin-home?param=admin-comisiones">Comisiones</a> '+
		          '<a class="list-group-item" href="admin-home?param=admin-clientes">Clientes</a> '+
				'</div>'
//href="home?param=cursos"

	}

	function AgregarNav(){
		
		var nav = document.getElementById("Nav");
		nav.innerHTML = 
		
	  '<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">'+
	    '<div class="container">'+
	      '<a class="navbar-brand" href="index.html">Cursos UTN</a>'+

	      '<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">'+
	        '<span class="navbar-toggler-icon"></span>'+
	      '</button>'+

	      '<div class="collapse navbar-collapse" id="navbarResponsive">'+
	        '<ul class="navbar-nav ml-auto">'+


	          '<li class="nav-item">'+
	            '<a class="nav-link" href="contact.html">Link auxiliar</a>'+
	          '</li>'+

	          '<li class="nav-item active dropdown">'+
	            '<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Opciones</a>'+
	            '<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPages">'+
	              '<a class="dropdown-item " href="sidebar.html">Configuración de cuenta</a>'+
	              '<a class="dropdown-item" href="404.html">Salir</a>'+
	            '</div>'+
	          '</li>'+

	        '</ul>'+

	      '</div>'+
	    '</div>'+

	  '</nav>'+


		  
		    '<!-- Page Heading/Breadcrumbs --> '+
		    '<h1 class="mt-4 mb-3">Inicio</h1> '+
		
		    '<ol class="breadcrumb"> '+
		      '<li class="breadcrumb-item"> '+
		 
		        '<a href="admin-home?param=admin-home">Home</a> '+
		      '</li> '+
		      '<li class="breadcrumb-item active">About</li> '+
		    '</ol> '

	}

	function AgregarFooter(){
		var footer = document.getElementById("Footer");
		footer.innerHTML = 
		
		  '<footer class="py-5 bg-dark border-top"> '+
				'<div class="container"> '+
			      '<p class="m-0 text-center text-white">Copyright &copy; UTN-Shops 2020</p> '+
			    '</div> '+
		  '</footer>'
				
	}
  
  </script>

 
</head>

<body>

<a href="prueba?param=prueba"></a>

  <div class="container">
    <div id="Nav"></div>

    <!-- Body de la pagina -->
    <div class="row" style="min-height: 50vh;"> 
      <!-- Menu de la izquierda-->
      <div id="Menu" class="col-2"></div>

      <!-- Content Column -->
      <div class="col-10 " >
        <h2>Bienvenido</h2>
        <p>Lorem ipsum dolor sit ame  t, consectetur adipisicing elit. Soluta, et temporibus, facere perferendis veniam beatae non debitis, numquam blanditiis necessitatibus vel mollitia dolorum laudantium, voluptate dolores iure maxime ducimus fugit.</p>
        </div>
      </div>
  
    </div>
    
    <!-- Footer de la pagina -->
    <div id="Footer"></div>

    </div>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
