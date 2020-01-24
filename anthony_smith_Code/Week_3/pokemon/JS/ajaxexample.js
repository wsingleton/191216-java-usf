/**
 * 

 * 
 * 
 * 
 */

 /*

  How does AJAX work ? 

  1) An event occur in a web page (button is clicked, page is loaded)
  2) An XMLHTTPRequest object is created by JavaScript
  3) The XMLHTTPRequest object sends a request to a web sever 
  4) The server process the request 
  5) the server sends a response back to the web page
  6) the repose is read by JavaScrpit 
  7) a proepr acrion (Like page upadte 

 */


// step one if the user clicks the button
 window.onload = function(){
 document.getElementById("pokemonSubmit").addEventListener('click', getPokemon);
}

function getPokemon(){

    //getting the id/field value
    let pokemonId = document.getElementById("pokemonId").nodeValue;

    //create an XMLHttpRewuet object to allow us to make requests
    let xhttp = new XMLHttpRequest();//htmp


    //create a connection(endpoint/url, verb, boolean asynch or not)
    xhttp.open("GET", 'https://pokeapi.co/api/v2/pokemon' + pokemonId, true);
    xhttp.send(); //step three

    xhttp.onreadystatechange = function(){

        /*
        *   The readystate property holds the status of the XMLHTTPREQUEST object
        *   0 - request not initialized
        *   1 - servetr  connection estab.
        *   2 - request recieved 
        *   3 - processing requesr
        *   4 - request is fin and response is ready
        */
  
  
        
        if (xhttp.readyState == 4 && xhttp.status == 200){
            let pokemon = JSON.parse(xhttp.responseText);
            //if steps 4 and 5 are sucessful we got our pokemon object 


            setValues(pokemon);

        }
  
    }

}

function setValues (pokemon){
    //6 & 7 : JS not reads the data but also utilizing DOM manipulation, we are able to reander 

    document.getElementById("pokemonName").innerHTML = pokemon.name;
    let pokemonImgElement = document.getElementById("pokemonIMG"); 
    pokemonImgElement.setAttribute("src", pokemon.sprites.front_default);
    pokemonImgElement.setAttribute("alt", pokemon.name);
}