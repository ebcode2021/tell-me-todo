function addTodoItem() {
    let inputText = document.querySelector('#add-todo-input').value;

    if (inputText.trim() === "") {
        return ;
    }

    let currentDate = new Date().toLocaleDateString();
    let todoList = getTodoList();

    let newItem = {
        id : todoList.length > 0 ? todoList[todoList.length - 1].id + 1: 0,
        content : inputText,
        completed : false,
        created_at : currentDate,
        updated_at : currentDate,
        favorite : false,
    }


    todoList.push(newItem);

    localStorage.setItem('local-todoList', JSON.stringify(todoList));
    
    document.querySelector('#add-todo-input').value="";
    renderTodoList();
}