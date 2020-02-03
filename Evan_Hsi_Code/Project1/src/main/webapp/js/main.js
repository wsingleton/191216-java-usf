window.onload = () => {
    loadLogin();
}


function loadLogin() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener('click', login);
            document.getElementById('register').addEventListener('click', loadRegister);
            document.getElementById('password').addEventListener('keyup', function(event) {
                if(event.keyCode === 13) {
                    document.getElementById('login').click();
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

                if(user["role"] === "MANAGER") {
                    loadDashMan();
                }
                else if(user["role"] === "EMPLOYEE") {
                    loadDashEmp();
                }
             }
             else if (xhr.status === 401) {
                 document.getElementById('login-message').innerText = 'Login failed';
             }
             else if (xhr.status === 402) {
                 document.getElementById('login-message').innerText = "Please confirm your account";
             }
        }
    }
}

function loadRegister() {

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

    if(registerValidation(info)) {
        let xhr = new XMLHttpRequest();
        xhr.open("POST", 'reg', true);
        xhr.send(infoJSON);
        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4) {
                if(xhr.status === 201) {
                    let user = JSON.parse(xhr.responseText);
                    loadLogin();
                }
                else if(xhr.status === 401) {
                    document.getElementById('register-message').innerText = "Invalid Input";
                }
            }
        }
    }
    else document.getElementById('register-message').innerText = "Invalid Input";

}

function loadDashEmp() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashemp.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('amount').onkeyup = setDecimal;
            document.getElementById('create-reimbursement')
                .addEventListener('click', createReimbursement);

            document.getElementById('logout').addEventListener('click', logout);

            let xhr2 = new XMLHttpRequest();
            xhr2.open('GET', 'dashman', true);
            xhr2.send();
            xhr2.onreadystatechange = () => {
                if(xhr2.readyState === 4 && xhr2.status === 200) {
                    let reimbs = JSON.parse(xhr2.responseText);
                    let tag = document.getElementById('reimbursements');
                    

                    empTable(reimbs, tag);
                }
            }
        }
    }
}

function loadDashMan() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashman.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('amount').onkeyup = setDecimal;
            document.getElementById('create-reimbursement')
                .addEventListener('click', createReimbursement);
            document.getElementById('manage-requests')
                .addEventListener('click', loadManage);


            document.getElementById('logout').addEventListener('click', logout);


            let xhr2 = new XMLHttpRequest();
            xhr2.open('GET', 'dashman', true);
            xhr2.send();
            xhr2.onreadystatechange = () => {
                if(xhr2.readyState === 4 && xhr2.status === 200) {
                    let reimbs = JSON.parse(xhr2.responseText);
                    let tag = document.getElementById('reimbursements');
                    empTable(reimbs, tag);
                }
            }
        }
    }
}

function loadManage () {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'manage.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('logout').addEventListener('click', logout);
            document.getElementById('back').addEventListener('click', loadDashMan);

            let xhr2 = new XMLHttpRequest();
            xhr2.open('GET', 'reimb', true);
            xhr2.send();
            xhr2.onreadystatechange = () => {
                if(xhr2.readyState === 4 && xhr2.status === 200) {
                    let reimbs = JSON.parse(xhr2.responseText);
                    let tag = document.getElementById('manage');
                    document.getElementById('status-sort').addEventListener('click', function () {manstatusSort(reimbs, tag)});
                    document.getElementById('id-sort').addEventListener('click', function () {manuserSort(reimbs, tag)});
                    manTable(reimbs, tag);
                }
            }
        }
    }
}

