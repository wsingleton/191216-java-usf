window.onload = () => {
    console.log('did the js load');
    loadLogin();
}

function loadLogin() {
    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {
        if(xhr.readystate === 4 && xhr.status === 200) {
            document.getElementById("root").innerHTML = xhr.responseText;
        }
    }
}
