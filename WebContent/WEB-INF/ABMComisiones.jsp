<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Curso" %>
<%@ page import="entities.Comision" %>
<%@ page import="logic.CursoLogic" %>
<%@ page import="logic.ComisionLogic" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Administrar comisiones</title>

   <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">

  <!-- jQuery-->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>

  
  <!-- Script para poder desplegar el container en la tabla-->
  <script src="js/table-action.js"></script>

  <!-- CSS para el form -->
  <link href="css/cursos-style.css" rel="stylesheet">

  <!-- esto es para poder editar la tabla -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    <!-- para el DATETIMEPICKER -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">



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
				  '<a class="list-group-item" href="admin-home?param=admin-cursos">Cursos</a>'+
		          '<a class="list-group-item" href="admin-home?param=admin-comisiones">Comisiones</a> '+
		          '<a class="list-group-item" href="admin-home?param=admin-inscripciones">Inscripciones</a> '+
				'</div>'
//href="home?param=cursos"

	}

	function AgregarNav(){
		
		var nav = document.getElementById("Nav");
		nav.innerHTML = 
		
	  '<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">'+
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
	      
	  '</nav>'+


      '<div class="container">'+

		    '<!-- Page Heading/Breadcrumbs --> '+
		    '<h1 class="mt-4 mb-3">Inicio</h1> '+
		
		    '<ol class="breadcrumb"> '+
		      '<li class="breadcrumb-item"> '+
		 
		        '<a href="admin-home?param=admin-home">Home</a> '+
		      '</li> '+
		      '<li class="breadcrumb-item active">About</li> '+
		    '</ol> '+
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
  
  </script>
    <!-- script para la MasterPage -->
  
  
  <!-- script para la tabla -->
	<script type="text/javascript">
	//muestro el timepicker
	 $(document).ready(function () {
	      $("#datetimepickerHoraInicio").datetimepicker({
	    		format: 'HH:ss'
		});
	  });

	$(document).ready(function () {
	      $("#datetimepickerHoraFin").datetimepicker({
			format: 'HH:ss'     
		});
	  });

	$(document).ready(function () {
		$("[id=datetimepickerHoraInicioEdit]").datetimepicker({
			format: 'HH:ss'     
		});
	  });
	
	$(document).ready(function () {
		$("[id=datetimepickerHoraFinEdit]").datetimepicker({
			format: 'HH:ss'     
		});
	  });
	

	
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
			  
			  $('#id-comision-eliminar').val(idCurso);
			  $('#nombre-comision-eliminar').val($(celdas[1]).html());
			  
		  });
		});
	 
	 

		
	</script>


  <%
    ComisionLogic comL = new ComisionLogic();
	LinkedList<Comision> comisiones = comL.getAll();
	
	CursoLogic curL = new CursoLogic();
	LinkedList<Curso> cursos = curL.getAll();

	
	//
	ArrayList<String> diasSemana = new ArrayList<String>();
	diasSemana.add("Lunes");
	diasSemana.add("Martes");
	diasSemana.add("Miercoles");
	diasSemana.add("Jueves");
	diasSemana.add("Viernes");
	
	ArrayList<String> tDias = new ArrayList<>();
	LinkedList<Curso> tCursos = new LinkedList<>();
	
  %>

</head>

<body>

