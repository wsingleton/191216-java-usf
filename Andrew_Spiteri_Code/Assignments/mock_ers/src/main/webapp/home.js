window.onload = () => {
    home();

    this.document.getElementById('login').addEventListener('click', login);
    this.document.getElementById('register').addEventListener('click', register);
}

function home(){
    let header1 = document.createElement('i');
    header1.setAttribute('class', 'fa fa-angle-right');
    header1.setAttribute('aria-hidden', 'true');
    header1.innerText = "Welcome to the Mock Employee Reimbursement System";
    
    let formDiv = document.createElement('div');
    formDiv.setAttribute('class', 'form-group');
    formDiv.setAttribute('id', 'loginForm');

    let unLabel = document.createElement('label');
    unLabel.setAttribute('for', 'un');
    unLabel.setAttribute('class', 'form-label');
    unLabel.innerText = "Username";

    let unInput = document.createElement('input');
    unInput.setAttribute('type', 'text');
    unInput.setAttribute('class', 'form-control');
    unInput.setAttribute('name', 'un-input');
    unInput.setAttribute('id', 'un');
    unInput.setAttribute('placeholder', 'Username');
    unInput.setAttribute('width', '50px');

    let pwLabel = document.createElement('label');
    pwLabel.setAttribute('for', 'passw');
    pwLabel.setAttribute('class', 'form-label');
    pwLabel.innerText = "Password";

    let pwInput = document.createElement('input');
    pwInput.setAttribute('type', 'password');
    pwInput.setAttribute('class', 'form-control');
    pwInput.setAttribute('name', 'passw-input');
    pwInput.setAttribute('id', 'passw');
    pwInput.setAttribute('placeholder', 'Password');
    pwInput.setAttribute('width', '50px');

    let loginBtn = document.createElement('button');
    loginBtn.setAttribute('id', 'login');
    loginBtn.innerText = 'Login';

    let regA = document.createElement('a');
    regA.setAttribute('id', 'register');
    regA.setAttribute('href', 'http://localhost:8080/ers-app/');
    regA.innerText = "Register";

    let divContainer = document.getElementById('container');

    divContainer.appendChild(header1);
    divContainer.appendChild(formDiv);

    formDiv.appendChild(unLabel);
    formDiv.appendChild(unInput);
    formDiv.appendChild(pwLabel);
    formDiv.appendChild(pwInput);
    formDiv.appendChild(loginBtn);
    formDiv.appendChild(regA);
    
}

function register(){
    let divContainer = document.getElementById('container');        
    let formHome = document.getElementById('loginForm')
    divContainer.removeChild(formHome);

    let formRegister = document.createElement('div');
    formRegister.setAttribute('class', 'form-group');
    formRegister.setAttribute('id', 'registerForm');

    let unLabel = document.createElement('label');
    unLabel.setAttribute('for', 'regUnInput');
    unLabel.setAttribute('class', 'form-label');
    unLabel.setAttribute('id', 'regUnLabel');
    unLabel.innerText = "Username:";

    let unInput = document.createElement('input');
    unInput.setAttribute('type', 'text');
    unInput.setAttribute('class', 'form-control');
    unInput.setAttribute('name', 'un-input');
    unInput.setAttribute('id', 'un-reg');
    unInput.setAttribute('placeholder', 'Username');
    unInput.setAttribute('width', '30px');

    divContainer.appendChild(formRegister);
    formRegister.appendChild(unLabel);
    formRegister.appendChild(unInput);
}

function login(){    
    let uname = document.getElementById('un').value;
    let passw = document.getElementById('passw').value;
    if(uname && passw){
        let divContainer = document.getElementById('container');        
        let formHome = document.getElementById('loginForm')
        divContainer.removeChild(formHome);

        let xhttp = new XMLHttpRequest();

        xhttp.open("GET", 'http://localhost:8080/ers-app/', true);
        let data = JSON.stringify({'username': uname, 'password': passw})
        xhttp.send(data);
        xhttp.onreadystatechange = function(){
            if(xhttp.readyState === 4 && xhttp.status === 200){

            }
        }
    }
}
   