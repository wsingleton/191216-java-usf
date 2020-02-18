import { IState } from "../../reducers"
import { connect } from "react-redux"
import { getAllPokemon } from '../../action-mappers/pokemon-actions'
import { PokemonComponent} from "./PokemonComponent"


const mapStateToProps = (state: IState) => {
    return {
        allPokemon: state.pokemonState.allPokemon
    }
}

const mapDispatchToProps = {
    getAllPokemon
}

export default connect(mapStateToProps, mapDispatchToProps)(PokemonComponent)