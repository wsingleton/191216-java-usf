window.onload = () => {
    console.log('homescreen loaded?');
    loadHome();
    document.getElementById('navdashboard').addEventListener('click', loadDashboard);
    document.getElementById('signout').addEventListener('click', logout);
    
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
                console.log(user);
                loadDashboard();
            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Login failed!';
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
            if (xhr.status === 200) {

                let user = JSON.parse(xhr.responseText);
                console.log(user);
                loadDashboard();
            }

            if (xhr.status === 401) {
                document.getElementById('register-message').innerText = 'Username is taken';
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

function loadDashboard() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashboard.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('newreimbbutton').addEventListener('click', loadNewReimb);
            document.getElementById('viewreimbbutton').addEventListener('click', loadReimbs);  
        }
    }
}

function loadNewReimb() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'newreimb.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('newreimb').addEventListener('click', submitNewReimb);  
        }
    }
}

function loadReimbs() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimbs.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            getReimbs();
            // document.getElementsByTagName('a')[5].addEventListener('click', valueOfTable);
            
            // let link = document.getElementsByTagName('a');
            // for (let i = 0; i < link.length; i++) {
            //     let value = link[i].innerHTML;
            // }
            
            // link.addEventListener('click', () => {
            //     loadInfo(value);
            //     console.log('this function works');
            //     console.log(value);
            // })
            
        }
    }
}

// function valueOfTable() {
//     document.getElementsByTagName('a').getAttribute('id')
//     console.log(document.getElementsByTagName('a').getAttribute('id'));
// }


function submitNewReimb() {

    let amount = getElementById('amount').value;
    let date = getElementById('expensedate').value;
    let select = getElementById('reimbtype');
    let type = select.options[select.selectedIndex].innerHTML;
    let description = getElementById('description').innerHTML;
    let receipt = getElementById('receipt').value;

    let creds = {
        amount: amount,
        expenseDate: date,
        type: type,
        description: description,
        receipt: receipt
    };

    let credJSON = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'reimbs', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {

                let newReimb = JSON.parse(xhr.responseText);
                console.log(newReimb);
            }

            if (xhr.status === 401) {
                document.getElementById('reimb-message').innerText = 'New Submission Failed!';
            }
        }
    }
}

function getReimbs() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimbs', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let reimbList = JSON.parse(xhr.responseText);
                console.log(reimbList);

                for(let i = 0; i < reimbList.length; i++) {
                    addRow(reimbList[i]);
                }
            }
        }
    }
}

function addRow(object) {

    let id = object.reimbId;
    let userId = object.authorId;
    let subDate = object.submitted;
    let newSub = subDate.substring(0,10);
    let expDate = object.expenseDate;
    let newExp = expDate.substring(0,10);
    let amount = object.amount;
    let type = object.type;
    let status = object.status;

    let row = document.createElement('tr');
    let idCell = document.createElement('td');
    let userIdCell = document.createElement('td');
    let subDateCell = document.createElement('td');
    let expDateCell = document.createElement('td');
    let amtCell = document.createElement('td');
    let typeCell = document.createElement('td');
    let statusCell = document.createElement('td');

    row.appendChild(idCell);
    row.appendChild(userIdCell);
    row.appendChild(subDateCell);
    row.appendChild(expDateCell);
    row.appendChild(amtCell);
    row.appendChild(typeCell);
    row.appendChild(statusCell);

    document.getElementById('reimbtable').appendChild(row);
    let link = document.createElement('a');
    link.setAttribute('href', '#');
    link.setAttribute('id', id);
    link.innerText = id;

    idCell.append(link);
    userIdCell.innerText = userId;
    subDateCell.innerText = newSub;
    expDateCell.innerText = newExp;
    amtCell.innerText = amount;
    typeCell.innerText = type;
    statusCell.innerText = status;

}

function addInfo(object) {

    let id = object.reimbId;
    let userId = object.authorId;
    let subDate = object.submitted;
    let newSub = subDate.substring(0, 10);
    console.log(newSub);
    let expDate = object.expenseDate;
    let newExp = expDate.substring(0, 10);
    console.log(newExp);
    let amount = object.amount;
    let type = object.type;
    let status = object.status;
    let description = object.description;
    let receipt = object.receipt;

    let pId = document.getElementById('reimbId');
    let pUserId = document.getElementById('reimbAuthor');
    let pAmount = document.getElementById('reimbamount');
    let pDate = document.getElementById('reimbdate');
    let pSubmitted = document.getElementById('reimbsubmitted');
    let pDescription = document.getElementById('reimbdescription');
    let pReceipt = document.getElementById('reimbreceipt');
    let pType = document.getElementById('reimbtype');

    pId.innerText = id;
    pUserId.innerText = userId;
    pAmount.innerText = amount;
    pDate.innerHTML = newSub;
    pSubmitted.innerHTML = newExp;
    pDescription.innerText = description;
    pReceipt.innerText = 'null';
    pType.innerText = type;

}

function getInfo(id) {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimbs?reimbId=' + id, true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb);
                addInfo(reimb);
            }
        }
    }
}

function loadInfo(id) {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimbupdate.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            getInfo(id);
            
        }
    }

}

function isEmail(string){

    let x = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(string);

    return x;

};

function checkLength (string) {
    if (string.length < 2) {
        return false;
    }
    return true;
}