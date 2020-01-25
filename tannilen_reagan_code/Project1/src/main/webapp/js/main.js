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
        }
    }
}
function login() {
    let username=document.getElementById("usrnm").value;
    let password=document.getElementById("pw").value;
    let creds={
        username: username,
        password: password
    };
    let credJSON=JSON.stringify(creds);
    let xhr=new XMLHttpRequest();
    xhr.open("POST", "auth", true);
    xhr.send(credJSON);
    xhr.onreadystatechange=()=> {
        if (xhr.readyState===4) {
            if (xhr.status===200) {
                let user=JSON.parse(xhr.responseText);
                console.log(user);
                loadDash()
            }
            if (xhr.status===401) {
                //failure text functionality will go here
            }
        }
    }
}
function logout() {
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "auth", true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if (xhr.readyState===4 && xhr.status===2) {
            console.log('logout successful!')
        }
    }
}
function loadDash() {
    console.log("in loadDash()");
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "dash.view", true);
    xhr.send();
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            document.getElementById("main").innerHTML=xhr.responseText;
            document.getElementById("logout").addEventListener("click", logout);
        }
    }
    console.log("pepping Nav.")
    let xhrNav=new XMLHttpRequest();
    xhrNav.open("GET", "dash.nav", true);
    xhrNav.send();
    xhrNav.onreadystatechange=()=>{
        if (xhrNav.readyState===4 && xhrNav.status===200) {
            document.getElementById("topnav").innerHTML=xhrNav.responseText;
        }
    }
}