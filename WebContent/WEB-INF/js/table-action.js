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
		var textarea = document.querySelector('[id=textarea]');
	
		textarea.addEventListener('keydown', autosize);
		             
		function autosize(){
		  var el = this;
		  setTimeout(function(){
		    el.style.cssText = 'height:' + el.scrollHeight + 'px';
		  },0);
		}
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
