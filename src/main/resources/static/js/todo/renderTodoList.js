function renderTodoList() {
    let todoList = getTodoList();
    let todoListContainer = document.querySelector(".home-todo-list-container");

    // 기존에 표시된 todoList 삭제
    todoListContainer.innerHTML = '';

    todoList.forEach(function(item) {
        let todoItemDiv = document.createElement('div');
        todoItemDiv.classList.add('home-todo-item');


        let checkboxDiv = document.createElement('div');
        checkboxDiv.classList.add('home-checkbox', 'form-check');

        let checkboxInput = document.createElement('input');
        checkboxInput.classList.add('form-check-input', 'home-checkbox', 'checkbox-icon');
        checkboxInput.type = 'checkbox';
        checkboxInput.id = "input_" + item.id;
        checkboxInput.checked = item.completed;

        let textInput = document.createElement('input');
        textInput.classList.add('form-control', 'home-todo-item-title');
        textInput.type = 'text';
        textInput.id = "text_" + item.id;
        textInput.value = item.content;

        checkboxDiv.appendChild(checkboxInput);
        checkboxDiv.appendChild(textInput);

        let iconContainerDiv = document.createElement('div');
        iconContainerDiv.classList.add('home-icon-container');

        let favoriteButton = document.createElement('button');
        favoriteButton.type = 'button';
        favoriteButton.classList.add('home-icon');
        favoriteButton.id = 'favorite-icon_' + item.id;

        let favoriteImage = document.createElement('img');
        if (item.favorite === true) {
            favoriteImage.src = '/svg/star-fill.svg';
        } else {
            favoriteImage.src = '/svg/star.svg';
        }
        favoriteButton.appendChild(favoriteImage);
        iconContainerDiv.appendChild(favoriteButton);

        let deleteButton = document.createElement('button');
        deleteButton.type = 'button';
        deleteButton.classList.add('home-icon');
        deleteButton.id = 'delete-icon_' + item.id;

        let deleteImg = document.createElement('img');
        deleteImg.src = '/svg/trash3.svg';

        deleteButton.appendChild(deleteImg);
        iconContainerDiv.appendChild(deleteButton);

        todoItemDiv.appendChild(checkboxDiv);
        todoItemDiv.appendChild(iconContainerDiv);

        todoListContainer.appendChild(todoItemDiv);


        /**
         * 이벤트 등록
         */

        deleteButton.addEventListener('click', function() {
            this.closest('.home-todo-item').remove();
            removeTodoItem(item.id);
            getProgressPercentage();
        });


        favoriteButton.addEventListener('click', function() {
            let todoList = getTodoList();
            let updatedTodoList = todoList.map(function(todo) {
                if (todo.id === item.id) {
                    todo.favorite = !todo.favorite;
                }
                return todo;
            });

            localStorage.setItem('local-todoList', JSON.stringify(updatedTodoList));
            renderTodoList();
        });


        checkboxInput.addEventListener('click', function() {
            let todoList = getTodoList();

            let updatedTodoList = todoList.map(function(todo) {
                if (todo.id === item.id) {
                    todo.completed = !todo.completed;
                }
                return todo;
            });
            localStorage.setItem('local-todoList', JSON.stringify(updatedTodoList));
            getProgressPercentage();
        })

        textInput.addEventListener('input', function() {
            let todoList = getTodoList();
            let updatedTodoList = todoList.map(function(todo) {
                if (todo.id === item.id) {
                    todo.content = textInput.value; // content 값을 변경
                }
                return todo;
            });
            localStorage.setItem('local-todoList', JSON.stringify(updatedTodoList));
            getProgressPercentage();
        });

        todoItemDiv.addEventListener('change', function() {
            getProgressPercentage();
        })

    });
}