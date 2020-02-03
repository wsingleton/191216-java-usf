
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
                document.getElementById('refreshReimb').addEventListener('click', loadManagerView)
                document.getElementById('logout').addEventListener('click', logout)
                loadEmployeeReimb()
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


function updateStatus(reimb_id, status) {
            
    let obj = {
            
        id: reimb_id,
        status_id: status
            
    }
    
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        
        if(xhr.readyState == 4 && xhr.status == 200) {
            

            refreshStatus();
            
        }
        
    }
    
    xhr.open("PUT", "login", true);
    xhr.setRequestHeader("Content-type", "application/json");
    let toSend = JSON.stringify(stat);
    xhr.send(toSend);
    
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
                <td>${reimbursements[i].resolverById}</td>
                <td>${reimbursements[i].reimbursementStatusId}</td>
                <td>${reimbursements[i].reimbursementTypeId}</td>
                `
              )
    info.innerHTML = te;
    table.appendChild(info);
    }
    
}




	
