window.onload = () => {
loadHome();

}

function loadHome() {

    console.log('in loadHome');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'home.view', true);
    xhr.send();
    xhr.onreadystatechange =() => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
            document.getElementById('home-login').addEventListener('click', loadLogin);
        }
    }
}

function loadDashboard() {

    console.log('in dashboard');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashboard.view', true);
    xhr.send();
    xhr.onreadystatechange =() => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;

        }
    }
}

//function loadNav(){
//
//let xhr = new XMLHttpRequest();
//    xhr.open('GET', 'nav.view', true);
//    xhr.send();
//    xhr.onreadystatechange =() => {
//        if (xhr.readyState === 4 && xhr.status === 200) {
//            document.getElementById("nav").innerHTML = xhr.responseText;
//
//        }
//    }
//}



function loadLogin() {
    console.log('in loadLogin()');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener('click', login);
        }
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