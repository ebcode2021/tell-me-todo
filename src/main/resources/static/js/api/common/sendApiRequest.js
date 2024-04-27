const sendApiRequest = async (method, url, headers, body) => {
    try {
        console.log("method : " + method + ", url : " + url);
        const response = await fetch(url, {
            method,
            headers,
            body: body ? JSON.stringify(body) : null,
        });
        console.log('response : ' + response.status);

        if (response.ok) {
            const data = await response.text();
            console.log('데이터 : ' + data);
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

