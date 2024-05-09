const existUsername = async (username) => {
    try {
        const response = await fetch("/users/exists/" + username, {
            method: "GET",
        })
        if (response.ok) {
            return await response.text();
        }
    } catch(e) {
        console.log('existUsername api error');
    }
}