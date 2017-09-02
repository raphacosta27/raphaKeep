
function addNote (){
    var label = document.getElementById("icon_prefix2");
    var texto = label.value;
    console.log(texto);
    var colocar = document.getElementById("sobrando").innerHTML = 
    "<div class='col s6 m31'>" + 
        "<div class='card blue-grey darken-1'>" +
        "<div class='card-content white-text'>" +
            "<span class='card-title'>Card Title</span>" +
            "<p>" + texto + "</p>"
        "</div>" +
        "<div class='card-action'>" +
            "<a href='#'>This is a link</a>" +
            "<a href='#'>This is a link</a>" +
        "</div>" +
        "</div>" +
    "</div>"
}
$( document ).ready(function() {
    var addButton = document.getElementById("addButton");
    addButton.addEventListener("click", function(){
        addNote();
    });
});

