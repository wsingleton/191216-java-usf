function getPokemon(){
window.onload = function(){
document.getElementById("pokemonSubmit")
.addEventListener("click", getPokemon);
// steop one if theuser clicks the button
}


    let pokemonId = document.getElementById("pokemonId").value;

    let xhhp = new XMLHttpRequest();

    XMLHttpRequest.OPEN("GET", 'https://pokeapi.co/api/v2/pokemon/' +pokemonId, true);
    XMLHttpRequest.send();

    if(XMLHttpRequest.readyState == 4 && XMLHttpRequest.status ==200){
        let pokemon = JSON.parse(xttp.responseText);
        setValues(pokemon);
    }
}
}

function setValues(pokemon){
    document.getElementById("pokemonName").innerHTML = pokemon.name;
    let pokemonImgElement = document.getElementById("pokemonImg");
    pokemonImgElement.setAttribute("src", pokemonImgElement.sprites.front_default);
    pokemoneImg.setAttribute("alt", pokemon.name);
}
