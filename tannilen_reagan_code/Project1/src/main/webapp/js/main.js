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
    xhr.send();
    xhr.onreadystatechange=()=>{
        if (xhr.readyState===4 && xhr.status===200) {
            let reqs=JSON.parse(xhr.responseText);
            console.log("Reimbursement requests list populated.");
            populateReqs(user, reqs);
        }
        else if (xhr.readyState===4 && !xhr.status===200) {
            console.log(xhr.status + ": Unexpected error.")
        }
   }
}
function populateReqs(user, reqs) {
    if (user.role===1) {
        console.log("In populateReqs - Mgr subsection.")
        let users;
        let xhr=new XMLHttpRequest();
        xhr.open("GET", "users", true)
        xhr.send();
        console.log("Mgr request for users placed.")
        xhr.onreadystatechange=()=>{
            if (xhr.readyState===4 && xhr.status===200) {
                users=JSON.parse(xhr.responseText);
                console.log(users.length);
                console.log("User list populated.");
                console.log("Passing users: "+users.length);
                console.log("Passing reqs: "+reqs.length);
                tblMakerAdmin(reqs, users);
            }
        }
    }

    else {
        tblMakerStandard(reqs);
    }
}
let allUsers;
function tblMakerAdmin(reqs, users) {
    console.log(reqs.length);
    console.log(users.length);
    allUsers=users;
    reqs.forEach(makeMgrTable)
}
function makeMgrTable(req) {
    if (req.status===1) {
        //create table elements
        let reimbID=document.createElement("p");
        let reimbTbl=document.createElement("table");
        let reimbAmtRow=document.createElement("tr");
        let reimbAmtLbl=document.createElement("td");
        let reimbAmt=document.createElement("td");
        let reimbSubmitRow=document.createElement("tr");
        let reimbSubmitLbl=document.createElement("td");
        let reimbSubmit=document.createElement("td");
        let reimbDescRow=document.createElement("tr");
        let reimbDescLbl=document.createElement("td");
        let reimbDesc=document.createElement("td");
        let reimbTypeRow=document.createElement("tr");
        let reimbTypeLbl=document.createElement("td");
        let reimbType=document.createElement("td");
        let reimbAuthRow=document.createElement("tr");
        let reimbAuthLbl=document.createElement("td");
        let reimbAuth=document.createElement("td");
        let approveDenyRow=document.createElement("tr");
        let approve=document.createElement("td");
        let deny=document.createElement("td");
        //attach elements to one another
        reimbTypeRow.appendChild(reimbTypeLbl);
        reimbTypeRow.appendChild(reimbType);
        reimbDescRow.appendChild(reimbDescLbl);
        reimbDescRow.appendChild(reimbDesc);
        reimbSubmitRow.appendChild(reimbSubmitLbl);
        reimbSubmitRow.appendChild(reimbSubmit);
        reimbAmtRow.appendChild(reimbAmtLbl);
        reimbAmtRow.appendChild(reimbAmt);
        reimbAuthRow.appendChild(reimbAuthLbl);
        reimbAuthRow.appendChild(reimbAuth);
        approveDenyRow.appendChild(approve);
        approveDenyRow.appendChild(deny);
        reimbTbl.appendChild(reimbAuthRow);
        reimbTbl.appendChild(reimbSubmitRow);
        reimbTbl.appendChild(reimbTypeRow);
        reimbTbl.appendChild(reimbAmtRow);
        reimbTbl.appendChild(reimbDescRow);
        reimbTbl.appendChild(approveDenyRow);
        //insert elements onto document
        console.log(document.getElementById("requests").nodeType);
        let rule=document.createElement("hr")
        document.getElementById("requests").appendChild(rule).setAttribute("class",req.reimbID);
        document.getElementById("requests").appendChild(reimbID).setAttribute("class",req.reimbID);
        document.getElementById("requests").appendChild(rule).setAttribute("class",req.reimbID);
        document.getElementById("requests").appendChild(reimbTbl).setAttribute("class",req.reimbID);
        document.getElementById("requests").appendChild(rule).setAttribute("class",req.reimbID);
        //populate data
        reimbID.innerHTML="<b>REIMBURSEMENT REQUEST " + req.reimbID +"</b>";
        reimbAuthLbl.innerHTML="<b>REQUESTER:</b>";
        let auth=allUsers.find(user=>user.userID===req.authID);
        reimbAuth.innerText=auth.first+" "+auth.last;
        reimbSubmitLbl.innerHTML="<b>SUBMITTED ON:</b>";
        reimbSubmit.innerText=new Date(req.submitted);
        reimbTypeLbl.innerHTML="<b>REIMBURSEMENT TYPE:</b>";
        if (req.type==1) {
            reimbType.innerText="travel";
        }
        if (req.type==2) {
            reimbType.innerText="supplies";
        }
        if (req.type==3) {
            reimbType.innerText="public relations";
        }
        if (req.type==4) {
            reimbType.innerText="recurring expense";
        }
        if (req.type==5) {
            reimbType.innerText="other";
        }
        reimbAmtLbl.innerHTML="<b>REIMBURSEMENT AMOUNT:</b>";
        reimbAmt.innerText="$"+req.amt;
        reimbDescLbl.innerHTML="<b>DESCRIPTION OF EXPENSE:</b>";
        reimbDesc.innerText=req.desc;
        let appID="approve"+req.reimbID;
        let denID="deny"+req.reimbID;
        approve.innerHTML="<button id=\""+appID+"\" class=\"accepted\" title=\"Approve request\">O</button>"
        deny.innerHTML="<button id=\""+denID+"\" class=\"rejected\" title=\"Deny request\">X</button>"
        document.getElementById(appID).addEventListener("click", ()=>resolve(req.reimbID, true));
        document.getElementById(denID).addEventListener("click", ()=>resolve(req.reimbID, false));
    }
}
function resolve(reimbID, approved) {
    let approval={
        reimbID: reimbID,
        approved: approved
    };
    let approvalJSON=JSON.stringify(approval);
    console.log(approvalJSON);
    let xhr=new XMLHttpRequest();
    xhr.open("POST", "review", true);
    xhr.send(approvalJSON);
    console.log("Submitting reimbursement request.")
    xhr.onreadystatechange=()=> {
        if (xhr.readyState===4) {
            if (xhr.status===200) {
                console.log("Reimbursement updated.  Beginning cleanup process.")
                removeReimb(reimbID);
            }
            if (xhr.status===400) {
                //some logic?
            }
        }
    }
}
function removeReimb(reimbID) {
    console.log("Reimbursement cleanup begun for "+reimbID+".")
    let reimbElements=document.getElementsByClassName(reimbID);
    while (reimbElements.length>0) {
        console.log(reimbElements[0]);
        document.getElementById("requests").removeChild(reimbElements[0]);
    }
} //Special thanks to Veikko Karsikko on StackOverflow for the sytnax for this!
function tblMakerStandard(reqs) {
    if (reqs.length===0) {
        document.getElementById("requests").innerHTML="<p>There are no existing reimbursement requests.</p>";
    }
    else {
        reqs.forEach(makeStandardTable)
    }
}
function makeStandardTable(req) {
    //create table elements
    let reimbID=document.createElement("p");
    let reimbStatus=document.createElement("div");
    let reimbTbl=document.createElement("table");
    let reimbAmtRow=document.createElement("tr");
    let reimbAmtLbl=document.createElement("td");
    let reimbAmt=document.createElement("td");
    let reimbSubmitRow=document.createElement("tr");
    let reimbSubmitLbl=document.createElement("td");
    let reimbSubmit=document.createElement("td");
    let reimbResRow=document.createElement("tr");
    let reimbReslbl=document.createElement("td");
    let reimbRes=document.createElement("td");
    let reimbDescRow=document.createElement("tr");
    let reimbDescLbl=document.createElement("td");
    let reimbDesc=document.createElement("td");
    let reimbTypeRow=document.createElement("tr");
    let reimbTypeLbl=document.createElement("td");
    let reimbType=document.createElement("td");
    //attach elements to one another
    reimbTypeRow.appendChild(reimbTypeLbl);
    reimbTypeRow.appendChild(reimbType);
    reimbDescRow.appendChild(reimbDescLbl);
    reimbDescRow.appendChild(reimbDesc);
    reimbResRow.appendChild(reimbReslbl);
    reimbResRow.appendChild(reimbRes);
    reimbSubmitRow.appendChild(reimbSubmitLbl);
    reimbSubmitRow.appendChild(reimbSubmit);
    reimbAmtRow.appendChild(reimbAmtLbl);
    reimbAmtRow.appendChild(reimbAmt);
    reimbTbl.appendChild(reimbSubmitRow);
    reimbTbl.appendChild(reimbTypeRow);
    reimbTbl.appendChild(reimbAmtRow);
    reimbTbl.appendChild(reimbDescRow);
    reimbTbl.appendChild(reimbResRow);
    //insert elements onto document
    console.log(document.getElementById("requests").nodeType);
    let rule=document.createElement("hr")
    document.getElementById("requests").appendChild(rule);
    document.getElementById("requests").appendChild(reimbStatus);
    document.getElementById("requests").appendChild(reimbID);
    document.getElementById("requests").appendChild(rule);
    document.getElementById("requests").appendChild(reimbTbl);
    document.getElementById("requests").appendChild(rule);
    //populate data
    reimbID.innerHTML="<b>REIMBURSEMENT REQUEST " + req.reimbID +"</b>";
    if (req.status==1) {
        reimbStatus.innerText="?";
        reimbStatus.setAttribute("class","submitted");
        reimbStatus.setAttribute("alt", "Request pending.");
        reimbStatus.setAttribute("title", "Request pending.");
    }
    if (req.status==2){
        reimbStatus.innerText="O";
        reimbStatus.setAttribute("class","accepted");
        reimbStatus.setAttribute("alt", "Request approved.");
        reimbStatus.setAttribute("title", "Request approved.");
    }
    if (req.status==3){
        reimbStatus.innerText="X";
        reimbStatus.setAttribute("class","rejected");
        reimbStatus.setAttribute("alt", "Request denied.");
        reimbStatus.setAttribute("title", "Request denied.");
    }
    reimbSubmitLbl.innerHTML="<b>SUBMITTED ON:</b>";
    reimbSubmit.innerText=new Date(req.submitted);
    reimbTypeLbl.innerHTML="<b>REIMBURSEMENT TYPE:</b>";
    if (req.type==1) {
        reimbType.innerText="travel";
    }
    if (req.type==2) {
        reimbType.innerText="supplies";
    }
    if (req.type==3) {
        reimbType.innerText="public relations";
    }
    if (req.type==4) {
        reimbType.innerText="recurring expense";
    }
    if (req.type==5) {
        reimbType.innerText="other";
    }
    reimbAmtLbl.innerHTML="<b>REIMBURSEMENT AMOUNT:</b>";
    reimbAmt.innerText="$"+req.amt;
    reimbDescLbl.innerHTML="<b>DESCRIPTION OF EXPENSE:</b>";
    reimbDesc.innerText=req.desc;
    reimbReslbl.innerHTML="<b>REQUEST RESOLVED: </b>";
    if (req.status==1) {
        reimbRes.innerText="";
    }
    if (req.status!=1) {
        reimbRes.innerText=new Date(req.resolved);
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