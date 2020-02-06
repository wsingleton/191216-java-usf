window.onload = () => {
    console.log('did the JS load?');
    loadLogin();
}


function loadLogin() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener("click", login);
            document.getElementById('register').addEventListener("click", loadRegister);
        }
    }

}
function loadRegister() {
    console.log('in register()');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'register.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('register1').addEventListener("click", () =>{register()});
        }
    }


}

function register() {
    let username = document.getElementById('username1').value;
    let password = document.getElementById('password1').value;
    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;

    let creds = {
        username: username,
        password: password,
        firstname: firstname,
        lastname: lastname,
        email: email
    };


    let credJSON = JSON.stringify(creds);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'register', true);
    xhr.send(credJSON);
    console.log('sent json');
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            console.log(xhr.status);
            if (xhr.status === 200) {

                let user = JSON.parse(xhr.responseText);
                console.log(user.role);
                // loadDashboard();
                ()=>{loadRegisterSuccess(); }

            }

            if (xhr.status === 201) {

                let user = JSON.parse(xhr.responseText);
                console.log(user);
                // loadDashboard();
                
                ()=>{loadRegisterSuccess(); }

            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'failed!';
            }
        }
    }

}



function getReimb(user) {
    

    console.log('in add Reimb');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'createReimb.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('summit1').addEventListener("click",() => {
                createReimb(user)
            });
            if (user.role === 'MANAGER'){
                document.getElementById('back').addEventListener("click",() => {
                    getMana(user)
                });

            }else{
                document.getElementById('back').addEventListener("click",() => {
                    getEmp(user)
                });
            }
           
        }
    }
}

function createReimb(user) {
    console.log('load create ');
    console.log(user);


    let today = new Date();
    let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    let dateTime = date + ' ' + time;


    
    let amount = document.getElementById('amount').value;
    let subTime = dateTime;
    let resTime = "123";
    let desc = document.getElementById('description').value;
    let receipt = "123"; 
    let authId = user.id;
    let resolver = 2;
    let statusID = 1;
    let typeId = document.getElementById('type').value;

    let creds = {
        amount: amount,
        subTime: subTime,
        resTime: resTime,
        desc: desc,
        receipt: receipt,
        authId: authId,
        resolver: resolver,
        statusID: statusID,
        typeId: typeId

    };
    console.log(creds);

    let credJSON = JSON.stringify(creds);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'createReimb', true);
    xhr.send(credJSON);
    console.log('sent json');
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            console.log(xhr.status);
            if (xhr.status === 200) {

                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb.desc);
                if(user.id === 1){
                    getMana(user);
                }else{
                    getEmp(user);
                }

            }
            if (xhr.status === 201) {

                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb.desc);
                // loadDashboard();
                if(user.id === 1){
                    getMana(user);
                }else{
                    getEmp(user);
                }
               

            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = ' failed!';
            }
            if (xhr.status === 400) {
                document.getElementById('login-message').innerText = 'failed!';
            }
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
                console.log(user.role);
                // loadDashboard();
                if (user.role === 'MANAGER') {

                    getMana(user);
                }
                else {

                    getEmp(user);
                }


            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'Login failed!';
            }
        }
    }

}

function loadRegisterSuccess() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'registerSuccess.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener("click", loadLogin);
        }
    }

}



function getEmp(user) {
    console.log('in get reimb');
    console.log(user);
    let credJSON = JSON.stringify(user);
    console.log(credJSON);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'showERS', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {

        if (xhr.readyState === 4 && xhr.status === 200) {
            let a = JSON.parse(xhr.responseText);
            loadEmp(user, a);

        }
    }

}


function loadEmp(user, check) {
    console.log('in load employee page');
    console.log(check);
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'employee.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {


            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login1').addEventListener("click", loadLogin);
            
            let name = "welcome back : " + user.username + " , your role is : " + user.role;
            document.getElementById('name').innerText = name;



            let txt = "";
            txt += "<table class = 'table table-dark' border='2'  >";
            txt += "<tr>"
                + "<th>ID</th>"
                + "<th>AMOUNT</th>"
                + "<th>SUBMITTED</th>"
                + "<th>RESOLVED</th>"
                + "<th>DESC</th>"
                + "<th>RECIEPT</th>"
                + "<th>AUTHOR</th>"
                + "<th>RESOLVER</th>"
                + "<th>STATUS</th>"
                + " <th>TYPE</th>"
                + "</tr>";

            for (let i = 0; i < check.length; i++) {
                txt += "<tr>"
                txt += "<td>" + check[i].id + "</td>";
                txt += "<td>" + check[i].amount + "</td>";
                txt += "<td>" + check[i].subTime + "</td>";
                txt += "<td>" + check[i].resTimed + "</td>";
                txt += "<td>" + check[i].desc + "</td>";
                txt += "<td>" + check[i].receipt + "</td>";
                txt += "<td>" + check[i].authId + "</td>";
                txt += "<td>" + check[i].resId + "</td>";
                txt += "<td>" + check[i].statusId + "</td>";
                txt += "<td>" + check[i].typeId + "</td>";

                txt += "</tr>";
            }
            txt += "</table>";

            let a = user.id;
            console.log(a);
            document.getElementById("check").innerHTML = txt;
            document.getElementById("new1").addEventListener("click", () => {
                getReimb(user)
            });
            

        }
    }

}





