let user;
let reimbs;

window.onload = () => {
    console.log('did the js load?');
    loadHome();
}

function loadHome() {
    console.log('in loadHome()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'home.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('toLogin').addEventListener('click', loadLogin);
            document.getElementById('toRegister').addEventListener('click', loadRegister);
        }
    }
}

function loadLogin() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener('click', login);

        }
    }

}

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

function loadDashboard() {

    console.log('in dashboard');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashboard.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('toRecords').addEventListener('click', loadReimbView);
            document.getElementById('toReimbursement').addEventListener('click', loadReimbursement);
        }
    }

}

function loadReimbursement() {

    console.log('in createReimbursement') 

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'createReimb.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('submitReimb').addEventListener('click', submitReimb);
        }
    }

}

function loadReimbView() {

    console.log('in view');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'viewReimb.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
        }
    }

}

function loadManagerDashboard() {

    console.log('in manager dashboard');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'managerDashboard.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('manageReimbursement').addEventListener('click', loadManageReimbursement);
        }
    }
}

function loadManageReimbursement() {

    console.log('in manage reimbursements');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'manageReimb.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
        }
    }

}



function login() {

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    
    let creds = {
        username: username,
        password: password
    }

    let credJSON = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                user = JSON.parse(xhr.responseText);
                console.log(user);
                if (Object.values(user).includes('BASIC_USER')){
                    loadDashboard();
                }
                else {
                    loadManagerDashboard();
                }
                
            }

            if (xhr.status === 400) {
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

function register() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let email = document.getElementById('email').value;

    let newUser = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email
    }

    let newUserJSON = JSON.stringify(newUser);

    let xhr = new XMLHttpRequest();
    xhr.open('POST','users', true );
    xhr.send(newUserJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 201) {
                user = JSON.parse(xhr.responseText);
                console.log(user);
                loadDashboard();
            }

            if (xhr.status === 400) {
                document.getElementById('register-message').innerText = 'Register failed!';
            }

        }
    }

}

function submitReimb() {
 //   let currentUser = JSON.parse(user);
    let amount = document.getElementById('amount').value;
    let type = document.getElementById('type').value;
    let description = document.getElementById('description').value;
    let authorId = user.id;
    

    let newReimb = {
        amount: amount,
        description: description,
        authorId: authorId,
        type: type
    }
    console.log(newReimb);
    let newReimbJSON = JSON.stringify(newReimb);
    console.log(newReimbJSON);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'reimb', true);
    xhr.send(newReimbJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb);
                loadDashboard();
            }

            if(xhr.status === 400) {
                console.log('didn\'t work man')
                document.getElementById('newReimb-message').innerText = 'Submission Failed';
            }
        }
    }
}

function populateUserReimbView() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimb', true) 
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status) {
            reimbs = JSON.parse(xhr.responseText);
        }
    }
}

function navigate(string) {
    location.href = "reimbursement/"+ partial
}

