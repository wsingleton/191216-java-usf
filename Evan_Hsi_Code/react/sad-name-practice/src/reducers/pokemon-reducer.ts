import { IPokemonState } from ".";
import { pokemonTypes } from "../action-mappers/pokemon-actions";


const initialState: IPokemonState = {
    allPokemon:[]
}

export const pokemonReducer = (state = initialState, action:any) => {
    switch (action.type) {
        case pokemonTypes.SUCCESSFUL_GET_PAGE_POKEMON: {
            return {
                ...state,
                allPokemon:action.payload.allPokemon
            }
        }
        case pokemonTypes.UNSUCCESSFUL_GET_PAGE_POKEMON: {
            return state
        }
        default:
            return state
    }
}