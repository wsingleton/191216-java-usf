/*
How does AJAX work?

    1) An event occurs in a web page (button is clicked, page is loaded)
    2) An XMLHttpRequest object is created by JavaScript
    3) The XMLHttpRequest object sends a request to a web server
    4) The server sends a response back to the web page
    6) The response is read by JavaScript
    7) A proper action (like page update etc.) is performed by JavaScript

*/
window.onload = function(){
document.getElementById("pokemonSubmit")
.addEventListener('click', getPokemon);
// step one if the user clicks the button
}

function getPokemon() {
    //getting the id/field value
    let id = document.getElementById("pokemonId").nodeValue;

    //create an XMLHttpRequest object to allow us to make requests
    let xhttp = new XMLHttpRequest(); // step two

    //create a connection (endpoint/url, verb, boolean asynch or not)
    xhttp.open("GET", 'https://pokeapi.co/api/v2/pokemon/' + id, true);
    xhttp.send(); // step three
    xhttp.onreadystatechange = function() {
        /*
            The readystate property holds the status of the XMLHTtpREQUEST object
            
                0 - request not initialized
                1 - server connection established
                2 - request recieved
                3 - processing request
                4 - request is finished and response is ready
        */

        if(xhttp.readyState == 4 && xhttp.status == 200) {
            let pokmeon = JSON.parse(xhttp.responseText);
            // if steps 4 and 5 are successful, we got our pokemon object

            setValues(pokemon);
        }
    }
}

function setValues(pokemon) {
    //step six, seven: JS not only reads the data, but also,
    // using dom manipulation, we are able to render the data onto the web page

    document.getElementById("pokemonName").innerHTML = pokemon.name;
    let pokemonImgElement = document.getElementById("pokemonImg");
    pokemonImgElement.setAttribute("src", pokemon.sprites.front_default);
    pokemonImgElement.setAttribute("alt", pokmeon.name);
}