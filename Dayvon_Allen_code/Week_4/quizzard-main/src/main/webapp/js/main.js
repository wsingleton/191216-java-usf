window.onload = () => {
console.log("loaded");
    loadLogin();
    document.getElementById('logout').addEventListener('click', logout);
}
function loadLogin() {
    console.log('in loadLogin()');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
            document.getElementById("login").addEventListener('click', login);
        }
    }
}

function login(){
let username = document.getElementById('username').value;
let password = document.getElementById('password').value;

let creds = {
    username: username,
    password: password
};

let credJson = JSON.stringify(creds);
 let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJson);
     xhr.onreadystatechange = () => {
            if(xhr.readyState === 4 ) {
                if(xhr.status === 200) {

                let user = JSON.parse(xhr.responseText);
                console.log(user);
                loadDashboard();
                }
                if(xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Login Failed!';
                }
            }


    }
}

function logout(){
let xhr = new XMLHttpRequest();
xhr.open('GET', 'auth', true);
xhr.send()
  xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            console.log('logout successful')
            loadLogin();
        }
    }

}

function loadDashboard() {

 let xhr = new XMLHttpRequest();
                    xhr.open('GET', 'dashboard.view', true);
                    xhr.send();
                    xhr.onreadystatechange = () => {
                        if(xhr.readyState === 4 && xhr.status === 200) {
                            document.getElementById("root").innerHTML = xhr.responseText;
                        }
                    }
}