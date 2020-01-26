let showForm = false;
let loggedOut = false;
let modalIdGenerator = 0;

let sortedInfo;

window.onload = () => {
loadHome()
}
function loadLogin(e) {
    console.log('in loadLogin()');
    e.preventDefault();
    if(document.querySelectorAll("head")[0].children.length === 7){
        document.querySelectorAll("head")[0].children[6].remove();
    }
     let css = document.createElement('link');
     css.setAttribute('rel', 'stylesheet');
     css.setAttribute('href', 'css/login.css');
     document.getElementsByTagName("head")[0].appendChild(css);
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
            let username = document.querySelectorAll(".txtb input")[0];
            let password = document.querySelectorAll(".txtb input")[1];

            username.addEventListener('focus', () => {
                username.classList.add('focus');
            });

            username.addEventListener('blur', () => {
                if(username.value < 1){
                username.classList.remove('focus');
                }
            });

            password.addEventListener('blur', () => {
                if(password.value < 1){
                password.classList.remove('focus');
                }
            });

            password.addEventListener('focus', () => {
                password.classList.add('focus');
            })
            document.getElementById('sign-up').addEventListener('click', loadRegister);
            document.getElementById('login').addEventListener('click', login);
        }
    }
}

function login(e){
 e.preventDefault();
let username = document.getElementById('username').value;
let password = document.getElementById('password').value;

if(username.length < 1 || password.length < 1){
console.log("No input!")
document.getElementById("warning").innerText ="Fields can't be empty.";
document.getElementById("warning").style.display = "flex";
                     setTimeout(() => {
                     document.getElementById("warning").style.display = "none";
                     }, 2500)
}
else{
let creds = {
    username: username,
    password: password
};

let credJson = JSON.stringify(creds);
 let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJson);
     xhr.onreadystatechange = () => {
            if(xhr.readyState === 4 ) {
                if(xhr.status === 200) {
                let user = JSON.parse(xhr.responseText);
                loadDashboard(user);
                console.clear();
                }
                if(xhr.status === 401) {
                  console.log("Login Failed!")
                  document.getElementById("warning").innerText ="Invalid Credentials";
                  document.getElementById("warning").style.display = "flex";
                      setTimeout(() => {
                      document.getElementById("warning").style.display = "none";
                      }, 2500)
//                document.getElementById('login-message').innerText = 'Login Failed!';
                }
                 if(xhr.status === 400) {
                 document.getElementById("warning").innerText ="Invalid Credentials";
                 document.getElementById("warning").style.display = "flex";
                     setTimeout(() => {
                     document.getElementById("warning").style.display = "none";
                     }, 2500)
                                  console.log("Login Failed!")
                //                document.getElementById('login-message').innerText = 'Login Failed!';
                }
            }
    }
    }
}

function register(e) {
e.preventDefault();
//strip all space
let password = document.getElementById('password').value;
let username = document.getElementById('username').value.toLowerCase().replace(/\s+/g, '');
let firstName= document.getElementById('firstName').value.replace(/\s+/g, '');
let lastName = document.getElementById('lastName').value.replace(/\s+/g, '');
let email = document.getElementById('email').value.toLowerCase().replace(/\s+/g, '');

let re =  /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

if(re.test(email) === false) {
    document.getElementById("warning").innerText ="Must use a valid email.";
    document.getElementById("warning").style.display = "flex";
                         setTimeout(() => {
                         document.getElementById("warning").style.display = "none";
                         }, 2500);

}
else if(username.length < 1 || password.length < 1 || firstName.length < 1 || lastName.length < 1){
       console.log("No input!")
       document.getElementById("warning").innerText ="Fields can't be empty.";
       document.getElementById("warning").style.display = "flex";
                            setTimeout(() => {
                            document.getElementById("warning").style.display = "none";
                            }, 2500)
 }
else{
let user = {
     username: username,
     password: password,
     firstName: firstName,
     lastName: lastName,
     email: email,
     role: 2
};

console.log(user)

let userJson = JSON.stringify(user);

console.log(userJson)

let xhr = new XMLHttpRequest();
    xhr.open('POST', 'register', true);
    xhr.send(userJson);
     xhr.onreadystatechange = () => {
         if(xhr.readyState === 4 ) {
                        if(xhr.status === 201) {
                        loadHome()
                        console.clear();
                        }
                        else if(xhr.status === 409) {
                            document.getElementById("warning").innerText ="Username or email is taken";
                            document.getElementById("warning").style.display = "flex";
                            setTimeout(() => {
                                document.getElementById("warning").style.display = "none";
                            }, 2500)
                                console.log("Registraion Failed!")
                            }
     }
}
}
}

