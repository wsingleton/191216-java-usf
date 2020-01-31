
window.onload = () => {
    console.log('homescreen loaded?');
    loadHome();


}

function loadHome() {

    console.log('in loadHome');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'home.view', true);
    xhr.send();
    xhr.onreadystatechange =() => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('home-login').addEventListener('click', loadLogin);
            document.getElementById('home-register').addEventListener('click', loadRegister);
        }
    }
}


//-------------------------------Login---------------------------------------------

function loadLogin() {

    console.log('in loadLogin');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener('click', function(event){
                event.preventDefault();
                login();
            });

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
                console.log(user)
                                console.log(user.id)
                // make it set authId

                // create an if else statement for manager vs employee
                if(user.role==="EMPLOYEE"){
                       loadDashboard(user);
                }else{
                    loadManager();
                }

                console.log(user);

            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Login failed!';
            }
        }
    }
}


//-----------------------------------Register--------------------------------



function loadRegister() {

    console.log('in loadRegister()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'register.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('register').addEventListener('click', register);
        }
    }
}


function register() {

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('firstname').value;
    let lastName = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;

    let creds = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email
    };

    let credJSON = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'users', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 201 || xhr.status === 200) {
                console.log('test');
                // let user = JSON.parse(xhr.responseText);
                // console.log(user);
                loadDashboard();
            }

            if (xhr.status === 401) {
                document.getElementById('register-message').innerText = 'Username is taken';
            }
        }
    }
}




function loadDashboard(user) {

    console.log(user)
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashboard.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;

            document.getElementById('newreimbbutton').addEventListener('click', () =>{
                loadNew(user);
            });
            document.getElementById('reimbbutton').addEventListener('click', loadReimb);

        }
    }
}

function loadManager(){
  console.log('in loadHome');

     let xhr = new XMLHttpRequest();
     xhr.open('GET', 'manager.view', true);
     xhr.send();
     xhr.onreadystatechange =() => {
         if (xhr.readyState === 4 && xhr.status === 200) {
             document.getElementById('root').innerHTML = xhr.responseText;

         }
     }
 }

function loadReimb(){

    console.log('in loadreimb');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimb.view', true);
    xhr.send();
    xhr.onreadystatechange = () =>{
    if (xhr.readyState===4 && xhr.status ===200){
        document.getElementById('root').innerHTML = xhr.responseText;


    }
    }
}



function loadNew(user) {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'new.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('newreimb').addEventListener('click', ()=> {
                newReimbursement(user);
            });
            }
    }
}

function newReimbursement(user) {

    let amount = document.getElementById('amount').value;
    let select = document.getElementById('type');
    let type = select.options[select.selectedIndex].value;
    let description = document.getElementById('description').value;


    let reimbs = {
        amount: parseInt(amount),
        description: description,
        authorId: user.id,
        type: parseInt(type)

    };

    let reimbsJSON = JSON.stringify(reimbs);
    console.log(reimbsJSON);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'reimbs', true);
    xhr.send(reimbsJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 201 || xhr.status === 200) {

                // let newReimb = JSON.parse(xhr.responseText);
                // console.log(newReimb);
                loadDashboard();
            }

            if (xhr.status === 401) {
                document.getElementById('reimb-message').innerText = 'New Submission Failed!';
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
            console.log('Logout successful!');
        }
    }

    loadHome();
}
