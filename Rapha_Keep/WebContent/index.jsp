<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>RaphaKeep</title>
		<!--Import Google Icon Font-->
	    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	    <!--Import materialize.css-->
	    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
	    <link type="text/css" rel="stylesheet" href="css/index.css"/>
	
	    <!--Let browser know website is optimized for mobile-->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		
	</head>
	
	<body>
	<%@ page import="java.util.*, javax.servlet.*,edu.insper.rapha.*" %>
	<!--Import jQuery before materialize.js-->
   	<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->
	<script
    src="https://code.jquery.com/jquery-1.12.4.js"
    integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
    crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/1.0.1/lodash.js"></script>
	<script type="text/javascript" src="js/index.js"></script>


    <nav>
        <div class="nav-wrapper blue darken-4">
            <a href="#" class="brand-logo">RaphaKeep</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
            <!-- <li><a href="sass.html"><i class="material-icons left">search</i>Link with Left Icon</a></li> -->
            <li><a href="#" id="perfilLabel">
           <script>
            $("#perfilLabel").text(localStorage.user); 
            </script> 
            </a></li>	
            <li><a href="http://localhost:8080/Rapha_Keep/login.jsp" id="logOut">Log Out</a></li>
            </ul>
        </div>
    </nav>
    
    <div id='myuser' class='row'></div>
    <div class='row'></div>
    <div class='row'></div>
    <% DAO dao = new DAO(); %>
    
	<div class="row">
        <div class = "container">
            <div class="row">
            <div class="input-field col s10">
                <i class="material-icons prefix">mode_edit</i>
                
                

			    <input type='text' name='texto' id="texto">
			    <label for ='texto'>Escreva uma nota</label>
			    </div>
			    <button type='submit' class="btn-floating btn-large waves-effect waves-light blue darken-4" id="addButton" ><i class="material-icons">add</i></button>
                <!-- <textarea id="icon_prefix2" class="materialize-textarea" name = "texto"></textarea>
                <label for="icon_prefix2">Escreva uma nota</label> -->

            </div>
        </div>
        
    </div>
    
                
	<div class='row' id='notas'>	
	<%
	 List<Notas> notas = dao.getLista();
	 for (Notas nota : notas ) {  
	 	String numero = Integer.toString(nota.getId());
	 	String idTitle = "card" +  numero;
	 	String cardTitle = "Nota " + numero;
	 	%>
	 	<div class='col s3 m31'> 
        <div class='card blue darken-4'>
        <div class='card-content white-text'>
        <span class="card-title"><%=cardTitle%> <p id='owner'>Feito por <u><%=nota.getUser()%></u> em <u><%=nota.getData()%></u></p></span>
        <p contentEditable onfocus="this.value = this.value;" class='cardContent' noteid=<%=nota.getId()%> ><%=nota.getTexto()%></p>
        </div>
        <div class='card-action'>
            <a href='#' class='eb' noteid=<%=nota.getId()%>>Editar</a>
            <a href='#' class='rb' noteid=<%=nota.getId()%>>Remover</a>
        </div>
        </div>
        </div>
	<% }
	
	%>
    </div>
    
	
	</body>
</html>



















