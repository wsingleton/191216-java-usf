//how does ajax work?
//event occurs in a web page (button is cliocked, page is loaded)
// An XMLHttprequest object is created by JavaScript
//the xmkhtttprequest object send a request to a server
//server processes the request 
//server sends a response back to the web page
//The response is read by javascript
//a proper action (like page update) is performed by javascript

window.onload = function(){
document.getElementById("pokemonSubmit").addEventListener('click', getPokemon);
}

function getPokemon(){
    let pokemon = document.getElementById("pokemonId").value;
    //create an xmlhttprequest object
    let xhttp = new XMLHttpRequest(); //step two
    //true mean sasync
    xhttp.open("GET", 'https:pokeapi.co/api/v2/pokemon/' + pokemon, true);
    xhttp.send();//step 3
    xhttp.onreadystatechange = function() {
        //ready state property holds the status of the http request 
        /*
        0 - request not init
        1- server connection established
        2 - request receive
        3 - processing request
        4 request is finished and response is ready
        */
       if(xhttp.readyState === 4 && xhttp.status === 200){
           let pokemonObject = JSON.parse(xhttp.responseText);
           //if steps 4 and 5 are succesful, we got our pokemon object
           setValues(pokemonObject); 
       }
    }
}

function setValues(pokemon) {
    //steps six , seven: Js not only reades the datab but also renders it onto the page.
    document.getElementById("pokemonName").innerText = pokemon.name;
    let pokeImg = document.getElementById("pokemonImg");
    pokeImg.setAttribute("src", pokemon.sprites.front_default);
    pokeImg.setAttribute("alt", pokemon.name);
}