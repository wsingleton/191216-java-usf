window.onload = () => {
    loadLogin();
}

function loadLogin() {

    console.log('in loadLogin');

    let xhr = new XMLHttpRequest();
    xhr.open('Get', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
        }
    }

function login() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let creds = {
        username: username,
        password: password
    };
    let credJSON = JSON.stringify(creds);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let user = JSON.parse(xhr.responseText);
                console.log(user);
                // loadDashboard();
            }
            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Login failed!';
            }
        }
    }
}
}