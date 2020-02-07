import { combineReducers } from "redux";
import { loginReducer } from "./login-reducer";
// import { registerReducer } from "./register-reducer";


export interface IUserState {
    currentUser:any
    loginMessage:string
}

export interface IRegisterState {
    newUser:any
    registerMessage:string
}

export interface IState {
    userState : IUserState
    
}


// we will take the individual reduces for each part of state
// and turn them into one super reducer that represents all of state
export const state = combineReducers<IState>({
    userState:loginReducer
   
})