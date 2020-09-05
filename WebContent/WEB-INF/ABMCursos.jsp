<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Curso" %>
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
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>

  <!-- Script para MasterPage -->
  <script src="js/masterpage.js"></script>
  
  <!-- Script para poder desplegar el container en la tabla-->
  <script src="js/table-action.js"></script>

  <!-- CSS para el form -->
  <link href="css/cursos-style.css" rel="stylesheet">


  <!-- esto es para poder editar la tabla -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

  <%
	LinkedList<Curso> cursos = (LinkedList<Curso>)request.getAttribute("cursos");
  %>
</head>

<body>

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
              <div class="modal-body">

                <form id="cursoForm">

                  <div class="form-row">
                    <div class="col">
                      <label>Nombre del curso</label>
                      <input type="text" class="form-control" placeholder="Ingrese un nombre para el curso">
                    </div>
                  </div>

                  <div class="form-row">
                    <div class="col">
                      <label>Fecha de inicio</label>
                      <div class='input-group date' id='datetimepickerFechaInicio'>
                        <input type='text' class="form-control" />     
                        <span class="input-group-addon">
                          <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                      </div>                    
                    </div>

                    <div class="col">
                      <label>Fecha de fin</label>
                      <div class='input-group date' id='datetimepickerFechaFin'>
                        <input type='text' class="form-control" />     
                        <span class="input-group-addon">
                          <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                      </div>
                    </div>
                  </div>

                  <div class="form-row">
                      <div class="col">
                        <label>Descripcion</label>
                        <textarea rows="1" class="form-control" placeholder="Ingrese una descripcion para el curso" maxlength="999"></textarea>
                      </div>
                  </div>

                  <div class="form-row">
                    <div class="col">
                      <label>URL imagen</label>
                      <input type="text" class="form-control" placeholder="Ingrese una URL de imagen para el curso">
                    </div>
                  </div>

                  <div id="success"></div>
                  <!-- For success/fail messages -->

              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-success" >Agregar curso</button>
              </div>
            </form>

            </div>
          </div>
        </div>
        <!--Modal Nuevo Curso-->


        <table class="table table-hover table-bordered ">

          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Nombre</th>
              <th scope="col">Descripcion</th>
              <th scope="col">Fecha de inicio</th>
              <th scope="col">Fecha de fin</th>
              <th scope="col">Opciones</th>
            </tr>
          </thead>
          
          <tbody>

            <tr>
              <th scope="row">1</th>
              <td  >Algoritmos genéticos</td>
              <td>Este curso es re zarpado</td>
              <td>25-02-2020</td>
              <td>09-06-2020</td>
              <td>
                <button type="button" id="" class="btn btn-warning btn-editar">Editar</button>


                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalEliminar">Eliminar</button>
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
                      <div class="modal-body">
                        Nombre del curso a eliminar
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-danger"">Si, eliminar</button>
                      </div>
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
                    <h1>Editar curso: aca va el nombre del curso</h1>
                  </div>

                  <div class="panel-body">

                    <!-- ESTE ES EL FORM -->
                    <form id="cursoForm">

                      <div class="form-row">
                        <div class="col">
                          <label>Nombre del curso</label>
                          <input type="text" class="form-control" placeholder="Ingrese un nombre para el curso">
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col">
                          <label>Fecha de inicio</label>
                          <div class='input-group date' id='datetimepickerFechaInicio'>
                            <input type='text' class="form-control" />     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>                    
                        </div>

                        <div class="col">
                          <label>Fecha de fin</label>
                          <div class='input-group date' id='datetimepickerFechaFin'>
                            <input type='text' class="form-control" />     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                          <div class="col">
                            <label>Descripcion</label>
                            <textarea rows="1" class="form-control" placeholder="Ingrese una descripcion para el curso" maxlength="999"></textarea>
                          </div>
                      </div>
    
                      <div class="form-row">
                        <div class="col">
                          <label>URL imagen</label>
                          <input type="text" class="form-control" placeholder="Ingrese una URL de imagen para el curso">
                        </div>
                      </div>

                      <div id="success"></div>
                      <!-- For success/fail messages -->
                      <button type="submit" class="btn btn-success" id="sendMessageButton" style="margin-top: 20px;">Editar</button>
                    </form>
                    <!-- ESTE ES EL FORM -->

                  </div>
                </div>
              </td>
            </td>

            </tr>

            <tr>
              <th scope="row">2</th>
              <td>TTADS</td>
              <td>Este curso es re zarpado</td>
              <td>03-05-1990</td>
              <td>09-02-2001</td>
              <td>
                <button type="button" id="" class="btn btn-warning btn-editar">Editar</button>
                <button type="button" class="btn btn-danger">Eliminar</button>
              </td>
            </tr>
            
            <tr class="row-form" style="display:none;" >
              <td colspan="6" id="mostrar-panel">
                <div class="panel panel-default ">
                  <div class="panel-heading">
                    <h1>Editar curso: aca va el nombre del curso</h1>
                  </div>

                  <div class="panel-body">

                    <!-- ESTE ES EL FORM -->
                    <form id="cursoForm">

                      <div class="form-row">
                        <div class="col">
                          <label>Nombre del curso</label>
                          <input type="text" class="form-control" placeholder="Ingrese un nombre para el curso">
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col">
                          <label>Fecha de inicio</label>
                          <div class='input-group date' id='datetimepickerFechaInicio'>
                            <input type='text' class="form-control" />     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>                    
                        </div>

                        <div class="col">
                          <label>Fecha de fin</label>
                          <div class='input-group date' id='datetimepickerFechaFin'>
                            <input type='text' class="form-control" />     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                          <div class="col">
                            <label>Descripcion</label>
                            <textarea rows="1" class="form-control" data-validation-required-message="Please enter your message" maxlength="999"></textarea>
                          </div>
                      </div>

                      <div id="success"></div>
                      <!-- For success/fail messages -->
                      <button type="submit" class="btn btn-success" id="sendMessageButton" style="margin-top: 20px;">Editar</button>
                    </form>
                    <!-- ESTE ES EL FORM -->

                  </div>
                </div>
              </td>
            </td>

            </tr>
            
            <tr>
              <th scope="row">3</th>
              <td>Sistemas Operativos</td>
              <td>Este curso NO es re zarpado</td>
              <td>25-02-2009</td>
              <td>09-06-2017</td>
              <td>
                <button type="button" id="" class="btn btn-warning btn-editar">Editar</button>
                <button type="button" class="btn btn-danger">Eliminar</button>
              </td>
            </tr>
            
            <tr class="row-form" style="display:none;">
              <td colspan="6" id="mostrar-panel" >
                <div class="panel panel-default ">
                  <div class="panel-heading">
                    <h1>Editar curso: aca va el nombre del curso</h1>
                  </div>

                  <div class="panel-body">

                    <!-- ESTE ES EL FORM -->
                    <form id="cursoForm">

                      <div class="form-row">
                        <div class="col">
                          <label>Nombre del curso</label>
                          <input type="text" class="form-control" placeholder="Ingrese un nombre para el curso">
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col">
                          <label>Fecha de inicio</label>
                          <div class='input-group date' id='datetimepickerFechaInicio'>
                            <input type='text' class="form-control" />     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>                    
                        </div>

                        <div class="col">
                          <label>Fecha de fin</label>
                          <div class='input-group date' id='datetimepickerFechaFin'>
                            <input type='text' class="form-control" />     
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                          <div class="col">
                            <label>Descripcion</label>
                            <textarea rows="1" class="form-control" data-validation-required-message="Please enter your message" maxlength="999"></textarea>
                          </div>
                      </div>

                      <div id="success"></div>
                      <!-- For success/fail messages -->
                      <button type="submit" class="btn btn-success" id="sendMessageButton" style="margin-top: 20px;">Editar</button>
                    </form>
                    <!-- ESTE ES EL FORM -->

                  </div>
                </div>
              </td>
            </td>

            </tr>
            
          </tbody>
          
        </table>
        
        
      </div>
  
    </div>
    
    <!-- Footer de la pagina -->
    <div id="Footer"></div>

    </div>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  
    <!-- para el DATETIMEPICKER -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


</body>

</html>