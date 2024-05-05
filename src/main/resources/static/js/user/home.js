/**
 * Fetch Function
 */
const clearTodoList = async() => {
    const date = new Date().toISOString().split('T')[0];
    await deleteTodoListForDate(date);
    window.location.reload();
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