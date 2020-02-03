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
        if (xhr.readyState === 4 && xhr.status === 200) {
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
        if (xhr.readyState === 4 && xhr.status === 200) {
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
        if (xhr.readyState === 4 && xhr.status === 200) {
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
        if (xhr.readyState === 4 && xhr.status === 200) {
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
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            populateUserReimbView();

        }
    }

}

function loadManagerDashboard() {

    console.log('in manager dashboard');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'managerDashboard.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
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
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            populateManagerReimbView();
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
                if (Object.values(user).includes('BASIC_USER')) {
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
    xhr.open('POST', 'users', true);
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
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb);
                loadDashboard();
            }

            if (xhr.status === 400) {
                console.log('didn\'t work man')
                document.getElementById('newReimb-message').innerText = 'Submission Failed';
            }
        }
    }
}

function approveReimbursement(reimbursement) {

    let reimbJSON = JSON.stringify(reimb);

    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'approve', send)
    xhr.send(reimbJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 201) {
            updatedReimb = JSON.parse(xhr.responseText);
            console.log(updatedReimb);
            loadManageReimbursement();
        }
    }

    xhr.open('PUT', 'manage', true);
    xhr.send

}

function denyReimbursement(reimb) {

    let reimbJSON = JSON.stringify(reimb);

    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'deny', true)
    xhr.send(reimbJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 201) {
            updatedReimb = JSON.parse(xhr.responseText);
            console.log(updatedReimb);
            loadManageReimbursement();
        }
    }

    xhr.open('PUT', 'manage', true);
    xhr.send

}

function populateUserReimbView() {

    let userJSON = JSON.stringify(user);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'usreimb', true)
    xhr.send(userJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 201) {
            reimbs = JSON.parse(xhr.responseText);
            console.log(reimbs);
            reimbView(reimbs);
        }
    }
}

function populateManagerReimbView() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'manage', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            reimbs = JSON.parse(xhr.responseText);
            console.log(reimbs);
            viewManageTable(reimbs);
        }
    }

}

function reimbView(arr) {
    for (let i = 0; i < arr.length; i++) {
        let row = document.createElement('tr');

        let sdate = '';
        let processed = '';
        let time = (arr[i])['timeSubmitted'].split(' ');
        let date = time[0].split('-')
        if ((arr[i])['timeResolved'] != null) {
            let stime = (arr[i])['timeResolved'].split(' ');
            sdate = stime[0].split('-')
            processed = `${sdate[1]}-${sdate[2]}-${sdate[0]}`;
        }
        

        row.setAttribute('row-', +i)
        let submittedCol = document.createElement('td');
        let processedCol = document.createElement('td');
        let reqTypeCol = document.createElement('td');
        let descriptCol = document.createElement('td');
        let amountCol = document.createElement('td');
        let reimbStatusCol = document.createElement('td');

        let submitted = `${date[1]}-${date[2]}-${date[0]}`;
        let type = (arr[i])['type'];
        let descript = (arr[i])['description'];
        let amount = (arr[i])['amount'];
        let status = (arr[i])['status'];

        submittedCol.innerText = submitted;
        processedCol.innerText = processed;
        reqTypeCol.innerText = type;
        descriptCol.innerText = descript;
        amountCol.innerText = amount;
        reimbStatusCol.innerText = status;

        row.appendChild(submittedCol);
        row.appendChild(processedCol);
        row.appendChild(reqTypeCol);
        row.appendChild(descriptCol);
        row.appendChild(amountCol);
        row.appendChild(reimbStatusCol);
        document.getElementById('viewTable').appendChild(row);

    }
}

function viewManageTable(arr) {
    for (let i = 0; i < arr.length; i++) {
        let row = document.createElement('tr');
        

        let processed = '';
        let time = (arr[i])['timeSubmitted'].split(' ');
        let date = time[0].split('-')

        row.setAttribute('row-', +i)
        let submittedCol = document.createElement('td');
        let processedCol = document.createElement('td');
        let reqTypeCol = document.createElement('td');
        let descriptCol = document.createElement('td');
        let amountCol = document.createElement('td');
        let reimbStatusCol = document.createElement('td');
        let approveCol = document.createElement('td');
        let denyCol = document.createElement('td');

        let submitted = `${date[1]}-${date[2]}-${date[0]}`;
        let type = (arr[i])['type'];
        let descript = (arr[i])['description'];
        let amount = (arr[i])['amount'];
        let status = (arr[i])['status'];

        submittedCol.innerText = submitted;
        processedCol.innerText = processed;
        reqTypeCol.innerText = type;
        descriptCol.innerText = descript;
        amountCol.innerText = amount;
        reimbStatusCol.innerText = status;
        let approvebtn = document.createElement('button');
        approvebtn.setAttribute('id',`approvebrn${i}`)
        approvebtn.setAttribute('class','btn btn-block btn-primary')
        approvebtn.innerText = 'Approve';

        let denybtn = document.createElement('button')
        denybtn.setAttribute('id',`denybtn${i}`)
        denybtn.setAttribute('class','btn btn-block btn-primary')
        denybtn.innerText = 'Deny';

        approvebtn.addEventListener('click', (e) => {
            e.preventDefault();
            let data = {
                id: (arr[i])['id'],
                amount: (arr[i])['amount'],
                timeSubmitted: (arr[i])['timeSubmitted'],
                timeResolved: (arr[i])['timeResolved'],
                description: (arr[i])['description'],
                authorId: (arr[i])['authorId'],
                resolverId: user.id,
                status: (arr[i])['status'],
                type: (arr[i])['type']
            } 

            let dataJSON = JSON.stringify(data);
            let xhr = new XMLHttpRequest();
            xhr.open('PUT', 'approve', true);
            xhr.send(dataJSON);
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 201) {
                    loadManagerDashboard();
                }
            }
        });

        denybtn.addEventListener('click', (e) => {
            e.preventDefault();
            let data = {
                id: (arr[i])['id'],
                amount: (arr[i])['amount'],
                timeSubmitted: (arr[i])['timeSubmitted'],
                timeResolved: (arr[i])['timeResolved'],
                description: (arr[i])['description'],
                authorId: (arr[i])['authorId'],
                resolverId: user.id,
                status: (arr[i])['status'],
                type: (arr[i])['type']
            } 

            let dataJSON = JSON.stringify(data);
            let xhr = new XMLHttpRequest();
            xhr.open('PUT', 'deny', true);
            xhr.send(dataJSON);
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 201) {
                    loadManagerDashboard();
                }
            }
        });

        row.appendChild(submittedCol);
        row.appendChild(reqTypeCol);
        row.appendChild(descriptCol);
        row.appendChild(amountCol);
        row.appendChild(reimbStatusCol);
        row.appendChild(approveCol);
        approveCol.appendChild(approvebtn)
        row.appendChild(denyCol)
        denyCol.appendChild(denybtn)
        document.getElementById('manageTable').appendChild(row);

    }
}

function navigate(string) {
    location.href = "reimbursement/" + partial
}