function logout(e){
e.preventDefault();
loggedOut = true;
let xhr = new XMLHttpRequest();
xhr.open('GET', 'auth', true);
xhr.send()
  xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            loadHome();
        }
    }
}

function loadDashboard(user) {
let currentUser = user;
console.log(currentUser);
 let xhr = new XMLHttpRequest();
                    xhr.open('GET', 'dashboard.view', true);
                    xhr.send();
                    xhr.onreadystatechange = () => {
                        if(xhr.readyState === 4 && xhr.status === 200) {
                            console.log("ran")
                            document.getElementById("root").innerHTML = xhr.responseText;
                            document.getElementById("logOut").addEventListener("click", logout)
                            if(currentUser["role"] === "EMPLOYEE"){

                                let userIdData = {
                                    id: parseInt(currentUser["id"])
                                }

                                let userIdJSON = JSON.stringify(userIdData);

                                console.log(userIdJSON)

                                let xhr4 = new XMLHttpRequest();
                                xhr4.open('POST', 'userreimb', true);
                                xhr4.send(userIdJSON)
                                xhr4.onreadystatechange = () => {

                                    if(xhr4.readyState === 4 ) {
                                     if(xhr4.status === 201) {

                                     let userReimbInfo = JSON.parse(xhr4.responseText);
                                     console.log(userReimbInfo["subTime"]);
                                     console.log(userReimbInfo);
                                      sortedInfo =  userReimbInfo.sort((a, b) => b["id"] - a["id"])
                                       console.log(sortedInfo);
                                     for (let i = 0; i < sortedInfo.length; i++){
                                          makeUserContent(sortedInfo[i]["id"], sortedInfo[i]["typeId"],sortedInfo[i]["amount"], sortedInfo[i]["authId"], sortedInfo[i]["resId"],sortedInfo[i]["statusId"], sortedInfo[i]["desc"], currentUser)
                                          }

                                      }
                                   }
                                }

                                document.getElementById("expenseButton").addEventListener('click', showFormFunc);
                                document.getElementById("expenseSubmit").addEventListener('click', () => {
                               showFormFunc();
                               let amount = document.getElementById("amount").value;
                                let selectBox = document.getElementById("type");
                                let type = selectBox.options[selectBox.selectedIndex].value;
                                let desc = document.getElementById("desc").value;
                                console.log(currentUser)
                                let reimbursement = {
                                     amount: amount,
                                     desc: desc,
                                     authId: currentUser["id"],
                                     typeId: parseInt(type)
                                };
                                let reimbJSON = JSON.stringify(reimbursement);
                                console.log(reimbJSON)
                                  document.getElementById("amount").value = "";
                                  document.getElementById("desc").value = "";
                                let xhr1 = new XMLHttpRequest();
                                    xhr1.open('POST', 'reimb', true);
                                    xhr1.send(reimbJSON);
                                    xhr1.onreadystatechange = () => {
                                     if(xhr1.readyState === 4 ) {
                                         if(xhr1.status === 201) {
                                             loadDashboard(user);
                                         }
                                }}
                            })
                            document.getElementById("amount").addEventListener("keyup", () => {
                                if(document.getElementById("amount").value.length < 1){
                                     document.getElementById("expenseSubmit").setAttribute("disabled", true);
                                }
                                else{
                                     document.getElementById("expenseSubmit").removeAttribute("disabled");
                                    }
                            })
                            if(document.getElementById("amount").value < 1){
                                document.getElementById("expenseSubmit").setAttribute("disabled", true);
                            }
                            else{
                               document.getElementById("expenseSubmit").removeAttribute("disabled");
                            }
                            }
                            else {
                                document.getElementById("expenseButton").style.display = "none";
                                document.getElementById("approve").style.display = "inline-block";
                                document.getElementById("deny").style.display = "inline-block";
                                document.getElementById("info").style.display = "inline-block";

                                let xhr2 = new XMLHttpRequest();
                                xhr2.open('GET', 'reimb', true);
                                xhr2.send()
                                xhr2.onreadystatechange = () => {
                                  if(xhr2.readyState === 4 ) {
                                                  if(xhr2.status === 200) {

                                                  let reimbInfo = JSON.parse(xhr2.responseText);
                                                  console.log(reimbInfo);
                                                  document.getElementById("expenseButton").style.display = "none";
                                                  for (let i = 0; i < reimbInfo.length; i++){
                                                    makeContent(reimbInfo[i]["id"], reimbInfo[i]["typeId"],reimbInfo[i]["amount"], reimbInfo[i]["authId"], reimbInfo[i]["resId"],reimbInfo[i]["statusId"], reimbInfo[i]["desc"], currentUser)
                                                  }
                                                  }
                                 }
                            }

                        }
                    }
}
}
function loadRegister(e) {
    e.preventDefault();
 if(document.querySelectorAll("head")[0].children.length === 7){
        document.querySelectorAll("head")[0].children[6].remove();
    }
let css = document.createElement('link');
     css.setAttribute('rel', 'stylesheet');
     css.setAttribute('href', 'css/register.css');
     document.getElementsByTagName("head")[0].appendChild(css);
 let xhr = new XMLHttpRequest();

                    xhr.open('GET', 'register.view', true);
                    xhr.send();
                    xhr.onreadystatechange = () => {
                        if(xhr.readyState === 4 && xhr.status === 200) {
                            document.getElementById("root").innerHTML = xhr.responseText;

                            let firstname = document.querySelectorAll(".txtb input")[0];
                            let lastname = document.querySelectorAll(".txtb input")[1];
                            let username = document.querySelectorAll(".txtb input")[2];
                            let email = document.querySelectorAll(".txtb input")[3];
                            let password = document.querySelectorAll(".txtb input")[4];
                            firstname.addEventListener('focus', () => {
                                firstname.classList.add('focus');
                            });

                            firstname.addEventListener('blur', () => {
                                if (firstname.value.length < 1) {

                                    firstname.classList.remove('focus');
                                }
                            });

                            lastname.addEventListener('blur', () => {
                                if (lastname.value.length < 1) {
                                    lastname.classList.remove('focus');
                                }
                            });

                            lastname.addEventListener('focus', () => {
                                lastname.classList.add('focus');
                            });

                            username.addEventListener('blur', () => {
                                if (username.value.length < 1) {
                                    username.classList.remove('focus');
                                }
                            });

                            username.addEventListener('focus', () => {
                                username.classList.add('focus');
                            });

                            email.addEventListener('blur', () => {
                                if (email.value.length < 1) {
                                    email.classList.remove('focus');
                                }
                            });

                            email.addEventListener('focus', () => {
                                email.classList.add('focus');
                            });
                            password.addEventListener('blur', () => {
                                if (password.value.length < 1) {
                                    password.classList.remove('focus');
                                }
                            });

                            password.addEventListener('focus', () => {
                                password.classList.add('focus');
                            });
                            document.getElementById("register").addEventListener("click", register);
                            document.getElementById("signIn").addEventListener("click", loadLogin);
                        }
                    }
}

