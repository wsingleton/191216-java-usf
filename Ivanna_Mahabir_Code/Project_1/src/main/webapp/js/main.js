window.onload = () => {
    loadLogin();

}
let user = [];

function loadLogin() {
    let xhr = new XMLHttpRequest();
       xhr.open('GET', "login.view", true);
       xhr.send();
       xhr.onreadystatechange = () => {
           if(xhr.readyState === 4 && xhr.status === 200) {
               document.getElementById("root").innerHTML = xhr.responseText;
               document.getElementById("login").addEventListener("click", login);
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
        xhr.open('POST', "auth", true);
        xhr.send(credJSON);
        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4){
                if(xhr.status === 200){
                user = JSON.parse(xhr.responseText);
                dashboard(user);
                console.log(user);


                }
                if (xhr.status === 401) {
                    document.getElementById('login-message').innerText = 'Login failed!';
                }
            }
        }
    }


    function register(){
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let first = document.getElementById('first').value;
    let last = document.getElementById('last').value;
    let email = document.getElementById('email').value;
    let role = document.getElementById('role').value;

    let user = {
    username: username,
    password: password,
    first: first,
    last: last,
    email: email,
    role: role
    };

     let userJSON = JSON.stringify(user);
        let xhr = new XMLHttpRequest();
            xhr.open('POST', "users", true);
            xhr.send(userJSON);
            xhr.onreadystatechange = () => {
                if(xhr.readyState === 4){
                    if(xhr.status === 200){
                    let user = JSON.parse(xhr.responseText);
                    console.log(user);
                    loadLogin();

                    }
                    if (xhr.status === 401) {
                        document.getElementById('register-message').innerText = 'Registration failed!';
                    }
                }
            }

    //use callable stat to check if user is registered

    }

function dashboard(){


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