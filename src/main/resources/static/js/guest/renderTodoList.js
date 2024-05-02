const renderTodoList = () => {
    let todoListContainer = document.querySelector(".home-todo-list-container");
    deletePreviousTodoList();

    let todoList = getTodoList();
    todoList.forEach((item) => {
        let todoDiv = createDiv();
        todoDiv.classList.add('home-todo-item');

        let checkboxDiv = createDiv();
        checkboxDiv.classList.add('home-checkbox', 'form-check');

        let checkboxInput = createInput();
        initCheckboxInput();

        let textInput = createInput();
        initTextInput();

        checkboxDiv.appendChild(checkboxInput);
        checkboxDiv.appendChild(textInput);

        let iconContainerDiv = createDiv();
        iconContainerDiv.classList.add('home-icon-container');

        let favoriteButton = createButton();
        initFavoriteButton();

        let favoriteImage = createImg();
        initFavoriteImage();

        favoriteButton.appendChild(favoriteImage);
        iconContainerDiv.appendChild(favoriteButton);

        let deleteButton = createButton();
        initDeleteButton();

        let deleteImg = createImg();
        initDeleteImg();

        deleteButton.appendChild(deleteImg);
        iconContainerDiv.appendChild(deleteButton);

        todoDiv.appendChild(checkboxDiv);
        todoDiv.appendChild(iconContainerDiv);

        todoListContainer.appendChild(todoDiv);

        /**
         * 각 이벤트 등록
         */

        deleteButton.addEventListener('click', function() {
            this.closest('.home-todo-item').remove();
            removeTodo(item.id);
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

        todoDiv.addEventListener('change', function() {
            getProgressPercentage();
        })

        /* initialize */
        function  initCheckboxInput() {
            checkboxInput.classList.add('form-check-input', 'home-checkbox', 'checkbox-icon');
            checkboxInput.type = 'checkbox';
            checkboxInput.id = "input_" + item.id;
            checkboxInput.checked = item.completed;
        }

        function initTextInput() {
            textInput.classList.add('form-control', 'home-todo-item-title');
            textInput.type = 'text';
            textInput.id = "text_" + item.id;
            textInput.value = item.content;
        }

        function initFavoriteButton() {
            favoriteButton.type = 'button';
            favoriteButton.classList.add('home-icon');
            favoriteButton.id = 'favorite-icon_' + item.id;
        }

        function initFavoriteImage() {
            if (item.favorite === true) {
                favoriteImage.src = '/images/svg/star-fill.svg';
            } else {
                favoriteImage.src = '/images/svg/star.svg';
            }
        }

        function initDeleteButton() {
            deleteButton.type = 'button';
            deleteButton.classList.add('home-icon');
            deleteButton.id = 'delete-icon_' + item.id;
        }

        function initDeleteImg() {
            deleteImg.src = '/images/svg/trash3.svg';
        }
    })

    function deletePreviousTodoList() {
        document.querySelector(".home-todo-list-container").innerHTML = '';
    }

    /* create */
    function createDiv()  {
        return document.createElement('div');
    }

    function createImg() {
        return document.createElement('img');
    }

    function createButton() {
        return document.createElement('button');
    }

    function createInput() {
        return document.createElement('input');
    }
}