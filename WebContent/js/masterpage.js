$(document).ready(function (){
		
		AgregarNav();
		AgregarMenu();
		AgregarFooter();
	})

function AgregarNav(){
		
		var nav = document.getElementById("Nav");
		nav.innerHTML = 
		
	  '<nav class="navbar-expand-lg navbar-dark bg-dark fixed-top">'+
	      '<a class="navbar-brand" href="index.html">Cursos UTN</a>'+

	      '<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">'+
	        '<span class="navbar-toggler-icon"></span>'+
	      '</button>'+


	      '<div class="collapse navbar-collapse" id="navbarResponsive">'+
	        '<ul class="navbar-nav ml-auto">'+


	          //'<li class="nav-item">'+
	            //'<a class="nav-link" href="contact.html">Link auxiliar</a>'+
	          //'</li>'+

	          '<li class="nav-item active dropdown">'+
	            '<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Opciones</a>'+
	            '<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPages">'+
	              '<a class="dropdown-item" href="index.html">Salir</a>'+
	            '</div>'+
	          '</li>'+

	        '</ul>'+

	      '</div>'+
	      
	  '</nav>'+


      '<div class="container">'+

		    '<!-- Page Heading/Breadcrumbs --> '+
		    '<h1 class="mt-4 mb-3">Inicio</h1> '+
		
		    '<ol class="breadcrumb"> '+
		      '<li class="breadcrumb-item"> '+
		        '<a href="admin-home?param=admin-home">Home</a> '+
		      '</li> '+
		      
		      //'<li class="breadcrumb-item active">About</li> '+
		    '</ol> '+
	'</div>'
	
	}

function AgregarMenu(){
	
	var menu = document.getElementById("Menu");
	menu.innerHTML = 
	      '<!-- Sidebar Column --> '+
	      
	        '<div class="list-group"> '+
			  '<a class="list-group-item" href="admin-home?param=admin-cursos">Cursos</a>'+
	          '<a class="list-group-item" href="admin-home?param=admin-comisiones">Comisiones</a> '+
	          //'<a class="list-group-item" href="admin-home?param=admin-inscripciones">Inscripciones</a> '+
			'</div>'

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