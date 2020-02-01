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
            document.getElementById("createBtn").addEventListener("click", ()=>createReq(user));
            document.getElementById("reviewBtn").addEventListener("click", ()=>reviewReqs(user));
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
function createReq(user) {
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "createReq.view", true);
    xhr.send();
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            document.getElementById("main").innerHTML=xhr.responseText;
            document.getElementById("back2Dash").addEventListener("click", ()=>loadDash(user));
            document.getElementById("submitNew").addEventListener("click", ()=>submit(user));
        }
    }
}
function reviewReqs(user) {
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "review.view", true);
    xhr.send();
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            document.getElementById("main").innerHTML=xhr.responseText;
            document.getElementById("back2Dash").addEventListener("click", ()=>loadDash(user));
            getReqs(user);
        }
    }
}
function getReqs(user) {
    let xhr=new XMLHttpRequest();
    xhr.open("GET", "review", true);
    xhr.send()
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            let reqs[]=JSON.parse(xhr.responseText);
            console.log{"Reimbursement requests list populated."}
            populateReqs(user, reqs);
        }
        else if (xhr.readyState===4 && !xhr.status===200) {
            console.log(xhr.status + ": Unexpected error.")
        }
   }
}
function populateReqs(user, reqs) {
    if (user.role===1) {
        let xhr=new XMLHttpRequest();
        xhr.open("GET", "users", true)
        //call a function that will take all users and all reqs and build a table for each req
    }
    else {
        //call a function that takes all reqs and builds a table for each req
    }
}
function reqBuilder(uID, typeID, amt, desc) {
    this.userID=uID;
    this.amt=amt;
    this.desc=desc;
    this.type=typeID;
}
function submit(user){
    let uID=user.userID;
    console.log(uID);
    let amt=document.getElementById("amt").value;
    console.log(amt);
    let typeID=document.getElementById("type").options[document.getElementById("type").selectedIndex].value;
    console.log(typeID);
    let desc=document.getElementById("desc").value || "";
    console.log(desc);
    let newReq=new reqBuilder(uID, typeID, amt, desc);
    console.log(newReq);
    let reqJSON=JSON.stringify(newReq);
    console.log(reqJSON);
    let xhr=new XMLHttpRequest();
    xhr.open("POST", "req", true);
        xhr.send(reqJSON);
        xhr.onreadystatechange=()=> {
            if (xhr.readyState===4) {
                if (xhr.status===201) {
                    console.log("New Req submitted!")
                }
                if (xhr.status===400) {
                    console.log("Something went wrong on the user end.")
                }
                if (xhr.status===500) {
                    console.log("Something went wrong on the system end.")
            }
        }
    }
}