function setDecimal (e)  {
    this.value = parseFloat(parseFloat(this.value).toFixed(2));
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
        let rescol = document.createElement('td');
        let receiptcol = document.createElement('td');
        let typecol = document.createElement('td');
        let statuscol = document.createElement('td');


        let id = (arr[i])['id'];
        let amount = (arr[i])['amount'];
        let desc = (arr[i])['description'];
        let time = (arr[i])['submitTime'];
        let minute = time.minute;
        let pad = '';
        if(minute < 10) pad = '0';
        let subt = `${time.monthValue}/${time.dayOfMonth}/${time.year} ${time.hour}:${pad}${minute}`;
        let rtime = (arr[i])['resolveTime'];
        let rest;
        if(rtime != null) {
            let rminute = rtime.minute;
            let rpad = '';
            if(rminute < 10) rpad = '0';
            rest = `${rtime.monthValue}/${rtime.dayOfMonth}/${rtime.year} ${rtime.hour}:${rpad}${rminute}`;
        } else rest = '-----';
        let res = (arr[i])['resolveId'];
        let receipt = '-------';
        /*
        if(arr[i]['receipt'] != null) {
            let receiptbin = (arr[i])['reciept'];
            receipt = "data:image/jpeg;base64," + hexToBase64(receiptbin);
            console.log(reciept)

        } else receipt = '-----';
        */
        let type = (arr[i])['type'];
        let status = (arr[i])['status'];
        
        idcol.innerText = id;
        amountcol.innerText = amount;
        desccol.innerText = desc;
        subtimecol.innerText = subt;
        restimecol.innerText = rest;
        rescol.innerText = res;
        if(arr[i]['receipt'] != null) {
            receiptcol.innerHTML = '(BLOB)';
        }
        else receiptcol.innerHTML = receipt;
        typecol.innerText = type;
        statuscol.innerText = status;

        if(status == 'APPROVED') statuscol.setAttribute('class', 'approved');
        else if(status == 'DENIED') statuscol.setAttribute('class', 'denied');
        else statuscol.setAttribute('class', 'pending');

        row.appendChild(idcol);
        row.appendChild(amountcol);
        row.appendChild(desccol);
        row.appendChild(subtimecol);
        row.appendChild(restimecol);
        row.appendChild(rescol);
        row.appendChild(receiptcol);
        row.appendChild(typecol);
        row.appendChild(statuscol);

        tag.appendChild(row);
    }
}

function hexToBase64(str) {
    return btoa(String.fromCharCode.apply(null, str.replace(/\r|\n/g, "").replace(/([\da-fA-F]{2}) ?/g, "0x$1 ").replace(/ +$/, "").split(" ")));
}

function manTable(arr, tag) {
    let elements = document.getElementsByClassName('table-entry');
    while(elements.length > 0){
        elements[0].parentNode.removeChild(elements[0]);
    }

    for(let i = 0; i < arr.length; i++) {

        let row = document.createElement('tr');
        row.setAttribute('id', ('row-'+i));
        row.setAttribute('class', 'table-entry');

        let idcol = document.createElement('td');
        let amountcol = document.createElement('td');
        let desccol = document.createElement('td');
        let authcol = document.createElement('td');
        let subtimecol = document.createElement('td');
        let rescol = document.createElement('td');
        let restimecol = document.createElement('td');
        let receiptcol = document.createElement('td');
        let typecol = document.createElement('td');
        let statuscol = document.createElement('td');
        let approvecol = document.createElement('td');
        let denycol = document.createElement('td');


        let time = (arr[i])['submitTime'];
        let minute = time.minute;
        let pad = '';
        if(minute < 10) pad = '0';
        let subt = `${time.monthValue}/${time.dayOfMonth}/${time.year} ${time.hour}:${pad}${minute}`;

        let rtime = (arr[i])['resolveTime'];
        let rest;
        if(rtime != null) {
            let rminute = rtime.minute;
            let rpad = '';
            if(rminute < 10) rpad = '0';
            rest = `${rtime.monthValue}/${rtime.dayOfMonth}/${rtime.year} ${rtime.hour}:${rpad}${rminute}`;
        } else rest = '-----';
        
        let receipt;
        if(arr[i]['receipt'] != null) {
            receipt = generateReceiptModal((arr[i])['reciept']);
        } else receipt = '-----';
        
        idcol.innerText = arr[i]['id'];
        amountcol.innerText = arr[i]['amount'];
        desccol.innerText = arr[i]['description'];
        authcol.innerText = arr[i]['submitId'];
        subtimecol.innerText = subt;
        rescol.innerText = arr[i]['resolveId'];
        restimecol.innerText = rest;
        receiptcol.innerText = receipt;
        typecol.innerText = arr[i]['type'];
        statuscol.innerText = arr[i]['status'];

        if(statuscol.innerText == 'APPROVED') statuscol.setAttribute('class', 'approved');
        else if(statuscol.innerText == 'DENIED') statuscol.setAttribute('class', 'denied');
        else statuscol.setAttribute('class', 'pending');

        
        if(statuscol.innerText == 'PENDING') {
            approvecol.innerText = 'Approve';
            denycol.innerText = 'Deny';
            approvecol.setAttribute('class', 'approve-button');
            denycol.setAttribute('class', 'deny-button');
            approvecol.addEventListener('click', function () { approveReimbursement(arr[i]['id']); });
            denycol.addEventListener('click', function () { denyReimbursement(arr[i]['id']); });
        }
        
        row.appendChild(idcol);
        row.appendChild(amountcol);
        row.appendChild(desccol);
        row.appendChild(authcol);
        row.appendChild(subtimecol);
        row.appendChild(rescol);
        row.appendChild(restimecol);
        row.appendChild(receiptcol);
        row.appendChild(typecol);
        row.appendChild(statuscol);
        row.appendChild(approvecol);
        row.appendChild(denycol);

        tag.appendChild(row);
    }

}

