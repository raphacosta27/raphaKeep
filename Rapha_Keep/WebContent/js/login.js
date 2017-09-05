$(document).ready(() => {
	
	$('#signUp').click((e) =>{
		if ($('#signUpPass').val() == $('#confirmPass').val()){
			newUser  = $('#signUpUser').val();
			newPass = $('#signUpPass').val();
			newJson = {"user": newUser, "pass": newPass}
			fetch("./singIn",{
				method: "POST",
				body: JSON.stringify(newJson)
			}).then((response)=>{
				
			})
		}	
	})
	
	
	$("#signInButton").click((e) => {
		user  = $('#user').val();
		pass = $('#pass').val();
		json = {"user": user, "pass": pass};
		fetch("./login", {
    		method: "POST",
    		body : JSON.stringify(json)
    		
    	}).then ((response)=> {
    		response.json().then((data)=> {
    			console.log(data)
    			if(data.login == "confirmed"){
    				window.location.replace("http://localhost:8080/Rapha_Keep/index.jsp");
    				localStorage.setItem('user', data.user);
    				
    			}
    			else if(data.login == "unconfirmed"){
    				alert("Login ou senha incorreta");
    			}
    		})
    	})
    })
    		
})