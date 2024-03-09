function removeTodoList () {
    localStorage.removeItem('local-todoList');
    renderTodoList();
}