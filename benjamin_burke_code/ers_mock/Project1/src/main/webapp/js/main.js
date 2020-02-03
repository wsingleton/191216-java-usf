
window.onload = () => {
    console.log('homescreen loaded?');
    loadHome();


}

function loadHome() {

    console.log('in loadHome');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'home.view', true);
    xhr.send();
    xhr.onreadystatechange =() => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('home-login').addEventListener('click', loadLogin);
            document.getElementById('home-register').addEventListener('click', loadRegister);
        }
    }
}


//-------------------------------Login---------------------------------------------

function loadLogin() {

    console.log('in loadLogin');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener('click', function(event){
                event.preventDefault();
                login();
            });

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
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {

                let user = JSON.parse(xhr.responseText);
                console.log(user)
                                console.log(user.id)
                // make it set authId

                // create an if else statement for manager vs employee
                if(user.role==="EMPLOYEE"){
                       loadDashboard(user);
                }else{
                    loadManager(user);
                }

                console.log(user);

            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Login failed!';
            }
        }
    }
}


//-----------------------------------Register--------------------------------



function loadRegister() {

    console.log('in loadRegister()');

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

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('firstname').value;
    let lastName = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;

    let creds = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email
    };

    let credJSON = JSON.stringify(creds);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'users', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 201 || xhr.status === 200) {
                console.log('test');
                // let user = JSON.parse(xhr.responseText);
                // console.log(user);
                loadDashboard();
            }

            if (xhr.status === 401) {
                document.getElementById('register-message').innerText = 'Username is taken';
            }
        }
    }
}


//-------------------------------Dashboard EMPLOYEE-------------------------------------




function loadDashboard(user) {

    console.log(user)
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'dashboard.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('user').innerHTML = user.username;

            document.getElementById('newreimbbutton').addEventListener('click', () =>{
                loadNew(user);
            });
            document.getElementById('reimbbutton').addEventListener('click', ()=>{
            loadReimb(user);
            });

        }
    }
}



function loadManager(user){
  console.log('in manager dashboard');

     let xhr = new XMLHttpRequest();
     xhr.open('GET', 'manager.view', true);
     xhr.send();
     xhr.onreadystatechange =() => {
         if (xhr.readyState === 4 && xhr.status === 200) {
             document.getElementById('root').innerHTML = xhr.responseText;
//              document.getElementById('man-newreim').addEventListener('click', () =>{
//              loadNewManReq(user);
//               });
               document.getElementById('man-completedreim').addEventListener('click', ()=>{
               loadReimb(user);

               });




         }
     }
 }

 function loadNewManReq(user) {

     console.log('in loadRegister()');

     let xhr = new XMLHttpRequest();
     xhr.open('GET', 'manNewReimb.view', true);
     xhr.send();
     xhr.onreadystatechange = () => {
         if(xhr.readyState === 4 && xhr.status === 200) {
             document.getElementById('root').innerHTML = xhr.responseText;
//             document.getElementById('register').addEventListener('click', register);
         }
     }
 }

 //-------------------------------------EMPLOYEE Reimbursement--------------------------------------

function loadReimb(user){

    console.log('in loadreimb');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'reimb.view', true);
    xhr.send();
    console.log(user.id)
    xhr.onreadystatechange = () =>{
    if (xhr.readyState===4 && xhr.status ===200){
        document.getElementById('root').innerHTML = xhr.responseText;

        getReimbusements(user);

    }
   }
   }






   function getReimbusements(user){

   	let xhttp = new XMLHttpRequest();
   	xhttp.open("GET", 'reimbs', true);
   	xhttp.send(); //step three
   	xhttp.onreadystatechange = function(){

   		if(xhttp.readyState == 4 && xhttp.status == 200){



   			let reimbursement = JSON.parse(xhttp.responseText);
   			 let userReimbursements = { reimbursement }
   			 let reimb = userReimbursements['reimbursement'];

   			 for (let i=0, len=reimb.length; i<len; i++){
   			 console.log(reimb[i])
//   			    console.log(reimb[i].amount)
//   			    console.log(reimb[i].description)
//   			    console.log(reimb[i].status)
//   			    console.log(reimb[i].type)

                let number = i+1;
                let reimbId = reimb[i].id;
                let amount = reimb[i].amount;
                let description = reimb[i].description;
                let status = reimb[i].status;
                let type = reimb[i].type;

                const $tableHead=$('<th>').text('approved')


                const tableRow=$('<tr>')
                tableRow.addClass('tableRowData')
                // number
                const tableCell = $('<td>')
                tableCell.addClass('rank data')
                const $rankOfReim = $('<p>').text(`${number}`)
                tableCell.append($rankOfReim)
                //id
                const tableCell2= $('<td>')
                tableCell2.addClass('id data');
                const $id = $('<p>').text(`${reimbId}`);
                tableCell2.append($id);

                //amount
                const tableCell3= $('<td>')
                tableCell3.addClass('amount data');
                const $amountOfReim = $('<p>').text(`${amount}`);
                tableCell3.append($amountOfReim);
                //description
                const tableCell4 = $('<td>')
                tableCell4.addClass('description data')
                const $desc = $('<p>').text(`${description}`);
                tableCell4.append($desc)
                //status
                const tableCell5 = $('<td>')
                tableCell5.addClass('status data')
                const $status = $('<p>').text(`${status}`);
                tableCell5.append($status)
                //type
                const tableCell6 = $('<td>')
                tableCell6.addClass('type data')
                const $type = $('<p>').text(`${type}`);
                tableCell6.append($type)
                //button
                const tableCell7= $('<td>')
                tableCell7.addClass('managerbtn')
                const $manBtn = $('<btn>').text('Approve?')
                $manBtn.attr('id', `manBtn${i}`)
                tableCell7.append($manBtn)

                //add button if you are manager
                 if(user.role==="EMPLOYEE"){
                 tableRow.append(
                 tableCell,
                 tableCell2,
                 tableCell3,
                 tableCell4,
                 tableCell5,
                 tableCell6
                 )
                 $('.a').append(tableRow)
                 }else{
//                 $tableHead.append($('#column-names'))

                 tableRow.append(

                    tableCell,
                    tableCell2,
                    tableCell3,
                    tableCell4,
                    tableCell5,
                    tableCell6,
                    tableCell7
                 )
                  $('.a').append(tableRow)
                  document.getElementById(`manBtn${i}`).addEventListener('click', ()=>{
                    loadEdit(user, reimbId, amount, description, status, type)
                  })

                  

   			  }
            }//end of the for loop
           }
       	}
   	}

