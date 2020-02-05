window.onload = () => {
    loadLogin();
}

function loadLogin() {
    console.log('login initializing');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'XND_INC', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener('click', login);
            document.getElementById('register').addEventListener('click', register)
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

    let credsJson = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let user = JSON.parse(xhr.responseText);
            console.log(user);
        }
        if (xhr.status === 401) {
            document.getElementById('login-message').innerText = 'Login failed';
        }
    }
}
function register () {
    console.log('working in register');
    let xhr = new XMLHttpRequest();
        xhr.open('POST', 'register', true);
        xhr.send();
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                document.getElementById('root').innerHTML = xhr.responseText;
                document.getElementById('register').addEventListener('click', () => {registration()});
                }
       }
}

function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('logout successful')
        }
    }
}

let user;

function savingTicket(user) {
    console.log(user)

    let amount = '';
    let timeSubmitted = '';
    let desc = '';
    let timeResolved = new Date();
    let receipt = '';
    let authId = document.getElementById('authId').value;
    let resolverId = user.id;
    let statusId = document.getElementById('statusId').value;
    let categoryId = document.getElementById('categoryId').value;

    let creds = {
        amount: amount,
        timeSubmitted: timeSubmitted,
        timeResolved: timeResolved,
        desc: desc,
        receipt: receipt,
        authId: authId,
        resolverId: resolverId,
        statusId: statusId,
        categoryId: categoryId,
    };

    console.log(creds);

    let credsJSON = JSON.stringify(creds);
    xhr.open('POST', 'auth', true);
        xhr.send();
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb.desc);
            }
            if (xhr.status === 201) {
                let reimb = JSON.parse(xhr.response);
                console.log(reimb.desc);
            }
        }

}

function registration() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let email = document.getElementById('email').value;

    // add input validation esp. for email
    let user = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email,
        role: 2

    };

    let userJSON = JSON.stringify(user);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'registration', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 201) {
            loadLogin();
        }
        else if (xhr.status === 409) {
            document.getElementById('registration message').innerText = "The username provided is unavailable at this time"
        }
        console.log('failed to register');
    }

}

function navigation() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'navigation', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('navigation').addEventListener('click', loadNavigation);
            document.getElementById('logout').addEventListener('click', logout);
            document.getElementById('new reimb req').addEventListener('click', loadReimbursment);
            document.getElementById('remib submit').addEventListener('click', loadReimbursmentUpdates);
        }
    }
}
function values(reimbData) {
    let reimbId = reimbData.reimbId;
    let amount = reimbData.amount;
    let submittedDate = reimbData.submittedDate;
    let type = reimbData.type;
    let status = reimbData.status;
    let description = reimbData.description;
    let receipt = reimbData.receipt;
    let resolverId = reimbData.resolverId;
    let authorId = reimbData.authorId;
    let resolvedDate = reimbData.resolvedDate;

    let row = document.createElement('tr');
    let reimbIdCell = document.createElement('td');
    let typeCell = document.createElement('td');
    let statusCell = document.createElement('td');
    let totalAmountCell = document.createElement('td');
    let dateCreatedCell = document.createElement('td');
    let resolvedDateCell = document.createElement('td');
    let descriptionCell = document.createElement('td');
    let receiptCell = document.createElement('td');
    let resolverCell = document.createElement('td');
    let authorIdCell = document.createElement('td');

    row.appendChild(reimbIdCell);//1
    row.appendChild(typeCell);//2
    row.appendChild(statusCell);//3
    row.appendChild(totalAmountCell);//4
    row.appendChild(dateCreatedCell);//5
    row.appendChild(descriptionCell);//7
    row.appendChild(receiptCell);//8
    row.appendChild(resolverCell);//9
    row.appendChild(resolvedDateCell);//6
    row.appendChild(authorIdCell);//10

    reimbIdCell.innerText = reimbId;
    typeCell.innerText = type;
    statusCell.innerText = status;
    amountCell.innerText = amount;
    dateCreatedCell.innerText = submittedDate;
    resolvedDateCell.innerText = resolvedDate;
    descriptionCell.innerText = description;
    receiptCell.innerText = receipt;
    resolvedCell.innerText = resolverId;
    authIdCell.innerText = authorId;
    document.getElementById('open-reimb').appendChild(row);

}

function reimbTable() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'navigation', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let reimbData = JSON.parse(xhr.responseText);
            for (let i=0; i<reimbData.length; i++) {
                values(reimbData[i]);
            }
        }
    }
}

function newReimbReq() {

    let req_amount = document.getElementById('req_amount').value;
    let reimb_category = document.getElementById('reimb_category').value;
    let reimb_desc = document.getElementById('reimb_desc').value;

    let newReimbRequest = {
        amount: req_amount,
        type: reimb_category,
        description: reimb_desc
    };

    /*
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'navigation', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {

    */
}