<div id="Nav"></div>

  <div class="container" style="min-height: 60vh;">

    <!-- Body de la pagina -->
    <div class="row"> 
    
      <!-- Menu de la izquierda-->
      <div id="Menu" class="col-2"></div>
      
      <!-- Content Column -->
      <div class="col-10 " >
      
        <button type="button" class="btn btn-success" id="sendMessageButton" style="margin-bottom: 20px; float: right;" data-toggle="modal" data-target="#modalAgregarComision">Agregar una nueva comision</button>
        
        <!-- Modal Nueva Comision -->
        <div class="modal fade" id="modalAgregarComision" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        
          <div class="modal-dialog" role="document">
          
            <div class="modal-content">
            
              <div class="modal-header">
              
                <h5 class="modal-title" id="exampleModalLabel">Información de la comision a agregar</h5>
                
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
                
              </div>
              
              <form id="comisionForm" method="post" action="alta-comision">
              
	              <div class="modal-body">
	              
	                  <div class="form-row" >
	                    <div class="col">
	                      <label>Curso al que pertenece la comision</label>
	                    
	                      <select class="form-control" name="idCurso" >
					      	<option>Seleccione un curso</option>
					        <%   for (Curso curso : cursos) 
									{ 
							%>
					            <option value="<%=curso.getId()%>"><%=curso.getNombre()%></option>
        	                <%  
									}
							%>
						 </select> 
						
	                    </div>
	                  </div>
	
					  <div class="form-row" >
	                    <div class="col">
	                      <label>Dia de dictado: </label>
	                    
	                      <select name="dia" class="form-control" >
					      	<option value="">Seleccione un día de la semana</option>
						<%   for(int i = 0; i < diasSemana.size(); ++i)
								{ 
						%>
					            <option value="<%=diasSemana.get(i)%>"><%=diasSemana.get(i)%></option>
						<% 
								} 
						%>
						 </select> 
						
	                    </div>
	                  </div>
	
		              <div class="form-row">
	                   <div class="col">
	                   	<label>Cupo: </label>	                   
	                   <input type="text" name="cupo" class="form-control" placeholder="Ingrese el cupo">
	                   </div>
	                 </div>
	                    
	                  <div class="form-row">
	                    <div class="col">
	                      <label>Hora de inicio</label>
	                      <div  data-provide="datepicker" class="input-group date" id="datetimepickerHoraInicio">
	                        <input name="hora-inicio" type="text" class="form-control">     
	                        <div class="input-group-addon">
	                          <span class="glyphicon glyphicon-time"></span>
	                        </div>
	                      </div>                    
	                    </div>


	                    <div class="col">
	                      <label>Hora de fin</label>
	                      <div data-provide="datepicker" class="input-group date" id="datetimepickerHoraFin">
	                        <input name="hora-fin" type="text" class="form-control">     
	                        <div class="input-group-addon">
	                          <span class="glyphicon glyphicon-time"></span>
	                        </div>
	                      </div>
	                    </div>
	                  </div>


	                  <div id="success"></div>
	                  <!-- For success/fail messages -->
					
	              </div>
	              
	          	  <div class="modal-footer">
                	<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                	<button type="submit" class="btn btn-success" name="modo" value="alta-comision" >Agregar comisión</button>
              	  </div>
            
              </form>

            </div>
          </div>
        
        </div>
        <!--Modal Nueva Comision -->

        <table class="table table-hover table-bordered">

          <thead>
            <tr class="d-flex">
              <th class="col-1" scope="row">Id</th>
              <th class="col-3">Curso</th>
              <th class="col-1">Cupo</th>
              <th class="col-2">Dia de la semana</th>
              <th class="col-1">Hora de inicio</th>
              <th class="col-1">Hora de fin</th>
              <th class="col-3">Opciones</th>
            </tr>
          </thead>
          
          <tbody>

	<%   for (Comision comision: comisiones) 
			{ 
	%>

            <tr class="d-flex">
              <th class="col-1"  scope="row"><%= comision.getIdComision() %></th>
              
              <td class="col-3" ><%= curL.getById(comision.getIdCurso()).getNombre()%></td>                    
              <td class="col-1" ><%= comision.getCupo() %></td>             
              <td class="col-2" ><%= comision.getDiaSemana() %></td>
              <td class="col-1" ><%= comision.getHoraInicio() %></td>
              <td class="col-1" ><%= comision.getHoraFin() %></td>
              <td class="col-3">
              
                <button type="button" id="btn-editar-comision" class="btn btn-warning btn-editar">Editar</button>
                <button type="button" id="btn-eliminar-comision" class="btn btn-danger btn-eliminar" data-toggle="modal" data-target="#modalEliminar">Eliminar</button>   

                <!-- Modal Eliminar -->
                <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                
                  <div class="modal-dialog" role="document">
                  
                    <div class="modal-content">
                      
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">¿Estas seguro de eliminar la siguiente comisión?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>  
                        
                      <form method="post" action="eliminar-comision">
                      
	                      <div class="modal-body">
	                        
	                        <label>Id: </label>                    
                        	<input readonly type="text" name="id_comision" id="id-comision-eliminar" value="" />	
                        	<br>
                        	<label>Nombre: </label>                    
                        	<input id="nombre-comision-eliminar" name="nombre" disabled/>	
                        	
	                      </div>
	                      
	                      <div class="modal-footer">
	                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
         	
                        	<button name="modo" value="eliminar-comision"  type="submit" class="btn btn-danger">Si, eliminar</button>
         
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
                    <h1>Editar comision:<%=comision.getIdComision() %></h1>
                  </div>

                  <div class="panel-body">

                    <!-- ESTE ES EL FORM -->
                  <form id="comisionForm" method="post" action="editar-comision" >
                    
					 <div class="form-row">
                       <div class="col">
                         <label>Id de la comision </label>  
                        	<input readonly name="id_comision" value="<%=comision.getIdComision()%>" class="form-control"/>	                        
                        </div>
                      </div>
                    
	                 <div class="form-row" >
	                    <div class="col">
	                      <label>Curso al que pertenece la comision</label>
	                      <select name="idCurso" id="dropdownCurso" class="form-control">      
	                        			                      
					        <%   
					        for (Curso curso : cursos) {
					               if (curso.getNombre().equals(curL.getById(comision.getIdCurso()).getNombre())) 
					               {
					            	   %>
								<option value="<%= curso.getId() %>" selected><%= curso.getNombre() %></option>					               <%
					               }
					               else
									{ 
							%>
					            <option value="<%= curso.getId() %>"><%= curso.getNombre() %></option>
        	                <%  
									}
					        }
							%>
							
						 </select> 
						
	                    </div>
	                  </div>
	
					 <div class="form-row" >
	                    <div class="col">
	                      <label>Dia de dictado: </label>
	                    
	                      <select name="dia" class="form-control">
							<%
						   for(int i = 0; i < diasSemana.size(); ++i)
							{ 
					               if (comision.getDiaSemana().equals(diasSemana.get(i))) 
					               {
							%>
							 	<option value="<%= comision.getDiaSemana() %>" selected><%= comision.getDiaSemana() %></option>					      		
							<% 
					               	}
					               else{
							%>
						            <option value="<%=diasSemana.get(i)%>"><%=diasSemana.get(i)%></option>
							<% 
									}
					        }
							%>
							</select>							
				 
						
	
						
						
	                    </div>
	                  </div>
	
		             <div class="form-row">
	                   <div class="col">
	                   	<label>Cupo: </label>
	                   <input type="text" name="cupo" class="form-control" placeholder="Ingrese el cupo" value="<%= comision.getCupo() %>">
	                   </div>
	                 </div>
	                    
	                  <div class="form-row">
	                    <div class="col">
	                      <label>Hora de inicio</label>
	                      <div  data-provide="datepicker" class="input-group date" id="datetimepickerHoraInicioEdit">
	                        <input name="hora-inicio" type="text" class="form-control" value="<%= comision.getHoraInicio() %>">     
	                        <div class="input-group-addon">
	                          <span class="glyphicon glyphicon-time"></span>
	                        </div>
	                      </div>                    
	                    </div>

	
	                    <div class="col">
	                      <label>Hora de fin</label>
	                      <div data-provide="datepicker" class="input-group date" id="datetimepickerHoraFinEdit">
	                        <input name="hora-fin" type="text" class="form-control" value="<%= comision.getHoraFin()%>">     
	                        <div class="input-group-addon">
	                          <span class="glyphicon glyphicon-time glyphicon-th"></span>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	               
	                  <div id="success"></div>
                     
                      <!-- For success/fail messages -->
                      <button name="modo" value="editar-comision" type="submit" class="btn btn-success" id="sendMessageButton" style="margin-top: 20px;">Editar</button>
                     
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
   
   <!-- Footer de la pagina -->
   <div id="Footer"></div>
   
</body>

</html>