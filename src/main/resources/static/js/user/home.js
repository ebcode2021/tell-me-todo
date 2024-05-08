/**
 * Fetch Function
 */
const clearTodoList = async() => {
    const todoItems = document.querySelectorAll(".home-todo-item");
    if (todoItems.length === 0)
        return;

    const date = new Date().toISOString().split('T')[0];
    await deleteTodoListForDate(date);

    todoItems.forEach(item => {
        item.remove();
    })
    setZeroProgress();
}

const clickCheckbox = async(id) => {
    await updateTodoCompleted(id);
    getProgressPercentage();
}

const toggleFavorite = async(id) => {
    await updateTodoFavorite(id);

    const image = document.querySelector(`#favorite_${id}`);

    if (image.src.endsWith('star-fill.svg')) {
        image.src = '/images/svg/star.svg';
    } else {
        image.src = '/images/svg/star-fill.svg';
    }
}

const clearTodo = async(id) => {
    await deleteTodo(id);

    const item = document.getElementById(`home-item-${id}`);
    if (item) {
        item.remove();
    }
    getProgressPercentage();
}

/**
 * Validate Function
 */
const checkContentLength = () => {
    const content = document.querySelector("#add-todo-input").value;

    return content.trim().length !== 0;
}

/**
 * Event Function
 */



/**
 * Event Detect Function
 */
const eventListener = () => {
    // document.getElementById("delete-item-button").addEventListener("click", clearTodoList);
}

eventListener()