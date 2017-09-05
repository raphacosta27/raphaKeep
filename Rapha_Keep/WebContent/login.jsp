<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Day 001 Login Form</title>
		
		
		<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
		
		<link rel="stylesheet" href="css/style.css">
		<script
	    src="https://code.jquery.com/jquery-1.12.4.js"
	    integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	    crossorigin="anonymous"></script>
		<script type="text/javascript" src="js/login.js"></script> 
	</head>

<body>
	<script> </script>
  <div class="login-wrap">
	<div class="login-html">
		<label class="tab">Welcome to RaphaKeep</label>
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
		<div class="login-form">
			<div class="sign-in-htm">
				<div class="group">
					<label for="user" class="label">Username</label>
					<input id="user" type="text" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="pass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<input id="check" type="checkbox" class="check" checked>
					<label for="check"><span class="icon"></span> Keep me Signed in</label>
				</div>
				<div class="group">
					<input type="submit" class="button" value="Sign In" id="signInButton">
				</div>
				<div class="hr"></div>
				<div class="foot-lnk">
					<a href="https://github.com/raphacosta27/raphaKeep">Get Source Code</a>
				</div>
			</div>
			<div class="sign-up-htm">
				<div class="group">
					<label for="signUpUser" class="label" >Username</label>
					<input id="signUpUser" type="text" class="input">
				</div>
				<div class="group">
					<label for="signUpPass" class="label">Password</label>
					<input id="signUpPass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="confirmPass" class="label">Repeat Password</label>
					<input id="confirmPass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="email" class="label">Email Address</label>
					<input id="email" type="text" class="input">
				</div>
				<div class="group">
					<input type="submit" class="button" value="Sign Up" id="signUp">
				</div>
				<div class="hr"></div>
				<div class="foot-lnk">
					<label for="tab-1">Already Member?</a>
				</div>
			</div>
		</div>
	</div>
</div>
  
  
</body>
</html>
