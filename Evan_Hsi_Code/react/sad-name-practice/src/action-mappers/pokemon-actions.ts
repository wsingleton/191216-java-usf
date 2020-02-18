import { getMultiplePokemon, getPokemonByUrl } from "../remote/get-pokemon"


export const pokemonTypes = {
    SUCCESSFUL_GET_PAGE_POKEMON: 'POKEMON_SUCCESSFUL_GET_PAGE_POKEMON',
    UNSUCCESSFUL_GET_PAGE_POKEMON: 'POKEMON_UNSUCCESSFUL_GET_PAGE_POKEMON'
}

export const getAllPokemon = (limit: number, offset: number) => async (dispatch: any) => {
    try {
        let pokeLinks: any = await getMultiplePokemon(limit, offset)
        let pokemon = await Promise.all(pokeLinks.results.map((objects: any) => {
            return getPokemonByUrl(objects.url)
        }))

        dispatch({
            type:pokemonTypes.SUCCESSFUL_GET_PAGE_POKEMON,
            payload:{
                allPokemon:pokemon
            }
        })
    } catch (e) {
        dispatch({
            type:pokemonTypes.UNSUCCESSFUL_GET_PAGE_POKEMON
        })
    }
}
