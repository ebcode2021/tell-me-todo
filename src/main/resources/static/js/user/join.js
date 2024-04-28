/**
 * Validate Function
 */
const validateUsername = () => {
    clearUsernameMessage();

    const button = document.getElementById('username-button');
    button.disabled = true;

    const username = document.getElementById("username").value;

    if (username.includes(' ')) {
        document.getElementById('usernameCheckFail').innerText = '아이디에는 공백이 들어갈 수 없습니다.';
    } else if (username.length > 20) {
        document.getElementById('usernameCheckFail').innerText = '아이디는 최대 20자까지 가능합니다.';
    } else if (!/^[a-zA-Z0-9_]*$/.test(username)) {
        document.getElementById('usernameCheckFail').innerText = '허용되지 않는 문자가 포함되어 있습니다.';
    } else

    if (username.length>= 6 && username.length <= 20) {
        button.disabled = false;
    }
}

const validatePassword = () => {
    clearPasswordMessage();

    const password = document.getElementById('password').value;

    if (password.length === 0) {
        return;
    }
    if (password.includes(' ')) {
        document.getElementById('passwordLengthFail').innerText = '비밀번호에는 공백이 들어갈 수 없습니다.';
    } else if (password.length < 8 || password.length > 20) {
        document.getElementById('passwordLengthFail').innerText = '비밀번호는 최소 8자, 최대 20자까지 가능합니다.';
    } else if (!/^[a-zA-Z0-9!@#$%^&*]*$/.test(password)) {
        document.getElementById('passwordLengthFail').innerText = '허용되지 않는 문자가 포함되어 있습니다.';
    }
}

const validateNickname = () => {
    clearNicknameMessage();

    const nickname = document.getElementById('nickname').value;

    if (nickname.length === 0) {
        document.getElementById('nickname').setAttribute("data-valid", "false");
    } else if (nickname.includes(' ')) {
        document.getElementById('nicknameCheckFail').innerText = '닉네임에는 공백이 들어갈 수 없습니다.';
        document.getElementById('nickname').setAttribute("data-valid", "false");
    } else if (nickname.length > 20) {
        document.getElementById('nicknameCheckFail').innerText = '닉네임은 최대 20자까지 가능합니다.';
        document.getElementById('nickname').setAttribute("data-valid", "false");
    } else {
        document.getElementById('nickname').setAttribute("data-valid", "true");
    }
}

const validateEmail = () => {
    clearEmailMessage();

    const email = document.getElementById('email').value;

    if (email.length === 0) {
        document.getElementById('email').setAttribute("data-valid", "true");
    } else if (email.includes(' ')) {
        document.getElementById('emailCheckFail').innerText = '이메일에는 공백이 들어갈 수 없습니다.';
        document.getElementById('email').setAttribute("data-valid", "false");
    } else if (!email.includes('@')) {
        document.getElementById('emailCheckFail').innerText = '이메일 양식이 맞지 않습니다.';
        document.getElementById('email').setAttribute("data-valid", "false");
    } else {
        document.getElementById('email').setAttribute("data-valid", "true");
    }
}

const checkPasswordMatch = () => {
    clearPasswordCheckMessage();

    const password = document.getElementById('password').value;
    const checkPassword = document.getElementById('checkPassword').value;

    if (checkPassword.trim().length === 0 || document.getElementById('passwordLengthFail').innerText.length) {
        document.getElementById('password').setAttribute("data-valid", "false");
        document.getElementById('checkPassword').setAttribute("data-valid", "false");
    } else if (password === checkPassword) {
        document.getElementById('passwordCheckSuccess').innerText = '비밀번호가 일치합니다.';
        document.getElementById('password').setAttribute("data-valid", "true");
        document.getElementById('checkPassword').setAttribute("data-valid", "true");
    } else {
        document.getElementById('passwordCheckFail').innerText = '비밀번호가 일치하지 않습니다.';
        document.getElementById('password').setAttribute("data-valid", "false");
        document.getElementById('checkPassword').setAttribute("data-valid", "false");
    }
}

/**
 * Fetch Function
 */

const checkUsernameDuplicate = async () => {
    clearUsernameMessage();

    const username = document.getElementById("username").value;
    const result = await existUsername(username);

    // if (result === true) {
    //     document.getElementById('usernameCheckFail').innerText = '이미 사용 중인 아이디입니다.';
    // } else {
        document.getElementById('usernameCheckSuccess').innerText = '사용 가능한 아이디입니다.';
    document.getElementById('username').setAttribute("data-valid", "true");
    // }
}

/**
 * Clear Message Function
 */
const clearUsernameMessage = () => {
    document.getElementById('usernameCheckSuccess').innerText = '';
    document.getElementById('usernameCheckFail').innerText = '';
}

const clearPasswordMessage = () => {
    document.getElementById('passwordLengthFail').innerText = '';
}

const clearPasswordCheckMessage = () => {
    document.getElementById('passwordCheckSuccess').innerText = '';
    document.getElementById('passwordCheckFail').innerText = '';
}

const clearNicknameMessage = () => {
    document.getElementById('nicknameCheckFail').innerText = '';
}

const clearEmailMessage = () => {
    document.getElementById('emailCheckFail').innerText = '';
}

/**
 * Event Detect Function
 */

const allInputValidObserver = () => {

    // Join Button Active event
    const button = document.getElementById('join-button');

    const target = document.querySelectorAll(".input-custom");
    const config = { attributes: true, attributeOldValue: true  }

    let validCnt = 1;

    for (let i = 0; i < target.length; i++) {
        // create an observer instance
        let observer = new MutationObserver( (list, observer) => {
            list.forEach( mutation => {
                if (mutation.type === 'attributes' && mutation.attributeName === 'data-valid') {
                    let valid = mutation.target.getAttribute("data-valid");
                    if (valid === 'false' && valid !== mutation.oldValue) {
                        validCnt--;
                    } else if (valid === 'true' && valid !== mutation.oldValue) {
                        validCnt++;
                    }
                }
            })
            console.log('validCnt : ' + validCnt);
            console.log('target.length : ' + target.length);
            console.log('----------------------')
            button.disabled = (validCnt !== target.length);
        })
        observer.observe(target[i], config);
    }
}

const eventListener = () => {

    // Check username input
    document.getElementById("username").addEventListener("input", validateUsername);

    // Check password input
    document.getElementById("password").addEventListener("input", validatePassword);

    // Check nickname input
    document.getElementById("nickname").addEventListener("input", validateNickname);

    // Check email input
    document.getElementById("email").addEventListener("input", validateEmail);

    // password, checkPassword match check
    document.querySelector(".join-form-wrapper").addEventListener("input", (e) =>  {
        if (e.target.matches("#password") || e.target.matches("#checkPassword")) {
            checkPasswordMatch();
        }
    });

    allInputValidObserver();

}

eventListener()

