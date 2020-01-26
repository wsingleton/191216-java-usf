let showForm = false
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

function logout(){
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
                            document.getElementById("root").innerHTML = xhr.responseText;
                            console.log(currentUser);
                            document.getElementById("logOut").addEventListener("click", logout)
                            console.log(currentUser["role"]);
                            if(currentUser["role"] === "EMPLOYEE"){
                            document.getElementById("approve").style.display = "none";
                            document.getElementById("deny").style.display = "none";
                            document.getElementById("info").style.display = "none";
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
                                     if(xhr.readyState === 4 ) {
                                         if(xhr.status === 201) {
                                             loadDashboard(currentUser)
                                             console.clear();
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

