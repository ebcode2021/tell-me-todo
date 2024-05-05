const deleteTodoListForDate = async(date) => {
    try {
        await sendApiRequest(
            'DELETE',
            "/todos/" + date,
        )
    } catch(e) {
        console.error(e);
    }
}