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
        }
    }
}