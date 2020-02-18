import { combineReducers } from "redux"
import { pokemonReducer } from "./pokemon-reducer"

export interface IPokemonState {
    allPokemon:any[],
}

export interface IState {
    pokemonState: IPokemonState
}

export const state = combineReducers<IState>({
    pokemonState:pokemonReducer
})