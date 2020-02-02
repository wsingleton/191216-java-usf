window.onload = () => {
    loadLogin();
}

function loadLogin() {
    console.log('in loadLogin()');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('loginbtn').addEventListener('click', login);
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
    console.log(creds)
    let credJSON = JSON.stringify(creds);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {

            if (xhr.status === 200) {
                let user = JSON.parse(xhr.responseText);
                console.log(user);
                if(user.role === "MANAGER") {
                    loadManagerView();
                }
                else loadUserView();
            }

            if (xhr.status === 401) {
                //document.getElementById('login-message').innerText = 'Login failed!';
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


function loadManagerView () {
    console.log('in loadManager()');
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "manager.view", true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('root').innerHTML = xhr.responseText
            // document.getElementById('login').addEventListener('click', login);
            loadMangereReimb()
        }

    }
}

function loadUserView () {
    console.log('in loadM()');
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "user.view", true);
    xhr.send();
    xhr.onreadystatechange = function () {

        if(xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('root').innerHTML = xhr.responseText
            loadUserReimb()
        }

    }
}



function loadMangerReimb() {
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "reimbursement", true);
    xhr.send();        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log(reimbursements)
        }
        
    }
    
    
    
}

function loadMangerReimbStatus() {
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "reimbursement", true);
    xhr.send();        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log(reimbursements)
        }
        
    }
    
    
    
}


function loadUserReimb() {
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "reimbursement", true);
    xhr.send();        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log(reimbursements)
        }
        
    }
    
    
    
}










