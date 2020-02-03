import React, { SyntheticEvent } from 'react';
import { Form, FormGroup, Jumbotron, Label, Col, Input, Button } from 'reactstrap';
// import './LoginComponent.css'

interface ILoginState {
    username: string
    password: string
}

interface ILoginProps {
    updateCurrentUser: (u: string, p: string) => void
    loginMessage: string
}

export class LoginComponent extends React.Component<ILoginProps, ILoginState> {
    constructor(props: any) {
        super(props)
        this.state = {
            username: '',
            password: ''
        }
    }

    updateUsername = (event: any) => {
        this.setState({
            ...this.state,
            username: event.target.value
        })
    }

    updatePassword = (event: any) => {
        this.setState({
            ...this.state,
            password: event.target.value
        })
    }

    submitLogin = async (event: SyntheticEvent) => {
        event.preventDefault()
        this.props.updateCurrentUser(this.state.username, this.state.password)
    }

    render() {
        return (
            <div>
                <Jumbotron>
                    <h2 className="display-4">
                        <strong>Buhlakify Login</strong>
                    </h2>
                    <p className="lead">Buhlakify: Here to service your reimbursement needs</p>
                </Jumbotron>
                <div className="d-flex justify-content-center">
                <Form  onSubmit={this.submitLogin}>
                    <FormGroup row>
                        <Col sm={12}>
                            <Input required
                                type="text"
                                name="Username"
                                id="exampleUsername"
                                placeholder="Username"
                                value={this.state.username}
                                onChange={this.updateUsername} />
                            {/* this is an example of data binding, we take data from the state and put it in our tsx */}
                        </Col>
                    </FormGroup>
                    <FormGroup row >
                        <Col sm={12}>
                            <Input required
                                type="password"
                                name="password"
                                id="examplePassword"
                                placeholder="Password"
                                value={this.state.password}
                                onChange={this.updatePassword} />
                        </Col>
                    </FormGroup>
                    <Button color="secondary">Login</Button>
                </Form>
                </div>
                <p>{this.props.loginMessage}</p>
            </div>
        )
    }
}