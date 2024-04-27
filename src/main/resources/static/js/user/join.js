const checkUsernameDuplicate = async () => {
    await existUsername(document.getElementById("username").value);
}