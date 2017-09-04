
$( document ).ready(function() {
    var addButton = document.getElementById("addButton");
    var editar = document.getElementById("editar");
    addButton.addEventListener("click", function(){
        addNote();
    });
    
    $("#addButton").click((e) => { 
    	console.log("Adicionando nota...")
    	fetch('./cria', {
    		method: 'POST',
    		body : $("#texto").val()
    	}).then ((response) => {
    		$('#notas').load(document.URL +  ' #notas');
    		/*$("#notas").load($("#notas"))*/
    		})
    	});
    
    $(".rb").click((e) => { 
    	console.log(e.target.attributes.noteid)
    	fetch('./remove', {
    		method: 'POST',
    		body : e.target.getAttribute('noteid')
    	}).then ((response) => {
    		$(e.target).parent().parent().remove();
    		console.log($(e.target).parent().parent().parent());
 /*   		$('#notas').load(document.URL +  ' #notas');*/
    		})
    	});
    
    var debounced_version = _.debounce(function(e){
    	editar(e);
    }, 2000)
    	
    
    $(".cardContent").on('keydown', (e) => { 
    	debounced_version(e);
    })
    
    var editar = (e) => {
	    console.log("fim do timeout");
		id = e.target.attributes.noteid;
		text = e.target.textContent;
		console.log(id.toString());
		json = {'id': id.value, 'text': text};
	//	console.log("alterando: " + id.toString());
		fetch('./Atualiza', {
			method: 'POST',
			body : JSON.stringify(json)
		}).then ((response) => {
			})
    }
})


var addNote = () => {
	$("notas").load($("notas"))
}