function generateReceiptModal(receipt) {
    let subj = BlobToImage(receipt);
    let elt = `
    <div id="myModal" class="modal">
        <span class="close">&times;</span>
        <img class="modal-content" id="img01">
        <div id="caption"></div>
    </div>
    `
}

function BlobToImage(blob) {

}

function util(a) {

}

function createReimbursement() {
    let amount = parseFloat(document.getElementById('amount').value);
    let description = document.getElementById('description').value;
    let type = document.getElementById('type').value;
    let file = document.getElementById('receipt').files[0];

    let fileReader = new FileReader();

    fileReader.onload = function () {
        receipt = fileReader.result;

        let reimb = {
            amount:amount,
            description:description,
            type:type,
            receipt:receipt
        }
        let reimbJSON = JSON.stringify(reimb);
    
        let xhr = new XMLHttpRequest();
        xhr.open("POST", 'reimb', true);
        xhr.send(reimbJSON);
        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4) {
                if(xhr.status === 200) {
                    let role = JSON.parse(xhr.responseText);
                    if(role == 1) {
                        loadDashEmp();
                    }
                    else {
                        loadDashMan();
                    }
                }
            }
        }
    }
    if(file != null) {
        fileReader.readAsBinaryString(file);
    }
    else {
        let reimb = {
            amount:amount,
            description:description,
            type:type,
            receipt:null
        }
        let reimbJSON = JSON.stringify(reimb);
    
        let xhr = new XMLHttpRequest();
        xhr.open("POST", 'reimb', true);
        xhr.send(reimbJSON);
        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4) {
                if(xhr.status === 200) {
                    let role = JSON.parse(xhr.responseText);
                    if(role == 1) {
                        loadDashEmp();
                    }
                    else {
                        loadDashMan();
                    }
                }
            }
        }
    }
}


function approveReimbursement(id) {

    let dto = {
        id:id,
        status:"approve"
    };

    let dtoJSON = JSON.stringify(dto);

    let xhr = new XMLHttpRequest();
    xhr.open("PUT", 'reimb', true);
    xhr.send(dtoJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                loadManage();
            }
        }
    }
}

function denyReimbursement(id) {

    let dto = {
        id:id,
        status:"deny"
    };

    let dtoJSON = JSON.stringify(dto);

    let xhr = new XMLHttpRequest();
    xhr.open("PUT", 'reimb', true);
    xhr.send(dtoJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            if(xhr.status === 200) {
                loadManage();
            }
        }
    }
}

function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'auth', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
        loadLogin();
        }
    }
}

function registerValidation(info) {
    let username = info.username;
    let password = info.password;
    let firstname = info.firstname;
    let lastname = info.lastname;
    let email = info.email;

    let nameregex = /^[a-zA-Z\-]+$/;
    if(!firstname.match(nameregex)){
        return false;
    }

    if(!lastname.match(nameregex)){
        return false;
    }

    let usernameregex = /^[a-zA-Z0-9\-\!\@\#\$\%\^\&\*]+$/;
    if(!username.match(usernameregex)) {
        return false;
    }

    let passwordregex = /^[a-zA-Z0-9\-\!\@\#\$\%\^\&\*]+$/;

    if(!password.match(passwordregex)) {
        return false;
    }

    let emailregex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(!email.match(emailregex)){
        return false;
    }

    return true;
}

function statusCompare(a, b) {

    if(a.status == "PENDING" && b.status ==  "APPROVED") {
        return -1;
    } else if(a.status == "PENDING" && b.status == "DENIED") {
        return -1;
    }else if(a.status == "DENIED" && b.status == "APPROVED") {
        return -1
    }else return 1;
}

function userCompare(a,b) {
    return (a.submitId - b.submitId)
}

function empstatusSort(arr, tag) {
    arr.sort(statusCompare);
    empTable(arr, tag);
}

function manstatusSort(arr, tag) {
    arr.sort(statusCompare);
    manTable(arr, tag);
}

function manuserSort(arr, tag) {
    arr.sort(userCompare);
    manTable(arr, tag)
}