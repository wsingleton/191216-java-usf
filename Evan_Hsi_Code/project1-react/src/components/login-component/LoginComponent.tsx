import React, { SyntheticEvent } from 'react';
import { Label, Input, Button } from 'reactstrap';
import axios from 'axios';

interface ILoginState {
    username: string
    password: string
    loginMessage: string
}

export class LoginComponent extends React.Component<any, ILoginState> {
    constructor(props: ILoginState) {
        super(props)
        this.state = {
            username: '',
            password: '', 
            loginMessage: ''
        }
    }

    updateUsername = (event:any) => {
        this.setState({
            ...this.state,
            username: event.target.value
        })
    }

    updatePassword = (event:any) => {
        this.setState({
            ...this.state,
            password: event.target.value
        })
    }

    submitLogin = async (event: SyntheticEvent) => {
        event.preventDefault();
        let creds = {
            username:this.state.username,
            password:this.state.password
        }
        let credsJSON = JSON.stringify(creds);
        axios.post(
            'http://localhost:8080/project1/auth', 
            credsJSON)
            .then(res => {
            console.log(res);
            console.log(res.data)
            })
    }

    render() {
        return (
            <div id='login-component'>
                <div id='login-row'>

                    <div id='block'></div>
                    <div id='login-form'>
                        <h2>Project1</h2>
                        <hr/>
                        <h3>Sign into Project 1</h3>
                        <div>
                            <Label for='username'>Username</Label>
                            <Input required
                                type='text'
                                name='Username'
                                id='username' 
                                placeholder='put username here'
                                value={this.state.username}
                                onChange={this.updateUsername} />
                        </div>
                        <div>
                            <Label for='password'>Password</Label>
                            <Input required
                                type="password" 
                                name='Password'
                                id='password' 
                                placeholder='Password'
                                value={this.state.password}
                                onChange={this.updatePassword} />
                        </div>
                        <br/>
                        <Button color='primary' id='login'
                        onClick={this.submitLogin}>Login</Button>
                        <br/>
                        <br/>
                        <div id='login-message'>{this.state.loginMessage}></div>
                    </div>
                </div>
            </div>
        )
    }
}