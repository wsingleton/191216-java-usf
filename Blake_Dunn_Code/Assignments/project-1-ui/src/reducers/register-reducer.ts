import { IRegisterState } from ".";



const initialState:IRegisterState = {
    newUser:null,
    registerMessage:''
}

export const registerReducer = (state = initialState, action:any) => {
    switch(action.type) {
        case 'registration was successful':{
            return {
                
            }
        }
        case 'registration was unsuccessful':{
            return {
                
            }
        }
        default:
            return state;
    }
}