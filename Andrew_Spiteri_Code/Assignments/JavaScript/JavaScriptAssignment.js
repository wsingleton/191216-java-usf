

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

    document.getElementById('form-sub').addEventListener('click', subForm);
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
    console.log('subForm');
    let fName = document.getElementById('firstname').value;
    let lName = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let bday = document.getElementById('bday').value;
    let planet = document.getElementById('planet').value;
    let gender = document.getElementsByName('gender').value;
    let color = document.getElementById('color').value;
    let activities = document.getElementsByClassName('activity').value;
    if(fName){
        console.log('fname: ' +fName);
    }
    if(lName){
        console.log('lname: ' +lName);
    }
    if(email){
        console.log('email: ' +email);
    }
    if(phone){
        console.log('phone: ' +phone);
    }
    if(bday){
        console.log('bday: ' +bday);
    }
    if(planet){
        console.log('planet: ' +planet);
    }
    if(gender){
        console.log('gender: ' +gender);
    }
    if(color){
        console.log('color: ' +color);
    }
    if(activities){
        console.log('actitiees: ' +activities);
    }
    

    if(fName && lName && email && phone && bday && planet && gender && color && activities){
        console.log('first if');
        if(isEmail(email) && fName.length >= 2 && lName.length >= 2 && isPhone(phone)){
            console.log('second if');
            let row = document.createElement('tr');
            let nameCell = document.createElement('td');
            let emailCell = document.createElement('td');
            let phoneCell = document.createElement('td');
            let bdayCell = document.createElement('td');
            let colorCell = document.createElement('td');
            let genderCell = document.createElement('td');
            let activitiesCell = document.createElement('td');

            row.appendChild(nameCell);
            row.appendChild(emailCell);
            row.appendChild(phoneCell);
            row.appendChild(bdayCell);
            row.appendChild(colorCell);
            row.appendChild(genderCell);
            row.appendChild(activitiesCell);

            let table = document.getElementsByClassName('table');
            table[0].appendChild(row);

            nameCell.innerText = fName + ' ' + lName;
            emailCell.innerText = email;
            phoneCell.innerText = phone;
            bdayCell.innerText = bday;
            colorCell.innerText = color;
            genderCell.innerText = gender;
            activitiesCell.innerText = function(){
                for (const i of activities) {
                    i.print;
                }
            }
        }
    }
}

function isEmail(string){
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(string)){
       return true;
    }      
    return false;
}

function isPhone(string){
    if(/^(?:(?:\+?1\s*(?:[.-]\s*)?)?(?:\(\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\s*\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\s*(?:[.-]\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\s*(?:[.-]\s*)?([0-9]{4})(?:\s*(?:#|x\.?|ext\.?|extension)\s*(\d+))?$/.test(string)){
        return true;
    }
    return false;
}