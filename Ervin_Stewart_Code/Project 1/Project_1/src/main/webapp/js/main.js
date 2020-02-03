window.onload = () =>{
    loadLogin();
    document.getElementById('logout').addEventListener('click',logout);
    document.getElementById('register').addEventListener('click',loadRegister);
 }

    function loadLogin(){


        console.log('in loadLogin()');


        let xhr = new XMLHttpRequest();
        xhr.open(GET,'login.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                document.getElementById("login").addEventListener("click", login);
            }
        }


    }

    function loadRegister(){


        console.log('in loadRegister()');


        let xhr = new XMLHttpRequest();
        xhr.open(GET,'registerscreen.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                document.getElementById("register-submit").addEventListener("click", register);
            }
        }


    }

    function loadDashboard(){


        console.log('in loadDashboard()');


        let xhr = new XMLHttpRequest();
        xhr.open(GET,'dashboard.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                 document.getElementById("logout").addEventListener("click", logout);
                document.getElementById("dashboard").addEventListener("click", loadDashboard);
                //document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                //document.getElementById("help").addEventListener("click", loadHelpScreen);

            }
        }


    }

    function loadReimbursement(){


        console.log('in loadReimbursement()');


        let xhr = new XMLHttpRequest();
        xhr.open(GET,'reimbursement.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                 document.getElementById("logout").addEventListener("click", logout);
                document.getElementById("dashboard").addEventListener("click", loadDashboard);
                //document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                //document.getElementById("help").addEventListener("click", loadHelpScreen);

            }
        }


    }

    function loadloadHelpScreen(){


        console.log('in loadDashboard()');


        let xhr = new XMLHttpRequest();
        xhr.open(GET,'dashboard.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                 document.getElementById("logout").addEventListener("click", logout);
                document.getElementById("dashboard").addEventListener("click", loadDashboard);
                //document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                //document.getElementById("help").addEventListener("click", loadHelpScreen);

            }
        }


    }



    function register(){


        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        let firstName = document.getElementById('firstname').value;
        let lastName = document.getElementById('lastname').value;
        let email = document.getElementById('email').value

    let newUser = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email
    };
    let userJSON =JSON.stringify(newUser);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'users', true);
    xhr.send(userJSON)
    xhr.onreadystatechange = () => {
        if(xhr.readyState ===4){
             if(xhr.status===200){

                let user = JSON.parse(xhr.responseText);
                    console.log(user);
                    // loadDashboard();

                }

                if (xhr.status === 401) {
                    document.getElementById('login-message').innerText = 'Login failed!';
                }
            }
        }

}


    function login(){


        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;

    let creds = {
        username: username,
        password: password
    };
    let credJSON =JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON)
    xhr.onreadystatechange = () => {
        if(xhr.readyState ===4){
             if(xhr.status===200){

                let user = JSON.parse(xhr.responseText);
                    console.log(user);
                    // loadDashboard();

                }

                if (xhr.status === 401) {
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

    function setValues(reimbSet){
        let reimbId = reimbSet.reimbId;
        let amount = reimbSet.amount;
        let submittedDate = reimbSet.submittedDate;
        let type = reimbSet.type;
        let status = reimbSet.status;
        let description = reimbSet.description;
        let receipt = reimbSet.receipt;
        let resolverId = reimbSet.resolverId;
        let authorId = reimbSet.authorId;
        let resolvedDate = reimbSet.resolvedDate;


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

        if(reimbStatus === 'pending'){
        let updatedStatusCell = document.createElement('td');
        let submitCell = document.createElement('td');

            let submitElement = document.createElement("button").setAttribute('id',reimbSubmit)
            let reimbursementOptionsElement = `
            <select id='newStatus'>
                            <option selected value="3">Pending</option>
                            <option  value="2">Approved</option>
                            <option value="1">Denied</option>
                        </select>
            `;

            let labelReimbStatus = document.createElement("label");
            labelReimbStatus.setAttribute("for", "select-options");
            labelReimbStatus.innerHTML = reimbursementOptionsElement;

            let submitElement = `<button class="btn btn-outline-primary" id="reimbSubmit" >Submit</button>`;
            let labelReimbSubmit = document.createElement("label");
            labelReimbSubmit.setAttribute("for", "#reimbSubmit");
            labelReimbSubmit.innerHTML = submitElement;

            row.appendChild(updatedStatusCell);
            row.appendChild(submitCell);
            updatedStatusCell.innerText = labelReimbStatus;
            submitCell.innerText = labelReimbSubmit;

        }

            row.appendChild(reimbIdCell);
            row.appendChild(typeCell);
            row.appendChild(statusCell);
            row.appendChild(totalAmountCell);
            row.appendChild(dateCreatedCell);
            row.appendChild(authorCell)
            row.appendChild(resolvedDateCell);
            row.appendChild(descriptionCell);
            row.appendChild(receiptCell);
            row.appendChild(resolverCell);
            row.appendChild(authorIdCell);

            document.getElementsById('open-reimb')[0].appendChild(row);

            reimbIdCell.innerText = reimbId;
            typeCell.innerText = type;
            statusCell.innerText = status;
            totalAmountCell.innerText = amount;
            dateCreatedCell.innerText = submittedDate;
            resolvedDateCell.innerText =  resolvedDate;
            descriptionCell.innerText = description;
            receiptCell.innerText = receipt;
            resolverCell.innerText = resolverId;
            authorIdCell.innerText =authorId;



    }