function loadHome() {
 let xhr = new XMLHttpRequest();
                    xhr.open('GET', 'home.view', true);
                    xhr.send();
                    xhr.onreadystatechange = () => {
                        if(xhr.readyState === 4 && xhr.status === 200) {
                            document.getElementById("root").innerHTML = xhr.responseText;
                            if(loggedOut === true){
                            console.log("Successfully Logged out!")
                            document.getElementById("message").innerText ="Successfully Logged Out!";
                            document.getElementById("message").style.display = "flex";
                            loggedOut = false;
                                                 setTimeout(() => {
                                                 document.getElementById("message").style.display = "none";
                                                 }, 2500)
                            }

                            document.getElementById("loginBut").addEventListener("click", loadLogin);
                            document.getElementById("registerBut").addEventListener("click", loadRegister);
                        }
                    }
}

function showFormFunc() {
    showForm = !showForm;
    if(showForm === false) {
        document.getElementById("expenseButton").innerText = "Add a new Expense";
        document.getElementById("expenseForm").style.display = "none";
    }
    else {
        document.getElementById("expenseButton").innerText = "Close";
        document.getElementById("expenseForm").style.display = "flex";
    }
}

document.getElementById("expenseButton").addEventListener('click', showFormFunc);



function makeContent(id, type, amount, author, resolver, status, descContent, currentUser) {
    let parentDiv = document.createElement("div");
    let secondDiv = document.createElement("div");
    let thirdDiv = document.createElement("div");
    let title = document.createElement("h5");
    let amountText = document.createElement("p")
    let authorText = document.createElement("p")
    let resolvedText = document.createElement("p")
    let statusText = document.createElement("p")
    let hr = document.createElement("hr")
    let hr2 = document.createElement("hr")
    let hr3 = document.createElement("hr")
    let hr4 = document.createElement("hr")
    let hr5 = document.createElement("hr")
    let but1 = document.createElement("a")
    let but2 = document.createElement("a")
    let but3 = document.createElement("a")

    parentDiv.classList.add("mt-4");


    but1.innerText = "Approve"
    but2.innerText = "Deny"
    but3.innerText = "More Info"

    but1.classList.add("btn", "btn-success", "approve", "text-white");
    but2.classList.add("btn", "btn-danger", "deny", "text-white", "ml-2");
    but3.classList.add("btn", "btn-info", "info", "text-white", "ml-2");
    but1.href = "#"
    but2.href = "#"
    but3.href = "#"
    but1.setAttribute("id", `approveBut${modalIdGenerator}`);
    but2.setAttribute("id", `denyBut${modalIdGenerator}`);
    but3.setAttribute("data-target", `#model${modalIdGenerator}`);
    but3.setAttribute("data-toggle", "modal");
    parentDiv.classList.add("card", "mt-3");
    secondDiv.classList.add("card-header");
    thirdDiv.classList.add("card-body")
    title.classList.add("card-title");
    amountText.classList.add("card-text");
    authorText.classList.add("card-text");
    resolvedText.classList.add("card-text");
    statusText.classList.add("card-text");
    title.innerText = "Reimbursement Type: " + type;
    amountText.innerText = "Author: " + author;
    authorText.innerText = "Amount: $" + amount;
    resolvedText.innerText = "Resolver: " + resolver;
    let span = document.createElement("span");
    if (status === "PENDING") {
        span.style.backgroundColor = "gold"
    }
    else if (status === "APPROVED") {
        span.style.backgroundColor = "#5cb85c"
    }
    else if (status === "DENIED") {
        span.style.backgroundColor = "#d9534f"
    }
    span.classList.add("circle")
    statusText.innerText = "Status: ";
    statusText.appendChild(span)

    thirdDiv.appendChild(title);
    thirdDiv.appendChild(hr);
    thirdDiv.appendChild(amountText);
    thirdDiv.appendChild(hr2);
    thirdDiv.appendChild(authorText);
    thirdDiv.appendChild(hr3);
    thirdDiv.appendChild(resolvedText);
    thirdDiv.appendChild(hr4);
    thirdDiv.appendChild(statusText);
    thirdDiv.appendChild(hr5);
    thirdDiv.appendChild(but1);
    thirdDiv.appendChild(but2);
    thirdDiv.appendChild(but3);
    secondDiv.innerText = "Reimbursement ID: " + id;

    parentDiv.appendChild(secondDiv);
    parentDiv.appendChild(thirdDiv);
    document.getElementById("mainContent").appendChild(parentDiv);

    let modalDiv1 = document.createElement("div");
    let modalDiv2 = document.createElement("div");
    let modalDiv3 = document.createElement("div");
    let modalDiv4 = document.createElement("div");
    let modalDiv5 = document.createElement("div");
    let modalDiv6 = document.createElement("div");
    let modalTitle = document.createElement("h5");
    let modalButton = document.createElement("button");
    let footerButton = document.createElement("button");

    modalButton.classList.add("close");
    modalButton.setAttribute("type", "button");
    modalButton.setAttribute("data-dismiss", "modal");
    modalButton.innerHTML = "&times;"
    modalTitle.innerText = "Description";
    modalTitle.classList.add("modal-title");

    footerButton.classList.add("btn", "btn-secondary");
    footerButton.setAttribute("type", "button");
    footerButton.setAttribute("data-dismiss", "modal");
    footerButton.innerText = "Close"

    modalDiv1.setAttribute("id", `model${modalIdGenerator}`);
    modalDiv1.setAttribute("role", "dialog");
    modalDiv1.classList.add("modal", "fade");
    modalDiv2.setAttribute("role", "document");
    modalDiv2.classList.add("modal-dialog");
    modalDiv3.classList.add("modal-content");
    modalDiv4.classList.add("modal-header");
    modalDiv5.classList.add("modal-body");
    modalDiv6.classList.add("modal-footer");
    modalDiv5.innerText = `${descContent}`;
    modalDiv4.appendChild(modalTitle);
    modalDiv4.appendChild(modalButton);
    modalDiv6.appendChild(footerButton);
    modalDiv3.appendChild(modalDiv4);
    modalDiv3.appendChild(modalDiv5);
    modalDiv3.appendChild(modalDiv6);
    modalDiv2.appendChild(modalDiv3);
    modalDiv1.appendChild(modalDiv2);
    document.getElementById("mainContent").appendChild(modalDiv1);

    document.getElementById(`approveBut${modalIdGenerator}`).addEventListener("click", () => {
        let data = {
            id: id
        };

        let dataJSON = JSON.stringify(data);
        let xhr = new XMLHttpRequest();
        xhr.open('PUT', 'approve', true);
        xhr.send(dataJSON);
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 201) {
                loadDashboard(currentUser);
            }
        }
    })
    document.getElementById(`denyBut${modalIdGenerator}`).addEventListener("click", () => {
        let data = {
            id: id
        };
        let dataJSON = JSON.stringify(data);
        let xhr = new XMLHttpRequest();
        xhr.open('PUT', 'deny', true);
        xhr.send(dataJSON);
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 201) {
                loadDashboard(currentUser);
            }
        }
    })
    modalIdGenerator++
}

