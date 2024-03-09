function removeTodoItem (id) {
    console.log(id);
    let todoList = getTodoList();

    let updatedTodoList = todoList.filter(item => item.id !== id);
    localStorage.setItem('local-todoList', JSON.stringify(updatedTodoList));
}