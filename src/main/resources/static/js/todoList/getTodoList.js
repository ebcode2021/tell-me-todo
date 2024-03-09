function getTodoList() {
    if (localStorage.getItem('local-todoList')) {
        return JSON.parse(localStorage.getItem('local-todoList'));
    } else {
        localStorage.setItem('local-todoList', JSON.stringify([]));
        return [];
    }
}