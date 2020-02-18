import { actionTypes } from "src/action-mappers/action-mappers";
import * as MyTypes from "MyTypes";


interface ITodoState {
    count: number;
    list:string[];
}

export const initialState: ITodoState = {
    count: 2,
    list: ["Do the laundry", "Do the dishes"]
};

export const todoReducer = (state: ITodoState = initialState, 
    action: MyTypes.RootAction) => {
    switch(action.type) {
        case actionTypes.ADD: {
            return {
                ...state,
                count: state.count + 1,
                list: [...state.list, action.payload]
            };
        }
        case actionTypes.DELETE: {
            const oldList = [...state.list];
            const newList = oldList.splice(action.payload, 1);
            //const newList = oldList;

            return {
                ...state,
                count:state.count - 1,
                list:newList
            };
        }
        default:
            return state;
    }
};