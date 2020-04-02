  
import { compose, applyMiddleware, Store, createStore } from "redux"
import logger from "redux-logger"
import reduxThunk from "redux-thunk"
import { state } from "./reducers"


const a:any = window;

const composeEnhancers = a.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose

const enhancer = composeEnhancers(
    applyMiddleware(reduxThunk, logger)

)

export const store: Store<any> = createStore(
    state,
    enhancer
)