function makeUserContent(id, type, amount, author, resolver, status, descContent, currentUser) {
    let parentDiv = document.createElement("div");
    let secondDiv = document.createElement("div");
    let thirdDiv = document.createElement("div");
    let title = document.createElement("h5");
    let amountText = document.createElement("p")
    let authorText = document.createElement("p")
    let resolvedText = document.createElement("p")
    let statusText = document.createElement("p")
    let hr = document.createElement("hr")
    let hr2 = document.createElement("hr")
    let hr3 = document.createElement("hr")
    let hr4 = document.createElement("hr")
    let hr5 = document.createElement("hr")


    parentDiv.classList.add("mt-4");

    parentDiv.classList.add("card", "mt-3");
    secondDiv.classList.add("card-header");
    thirdDiv.classList.add("card-body")
    title.classList.add("card-title");
    amountText.classList.add("card-text");
    authorText.classList.add("card-text");
    resolvedText.classList.add("card-text");
    statusText.classList.add("card-text");
    title.innerText = "Reimbursement Type: " + type;
    amountText.innerText = "Author: " + author;
    authorText.innerText = "Amount: $" + amount;
    let span = document.createElement("span");
    if (status === "PENDING") {
        span.style.backgroundColor = "gold"
        resolvedText.innerText = "Has not been resolved yet.";
    }
    else if (status === "APPROVED") {
        span.style.backgroundColor = "#5cb85c"
        resolvedText.innerText = "Resolver: DLaw";

    }
    else if (status === "DENIED") {
        span.style.backgroundColor = "#d9534f"
        resolvedText.innerText = "Resolver: DLaw";
    }
    span.classList.add("circle")
    statusText.innerText = "Status: ";
    statusText.appendChild(span)

    thirdDiv.appendChild(title);
    thirdDiv.appendChild(hr);
    thirdDiv.appendChild(amountText);
    thirdDiv.appendChild(hr2);
    thirdDiv.appendChild(authorText);
    thirdDiv.appendChild(hr3);
    thirdDiv.appendChild(resolvedText);
    thirdDiv.appendChild(hr4);
    thirdDiv.appendChild(statusText);
    thirdDiv.appendChild(hr5);
    secondDiv.innerText = "Reimbursement ID: " + id;

    parentDiv.appendChild(secondDiv);
    parentDiv.appendChild(thirdDiv);
    document.getElementById("mainContent").appendChild(parentDiv);

    let modalDiv1 = document.createElement("div");
    let modalDiv2 = document.createElement("div");
    let modalDiv3 = document.createElement("div");
    let modalDiv4 = document.createElement("div");
    let modalDiv5 = document.createElement("div");
    let modalDiv6 = document.createElement("div");
    let modalTitle = document.createElement("h5");
    let modalButton = document.createElement("button");
    let footerButton = document.createElement("button");

    modalButton.classList.add("close");
    modalButton.setAttribute("type", "button");
    modalButton.setAttribute("data-dismiss", "modal");
    modalButton.innerHTML = "&times;"
    modalTitle.innerText = "Description";
    modalTitle.classList.add("modal-title");

    footerButton.classList.add("btn", "btn-secondary");
    footerButton.setAttribute("type", "button");
    footerButton.setAttribute("data-dismiss", "modal");
    footerButton.innerText = "Close"

    modalDiv1.setAttribute("id", `model${modalIdGenerator}`);
    modalDiv1.setAttribute("role", "dialog");
    modalDiv1.classList.add("modal", "fade");
    modalDiv2.setAttribute("role", "document");
    modalDiv2.classList.add("modal-dialog");
    modalDiv3.classList.add("modal-content");
    modalDiv4.classList.add("modal-header");
    modalDiv5.classList.add("modal-body");
    modalDiv6.classList.add("modal-footer");
    modalDiv5.innerText = `${descContent}`;
    modalDiv4.appendChild(modalTitle);
    modalDiv4.appendChild(modalButton);
    modalDiv6.appendChild(footerButton);
    modalDiv3.appendChild(modalDiv4);
    modalDiv3.appendChild(modalDiv5);
    modalDiv3.appendChild(modalDiv6);
    modalDiv2.appendChild(modalDiv3);
    modalDiv1.appendChild(modalDiv2);
    document.getElementById("mainContent").appendChild(modalDiv1);

    modalIdGenerator++
}



function bufferFunction(user) {
    loadDashboard(user)
}


