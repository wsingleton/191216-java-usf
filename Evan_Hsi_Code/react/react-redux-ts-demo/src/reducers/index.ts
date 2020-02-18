import { combineReducers } from "redux";
import { todoReducer } from "./todoReducers"

const rootReducer = combineReducers({
    todo: todoReducer
});

export default rootReducer;