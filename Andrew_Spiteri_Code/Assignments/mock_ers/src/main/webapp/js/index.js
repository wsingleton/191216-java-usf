window.onload = () => {
    homePage();

    this.document.getElementById('login').addEventListener('click', login);
    this.document.getElementById('register').addEventListener('click', registerPage);

}

function homePage(){
    let divContainer = document.getElementById('container');        

    let header1 = document.createElement('i');
    header1.setAttribute('id', 'header1');
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

    let regA = document.createElement('button');
    regA.setAttribute('id', 'register');
    regA.innerText = "Register";

    divContainer.appendChild(header1);
    divContainer.appendChild(formDiv);

    formDiv.appendChild(unLabel);
    formDiv.appendChild(unInput);
    formDiv.appendChild(pwLabel);
    formDiv.appendChild(pwInput);
    formDiv.appendChild(loginBtn);
    formDiv.appendChild(regA);
    
}

function registerPage(){
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

    let pwLabel = document.createElement('label');
    pwLabel.setAttribute('for', 'regPwInput');
    pwLabel.setAttribute('class', 'form-label');
    pwLabel.setAttribute('id', 'regPwLabel');
    pwLabel.innerText = "Password:";

    let pwInput = document.createElement('input');
    pwInput.setAttribute('type', 'password');
    pwInput.setAttribute('class', 'form-control');
    pwInput.setAttribute('name', 'pw-input');
    pwInput.setAttribute('id', 'pw-reg');
    pwInput.setAttribute('placeholder', 'Password');
    pwInput.setAttribute('width', '30px');

    let fnLabel = document.createElement('label');
    fnLabel.setAttribute('for', 'regFnInput');
    fnLabel.setAttribute('class', 'form-label');
    fnLabel.setAttribute('id', 'regFnLabel');
    fnLabel.innerText = "First Name:";

    let fnInput = document.createElement('input');
    fnInput.setAttribute('type', 'text');
    fnInput.setAttribute('class', 'form-control');
    fnInput.setAttribute('name', 'fn-input');
    fnInput.setAttribute('id', 'fn-reg');
    fnInput.setAttribute('placeholder', 'First Name');
    fnInput.setAttribute('width', '30px');

    let lnLabel = document.createElement('label');
    lnLabel.setAttribute('for', 'regLnInput');
    lnLabel.setAttribute('class', 'form-label');
    lnLabel.setAttribute('id', 'regLnLabel');
    lnLabel.innerText = "Last Name:";

    let lnInput = document.createElement('input');
    lnInput.setAttribute('type', 'text');
    lnInput.setAttribute('class', 'form-control');
    lnInput.setAttribute('name', 'ln-input');
    lnInput.setAttribute('id', 'ln-reg');
    lnInput.setAttribute('placeholder', 'Last Name');
    lnInput.setAttribute('width', '30px');

    let emLabel = document.createElement('label');
    emLabel.setAttribute('for', 'regEmInput');
    emLabel.setAttribute('class', 'form-label');
    emLabel.setAttribute('id', 'regEmLabel');
    emLabel.innerText = "Email:";

    let emInput = document.createElement('input');
    emInput.setAttribute('type', 'text');
    emInput.setAttribute('class', 'form-control');
    emInput.setAttribute('name', 'em-input');
    emInput.setAttribute('id', 'em-reg');
    emInput.setAttribute('placeholder', 'Email');
    emInput.setAttribute('width', '30px');

    let regBtn = document.createElement('button');
    regBtn.setAttribute('id', 'registerFormBtn')
    regBtn.innerText = "Register"


    divContainer.appendChild(formRegister);
    formRegister.appendChild(unLabel);
    formRegister.appendChild(unInput);
    formRegister.appendChild(pwLabel);
    formRegister.appendChild(pwInput);
    formRegister.appendChild(fnLabel);
    formRegister.appendChild(fnInput);
    formRegister.appendChild(lnLabel);
    formRegister.appendChild(lnInput);
    formRegister.appendChild(emLabel);
    formRegister.appendChild(emInput);
    formRegister.appendChild(regBtn);

    regBtn.addEventListener('click', register);
}

