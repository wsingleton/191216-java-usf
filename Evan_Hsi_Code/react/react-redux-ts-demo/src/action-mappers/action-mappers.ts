import { action } from "typesafe-actions";

export enum actionTypes {
    ADD = 'ADD',
    DELETE = 'DELETE'
}

export const todoActions = {
    add: (item:string) => action(actionTypes.ADD, item),
    delete: (idx:number) => action(actionTypes.DELETE, idx)
};