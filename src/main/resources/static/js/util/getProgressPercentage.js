function getProgressPercentage() {
    let checkedCount = 0;

    document.querySelectorAll('.home-checkbox .checkbox-icon').forEach(function (checkBox) {
        if (checkBox.checked) {
            checkedCount++;
        }
    });

    // 전체 항목 개수
    let totalItemsCount = document.querySelectorAll('.home-todo-item').length;
    let progressPercentage = (checkedCount / totalItemsCount) * 100;

    if (totalItemsCount === 0) {
        progressPercentage = 0;
    }

    // 달성률 업데이트
    document.querySelector('.home-progress-bar-detail').innerText = progressPercentage.toFixed(0) + '%';
    document.querySelector('.home-progress-bar-detail').setAttribute('aria-valuenow', progressPercentage);
    document.querySelector('.home-progress-bar-detail').style.width = progressPercentage + '%';
}

const setZeroProgress = () => {
    const progressPercentage = 0;

    // document.querySelector('.home-progress-bar-detail').innerText = progressPercentage.toFixed(0) + '%';
    document.querySelector('.home-progress-bar-detail').setAttribute('aria-valuenow', 0);
    document.querySelector('.home-progress-bar-detail').style.width = 0 + '%';
}