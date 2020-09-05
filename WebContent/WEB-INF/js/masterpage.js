
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
	          '<a href="about.html" class="list-group-item">Cursos</a> '+
	          '<a href="services.html" class="list-group-item">Clientes</a> '+
	          '<a href="contact.html" class="list-group-item">Comisiones</a> '

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
	        '<a href="index.html">Home</a> '+
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