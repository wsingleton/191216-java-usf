window.onload = () => {
    loadLogin();

}
let user = [];

function loadLogin() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', "login.view", true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
            document.getElementById("login").addEventListener("click", login);
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
    xhr.open('POST', "auth", true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let user = JSON.parse(xhr.responseText);
                if (user.role == "MANAGER") {
                    financedash();
                }
                else {
                    loadDashboard();
                }
                console.log(user);
            }
            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Invalid Input: Login failed!';
            }
        }
    }
}

//finance manager
function financedash() {
    console.log('in financedash()');
    let xhr = new XMLHttpRequest();
    xhr.open("GET", 'financeDisplay.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {

        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
            document.getElementById("reimb").addEventListener("click", reimb);
            document.getElementById("logout").addEventListener("click", logout);
            loadManager();
        }
    }
}
//manager loader
function loadManager() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', "reimb", true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let reimbs = JSON.parse(xhr.responseText);
            console.log(reimbs);
            reimburseListsManager(reimbs);
            
        }
    }
}
        //employee dashboard
        function loadDashboard() {
            let xhr = new XMLHttpRequest();
            xhr.open('GET', "dashboard.view", true);
            xhr.send();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("root").innerHTML = xhr.responseText;
                    document.getElementById("reimb").addEventListener("click", createReimb);
                    document.getElementById("refresh").addEventListener("click", loadDashboard);
                    document.getElementById("logout").addEventListener("click", logout);
                    loadEmployee();
                }
            }
        }
    
        //employee
        function loadEmployee() {
            let xhr = new XMLHttpRequest();
            xhr.open('GET', "reimb", true);
            xhr.send();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    let reimbs = JSON.parse(xhr.responseText);
                    console.log(reimbs);
                    reimburstmentList(reimbs);
        
                }
            }
        }

        // function dashboard() {
        //     let dashboard = document.getElementById('dashboard-component"');
        //     document.getElementById("first").innerText = user.first_name;
        //     document.getElementById("last").innerText = user.last_name;
        //     console.log("what is user_id")
        // }

        function getNewReimb(){
           
            let obj = {
                
                amount: document.getElementById('amount').value,
                description: document.getElementById('description').value,
                type: document.querySelector('input[name="type"]:checked').value
            
            
            }
            console.log(obj)
            return JSON.stringify(obj);            
        }

function createReimb() {

    let reimb = getNewReimb()
    console.log(reimb)
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

        function reimburstmentList(reimbs){
            let table = document.getElementById('reimInfo');
            let info
            for(let i = 0; i < reimbs.length; i++) {
                info = document.createElement('tr');
        
                      let te = ( `
                       <th>${reimbs[i].id}</th>
                        <td>${reimbs[i].amount}</td>
                        <td>${reimbs[i].submitted}</td>
                        <td>${reimbs[i].description}</td>
                        <td>${reimbs[i].author}</td>
                        <td>${reimbs[i].status}</td>
                        <td>${reimbs[i].type}</td>
                        `
                      )
            info.innerHTML = te;
            table.appendChild(info);
            }
            
        }

        function reimburseListsManager(reimbs){
            let table = document.getElementById('reimInfo');
            let info
            for(let i = 0; i < reimbs.length; i++) {
                info = document.createElement('tr');
          
            
                      let te = ( `
                       <th>${reimbs[i].id}</th>
                        <td>${reimbs[i].amount}</td>
                        <td>${reimbs[i].submitted}</td>
                        <td>${reimbs[i].description}</td>
                        <td>${reimbs[i].author}</td>
                        <td>${reimbs[i].status}</td>
                        <td>${reimbs[i].type}</td>
                        `
                      )
                        
            
            let buttonentry = document.createElement('td');
            
            let approve = document.createElement('button');
            let deny = document.createElement('button');
            approve.setAttribute('id', 'approve-button');
            deny.setAttribute('id', 'deny-button');
            approve.innerText = 'approve';
            deny.innerText = 'deny';
            approve.addEventListener('click', () => {approveReimb(reimbs[i].id)});
            deny.addEventListener('click', () => {denyReimb(reimbs[i].id)});
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
                status:1
            };
            let dtoJSON = JSON.stringify(dto)
            let xhr = new XMLHttpRequest();
            xhr.open('PUT', 'reimb', true)
            xhr.send(dtoJSON);
            xhr.onreadystatechange = () => {
                if(xhr.readyState === 4 && xhr.status === 200) {
                    console.log(dto);
                    financedash();
                }
            }
        }
        function denyReimb(id){
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
                    console.log(dto);
                    financedash();
                }
            }
        }

        function displayReimb(reim) {
            //reimb data from db
            let reimbs = {
                id: reim.id,
                amount: reim.amount,
                submitted: reim.submitted,
                resolved: reim.resolved,
                description: reim.description,
                author: reim.author,
                resolver: reim.resolver,
                status: reim.status,
                type: reim.type
            };

            let reimbJSON = JSON.stringify(reimbs);
            let reims = [];

            let xhr = new XMLHttpRequest();
            xhr.open('GET', "dashboard", true);
            xhr.send();
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        reims = JSON.parse(xhr.responseText);
                        console.log(reims);

                    }
                    if (xhr.status === 401) {
                        document.getElementById('reimb-message').innerText = 'Submission failed!';
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
                    loadLogin();
                }
            }
        }
