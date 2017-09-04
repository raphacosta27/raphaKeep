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
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Keep </a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="sass.html"><i class="material-icons left">search</i>Link with Left Icon</a></li>
            <li><a href="badges.html">Components</a></li>
            <li><a href="collapsible.html">JavaScript</a></li>
            </ul>
        </div>
    </nav>
    
    <div class='row'></div>
    <div class='row'></div>
    <div class='row'></div>
    <% DAO dao = new DAO(); %>
    
	<div class="row">
        <div class = "container">
        <form class="col s12">
            <div class="row">
            <div class="input-field col s10">
                <i class="material-icons prefix">mode_edit</i>
                
                
                <form method='post'>
			    <input type='text' name='texto' id="texto">
			    <label for ='texto'>Escreva uma nota</label>
			    </div>
			    <button type='submit' class="btn-floating btn-large waves-effect waves-light red" id="addButton" ><i class="material-icons">add</i></button>
                <!-- <textarea id="icon_prefix2" class="materialize-textarea" name = "texto"></textarea>
                <label for="icon_prefix2">Escreva uma nota</label> -->
                
                
            

            </div>
        </form>
        </div>
        
    </div>
    
                
	<div class='row' id='notas'>	
	<% 
	 List<Notas> notas = dao.getLista();
	 for (Notas nota : notas ) {  
	 	String numero = Integer.toString(nota.getId());
	 	String idTitle = "card" + numero;
	 	String cardTitle = "Nota " + numero;
	 	%>
	 	<div class='col s3 m31'> 
        <div class='card blue-grey darken-1'>
        <div class='card-content white-text'>
        <form>
        <span class="card-title"><%=cardTitle%></span>
        </form>
        
        <form method="post">
        
        </form>
            <p contentEditable class='cardContent' noteid=<%=nota.getId()%> ><%=nota.getTexto()%></p>
        </div>
        <div class='card-action'>
            <a href='#'>Editar</a>
            <a href='#' class='rb' noteid=<%=nota.getId()%>>Remover</a>

        </div>
        </div>
        </div>
	<% }
	
	%>
    </div>
    
	
	</body>
</html>



















