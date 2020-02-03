window.onload = () =>{
    loadLogin();
     }
 var rows =0;
let currentUser ={};
    function loadLogin(){


        console.log('in loadLogin()');


        let xhr = new XMLHttpRequest();
        xhr.open('GET','login.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                document.getElementById("login").addEventListener("click", login);
                document.getElementById('register').addEventListener('click',loadRegister);

            }
        }


    }

    function loadRegister(){


        console.log('in loadRegister()');


        let xhr = new XMLHttpRequest();
        xhr.open('GET','registerscreen.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                document.getElementById("register-sub").addEventListener("click", register);
            }
        }


    }

    function loadDashboard(){


        console.log('in loadDashboard()');
        createManagerReimbursementTable();
        setTimeout(()=>{
            console.log("the rows are " +rows + " after the 5000 miliseconds")
            accesstable();

        }, 5000);



        let xhr = new XMLHttpRequest();
        xhr.open('GET','dashboard.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                 document.getElementById("logout").addEventListener("click", logout);
                document.getElementById("dashboard").addEventListener("click", loadDashboard);
                document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                document.getElementById("help").addEventListener("click", loadHelpScreen);
                document.getElementById('reimbSubmit').addEventListener("click",updateReimb);
console.log( 'the row lenght is ' + rows);

            }
        }
console.log('please' +rows);

    }


    function loadEmployeeDashboard(){


            console.log('in loadEmployeeDashboard()');
            createEmployeeReimbursementTable();



            let xhr = new XMLHttpRequest();
            xhr.open('GET','employee_dashboard.view',true);
            xhr.send();
            xhr.onreadystatechange = () =>{
                if(xhr.readyState === 4 && xhr.status ===200){
                    document.getElementById("root").innerHTML = xhr.responseText;
                    //implement all button functionality
                     document.getElementById("logout").addEventListener("click", logout);
                    document.getElementById("dashboard").addEventListener("click", loadDashboard);
                    document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                    document.getElementById("help").addEventListener("click", loadHelpScreen);

    console.log( 'the row lenght is ' + rows);

                }
            }
    console.log('please' +rows);

        }



    function loadReimbursement(){


        console.log('in loadReimbursement()');


        let xhr = new XMLHttpRequest();
        xhr.open('GET','reimbursement.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                document.getElementById('reimb-sub').addEventListener('click',newReimbursement);
                 document.getElementById("logout").addEventListener("click", logout);
                document.getElementById("dashboard").addEventListener("click", loadDashboard);
                document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                document.getElementById("help").addEventListener("click", loadHelpScreen);

            }
        }


    }

    function loadHelpScreen(){


        console.log('in loadDashboard()');


        let xhr = new XMLHttpRequest();
        xhr.open('GET','help.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                 document.getElementById("logout").addEventListener("click", logout);
                document.getElementById("dashboard").addEventListener("click", loadDashboard);
                document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                document.getElementById("help").addEventListener("click", loadHelpScreen);

            }
        }


    }



    function register(){


        let username = document.getElementById('r_username').value;
        let password = document.getElementById('r_password').value;
        let firstName = document.getElementById('firstname').value;
        let lastName = document.getElementById('lastname').value;
        let email = document.getElementById('email').value;

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
    xhr.send(userJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState ===4){
             if(xhr.status===201){

                let user = JSON.parse(xhr.responseText);
                    console.log(user);
                    loadDashboard();

                }

                if (xhr.status === 409) {
                    document.getElementById('login-message').innerText = 'Login failed!';
                }
            }
        }

    }


function newReimbursement(){


        let new_amount = document.getElementById('new-amount').value;
        let new_description = document.getElementById('new-description').value;
        let new_type = document.getElementById('new-reimb-type').value;

    let newReimb = {
        amount: new_amount,
        description: new_description,
        type: new_type,
        };
    let reimbJSON =JSON.stringify(newReimb);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'reimbursements', true);
    xhr.send(reimbJSON);
    xhr.onreadystatechange = () => {
        if(xhr.readyState ===4){
             if(xhr.status===201){


                    document.getElementById('reimb-message').innerText ='reimbursement created!';
                    console.log(newReimb);
                    if(currentUser.role === "FINANCE_MANAGER" || currentUser === "CFO"){
                                        loadDashboard();
                                        }else{
                                        loadEmployeeDashboard();

                                    }

                }

                if (xhr.status === 409) {
                    document.getElementById('reimb-message').innerText = 'reimbursement created unsuccessfully!';
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
                 currentUser = user;
                    console.log(currentUser);
                    if(currentUser.role === "FINANCE_MANAGER" || currentUser === "CFO"){
                    loadDashboard();
                    }else{
                    loadEmployeeDashboard();

                }

                if (xhr.status === 401) {
                    document.getElementById('login-message').innerText = 'Login failed!';
                }
            }
        }

}}


