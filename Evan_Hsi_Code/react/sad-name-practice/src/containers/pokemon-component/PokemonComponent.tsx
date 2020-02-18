import React from 'react'
import { PokemonDisplayComponent } from './pokemon-display-component/PokemonDisplayComponent'
import { CardColumns, Pagination, PaginationItem, PaginationLink } from 'reactstrap'


interface IPokemonState {
    limit: number
    offset: number
}

interface IPokemonProps {
    allPokemon: any[],
    getAllPokemon: (l: number, o: number) => void
}

export class PokemonComponent extends React.Component<IPokemonProps, IPokemonState> {
    constructor(props: IPokemonProps) {
        super(props)
        this.state = {
            limit: 18,
            offset: 0
        }
    }

    async componentDidMount() {
        if (this.props.allPokemon.length === 0) {
            this.props.getAllPokemon(18, 0)
        }
    }

    pageTurnForward = () => {
        let newOffset = this.state.offset + this.state.limit
        this.props.getAllPokemon(this.state.limit, newOffset)
        this.setState({
            ...this.state,
            offset: newOffset,
        })
    }

    pageTurnBackward = () => {
        let newOffset = this.state.offset - this.state.limit
        this.props.getAllPokemon(this.state.limit, newOffset)
        this.setState({
            ...this.state,
            offset: newOffset,
        })
    }


    render() {

        const displayList: PokemonDisplayComponent[] = this.props
        .allPokemon.map<any>((pokemon: any) => {
            return <PokemonDisplayComponent id={pokemon.id}
                name={pokemon.name}
                height={pokemon.height}
                weight={pokemon.weight}
                types={[pokemon.types[0].type.name, pokemon.types[1]
                    && pokemon.types[1].type.name]}
                key={pokemon.id}
            />
        })

        return (
            <>
                <h3>Welcome Trainer</h3>
                <CardColumns>
                    {displayList}
                </CardColumns>
                <Pagination aria-label='Page navigation example'>
                    <PaginationItem disabled={!this.state.offset}
                    onClick={this.pageTurnBackward}>
                        <PaginationLink previous />
                    </PaginationItem>
                    <PaginationItem disabled={!this.state.offset}
                    onClick={this.pageTurnForward}>
                        <PaginationLink next />
                    </PaginationItem>
                </Pagination>
            </>
        )
    }

}