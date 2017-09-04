
$( document ).ready(function() {
    var addButton = document.getElementById("addButton");
    var editar = document.getElementById("editar");
    addButton.addEventListener("click", function(){
        addNote();
    });
    
  
    $(".rb").click((e) => { 
    	console.log(e.target.attributes.noteid)
    	fetch('./remove', {
    		method: 'POST',
    		body : e.target.getAttribute('noteid')
    	}).then ((response) => {
    		$(e.target).parent().parent().remove()
    		})
    	});
    
    
    })
    


function addNote(){
	$("notas").load($("notas"))
}

