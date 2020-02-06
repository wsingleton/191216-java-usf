window.onload = () => {
    loadLogin();
}

function loadLogin() {
    console.log('login intiializing');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login-bttn').addEventListener('click', login);
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

    let credsJSON = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credsJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let user = JSON.parse(xhr.responseText);
            console.log(user);
            if (user.role === 'FINANCE_MANAGER') {
                console.log(loadManager)
                loadManager();
            } else {
                loadUser();
            }
        }
        if (xhr.status === 401) {
            document.getElementById('login-message').innerText = 'Login failed';
        }
    }
}

function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('logout successful')
            loadLogin();
        }
    }
}

function loadManager(){
    console.log('this is your manager speaking');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'manager.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('this is your manager speaking');
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('reloadReimb').addEventListener('click', loadManager);
            document.getElementById('logout').addEventListener('click', logout);
            loadManagerReimb();
        }
    }
}

function loadManagerReimb(){
    console.log('this is your manager approving');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimb', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let reimbs = JSON.parse(xhr.responseText);
            console.log(reimbs);
            reimbManagerTable(reimbs);
        }
    }
}

function loadUser(){
    console.log('I am a grunt level employee');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'user.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('submitR').addEventListener('click', createReimb)
            document.getElementById('refreshReimb').addEventListener('click', loadUser)
            document.getElementById('logout').addEventListener('click', logout);
            loadReimbs();
        }
    }
}

function loadReimbs(){
    console.log('Please accept my request');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimb', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let reimbs = JSON.parse(xhr.responseText);
            console.log(reimbs);
            document.getElementById('approve');
            reimbUserTable(reimbs);
            
        }
    }
}

function approveReimb(id) {
    let Status = {
        id:id,
        status:1
    };

    let StatusJSON = JSON.stringify(Status);
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'reimb', true);
    xhr.send(StatusJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            loadManager();
        }
    }

}

function denyReimb(id) {
    let Status = {
        id:id,
        status:2
    };

    let StatusJSON = JSON.stringify(Status);
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'reimb', true);
    xhr.send(StatusJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            loadManager();
        }
    }

}

let reimb;

function reimbManagerTable(reimbs){
    let table = document.getElementById('reimbData');
    let data;
    for (let i =0; i<reimbs.length; i++){
        data = document.createElement('tr');

        let ticket = ( `
            <th>${reimbs.id}</th>
            <td>${reimbs.amount}</td>
            <td>${reimbs.timeSubmitted}</td>
            <td>${reimbs.timeResolved}</td>
            <td>${reimbs.description}</td>
            <td>${reimbs.receipt}</td>
            <td>${reimbs.authId}</td>
            <td>${reimbs.resId}</td>
            <td>${reimbs.statusId}</td>
            <td>${reimbs.categoryId}</td>

              `
            )

        let button = document.createElement('td');
        let approve = document.createElement('button');
        let deny = document.createElement('button');

        approve.setAttribute('id', 'a-button');
        approve.setAttribute('id', 'b-button');

        approve.innerText = 'approve';
        deny.innerText = 'deny';

        approve.addEventListener('click', () => {approveReimb(reimbs[i].id)});
        deny.addEventListener('click', () => {denyReimb(reimbs[i].id)});

        button.appendChild(approve);
        button.appendChild(deny);

        data.innerHTML = ticket;
        data.appendChild(button);

        table.appendChild(data);
    }
}

function reimbUserTable(reimbs){
    let table = document.getElementById('reimbData');
    let data;
    for(let i = 0; i <reimbs.length; i++) {
        data = document.createElement('tr');


              let ticket = ( `
               <th>${reimbs[i].id}</th>
                <td>${reimbs[i].amount}</td>
                <td>${reimbs[i].timeSubmitted}</td>
                <td>${reimbs[i].description}</td>                
                <td>${reimbs[i].recepit}</td>   
                <td>${reimbs[i].authorById}</td>
                <td>${reimbs[i].resolverById}</td>
                <td>${reimbs[i].reimbursementStatusId}</td>
                <td>${reimbs[i].reimbursementTypeId}</td>


                `
              )


    data.innerHTML = ticket;
    table.appendChild(data);

    
    }
}

function createReimb(){
    let reimb = getNewReimb()
    let xhr = new XMLHttpRequest();
    xhr.open("POST", 'reimb', true);
    xhr.send(reimb);        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbs = JSON.stringify(xhr.responseText);
            reimbursement = JSON.parse(reimbs);
            console.log('in createReimb!')
        }               
    } 
}

function getNewReimb() {
    let obj = {

        amount: document.getElementById('reimbamount').value,
        description: document.getElementById('reimbDesc').value,
        categoryId: parseInt(document.getElementById('reimbType').value)

    }
    console.log(obj)
    return JSON.stringify(obj);
}


