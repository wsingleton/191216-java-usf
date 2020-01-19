

window.onload = function (){
    let googleLink = document.getElementsByName('google');
    googleLink.forEach(element => {
        element.setAttribute('href', 'https://www.google.com')
        element.innerText = 'Google';
    });
    let twitterLink = document.getElementsByName('twitter');
    twitterLink.forEach(element =>{
        element.setAttribute('href', 'https://www.twitter.com');
        element.innerText = 'Twitter';
    });
    let slackLink = document.getElementsByName('slack');
    slackLink.forEach(element =>{
        element.setAttribute('href', 'https://www.slack.com');
        element.innerText = 'Slack';
    });
    let javaLink = document.getElementsByName('javadocs');
    javaLink.forEach(element =>{
        element.setAttribute('href', 'https://docs.oracle.com/javase/8/docs/api/');
        element.innerText = 'Java Docs';
    });

    let planetForm = document.getElementById('planet');
    let list = planetForm.children;
    list[3].setAttribute('disabled', true);

    planetForm.addEventListener('click', alientText);

    this.document.getElementById('form-sub').addEventListener('click', subForm);
}

function alientText(){
    let planetSelector = document.getElementById('planet');
    let hiddenAtt = document.getElementsByTagName('p');
    if(planetSelector.value !== 'Earth'){
        for(let i = 0; i < hiddenAtt.length; i++)  {
            hiddenAtt[i].removeAttribute('hidden');
        }
    }
}

function subForm(){
    let fName = document.getElementById('firstname').value;
    let lName = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    if()
}