
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

    let credJSON = JSON.stringify(creds);

    console.log(credJSON);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {

                let user = JSON.parse(xhr.responseText);
                console.log(user);
                if(user.userRole == "MANAGER") {
                    loadManagerView();
                }
                else loadEmployeeView();
               

            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Login failed!';
            }
        }
    }

}

    
        
    
    function loadManagerView () {

        console.log('in loadManagerView()');
        let xhr = new XMLHttpRequest();
        xhr.open("GET", 'manager.view', true);
        xhr.send();
        xhr.onreadystatechange = () => {
            if(xhr.readyState == 4 && xhr.status == 200) {
                document.getElementById('root').innerHTML = xhr.responseText
                loadEmployeeReimb()
                // document.getElementById('login').addEventListener('click', login);
                
            }
            
        }
        

        
    }
    
    function loadEmployeeView () {
        console.log('in loadEmployeeView()');
        let xhr = new XMLHttpRequest();
        xhr.open("GET", 'employee.view', true);
        xhr.send();
        xhr.onreadystatechange = function () {
            
            if(xhr.readyState == 4 && xhr.status == 200) {
             document.getElementById('root').innerHTML = xhr.responseText
             loadEmployeeReimb()
             
            }
            
        }
        

        
    }


function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('logout successful!')
        }
    }
}

	
function loadEmployeeReimb() {
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", 'reimb', true);
    xhr.send();        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log(reimbursements)
        }
        
    }
    
    
    
}

	
function loadEachEmployeeReimb() {
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", 'userreimbursement', true);
    xhr.send();        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log('in get each reimbursements!')
        }
        
    }
    
    
    
}

