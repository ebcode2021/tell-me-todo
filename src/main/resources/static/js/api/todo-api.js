const deleteTodoListForDate = async(date) => {
    try {
        await sendApiRequest(
            'DELETE',
            "/todos/date/" + date,
        )
    } catch(e) {
        console.error(e);
    }
}

const updateTodoCompleted = async(id) => {
    try {
        await sendApiRequest(
            'PATCH',
            "/todos/" + id + "/completed"
        )
    } catch (e) {
        console.error(e);
    }
}

const updateTodoFavorite = async(id) => {
    try {
        await sendApiRequest(
            'PATCH',
            "/todos/" + id + "/favorite",
        )
    } catch (e) {
        console.error(e);
    }
}

const deleteTodo = async(id) => {
    try {
        await sendApiRequest(
            'DELETE',
            "/todos/" + id,
        )
    } catch(e) {
        console.error(e);
    }
}
