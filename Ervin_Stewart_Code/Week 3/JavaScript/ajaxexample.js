window.onload = function(){
document.getElementById("pokemonSubmit").addEventListener('click', getPokemon);}

function getPokemon(){
// get Id/field value
let pokemonId = document.getElementById("pokemonId").value;
let xhttp = new XMLHttpRequest();
xhttp.open("GET", 'https://pokeapi.co/api/v2/pokemon/'+ pokemonId, true);
xhttp.send();
xhttp.onreadystatechange = function(){

    if(xhttp.readyState == 4 && xhttp.status == 200){
        let pokemon = JSON.parse(xhttp.responseText);
        setValue(pokemon);
    }
}
}

function setValue(pokemon){
    document.getElementById("pokemonName").innerHTML = pokemon.name;
let pokemonIMGElement = document.getElementById("pokemonImg");
pokemonIMGElement.setAttribute("src", pokemon.sprites.front_default);
pokemonIMGElement.setAttribute("alt", pokemon.name);
}


