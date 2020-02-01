window.onload = () => {
    console.log('homescreen loaded?');
    loadHome();
    document.getElementById('homebutton').addEventListener('click', logout);
    document.getElementById('signout').addEventListener('click', logout);
}


// +----------- Combined -----------+


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
            document.getElementById('policy').addEventListener('click', loadPolicy);
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
            loadHome();
        }
    }
}

function loadPolicy() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'policy.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText; 
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
            if (xhr.status === 401) {
                let hiddenMessage = document.getElementById('login-message').hidden = false;
                document.getElementById('username').value = '';
                document.getElementById('password').value = '';
            }
            if (xhr.status === 200) {

                let user = JSON.parse(xhr.responseText);

                if (user.role === 'EMPLOYEE'){
                    loadDashboard();
                }else {
                    loadAdminDash();
                }
            }

            
        }
    }
}



// +----------- Admin/Manager -----------+

function loadAdminDash() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'admindash.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('navdashboard').addEventListener('click', loadAdminDash);
            getReimbsForAdmin(); 

            document.onclick = function(event) {
                var target = event.target || event.srcElement;
                if(target.getAttribute('class') === 'admintableId') {
                    let elementId = target.innerHTML; 
                    console.log(elementId);
                    loadAdminInfo(elementId); 
                }            
            }
        }
    }
}

function getReimbsForAdmin() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimbs', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let reimbList = JSON.parse(xhr.responseText);
                console.log(reimbList);

                for(let i = 0; i < reimbList.length; i++) {
                    addRows(reimbList[i]);
                }
                
            }
        }
    }
}

function loadAdminInfo(id) {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'admininfo.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('navdashboard').addEventListener('click', loadAdminDash);
            document.getElementById('updatereimb').addEventListener('click', updateReimb);
            getAdminInfo(id);
            
            
        }
    }
}

function getAdminInfo(id) {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimbs?reimbId=' + id, true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb);
                addAdminInfo(reimb);
            }
        }
    }  
}



function addAdminInfo(object) {

    let id = object.reimbId;
    let userId = object.authorId;
    let subDate = object.submitted;
    let newSub = subDate.substring(0, 10);
    let amount = object.amount;
    let type = object.type;
    let status = object.status;
    let description = object.description;
    let receipt = object.receipt;

    let pId = document.getElementById('reimbId');
    pId.setAttribute('value', id);
    let pUserId = document.getElementById('reimbAuthor');
    let pAmount = document.getElementById('reimbamount');
    let pSubmitted = document.getElementById('reimbsubmitted');
    let pDescription = document.getElementById('reimbdescription');
    let pReceipt = document.getElementById('reimbreceipt');
    let pType = document.getElementById('reimbtype');

    pId.innerText = id;
    pUserId.innerText = userId;
    pAmount.innerText = amount;
    pSubmitted.innerHTML = newSub;
    pDescription.innerText = description;
    pReceipt.innerText = 'null';
    pType.innerText = type;

}

function updateReimb() {

    let updReimbId = document.getElementById('reimbId').innerHTML;
    let select = document.getElementById('reimbstatus');
    let updStatus = select.options[select.selectedIndex].innerHTML;

    if(updStatus === 'PENDING') {
        document.getElementById('update-message').hidden = false;
    }

    let updated = {
        reimbId: updReimbId,
        status: updStatus
    };

    let updatedJSON = JSON.stringify(updated);

    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'reimbs', true);
    xhr.send(updatedJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 202 || xhr.status === 200) {
                loadAdminDash();
            }
        }
    }   
}

function addRows(object) {

    let id = object.reimbId;
    let userId = object.authorId;
    let subDate = object.submitted;
    let newSub = subDate.substring(0,10);
    let amount = object.amount;
    let type = object.type;
    let status = object.status;

    let row = document.createElement('tr');
    let idCell = document.createElement('td');
    let userIdCell = document.createElement('td');
    let subDateCell = document.createElement('td');
    let amtCell = document.createElement('td');
    let typeCell = document.createElement('td');
    let statusCell = document.createElement('td');

    row.appendChild(idCell);
    row.appendChild(userIdCell);
    row.appendChild(subDateCell);
    row.appendChild(amtCell);
    row.appendChild(typeCell);
    row.appendChild(statusCell);

    document.getElementById('adminreimbtable').appendChild(row);
    let link = document.createElement('a');
    link.setAttribute('class', 'admintableId');
    link.setAttribute('href', '#');
    link.setAttribute('id', id);
    link.innerText = id;

    idCell.append(link);
    userIdCell.innerText = userId;
    subDateCell.innerText = newSub;
    amtCell.innerText = amount;
    typeCell.innerText = type;
    statusCell.innerText = status;

}

