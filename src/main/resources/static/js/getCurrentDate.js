function getCurrentDate() {
    let currentDate = new Date();

    document.getElementById('current-date').innerText =
        `${currentDate.getFullYear()}년 ${currentDate.getMonth() + 1}월 ${currentDate.getDate()}일`;
}
