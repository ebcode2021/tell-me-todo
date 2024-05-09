/**
 * @DELETE method
 */
const deleteTodoListForDate = async(date) => {
    try {
        await fetch("/todos/date/" + date, {
            method: "DELETE",
        })
    } catch(e) {
        console.error(e);
    }
}

const deleteTodo = async(id) => {
    try {
        await fetch("/todos/" + id, {
            method: "DELETE",
        })
    } catch(e) {
        console.error(e);
    }
}

/**
 * @PATCH method
 */
const updateTodoCompleted = async(id) => {
    try {
        await fetch('/todos/' + id + "/completed", {
            method: "PATCH",
        })
    } catch (e) {
        console.error(e);
    }
}

const updateTodoFavorite = async(id) => {
    try {
        await fetch('/todos/' + id + "/favorite", {
            method: "PATCH",
        })
    } catch (e) {
        console.error(e);
    }
}

const updateTodoContent = async(id, content) => {
    try {
        await fetch('/todos/' + id + "/content", {
            method: "PATCH",
            body: content,
        })
    } catch(e) {
        console.error(e);
    }
}