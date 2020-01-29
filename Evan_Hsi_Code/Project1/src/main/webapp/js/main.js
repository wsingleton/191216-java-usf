window.onload = () => {
    console.log("did js deploy");
    loadLogin();
    //loadRegister();
    document.getElementById('logout').addEventListener('click', logout);


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
            document.getElementById('register').addEventListener('click', loadRegister);
            document.getElementById('password').addEventListener('keyup', function(event) {
                console.log(event.keyCode);
                if(event.keyCode === 13) {
                    document.getElementById('login').click();
                    console.log('enter');
                }
            });
        }
    }
}

function login() {

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let creds = {
        username: username,
        password: password
    };

    let credJSON = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", 'auth', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 ) {
             if(xhr.status === 200) {
                 let user = JSON.parse(xhr.responseText);
                 console.log(user);

                if(user["role"] === "MANAGER") {
                    loadDashMan();
                }
                else
                    loadDashEmp();

             }
             else if (xhr.status === 401) {
                 document.getElementById('login-message').innerText = 'Login failed';
             }
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

function register() {

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;

    let info = {
        firstname: firstname,
        lastname: lastname,
        username: username,
        password: password,
        email: email
    };

    let infoJSON = JSON.stringify(info);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", 'reg', true);
    xhr.send(infoJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            if(xhr.status === 201) {
                let user = JSON.parse(xhr.responseText);
                console.log(user);
                loadDashEmp();
            }
            else if(xhr.status === 401) {
                document.getElementById('register-message').innerText = "Invalid Input";
            }
        }
    }

}

function loadDashEmp() {
    console.log('in loadDashEmp()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashemp.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;

            let xhr2 = new XMLHttpRequest();
            xhr2.open('GET', 'dashemp', true);
            xhr2.send();
            xhr2.onreadystatechange = () => {
                if(xhr2.readyState === 4 && xhr2.status === 200) {
                    document.getElementById('insert').innerHTML = xhr2.responseText;
                }
            }
        }
    }
}

function loadDashMan() {
    console.log('in loadDashMan()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashman.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;

            let xhr2 = new XMLHttpRequest();
            xhr2.open('GET', 'dashman', true);
            xhr2.send();
            xhr2.onreadystatechange = () => {
                if(xhr2.readyState === 4 && xhr2.status === 200) {
                    let reimbs = JSON.parse(xhr2.responseText);
                    console.log(reimbs);
                    let tag = document.getElementById('reimbursements');
                    empTable(reimbs, tag);
                    
                }
            }
        }
    }
}

function empTable(arr, tag) {

    for(let i = 0; i < arr.length; i++) {
        let row = document.createElement('tr');
        row.setAttribute('id', ('row-'+i));

        let idcol = document.createElement('td');
        let amountcol = document.createElement('td');
        let desccol = document.createElement('td');
        let subtimecol = document.createElement('td');
        let restimecol = document.createElement('td');
        let authcol = document.createElement('td');
        let rescol = document.createElement('td');
        let receiptcol = document.createElement('td');
        let typecol = document.createElement('td');
        let statuscol = document.createElement('td');

        let id = (arr[i])['id'];
        let amount = (arr[i])['amount'];
        let desc = (arr[i])['description'];
        let subt = (arr[i])['submitTime'];
        let rest = (arr[i])['resolveTime'];
        let auth = (arr[i])['submitId'];
        let res = (arr[i])['resolveId'];
        let receipt = (arr[i])['reciept'];
        let type = (arr[i])['type'];
        let status = (arr[i])['status'];
        
        idcol.innerText = id;
        amountcol.innerText = amount;
        desccol.innerText = desc;
        subtimecol.innerText = subt;
        restimecol.innerText = rest;
        authcol.innerText = auth;
        rescol.innerText = res;
        receiptcol.innerText = receipt;
        typecol.innerText = type;
        statuscol.innerText = status;

        row.appendChild(idcol);
        row.appendChild(amountcol);
        row.appendChild(desccol);
        row.appendChild(subtimecol);
        row.appendChild(restimecol);
        row.appendChild(authcol);
        row.appendChild(rescol);
        row.appendChild(receiptcol);
        row.appendChild(typecol);
        row.appendChild(statuscol);

        tag.appendChild(row);
    }

}

function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'auth', true);
    xhr.send();
    xhr.onreadystatechante = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
        console.log('logout');
        }
    }
}