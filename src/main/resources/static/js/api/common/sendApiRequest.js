// @Deprecated function

const sendApiRequest = async (method, url, headers, body) => {
    try {
        const response = await fetch(url, {
            method,
            headers,
            body: body ? JSON.stringify(body) : null,
        });

        if (response.ok) {
            const data = await response.text();
            try {
                return data ? JSON.parse(data) : {};
            } catch(e) {
                return data;
            }
        }
    } catch (error) {
        console.log('Fetch Error::', error);
    }
}

