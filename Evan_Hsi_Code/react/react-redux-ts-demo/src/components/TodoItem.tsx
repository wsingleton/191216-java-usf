import * as React from 'react';

interface TodoItemProps {
    item: string;
    idx: number;
    handleDelete: (idx: number) => void;
}

export const TodoItem: React.FC<TodoItemProps> = props => {
    return (
        <div>
        <span>
            {props.item}
            <button onClick={() => props.handleDelete(props.idx)}>X</button>
        </span>
        </div>
        
    );
};