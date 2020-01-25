window.onload = () => {

}

function loadLogin() {
    console.log("In load login");

    let xhr = new XMLHttpRequest();
    xhr.open('GET', url'login.view', true);
    xhr.send();
    xhr.onreadystatechange = () => {

        if(xhr.readState === 4 && xhr.status === 200) {
            document.getElementById('root').innerHTML = xhr.responseText;
        }
    }
}