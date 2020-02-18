declare module "MyTypes" {
    import { StateType, ActionType } from "typesafe-actions";
    //1 for reducer, 1 for action creators
    export type ReducerState = StateType<typeof 
        import("../reducers").default>;
    export type RootAction = ActionType<typeof 
        import("../action-mappers/action-mappers")>;
}