window.onload = () => {
loadHome()
}
function loadLogin() {
    console.log('in loadLogin()');
    if(document.querySelectorAll("head")[0].children.length === 7){
        document.querySelectorAll("head")[0].children[6].remove();
    }
     let css = document.createElement('link');
     css.setAttribute('rel', 'stylesheet');
     css.setAttribute('href', 'css/login.css');
     document.getElementsByTagName("head")[0].appendChild(css);
     console.log(document.querySelectorAll("head")[0].children);
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
            document.getElementById('sign-up').addEventListener('click', loadRegister);
            document.getElementById('login').addEventListener('click', login);

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

function loadRegister() {
 if(document.querySelectorAll("head")[0].children.length === 7){
        document.querySelectorAll("head")[0].children[6].remove();
    }
let css = document.createElement('link');
     css.setAttribute('rel', 'stylesheet');
     css.setAttribute('href', 'css/register.css');
     document.getElementsByTagName("head")[0].appendChild(css);
 let xhr = new XMLHttpRequest();

                    xhr.open('GET', 'register.view', true);
                    xhr.send();
                    xhr.onreadystatechange = () => {
                        if(xhr.readyState === 4 && xhr.status === 200) {
                            document.getElementById("root").innerHTML = xhr.responseText;

                            let firstname = document.querySelectorAll(".txtb input")[0];
                            let lastname = document.querySelectorAll(".txtb input")[1];
                            let username = document.querySelectorAll(".txtb input")[2];
                            let email = document.querySelectorAll(".txtb input")[3];
                            let password = document.querySelectorAll(".txtb input")[4];
                            window.onload = () => {
                                console.log(window.innerHeight);
                                console.log(window.innerWidth);
                            }
                            firstname.addEventListener('focus', () => {
                                let css = document.createElement('link');
                                css.setAttribute('rel', 'stylesheet');
                                css.setAttribute('href', 'login.css');
                                document.getElementsByTagName("head")[0].appendChild(css)
                                console.log(document.querySelectorAll("head")[0].children[5]);
                                firstname.classList.add('focus');
                            });

                            firstname.addEventListener('blur', () => {
                                if (firstname.value.length < 1) {

                                    firstname.classList.remove('focus');
                                }
                            });

                            lastname.addEventListener('blur', () => {
                                if (lastname.value.length < 1) {
                                    lastname.classList.remove('focus');
                                }
                            });

                            lastname.addEventListener('focus', () => {
                                lastname.classList.add('focus');
                            });

                            username.addEventListener('blur', () => {
                                if (username.value.length < 1) {
                                    username.classList.remove('focus');
                                }
                            });

                            username.addEventListener('focus', () => {
                                username.classList.add('focus');
                            });

                            email.addEventListener('blur', () => {
                                if (email.value.length < 1) {
                                    email.classList.remove('focus');
                                }
                            });

                            email.addEventListener('focus', () => {
                                email.classList.add('focus');
                            });
                            password.addEventListener('blur', () => {
                                if (password.value.length < 1) {
                                    password.classList.remove('focus');
                                }
                            });

                            password.addEventListener('focus', () => {
                                password.classList.add('focus');
                            });

                            document.getElementById("signIn").addEventListener("click", loadLogin);
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
                            document.getElementById("registerBut").addEventListener("click", loadRegister)
                        }
                    }
}