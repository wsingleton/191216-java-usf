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
    
}

function login(){    
    let uname = document.getElementById('un').value;
    let passw = document.getElementById('passw').value;
    if(uname && passw){
        let divContainer = document.getElementById('container');        
        let formDiv = document.getElementById('loginForm');;
        divContainer.removeChild(formDiv);
    }
}
   