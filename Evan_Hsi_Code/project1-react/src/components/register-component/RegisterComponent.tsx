import React, { SyntheticEvent } from 'react';
import axios from 'axios'
import { Label, Input, Button } from 'reactstrap';

interface IRegisterState {
    username: string
    password: string
    firstname: string
    lastname: string
    email:string
}

export class RegisterComponent extends React.Component<any, IRegisterState> {
    constructor(props: IRegisterState) {
        super(props)
        this.state = {
            username:'',
            password:'',
            firstname:'',
            lastname: '',
            email: ''
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

    updateFirstname = (event:any) => {
        this.setState({
            ...this.state,
            firstname: event.target.value
        })
    }

    updateLastname = (event:any) => {
        this.setState({
            ...this.state,
            lastname: event.target.value
        })
    }

    updateEmail = (event:any) => {
        this.setState({
            ...this.state,
            email: event.target.value
        })
    }

    submitRegister = async (event: SyntheticEvent) => {
        event.preventDefault();
        let user = {
            username:this.state.username,
            password:this.state.password,
            firstname:this.state.firstname,
            lastname:this.state.lastname,
            email:this.state.email
        }
        let userJSON = JSON.stringify(user);
        axios.post(
            'http://localhost:8080/project1/reg',
            userJSON)
            .then(res => {
                console.log(res);
                console.log(res.data);
            })

    }

    render() {
        return (

            <div>
                <h3>Register</h3>
                <hr/>
                <div>
                    <Label for='firstname'>First Name</Label>
                    <Input required
                    type='text'
                    name='firstname'
                    id='firstname'
                    placeholder='First Name'
                    value={this.state.firstname}
                    onChange={this.updateFirstname}></Input>
                </div>
                <div>
                    <Label for='lastname'>Last Name</Label>
                    <Input required
                    type='text'
                    name='lastname'
                    id='lastname'
                    placeholder='Last Name'
                    value={this.state.lastname}
                    onChange={this.updateLastname}></Input>
                </div>
                <div>
                    <Label for='username'>Username</Label>
                    <Input required
                    type='text'
                    name='username'
                    id='username'
                    placeholder='Usernme'
                    value={this.state.username}
                    onChange={this.updateUsername}></Input>
                </div>
                <div>
                    <Label for='password'>Password</Label>
                    <Input required
                    type='password'
                    name='password'
                    id='password'
                    placeholder='Password'
                    value={this.state.password}
                    onChange={this.updatePassword}></Input>
                </div>
                <div>
                    <Label for='email'>Email  </Label>
                    <Input required
                    type='email'
                    name='email'
                    id='email'
                    placeholder='sample@company.com'
                    value={this.state.email}
                    onChange={this.updateEmail}></Input>
                </div>

                <Button color='primary' id='register'
                onClick={this.submitRegister}>Register</Button>
            </div>
            
        )
    }
    


}