const existUsername = async (username) => {
    try {
        await sendApiRequest(
            'GET',
            "/users/exists/" + username,
        )
    } catch(e) {
        console.log('existUsername api error');
    }
}