function register(){
    let uname = document.getElementById('un-reg').value;
    let passw = document.getElementById('pw-reg').value;
    let fname = document.getElementById('fn-reg').value;
    let lname = document.getElementById('ln-reg').value;
    let email = document.getElementById('em-reg').value;

    if(uname && passw && fname && lname && email){
        let xhttp = new XMLHttpRequest();

        xhttp.open('POST', 'http://localhost:8080/ers-app/user', true);
        let data = JSON.stringify({'ersUsername':uname,'ersPassword':passw,'user_first_name':fname,'user_last_name':lname,'user_email':email});
        xhttp.send(data);
        xhttp.onreadystatechange = () =>{
            if(xhttp.readyState === 4 && xhttp.status === 200){
                alert('Successfully registered!');
                let divContainer = document.getElementById('container');        
                let formRegister = document.getElementById('registerForm')
                let header1 = document.getElementById('header1');
                divContainer.removeChild(header1);
                divContainer.removeChild(formRegister);
                homePage();
            }
        }
    }
}

function login(){    
    let uname = document.getElementById('un').value;
    let passw = document.getElementById('passw').value;
    if(uname && passw){
        let xhttp = new XMLHttpRequest();

        xhttp.open('POST', 'http://localhost:8080/ers-app/auth', true);
        let data = JSON.stringify({'username': uname, 'password': passw});
        xhttp.send(data);
        xhttp.onreadystatechange = function(){
            if(xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById('un').innerText = '';
                document.getElementById('passw').innerText = '';
                let divContainer = document.getElementById('container');        
                let formHome = document.getElementById('loginForm')
                divContainer.removeChild(formHome);
                loadDashboard();
                
            }
        }
    }
}

function logout(){
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'auth', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('logout successful!')
        }
    }
}

function loadDashboard(){
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'dashboard.view', true);
    xhttp.send();
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState === 4){
            if(xhttp.status === 200){
                document.getElementById('container').innerHTML = xhttp.responseText;
                document.getElementById('reimb_submit').addEventListener('click', createReimb);
                returnReimb();
            }
        }
    }
}  

function returnReimb(){
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'http://localhost:8080/ers-app/reimb', true);
    xhttp.send();
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState === 4 && xhttp.status === 200){
            console.log(xhttp.responseText);
            let data = JSON.parse(xhttp.responseText);
            setValues(data);
        }        
    }
}

function setValues(table_values){
    let table = document.getElementById('reimb_table');
    console.log(table_values);
    for(const item of table_values){
        let row = document.createElement('tr');
        let id = document.createElement('td');
        let description = document.createElement('td');
        let amount = document.createElement('td');
        let type = document.createElement('td');
        let status = document.createElement('td');
        let received = document.createElement('td');
        let completed = document.createElement('td');

        id.innerText = item.id;
        description.innerText = item.description;
        amount.innerText = new Intl.NumberFormat('en-US', { 
            style: 'currency', 
            currency: 'USD' 
        }).format(item.amount);
        type.innerText = item.type;
        status.innerText = item.status;
        received.innerText = new Date(item.received).toDateString();
        completed.innerText = (item.completed != null) ? new Date(item.completed).toDateString() : '-';
        row.appendChild(id);
        row.appendChild(description);
        row.appendChild(amount);
        row.appendChild(type);
        row.appendChild(status);
        row.appendChild(received);
        row.appendChild(completed);
        table.appendChild(row);
    }
}

function createReimb(){
    let xhttp = new XMLHttpRequest();
    let amount = document.getElementById('reimb_amount').value;
    let desc = document.getElementById('description').value;
    let type = document.getElementById('type').value;
    if(amount){
        xhttp.open('POST', 'http://localhost:8080/ers-app/reimb', true);
        let data = JSON.stringify({'amount':amount,'desc':desc,'type':type});
        xhttp.send(data);
        xhttp.onreadystatechange = () => {
            if(xhttp.readyState === 4 && xhttp.status === 201){
                alert('Successfully saved ');
                loadDashboard();
            }
        }
    }
}



