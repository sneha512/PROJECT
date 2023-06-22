import {h,FunctionComponent} from 'preact';
import { useState } from 'preact/hooks';
import './app.css'

interface Todo {
  id: number;
  text: string;
  completed: boolean;
}

const TodoList: FunctionComponent = () => {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [inputValue, setInputValue] = useState<string>("");

  const handleInputChange = (event: h.JSX.TargetedEvent<HTMLInputElement>) => {
    setInputValue(event.currentTarget.value);
  };

  const handleAddTodo = () => {
    if (inputValue.trim() !== "") {
      const newTodo: Todo = {
        id: todos.length + 1,
        text: inputValue,
        completed: false
      };

      setTodos([...todos, newTodo]);
      setInputValue("");
    }
  };

  const handleToggleComplete = (id: number) => {
    setTodos(prevTodos =>
      prevTodos.map(todo =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo
      )
    );
  };

  const handleDeleteTodo = (id: number) => {
    setTodos(prevTodos => prevTodos.filter(todo => todo.id !== id));
  };

  return (
    <div>
      <h1>Todo List</h1>
      <input
        type="text"
        value={inputValue}
        onChange={handleInputChange}
        placeholder="Enter a todo"
      />
      <button onClick={handleAddTodo}>Add Todo</button>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            <input
              type="checkbox"
              checked={todo.completed}
              onChange={() => handleToggleComplete(todo.id)}
            />
            <span style={{ textDecoration: todo.completed ? "line-through" : "none" }}>
              {todo.text}
            </span>
            <button onClick={() => handleDeleteTodo(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
export function App()
{
  return(
  <>
  <TodoList/>
  </>
  )
}