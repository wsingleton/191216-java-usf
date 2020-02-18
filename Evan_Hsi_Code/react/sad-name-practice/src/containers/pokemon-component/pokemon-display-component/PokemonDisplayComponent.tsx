import React from 'react'
import { Card, CardBody, CardTitle, CardSubtitle, CardText } from 'reactstrap'

interface IPokemonDisplayProps {
    id: number
    height: number
    weight: number
    name: string
    types: string[]
}

export class PokemonDisplayComponent extends React.PureComponent<IPokemonDisplayProps> {

    cardTextBuilder() {
        return `This pokemon: ${this.props.name} has an amusing weight of ${this.props.weight}
        it is also ${this.props.height} tall and has the type(s) of ${this.props.types[0]}`
        + (this.props.types[1] ? 'and ' + this.props.types[1] : '')
    }

    render() {
        return (
            <Card>
                <CardBody>
                    <CardTitle>{this.props.id}</CardTitle>
                    <CardSubtitle>{this.props.name}</CardSubtitle>
                    <CardText>{this.cardTextBuilder()}</CardText>
                </CardBody>
            </Card>
        )
    }
}