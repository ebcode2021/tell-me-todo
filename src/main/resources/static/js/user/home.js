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

const clearTodo = async(id) => {
    await deleteTodo(id);

    const item = document.getElementById(`home-item-${id}`);
    if (item) {
        item.remove();
    }
    getProgressPercentage();
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
const handleInputContent = async(id, content) => {
    const inputValue = document.querySelector(`[data-item-id="${id}"]`).value.trimEnd();

    if (inputValue !== content) {
        await updateTodoContent(id, inputValue);
    }
}


/**
 * Event Detect Function
 */
const inputContentChangeEvent = () => {
    document.querySelectorAll('.home-todo-item-title').forEach(item => {
        const id = item.getAttribute("data-item-id");
        const content = item.value;
        let timeoutId = null;

        item.addEventListener("input", inputTimer);

        function inputTimer() {
            if (timeoutId) {
                clearTimeout(timeoutId);
            }

            timeoutId = setTimeout(() => {
                handleInputContent(id, content);
            }, 2000);
        }
    })
}

inputContentChangeEvent()