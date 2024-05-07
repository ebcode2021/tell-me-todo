/**
 * Fetch Function
 */
const clearTodoList = async() => {
    if (document.querySelector(".home-todo-item").length === 0)
        return;

    const date = new Date().toISOString().split('T')[0];
    await deleteTodoListForDate(date);
    window.location.reload();
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