function logout() {
        let xhr = new XMLHttpRequest();
        xhr.open('GET', 'auth', true);
        xhr.send();
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                loadLogin();
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
            totalAmountCell.innerText = amount;
            dateCreatedCell.innerText = submittedDate;
            resolvedDateCell.innerText =  resolvedDate;
            descriptionCell.innerText = description;
            receiptCell.innerText = receipt;
            resolverCell.innerText = resolverId;
            authorIdCell.innerText =authorId;


            document.getElementById('open-reimb').appendChild(row);





    }

    function createManagerReimbursementTable(){

            let xhttp = new XMLHttpRequest();
            xhttp.open("GET", 'reimbursements', true);
            xhttp.send();
            xhttp.onreadystatechange = function(){

            if(xhttp.readyState == 4 && xhttp.status == 200){
                let reimbSet = JSON.parse(xhttp.responseText);
                    console.log(reimbSet);
                for(let i = 0;i<reimbSet.length; i++ ){
            setValues(reimbSet[i]);
                }
                rows = reimbSet.length;
                console.log( 'the row length is' + rows);


        }
        }
}
function accesstable(){

                let table = document.getElementById('open-reimb');

                                        for(let i =1; i< rows; i++){
                                                table.rows[i].onclick = function(){
                                                    document.getElementById('reimb-id').value = this.cells[0].innerHTML;
                                                    document.getElementById('amount').value = this.cells[3].innerHTML;
                                            }

                                        }

                }


        function updateReimb(){
        let reimbId = document.getElementById('reimb-id').value;
        let newStatus = document.getElementById('newStatus').value;


            let updatedReimb = {
                reimbId: reimbId,
                status: newStatus
            };
            let uReimbJSON =JSON.stringify(updatedReimb);

            let xhr = new XMLHttpRequest();
            xhr.open('PUT', 'reimbursements', true);
            xhr.send(uReimbJSON);
            xhr.onreadystatechange = () => {
                if(xhr.readyState ===4){
                     if(xhr.status===201){


                            loadDashboard();

                        }

                        if (xhr.status === 401) {

                        }
                    }
                }



        }

        function setEmployeeValues(reimbSet){
                let reimbId = reimbSet.reimbId;
                let amount = reimbSet.amount;
                let submittedDate = reimbSet.submittedDate;
                let type = reimbSet.type;
                let status = reimbSet.status;
                let description = reimbSet.description;
                let receipt = reimbSet.receipt;
                let resolverId = reimbSet.resolverId;
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



                    row.appendChild(reimbIdCell);//1
                    row.appendChild(typeCell);//2
                    row.appendChild(statusCell);//3
                    row.appendChild(totalAmountCell);//4
                    row.appendChild(dateCreatedCell);//5
                    row.appendChild(descriptionCell);//7
                    row.appendChild(receiptCell);//8
                    row.appendChild(resolverCell);//9
                    row.appendChild(resolvedDateCell);//6




                    reimbIdCell.innerText = reimbId;
                    typeCell.innerText = type;
                    statusCell.innerText = status;
                    totalAmountCell.innerText = amount;
                    dateCreatedCell.innerText = submittedDate;
                    resolvedDateCell.innerText =  resolvedDate;
                    descriptionCell.innerText = description;
                    receiptCell.innerText = receipt;
                    resolverCell.innerText = resolverId;



                    document.getElementById('open-reimb').appendChild(row);





            }

            function createEmployeeReimbursementTable(){

                    let xhttp = new XMLHttpRequest();
                    xhttp.open("GET", 'reimbursements', true);
                    xhttp.send();
                    xhttp.onreadystatechange = function(){

                    if(xhttp.readyState == 4 && xhttp.status == 200){
                        let reimbSet = JSON.parse(xhttp.responseText);
                            console.log(reimbSet);
                        for(let i = 0;i<reimbSet.length; i++ ){
                            setEmployeeValues(reimbSet[i]);
                        }
                        rows = reimbSet.length;
                        console.log( 'the row length is' + rows);


                }
                }
        }