function loadEdit(user, reimbId, amount, description, status, type ){



    console.log('in loadEdit()');
    console.log(reimbId)

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'edit.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;



//            editReimbusement(reimbId, amount, description, status, type)
             let creds = {
                        id: reimbId,
                        amount: amount,
                        description: description,
                        status: status,
                        type: type
                    };

                    let credJSON = JSON.stringify(creds);

                    let xhr2 = new XMLHttpRequest();
                    xhr2.open('POST', 'userreimb', true);

                    xhr2.send(credJSON);
                    xhr2.onreadystatechange = () => {
                        if (xhr2.readyState === 4) {
                            if (xhr2.status === 201 || xhr2.status === 200) {
                              document.getElementById('root').innerHTML = xhr.responseText;
                              document.getElementById('reimbId').innerHTML = creds.id;
                              document.getElementById('reimbamount').innerHTML = creds.amount;
                              document.getElementById('reimbdescription').innerHTML = creds.description;
//                              document.getElementById('reimtype').innerText = creds.type

                               document.getElementById('accept').addEventListener('click', (e)=>{

                                                   e.preventDefault();
                                                   let data = {
                                                     id: reimbId,
                                                     amount: amount,
                                                     description: description,
                                                     status: status,
                                                     type: type

                                                   }
                                                   let dataJSON = JSON.stringify(data);
                                                   let xhr = new XMLHttpRequest();
                                                   xhr.open('PUT', 'approve', true);
                                                   xhr.send(dataJSON);
                                                   xhr.onreadystatechange=()=>{
                                                    if(xhr.onreadystatechange===4 && xhr.status===201){
                                                    console.log('clicked ' + dataJSON )

                                                    }
                                                    loadManager(user);
                                                   }
                                                 })
                               document.getElementById('deny').addEventListener('click', (e)=>{
                                                    e.preventDefault();
                                                    let data = {
                                                      id: reimbId,
                                                      amount: amount,
                                                      description: description,
                                                      status: status,
                                                      type: type

                                                    }
                                                    let dataJSON = JSON.stringify(data);
                                                    let xhr = new XMLHttpRequest();
                                                    xhr.open('PUT', 'deny', true);
                                                    xhr.send(dataJSON);
                                                    xhr.onreadystatechange=()=>{
                                                     if(xhr.onreadystatechange===4 && xhr.status===201){
                                                     console.log('clicked ' + dataJSON )
                                                         loadManager();
                                                     }
                                                    }
                                                 })


                                console.log('test');
                                console.log(creds.type)
                            }

                        }
                    }
                  }
            }
        }

function loadNew(user) {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'new.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('newreimb').addEventListener('click', ()=> {
                newReimbursement(user);
            });
            }
    }
}

function newReimbursement(user) {

    let amount = document.getElementById('amount').value;
    let select = document.getElementById('type');
    let type = select.options[select.selectedIndex].value;
    let description = document.getElementById('description').value;


    let reimbs = {
        amount: parseInt(amount),
        description: description,
        authorId: user.id,
        type: parseInt(type)

    };

    let reimbsJSON = JSON.stringify(reimbs);
    console.log(reimbsJSON);

    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'reimbs', true);
    xhr.send(reimbsJSON);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 201 || xhr.status === 200) {

                // let newReimb = JSON.parse(xhr.responseText);
                // console.log(newReimb);
                loadDashboard(user);
            }

            if (xhr.status === 401) {
                document.getElementById('reimb-message').innerText = 'New Submission Failed!';
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
            console.log('Logout successful!');
        }
    }

    loadHome();
}



