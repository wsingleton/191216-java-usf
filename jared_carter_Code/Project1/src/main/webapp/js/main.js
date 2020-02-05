
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
    xhr.open('POST', 'auths', true);
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
                document.getElementById('failed-login-message').innerText = 'Username or password is incorrect';
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
                document.getElementById('refreshReimb').addEventListener('click', loadManagerView)
                document.getElementById('logout').addEventListener('click', logout)
                loadManagerReimb()
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
             
             document.getElementById('submitReimb').addEventListener('click', createReimb, loadEmployeeView)
             document.getElementById('refreshReimb').addEventListener('click', loadEmployeeView)
             document.getElementById('logout').addEventListener('click', logout)
            
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
            loadLogin()
        }
    }
}

	
function loadManagerReimb() {
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", 'reimb', true);
    xhr.send();        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log(reimbursements)
            reimburseListsManager(reimbursements)
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
            reimburseLists(reimbursements)
        }
        
    }
    
    
    
}

	
function createReimb() {
    let reimb = getNewReimb()
    
    let xhr = new XMLHttpRequest();
    xhr.open("POST", 'createNew', true);
    xhr.send(reimb);        
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let reimbursements = JSON.parse(xhr.responseText);
            console.log('in createReimb!')
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
                <td>${reimbursements[i].authorById}</td>
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
                `
              )
                

    

    let buttonentry = document.createElement('td');
    

    let approve = document.createElement('button');
    let deny = document.createElement('button');
    approve.setAttribute('id', 'approve-button');
    deny.setAttribute('id', 'deny-button');
    approve.innerText = 'approve';
    deny.innerText = 'deny';


    approve.addEventListener('click', () => {approveReimb(reimbursements[i].id)});
    deny.addEventListener('click', () => {denyReimb(reimbursements[i].id)});


    buttonentry.appendChild(approve);
    buttonentry.appendChild(deny);

    

    info.innerHTML = te;

    info.appendChild(buttonentry);
            
    table.appendChild(info);
    }
    
}

function approveReimb(id){
    let dto = {
        id:id,
        status:2
    };
    let dtoJSON = JSON.stringify(dto)
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'reimb', true)
    xhr.send(dtoJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            loadManagerView();
        }
    }
}

function denyReimb(id){
    let dto = {
        id:id,
        status:3
    };
    let dtoJSON = JSON.stringify(dto)
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'reimb', true)
    xhr.send(dtoJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            loadManagerView();
        }
    }
}
	
