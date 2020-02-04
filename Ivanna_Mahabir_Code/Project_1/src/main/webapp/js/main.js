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

    function loadDashboard() {
        let xhr = new XMLHttpRequest();
           xhr.open('GET', "dashboard.view", true);
           xhr.send();
           xhr.onreadystatechange = () => {
               if(xhr.readyState === 4 && xhr.status === 200) {
                   document.getElementById("root").innerHTML = xhr.responseText;
                    dashboard(user);
               }
           }
        }

    function loadRegister() {
        let xhr = new XMLHttpRequest();
           xhr.open('GET', "register.view", true);
           xhr.send();
           xhr.onreadystatechange = () => {
               if(xhr.readyState === 4 && xhr.status === 200) {
                   document.getElementById("root").innerHTML = xhr.responseText;
                   document.getElementById("register").addEventListener("click", register);
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
                loadDashboard(user);
                console.log(user);

                }
                if (xhr.status === 401) {
                    document.getElementById('login-message').innerText = 'Invalid Input: Login failed!';
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
                    dashboard(user);
                    console.log(user);
                    loginLogin();

                    }
                    if (xhr.status === 401) {
                        document.getElementById('register-message').innerText = 'Registration failed!';
                    }
                }
            }

    //use callable stat to check if user is registered

    }

//employee dashboard
function dashboard(user){
let dashboard = document.getElementById('dashboard-component"');
document.getElementById("first").innerText = user.first_name;
document.getElementById("last").innerText = user.last_name;
let user_id = document.getElementById("author").innerText - user.user_id;



document.getElementById("reimb").addEventListener("click", reimb);
document.getElementById("logout").addEventListener("click", logout);
}

function reimb() {
//reimb form
let amount = document.getElementById("amount").value;
let submitted = new Date();
let description = document.getElementById("description").value;
let author = user.user_id;
//let type = document.getElementById("type").value;
let type = document.querySelector('input[name="type"]:checked').value;
let status = 3;

let reimb = {
    amount: amount,
    submitted: submitted,
    description: description,
    author: author,
    type: type,
    status: 3
};

console.log(reimb);

    let reimbJSON = JSON.stringify(reimb);

    let xhr = new XMLHttpRequest();
        xhr.open('POST', "dashboard", true);
        xhr.send(reimbJSON);
        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4){
                if(xhr.status === 200){
                reim = JSON.parse(xhr.responseText);
                loadDashboard(reim);
                console.log(reim);

                }
                if (xhr.status === 401) {
                    document.getElementById('reimb-message').innerText = 'Submission failed!';
                }
            }
        }
}


function displayReimb(){
let xhr = new XMLHttpRequest();
xhr.open('GET', "dashboard", true);
xhr.send();
xhr.onreadystatechange = () =>{
if(xhr.readyState === 4){
    if(xhr.status === 200)
            reim = JSON.parse(xhr.responseText);
            loadDashboard(reim);
            console.log(reim);

            }
            if (xhr.status === 401) {
               document.getElementById('reimb-message').innerText = 'Submission failed!';
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
                loadLogin();
            }
        }
    }