/*
How does AJAX work?

1) an event occurs in a webpage (button is clicked, page is loaded)

2) An XMLHttpRequest object is creatted by JavaScript

3) The XMLHttpRequest object sends a request to a web server

4) The server processes the request

5) The server sends a response back to the webpage

6) The reponse is read by JavaScript

7) A proper action (like page update)
*/

window.onload = function() {
document.getElementById("pokemonSubmit")
.addEventListener('click', getPokemon);
// step one if the user clicks the button
}

function getPokemon() {
    //getting the id/field value
    let pokemonID = document.getElementById("pokemonID").value;

    // create and XMLHttpRequest object to allow us to make requests
    let xhttp = new XMLHttpRequest(); //step two

    // create a connecetion (endpoint/url, verb, boolean asynch or not)
    xhttp.open("GET", 'https://pokeapi.com./api/v2/pokemon/'+ pokemonID, true);
    xhttp.send(); //step three

    xhttp.onreadystatechange = function() {

        /*

        The readystate property hold the status of the XMLHttpRequest object

        0 - request not initialized
        1- server connection established
        2 - request received
        3 - processing request
        4 - request is finished and reponse is ready

        */

        if(xhttp.readyState == 4 && xhttp.status == 200) {
            let pokemon JSON.parse(xhttp.responseText);
            // if steps 4 and 5 are successful, we got out pokemon object

            setValues(pokemon);
        }
    }

}

function setValues(pokemon){
    //step 6 and 7: JS not only reads the data but also utilizing DOM manipulation, we are able to render the date onto the DOM page
    document.getElementById("pokemonName").innerHTML = pokemon.name;
    let pokemonImgElement = document.getElementById("pokemonImg");
    pokemonImgElement.setAttribute("src", pokemon.sprites.front_default);
    pokemonImgElement.setAttribute("alt", pokemon.name);
}