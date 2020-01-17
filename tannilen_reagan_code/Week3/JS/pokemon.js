/*
    How does AJAX work?
        - Event occurs in a webpage
        - An XMLHttpRequest object is created by JavaScript
        - The XMLHttpRequest object sends a request to a webserver
        - The server processes the request
        - The server send back a response
        - The response is read by JavaScript
        - A proper action is performed by JavaScript
*/
window.onload=function(){
    document.getElementById("pokemonSubmit").addEventListener("click", getPokemon);
}
let pokemon;
function getPokemon() {
    let pkmnID=document.getElementById("pokemonID").value;
    if (pkmnID) {
        let xhttp=new XMLHttpRequest();
        // communication requires endpoint, verb, optional boolean to specify if you want the request to be completed asynchronously
        xhttp.open("GET", "https://pokeapi.co/api/v2/pokemon/" + pkmnID, true);
        xhttp.send();
        xhttp.onreadystatechange=function() {
            //The readystate property holds the status of the XMLHttpRequest object
            // - 0: request not initialized
            // - 1: server connection established
            // - 2: request received
            // - 3: processing request
            // - 4: request is finished and response is ready
            if(xhttp.readyState==4 && xhttp.status==200) {
                pokemon = JSON.parse(xhttp.responseText);
                setValues(pokemon);
            }
        }
    }
}
function setValues(pokemon) {
    document.getElementById("pokemonName").innerText = pokemon.name;
    let pokemonImg=document.getElementById("pokemonImg");
    pokemonImg.setAttribute("src", pokemon.sprites.front_default);
    pokemonImg.setAttribute("alt", pokemon.name);
}
document.getElementById("pokemonImg").addEventListener("mouseover", makeShiny);
document.getElementById("pokemonImg").addEventListener("mouseleave", makeStandard);
function makeShiny() {
    document.getElementById("pokemonImg").setAttribute("src", pokemon.sprites.front_shiny);
}
function makeStandard() {
    document.getElementById("pokemonImg").setAttribute("src", pokemon.sprites.front_default);
}