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