// +----------- Employee -----------+

function loadDashboard() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashboard.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('newreimbbutton').addEventListener('click', loadNewReimb);
            document.getElementById('navdashboard').addEventListener('click', loadDashboard);
            document.getElementById('policy').addEventListener('click', loadPolicy); 
            getReimbs(); 

            document.onclick = function(event) {
                var target = event.target || event.srcElement;
                if(target.getAttribute('class') === 'tableId') {
                    let elementId = target.innerHTML; 
                    console.log(elementId);
                    loadInfo(elementId); 
                }            
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
            if (xhr.status === 401) {
                document.getElementById('register-message').hidden = false;
                document.getElementById('username').value = '';
                document.getElementById('password').value = '';
                document.getElementById('firstname').value = '';
                document.getElementById('lastname').value = '';
                document.getElementById('email').value = '';
            }
            if (xhr.status === 201 || xhr.status === 200) {
                console.log('success');
                loadDashboard();
            }

            
        }
    }
}

function loadNewReimb() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'request.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('newreimb').addEventListener('click', submitNewReimb);
            document.getElementById('navdashboard').addEventListener('click', loadDashboard);
            document.getElementById('policy').addEventListener('click', loadPolicy); 
            document.getElementById('signout').addEventListener('click', logout); 
        }
    }
}

function submitNewReimb() {

    let amount = document.getElementById('amountinput').value;
    let select = document.getElementById('reimbtypeinput');
    let type = select.options[select.selectedIndex].innerHTML;
    let description = document.getElementById('descriptioninput').value;
    let receipt = document.getElementById('receiptinput').value;

    let reimbs = {
        amount: amount,
        description: description,
        receipt: null,
        type: type
        
    };

    let reimbsJSON = JSON.stringify(reimbs);
    console.log(reimbsJSON);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'reimbs', true);
    xhr.send(reimbsJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 401) {
                document.getElementById('reimb-message').hidden = false;
                document.getElementById('amount').value = '';
                document.getElementById('descriptioninput').value = '';
            }
            if (xhr.status === 201 || xhr.status === 200) {
                loadDashboard();
            }

           
        }
    }
}

// +----------- Reimbursements -----------+ 

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
    xhr.open('GET', 'info.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('navdashboard').addEventListener('click', loadDashboard);
            document.getElementById('policy').addEventListener('click', loadPolicy);
            document.getElementById('signout').addEventListener('click', logout); 
            getInfo(id);
            
            
        }
    }
}

function addRow(object) {

    let id = object.reimbId;
    let userId = object.authorId;
    let subDate = object.submitted;
    let newSub = subDate.substring(0,10);
    let amount = object.amount;
    let type = object.type;
    let status = object.status;

    let row = document.createElement('tr');
    let idCell = document.createElement('td');
    let userIdCell = document.createElement('td');
    let subDateCell = document.createElement('td');
    let amtCell = document.createElement('td');
    let typeCell = document.createElement('td');
    let statusCell = document.createElement('td');

    row.appendChild(idCell);
    row.appendChild(userIdCell);
    row.appendChild(subDateCell);
    row.appendChild(amtCell);
    row.appendChild(typeCell);
    row.appendChild(statusCell);

    document.getElementById('reimbtable').appendChild(row);
    let link = document.createElement('a');
    link.setAttribute('class', 'tableId');
    link.setAttribute('href', '#');
    link.setAttribute('id', id);
    link.innerText = id;

    idCell.append(link);
    userIdCell.innerText = userId;
    subDateCell.innerText = newSub;
    amtCell.innerText = amount;
    typeCell.innerText = type;
    statusCell.innerText = status;

}

function addInfo(object) {

    let id = object.reimbId;
    let userId = object.authorId;
    let subDate = object.submitted;
    let newSub = subDate.substring(0, 10);
    let amount = object.amount;
    let type = object.type;
    let status = object.status;
    let description = object.description;
    let receipt = object.receipt;

    let pId = document.getElementById('reimbId');
    pId.setAttribute('value', id);
    let pUserId = document.getElementById('reimbAuthor');
    let pAmount = document.getElementById('reimbamount');
    let pSubmitted = document.getElementById('reimbsubmitted');
    let pDescription = document.getElementById('reimbdescription');
    let pReceipt = document.getElementById('reimbreceipt');
    let pStatus = document.getElementById('reimbstatus')
    let pType = document.getElementById('reimbtype');

    pId.innerText = id;
    pUserId.innerText = userId;
    pAmount.innerText = amount;
    pSubmitted.innerHTML = newSub;
    pDescription.innerText = description;
    pReceipt.innerText = 'null';
    pStatus.innerText = status;
    pType.innerText = type;

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