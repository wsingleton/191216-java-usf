


const initialState:IUserState = {
    currentUser:null,
    loginMessage:''
}

export const loginReducer = (state = initialState, action:any) => {
    switch(action.type) {
        case 'Login successful':{

        }
        case 'unsuccessful':{

        }
        default:
            return state;
    }
}