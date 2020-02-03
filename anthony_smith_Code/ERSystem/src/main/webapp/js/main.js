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
              //  document.getElementById('login-message').innerText = 'Invaild Credentials';
                alert('Invaild Credentials')
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
            document.getElementById('refreshReimb').addEventListener('click', loadManagerView)

            document.getElementById('logout').addEventListener('click', logout);
            loadMangerReimb()

        
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
            reimburseListsManager(reimbursements)
            


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
         document.getElementById('submitR').addEventListener('click', createReimb)
         document.getElementById('refreshReimb').addEventListener('click', loadUserView)
         document.getElementById('logout').addEventListener('click', logout);

            
            loadUserReimb()
           
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

            reimburseLists(reimbursements)
        }
        
    }   
}


function createReimb() {
    let reimb = getNewReimb()
    
    let xhr = new XMLHttpRequest();
    xhr.open("POST", 'reimbursement', true);
    xhr.send(reimb);        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log('in createReimb!')
            alert('Reimbursemnt Submitted')
        }               
    } 
}

function getNewReimb () { 
    let obj = {
            
        amount: document.getElementById('reimbamount').value,
        description: document.getElementById('reimbDesc').value,
        reimbursementTypeId: parseInt(document.getElementById('reimbType').value)
    
    }
    console.log(obj)
    return JSON.stringify(obj);
}




function insertTableData(){
    var table = document.getElementById("mangerTable");
    var row = table.insertRow(0);
    
}

function reimburseLists(reimbursements){
    let table = document.getElementById('reimInfo');
    let info
    for(let i = 0; i < reimbursements.length; i++) {
        info = document.createElement('tr');
  
    
              let te = ( `
               <th>${reimbursements[i].id}</th>
                <td>${reimbursements[i].amount}</td>
                <td>${reimbursements[i].timeSubmitted}</td>
                <td>${reimbursements[i].description}</td>                
                <td>${reimbursements[i].recepit}</td>   
                <td>${reimbursements[i].authorById}</td>
                <td>${reimbursements[i].resolverById}</td>
                <td>${reimbursements[i].reimbursementStatusId}</td>
                <td>${reimbursements[i].reimbursementTypeId}</td>
               
                
                `
              )
    info.innerHTML = te;
    table.appendChild(info);
    }
    
}

function reimburseListsManager(reimbursements){
    let table = document.getElementById('reimInfo');
    let info
    for(let i = 0; i < reimbursements.length; i++) {
        info = document.createElement('tr');
  
    
              let te = ( `
               <th>${reimbursements[i].id}</th>
                <td>${reimbursements[i].amount}</td>
                <td>${reimbursements[i].timeSubmitted}</td>
                <td>${reimbursements[i].description}</td>
                <td>${reimbursements[i].authorById}</td>
                <td>${reimbursements[i].reimbursementStatusId}</td>
                <td>${reimbursements[i].reimbursementTypeId}</td>
                <td>
                <button class = "button1" onclick = "update(${reimbursements[i].reimbursementStatusId}, 1)">Approve</button>
                <button class = "button2" onclick = "update(${reimbursements[i].reimbursementStatusId}, 2)">Deny</button>
                </td>
                `
              )
    info.innerHTML = te;
    table.appendChild(info);
    }
    
}


function logout() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('logout successful!')
            loadLogin()
        }
    }
}




