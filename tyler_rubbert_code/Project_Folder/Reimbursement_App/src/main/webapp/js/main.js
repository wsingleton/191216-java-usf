window.onload = () => {
    console.log('did the js load?');
    loadHome();
}

function loadHome() {
    console.log('in loadHome()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'home.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('toLogin').addEventListener('click', loadLogin);
            document.getElementById('toRegister').addEventListener('click', loadRegister);
        }
    }
}

function loadLogin() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener('click', login);
        }
    }

}

function loadRegister() {

    console.log('in loadRegister()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'register.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('register').addEventListener('click', register);
        }
    }


}



function login() {

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    
    let creds = {
        username: username,
        password: password
    }

    let credJSON = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let user = JSON.parse(xhr.responseText);
                console.log(user);
            }

            if (xhr.status === 400) {
                document.getElementById('login-message').innerText = 'Login failed!';
            }

        }
    }

}

function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'auth', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('logout successful!')
        }
    }
}

function register() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let email = document.getElementById('email').value;

    let newUser = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email
    }

    let newUserJSON = JSON.stringify(newUser);

    let xhr = new XMLHttpRequest();
    xhr.open('POST','users', true );
    xhr.send(newUserJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let user = JSON.parse(xhr.responseText);
                console.log(user);
            }

            if (xhr.status === 400) {
                document.getElementById('register-message').innerText = 'Register failed!';
            }

        }
    }

}

function navigate(string) {
    location.href = "reimbursement/"+ partial
}

