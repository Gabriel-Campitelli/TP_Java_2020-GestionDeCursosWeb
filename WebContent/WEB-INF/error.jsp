<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ha ocurrido un error</title>

<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <style>
      :root {
		  --input-padding-x: 1.5rem;
		  --input-padding-y: .75rem;
		}
		
		body {
		  background: #007bff;
		  background: linear-gradient(to right, #0062E6, #33AEFF);
		}
		
		.card-signin {
		  border: 0;
		  border-radius: 1rem;
		  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
		}
		
		.card-signin .card-title {
		  margin-bottom: 2rem;
		  font-weight: 300;
		  font-size: 1.5rem;
		}
		
		.card-signin .card-body {
		  padding: 2rem;
		}
		
		.form-signin {
		  width: 100%;
		}
		
		.form-signin .btn {
		  font-size: 80%;
		  border-radius: 5rem;
		  letter-spacing: .1rem;
		  font-weight: bold;
		  padding: 1rem;
		  transition: all 0.2s;
		}
		
		.form-label-group {
		  position: relative;
		  margin-bottom: 1rem;
		}
		
		.form-label-group input {
		  height: auto;
		  border-radius: 2rem;
		}
		
		.form-label-group>input,
		.form-label-group>label {
		  padding: var(--input-padding-y) var(--input-padding-x);
		}
		
		.form-label-group>label {
		  position: absolute;
		  top: 0;
		  left: 0;
		  display: block;
		  width: 100%;
		  margin-bottom: 0;
		  /* Override default `<label>` margin */
		  line-height: 1.5;
		  color: #495057;
		  border: 1px solid transparent;
		  border-radius: .25rem;
		  transition: all .1s ease-in-out;
		}
		
		.form-label-group input::-webkit-input-placeholder {
		  color: transparent;
		}
		
		.form-label-group input:-ms-input-placeholder {
		  color: transparent;
		}
		
		.form-label-group input::-ms-input-placeholder {
		  color: transparent;
		}
		
		.form-label-group input::-moz-placeholder {
		  color: transparent;
		}
		
		.form-label-group input::placeholder {
		  color: transparent;
		}
		
		.form-label-group input:not(:placeholder-shown) {
		  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
		  padding-bottom: calc(var(--input-padding-y) / 3);
		}
		
		.form-label-group input:not(:placeholder-shown)~label {
		  padding-top: calc(var(--input-padding-y) / 3);
		  padding-bottom: calc(var(--input-padding-y) / 3);
		  font-size: 12px;
		  color: #777;
		}
		
		.btn-google {
		  color: white;
		  background-color: #ea4335;
		}
		
		.btn-facebook {
		  color: white;
		  background-color: #3b5998;
		}
		
		/* Fallback for Edge
		-------------------------------------------------- */
		
		@supports (-ms-ime-align: auto) {
		  .form-label-group>label {
		    display: none;
		  }
		  .form-label-group input::-ms-input-placeholder {
		    color: #777;
		  }
		}
		
		/* Fallback for IE
		-------------------------------------------------- */
		
		@media all and (-ms-high-contrast: none),
		(-ms-high-contrast: active) {
		  .form-label-group>label {
		    display: none;
		  }
		  .form-label-group input:-ms-input-placeholder {
		    color: #777;
		  }
		}
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">


</head>
<body>

<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
                <h5 class="card-title text-center">
                	<%=request.getAttribute("mensaje")%>
                </h5>            
                
                <a class="btn btn-lg btn-primary btn-block text-uppercase" href="<%=request.getAttribute("direccion-volver")%>" >
                	<%=request.getAttribute("mensaje-volver")%>
                </a> 
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
</html>