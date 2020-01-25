window.onload = () => {
loadHome()
}
function loadLogin() {
    console.log('in loadLogin()');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
            let username = document.querySelectorAll(".txtb input")[0];
            let password = document.querySelectorAll(".txtb input")[1];

            username.addEventListener('focus', () => {
                username.classList.add('focus');
            });

            username.addEventListener('blur', () => {
                if(username.value < 1){
                username.classList.remove('focus');
                }
            });

            password.addEventListener('blur', () => {
                if(password.value < 1){
                password.classList.remove('focus');
                }
            });

            password.addEventListener('focus', () => {
                password.classList.add('focus');
            })

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

function loadHome() {

 let xhr = new XMLHttpRequest();
                    xhr.open('GET', 'home.view', true);
                    xhr.send();
                    xhr.onreadystatechange = () => {
                        if(xhr.readyState === 4 && xhr.status === 200) {
                            document.getElementById("root").innerHTML = xhr.responseText;
                            document.getElementById("loginBut").addEventListener("click", loadLogin);
                        }
                    }
}