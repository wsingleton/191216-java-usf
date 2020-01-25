window.onload=()=> {
    loadLogin();
}
function loadLogin() {
    console.log("in loadLogin()");
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "login.view", true);
    xhr.send();
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            document.getElementById("main").innerHTML=xhr.responseText;
            document.getElementById("login").addEventListener("click", login);
        }
    }
    console.log("pepping Nav.")
    let xhrNav=new XMLHttpRequest();
    xhrNav.open("GET", "login.nav", true);
    xhrNav.send();
    xhrNav.onreadystatechange=()=>{
        if (xhrNav.readyState===4 && xhrNav.status===200) {
            document.getElementById("topnav").innerHTML=xhrNav.responseText;
            document.getElementById("abt").addEventListener("click", about);
            document.getElementById("home").addEventListener("click", loadLogin);
        }
    }
}
function login() {
    console.log("In Login()")
    let username=document.getElementById("usrnm").value;
    let password=document.getElementById("pw").value;
    let creds={
        username: username,
        password: password
    };
    let credJSON=JSON.stringify(creds);
    console.log(credJSON);
    let xhr=new XMLHttpRequest();
    xhr.open("POST", "auth", true);
    xhr.send(credJSON);
    xhr.onreadystatechange=()=> {
        if (xhr.readyState===4) {
            if (xhr.status===200) {
                let user=JSON.parse(xhr.responseText);
                console.log(user);
                loadDash(user)
            }
            if (xhr.status===401) {
                //failure text functionality will go here
            }
        }
    }
}
function logout() {
    console.log("In logout()");
    let xhr=new XMLHttpRequest();
    console.log(xhr);
    xhr.open("GET", "auth", true);
    console.log(xhr.readyState);
    xhr.send();
    xhr.onreadystatechange = () => {
        console.log(xhr.readyState);
        if (xhr.readyState===4 && xhr.status===200) {
            console.log('logout successful!');
            loadLogin();
        }
    }
}
function loadDash(user) {
    console.log("in loadDash()");
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "dash.view", true);
    xhr.send();
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            document.getElementById("main").innerHTML=xhr.responseText;
            document.getElementById("fName").innerText=user.first;
            document.getElementById("lName").innerText=user.last;
        }
    }
    console.log("pepping Nav.")
    let xhrNav=new XMLHttpRequest();
    xhrNav.open("GET", "dash.nav", true);
    xhrNav.send();
    xhrNav.onreadystatechange=()=>{
        if (xhrNav.readyState===4 && xhrNav.status===200) {
            document.getElementById("topnav").innerHTML=xhrNav.responseText;
            document.getElementById("logout").addEventListener("click", logout);
        }
    }
}
function about() {
    document.getElementById("home").setAttribute("class", "navtab");
    document.getElementById("abt").setAttribute("class", "navtab active");
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "about.view", true);
    xhr.send();
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            document.getElementById("main").innerHTML=xhr.responseText;
        }
    }
}