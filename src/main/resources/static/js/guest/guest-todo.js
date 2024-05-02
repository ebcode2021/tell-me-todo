// common const Value
const localStorageItemName = "local-todoList";

// Todo function
const addTodo = () => {
    let inputText = document.querySelector('#add-todo-input').value;

    let savedTodoList = getTodoList();
    savedTodoList.push(createNewItem());

    localStorage.setItem(localStorageItemName, JSON.stringify(savedTodoList));
    clearInputArea();

    function createNewItem() {
        let currentDate = new Date().toLocaleDateString();

        return {
            id : savedTodoList.length > 0 ? savedTodoList[savedTodoList.length - 1].id + 1: 0,
            content : inputText,
            completed : false,
            created_at : currentDate,
            updated_at : currentDate,
            favorite : false,
        };
    }

    function clearInputArea()  {
        document.querySelector('#add-todo-input').value="";
    }
}

const removeTodo = (id) => {
    let todoList = getTodoList();
    let updatedTodoList = todoList.filter(item => item.id !== id);

    localStorage.setItem(localStorageItemName, JSON.stringify(updatedTodoList));
}

// Todo-List function
const getTodoList = () => {
    if (localStorage.getItem(localStorageItemName)) {
        return JSON.parse(localStorage.getItem(localStorageItemName));
    }
    localStorage.setItem(localStorageItemName, JSON.stringify([]));
    return [];
}

const removeTodoList = () => {
    localStorage.removeItem(localStorageItemName);
}

/**
 * Event Detect Function
 */

const eventListener = () => {
    document.querySelector('#delete-item-button').addEventListener('click', () => {
        removeTodoList();
        updateTodoList();
    });

    document.querySelector('#add-todo-input').addEventListener('keypress', (e) => {
        if (e.key === 'Enter' && e.target.value.length > 0) {
            addTodo();
            updateTodoList();
        }
    });

    document.querySelector('.home-inputButton').addEventListener('click', () => {
        if (document.querySelector('#add-todo-input').value.length === 0) {
            return
        }
        addTodo();
        updateTodoList();
    });

    function updateTodoList() {
        renderTodoList();
        getProgressPercentage();
    }

}

    // todoObserver();
eventListener();