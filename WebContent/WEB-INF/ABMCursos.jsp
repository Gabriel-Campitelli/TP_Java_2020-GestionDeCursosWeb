<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Curso" %>
<%@ page import="logic.CursoLogic" %>
<%@ page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Administrar cursos</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">

  <!-- jQuery-->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>

  <!-- Script para MasterPage -->
  <script src="js/masterpage.js"></script>
  
  <!-- Script para poder desplegar el container en la tabla-->
  <script src="js/table-action.js"></script>

  <!-- CSS para el form -->
  <link href="css/cursos-style.css" rel="stylesheet">


  <!-- esto es para poder editar la tabla -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>



	<!-- Script para MasterPage -->
  <script type="text/javascript" >
  
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
		        '<a class="list-group-item" href="admin-home">Home</a>'+
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
    <!-- script para la MasterPage -->
  
  
  <!-- script para la tabla -->
	<script type="text/javascript">
	//esto es para que me muestre el form para editar en la tabla
	$(document).ready(function(){
		$("#boton-panel").click(function (){
			
			if(!$('#mostrar-panel').is(':visible'))
			{
				$("#mostrar-panel").show();
				$("#boton-panel").text("Cerrar")
			}
			else
			{
				$("#mostrar-panel").hide();
				$("#boton-panel").text("Editar")
			}	
		
		})
	})
	
	//esto es para que me cambie el tamaño del textarea a medida que escribo
	$(document).ready(function(){
		var textarea = document.querySelector('textarea');
	
		textarea.addEventListener('keydown', autosize);
		             
		function autosize(){
		  var el = this;
		  setTimeout(function(){
		    el.style.cssText = 'height:' + el.scrollHeight + 'px';
		  },0);
		}
	})
	
	
	
	$(document).ready(function () {
	      $('#datetimepickerFechaInicio').datetimepicker({
		format: 'DD/MM/YYYY'
		});
	  });
	
	$(document).ready(function () {
	      $('#datetimepickerFechaFin').datetimepicker({
		format: 'DD/MM/YYYY'
		});
	  });
	
	
	
	//ESTO ME SIRVE PARA OBTENER LA INFORMACIÓN DE LAS COLUMNAS DE CADA ROW
	 $(document).on("click", ".btn-editar", function() {
	   $(this).closest('tr').find('td:nth-child(2)').each(function() {
	     var nombre = $(this).html();
	   });
	
	   $(this).closest('tr').find('td:nth-child(3)').each(function() {
	     var descripcion = $(this).html();
	   });
	
	   $(this).closest('tr').find('td:nth-child(4)').each(function() {
	     var fechaInicio = $(this).html();
	   });
	
	   $(this).closest('tr').find('td:nth-child(5)').each(function() {
	     var fechaFin = $(this).html();
	   });
	
		//buscar el siguinete: row-form
		var variable = $(this).parents("tr").nextAll(".row-form").eq(0).toggle();
		
		//mostrarlo
		variable(function(){
			if(!$('#mostrar-panel').is(':visible'))
			{
				$("#mostrar-panel").show();
				$("#boton-panel").text("Cerrar")
			}
			else
			{
				$("#mostrar-panel").hide();
				$("#boton-panel").text("Editar")
	
			}	
		})
	
	 });
		 
	 $(document).ready(function (e) {
		  $('#modalEliminar').on('show.bs.modal', function(e) {   
			  			  
			  var row= $(e.relatedTarget).parent().parent();
			  var celdas= row.children();
			  //alert($(celdas[0]).html()); 
			  var idCurso = $(celdas[0]).text();
			  
			  $('#id-curso-eliminar').val(idCurso);
			  $('#nombre-curso-eliminar').val($(celdas[1]).html());
			  
		  });
		});
	 

	</script>
  <!-- script para la tabla -->




  <%
  	CursoLogic curL = new CursoLogic();
	LinkedList<Curso> cursos = curL.getAll();
  %>
</head>

