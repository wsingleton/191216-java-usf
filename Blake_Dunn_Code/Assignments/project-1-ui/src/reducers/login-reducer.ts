import { IUserState } from "."
import { loginTypes } from "../action-mappers/login-actions";


const initialState:IUserState = {
    currentUser:null,
    loginMessage:''
}

export const loginReducer = (state = initialState, action:any) => {
    switch(action.type) {
        case loginTypes.SUCCESSFUL_LOGIN:{
            return {
                ...state,
                currentUser:action.payload.currentUser,
                loginMessage: 'You have logged in'
            }
        }
        case loginTypes.UNSUCCESSFUL_LOGIN:{
            return {
                ...state,
                loginMessage:action.payload.loginMessage
            }
        }
        default:
            return state;
    }
}