/*
    How does AJAX work?

    1) An event occurs in a web page (button is clicked, page is loaded)
    2) An XMLHttpRequest object is created by JavaScript
    3) The XMLHttpRequest object sends a request to a web server
    4) The server processes the request
    5) The server sends a response back to the web page
    6) The response is read by JavaScript
    7) a proper action (like page update) is performed by JavaScript
*/

// step 1 
// if the user clicks the button
window.onload = function(){

document.getElementById("pokemonSubmit").addEventListener('click', getPokemon);

}

function getPokemon() {

    // getting the id/field value
    let pokemonId = document.getElementById("pokemonId").value;

    // create an XMLHttpRequest object allow us to make requests
    let xhttp = new XMLHttpRequest(); // step 2

    // create a connection (endpoint/url, verb, boolean asynch or not)
    xhttp.open("GET", 'https://pokeapi.co/api/v2/pokemon/' + pokemonId, true)
    xhttp.send(); // step 3
    xhttp.onreadystatechange = function() {
        /*
            The ready state property holds the status of the XMLHttpRequest object
                + 0 - request not initialized - UNSENT
                + 1 - server connection established - OPENED
                + 2 - request received - HEADERS_RECEIVED
                + 3 - processing request - LOADING
                + 4 - request is finished and response is read - DONE

            Status codes
                + Informational responses (100–199),
                + Successful responses (200–299),
                + Redirects (300–399),
                + Client errors (400–499),
                + Server errors (500–599).
         */
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let pokemon = JSON.parse(xhttp.responseText);

            // if steps 4 and 5 are successful, we got our pokemon object

            setValues(pokemon);

        }
        
    }

}

function setValues(pokemon) {
    // step six, seven: JS not only reads the data but also utilizing DOM manipulation
    // we are able to render the data onto the web page

    document.getElementById("pokemonName").innerText = pokemon.name;
    let pokemonImgStandard = document.getElementById("pokemonImg");
    pokemonImgStandard.setAttribute("src", pokemon.sprites.front_default);
    pokemonImgStandard.setAttribute("alt", pokemon.name);

}

document.getElementById("pokemonImg").addEventListener("mouseover", makeShiny);
document.getElementById("pokemonImg").addEventListener("mouseleave", makeStandard);

function makeShiny(){
    document.getElementById("pokemonImg").setAttribute("src", pokemon.sprites.front_shiny);
}

function makeStandard(){
    document.getElementById("pokemonImg").setAttribute("src", pokemon.sprites.front_default);
}