function getMana(user) {
    console.log('in get reimb');
    console.log(user);
    let credJSON = JSON.stringify(user);
    console.log(credJSON);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'showERS', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {

        if (xhr.readyState === 4 && xhr.status === 200) {
            let a = JSON.parse(xhr.responseText);
            loadMana(user, a);

        }
    }

}

function loadMana(user, check) {

    console.log('in load manager page()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'manager.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {


            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('login').addEventListener("click", loadLogin);
            let name = "welcome back : " + user.username + " , your role is : " + user.role;
            document.getElementById('name').innerText = name;
            



            let txt = "";
            txt += "<table class = 'table table-dark' border='2'  >";
            txt += "<tr> "
                + "<th>ID</th>"
                + "<th>AMOUNT</th>"
                + "<th>SUBMITTED</th>"
                + "<th>RESOLVED</th>"
                + "<th>DESC</th>"
                + "<th>RECIEPT</th>"
                + "<th>AUTHOR</th>"
                + "<th>RESOLVER</th>"
                + "<th>STATUS</th>"
                + " <th>TYPE</th>"
                + "</tr>";

            for (let i = 0; i < check.length; i++) {
                txt += "<tr>"
                txt += "<td>" + check[i].id + "</td>";
                txt += "<td>" + check[i].amount + "</td>";
                txt += "<td>" + check[i].subTime + "</td>";
                txt += "<td>" + check[i].resTimed + "</td>";
                txt += "<td>" + check[i].desc + "</td>";
                txt += "<td>" + check[i].receipt + "</td>";
                txt += "<td>" + check[i].authId + "</td>";
                txt += "<td>" + check[i].resId + "</td>";
                txt += "<td>" + check[i].statusId + "</td>";
                txt += "<td>" + check[i].typeId + "</td>";

                txt += "</tr>";
            }
            txt += "</table>";


            document.getElementById("check").innerHTML = txt;
            document.getElementById("new").addEventListener("click", () => {
                getReimb(user)
            });

            document.getElementById("update").addEventListener("click", () => {getUpdate(user)});

            let sId = document.getElementById('sId').value;
            document.getElementById("search").addEventListener("click", () => {getSearch(user,sId)});
            document.getElementById("seeall").addEventListener("click", () => {getMana(user)});

        }
    }

}

function getSearch(user,sId){

    sId = document.getElementById('sId').value;
    let creds = {
        sId : sId,
    };

    console.log('in get search');
    console.log(user);
    console.log(sId);
    let credJSON = JSON.stringify(creds);
    console.log(credJSON);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'searchId', true);
    xhr.send(credJSON);
    xhr.onreadystatechange = () => {

        if (xhr.readyState === 4 && xhr.status === 200) {
            let a = JSON.parse(xhr.responseText);
            loadMana(user, a);

        }
    }
}



function getUpdate(user){
    console.log('in get update');
    console.log(user);
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'update.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
            document.getElementById('summit2').addEventListener("click",() => {createUpdate(user)});
            document.getElementById('back2').addEventListener("click",() => {getMana(user)});
        }
    }

}

function createUpdate(user){

    console.log('load update status ')

    let today = new Date();
    let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    let dateTime = date + ' ' + time;

    console.log(user);
    
    let amount = "";
    let subTime = "";
    let resTime = dateTime;
    let desc = "";
    let receipt = "123"; 
    let authId = document.getElementById('re').value;
    let resolver = user.id;
    let statusID = document.getElementById('ac').value;
    let typeId = 1;

    let creds = {
        amount: amount,
        subTime: subTime,
        resTime: resTime,
        desc: desc,
        receipt: receipt,
        authId: authId,
        resolver: resolver,
        statusID: statusID,
        typeId: typeId

    };
    console.log(creds);

    let credJSON = JSON.stringify(creds);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'updateReimb', true);
    xhr.send(credJSON);
    console.log('sent json');
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            console.log(xhr.status);
            if (xhr.status === 200) {

                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb.desc);
                // loadDashboard();
                getMana(user);

            }
            if (xhr.status === 201) {

                let reimb = JSON.parse(xhr.responseText);
                console.log(reimb.desc);
                // loadDashboard();
                getMana(user);

            }

            if (xhr.status === 401) {
                document.getElementById('login-message').innerText = 'update failed!';
            }
            if (xhr.status === 400) {
                document.getElementById('login-message').innerText = 'update failed!';
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