<body>
 <!-- <%=cursos%>
  <%= request.getParameter("id_curso") %>-->

  <div class="container">
    <div id="Nav"></div>

    <!-- Body de la pagina -->
    <div class="row" style="min-height: 50vh;"> 
      <!-- Menu de la izquierda-->
      <div id="Menu" class="col-2"></div>
      
	

      <!-- Content Column -->
      <div class="col-10 " >
      
        <button type="button" class="btn btn-success" id="sendMessageButton" style="margin-bottom: 20px; float: right;" data-toggle="modal" data-target="#modalAgregarCurso">Agregar un nuevo curso</button>
        <!-- Modal Nuevo Curso -->
        <div class="modal fade" id="modalAgregarCurso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Información del curso a agregar</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              
              <form id="cursoForm" method="post" action="alta-curso">
              
	              <div class="modal-body">
	
	                  <div class="form-row" >
	                    <div class="col">
	                      <label>Nombre del curso</label>
	                      <input name="nombre" type="text" class="form-control" placeholder="Ingrese un nombre para el curso">
	                    </div>
	                  </div>
	
	                  <div class="form-row">
	                    <div class="col">
	                      <label>Fecha de inicio</label>
	                      <div class='input-group date' id='datetimepickerFechaInicio'>
	                        <input name="fecha-inicio" type='text' class="form-control" />     
	                        <span class="input-group-addon">
	                          <span class="glyphicon glyphicon-calendar"></span>
	                        </span>
	                      </div>                    
	                    </div>
	
	                    <div class="col">
	                      <label>Fecha de fin</label>
	                      <div class='input-group date' id='datetimepickerFechaFin'>
	                        <input name="fecha-fin" type='text' class="form-control" />     
	                        <span class="input-group-addon">
	                          <span class="glyphicon glyphicon-calendar"></span>
	                        </span>
	                      </div>
	                    </div>
	                  </div>
	
	                  <div class="form-row">
	                      <div class="col">
	                        <label>Descripcion</label>
	                        <textarea name="descripcion" rows="1" class="form-control" placeholder="Ingrese una descripcion para el curso" maxlength="999"></textarea>
	                      </div>
	                  </div>
	
	                  <div class="form-row">
	                    <div class="col">
	                      <label>URL imagen</label>
	                      <input name="url-imagen" type="text" class="form-control" placeholder="Ingrese una URL de imagen para el curso">
	                    </div>
	                  </div>
	
	                  <div id="success"></div>
	                  <!-- For success/fail messages -->
					
	              </div>
	              
	              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-success" name="modo" value="alta-curso" >Agregar curso</button>
              </div>
            
              </form>

            </div>
          </div>
        </div>
        <!--Modal Nuevo Curso-->


        <table class="table table-hover table-bordered">

          <thead>
            <tr class="d-flex">
              <th class="col-1" scope="row">Id</th>
              <th class="col-2">Nombre</th>
              <th class="col-2">Descripcion</th>
              <th class="col-2">Fecha de inicio</th>
              <th class="col-2">Fecha de fin</th>
              <th class="col-3">Opciones</th>
            </tr>
          </thead>
          
          <tbody>

	<%   for (Curso curso : cursos) 
			{ 
	%>
            <tr class="d-flex">
              <th class="col-1"  scope="row"><%= curso.getId() %></th>
              
              <td class="col-2" ><%= curso.getNombre() %></td>
              <td class="col-2" ><%= curso.getDescripcion() %></td>
              <td class="col-2" ><%= curso.getFecha_inicio() %></td>
              <td class="col-2" ><%= curso.getFecha_fin() %></td>
              <td class="col-3">
                <button type="button" id="" class="btn btn-warning btn-editar">Editar</button>

                <button type="button" id="btn-eliminar-curso" class="btn btn-danger btn-eliminar" data-toggle="modal" data-target="#modalEliminar">Eliminar</button>   

                <!-- Modal Eliminar -->
                <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">¿Estas seguro de eliminar el siguiente curso?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>    
                      <form method="post" action="eliminar-curso">
	                      <div class="modal-body">
	                        
	                        <label>Id: </label>                    
                        	<input readonly type="text" name="id_curso" id="id-curso-eliminar" value="" />	
                        	<br>
                        	<label>Nombre: </label>                    
                        	<input id="nombre-curso-eliminar" name="nombre" disabled/>	
                        	
	                      </div>
	                      
	                      <div class="modal-footer">
	                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
         	
                        	<button name="modo" value="eliminar-curso"  type="submit" class="btn btn-danger">Si, eliminar</button>
         
                      	</div>	
                      </form>
                    </div>
                  </div>
                </div>
                <!--Modal Eliminar-->
              </td>
            </tr>

            <tr class="row-form" style="display:none;" >
              <td colspan="6" id="mostrar-panel">
                <div class="panel panel-default ">
                  <div class="panel-heading">
                    <h1>Editar curso: <%=curso.getNombre()%></h1>
                  </div>

                  <div class="panel-body">

                    <!-- ESTE ES EL FORM -->
                    <form id="cursoForm" method="post" action="editar-curso" >
		<!--				
					 <div class="form-row">
                       <div class="col">
                         <label>Id del curso</label>  
                        	<input name="id_curso" value="<%=curso.getId()%>" />	                        
                        </div>
                      </div>
	 	 -->
                      <div class="form-row">
                        <div class="col">
                          <label>Nombre del curso</label>
                          <input name="nombre" type="text" class="form-control" placeholder="Ingrese un nombre para el curso" value="<%= curso.getNombre() %>"/>
                        
                        </div>
                      </div>
		
                      <div class="form-row">
                        <div class="col">
                          <label>Fecha de inicio</label>
                          <div class='input-group date' id='datetimepickerFechaInicio'>
                            <input name="fecha-inicio" type='text' class="form-control" value="<%= curso.getFecha_inicio() %>"/>     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>                    
                        </div>
                        
                        <div class="col">
                          <label>Fecha de fin</label>
                          <div class='input-group date' id='datetimepickerFechaFin'>
                            <input name="fecha-fin" type='text' class="form-control" value="<%= curso.getFecha_fin() %>" />     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                          <div class="col">
                            <label>Descripcion</label>
                            <textarea name="descripcion" rows="1" class="form-control" placeholder="Ingrese una descripcion para el curso" maxlength="999" ><%= curso.getDescripcion() %></textarea>
                          </div>
                      </div>
                      
                      <div class="form-row">
                        <div class="col">
                          <label>URL imagen</label>
                          <input name="url-imagen" type="text" class="form-control" placeholder="Ingrese una URL de imagen para el curso" value="<%= curso.getUrl() %>">
                        </div>
                      </div>

                      <div id="success"></div>
                      <!-- For success/fail messages -->
                      <button name="modo" value="editar-curso" type="submit" class="btn btn-success" id="sendMessageButton" style="margin-top: 20px;">Editar</button>
                    </form>
                    <!-- ESTE ES EL FORM -->

                  </div>
                </div>
             

            </tr>
    <%
			} 
	%>
            
          </tbody>
          
        </table>

        
      </div>
  
    </div>
    
   </div>
   

    
 
  
  
    
     <!-- Bootstrap core JavaScript -->

  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- para el DATETIMEPICKER -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
  

   <!-- Footer de la pagina -->
   <div id="Footer"></div>

</body>

</html>