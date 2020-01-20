

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

    planetForm.addEventListener('click', alienText);

    document.getElementById('form-sub').addEventListener('click', subForm);

    let detailsSection = document.getElementsByTagName('summary');
    detailsSection[0].addEventListener('mouseover', this.openDetails);
    detailsSection[0].addEventListener('mouseleave', closeDetails);

    this.printSpan();

    let earthBtn = document.getElementById('earth_time_check');
    earthBtn.addEventListener('click', itsEarthTime);

    let heading1 = document.getElementsByTagName('h1');
    heading1[0].addEventListener('click', colorChange);

    let operation = document.getElementById('operation');
    operation.addEventListener('click', this.calculator);

    this.walkTheDOM(document.getRootNode());
    
}

function alienText(){
    let planetSelector = document.getElementById('planet');
    let hiddenAtt = document.getElementsByTagName('p');
    if(planetSelector.value !== 'Earth'){
        for(let i = 0; i < hiddenAtt.length; i++)  {
            hiddenAtt[i].removeAttribute('hidden');
        }
    }else if(planetSelector.value == 'Earth'){
        hiddenAtt[5].setAttribute('hidden', true);
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
    let gender = document.getElementsByName('gender');
    let genderVal = gender[0].value;
    let color = document.getElementById('color').value;
    let activities = document.getElementsByClassName('activity');
    let activitiesBool;
    output = [];
    for(let i = 0; i < activities.length; i++){
        if(activities[i].checked){
            activitiesBool = true;
            output.push(
                `<ul>
                    <li>${activities[i].value}</li>
                </ul>`
            )
        }
    }
    
    if(fName && lName && email && phone && bday && planet && genderVal && color && activitiesBool){
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
            genderCell.innerText = genderVal;

            activitiesCell.innerHTML = output.join('');
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

function openDetails(){
    console.log('openDetails');
    let details = document.getElementsByTagName('details');
    details[0].open = true;
}

function closeDetails(){
    console.log('closeDetails');
    let details = document.getElementsByTagName('details');
    details[0].open = false;
}

function printSpan(){
    let spans = document.getElementsByTagName('span');
    let text = '';
    for(let i = 0; i < spans.length; i++){
        text += spans[i].innerHTML;
    }
}

function itsEarthTime(){
    let date = new Date();
    let earthTime = document.getElementById('earth_time');
    earthTime.innerHTML = date.getUTCHours()+':'+date.getUTCMinutes()+':'+date.getUTCSeconds()+' '+date.getUTCDay()+'/'+date.getUTCDate()+'/'+date.getUTCFullYear();
}

function colorChange(){
    let bgColor = document.getElementsByClassName('container');
    let randomColor = "#000000".replace(/0/g,function(){return (~~(Math.random()*16)).toString(16);});
    setTimeout(function() {
        bgColor[0].setAttribute('background-color', randomColor)
    }, 3000);
}

function calculator(){
    console.log('calculator');
    let operation = document.getElementById('operation');
    let result = document.getElementById('result');
    let number1 = document.getElementById('n1').value;
    let number2 = document.getElementById('n2').value;
    number1 = Number(number1);
    number2 = Number(number2);
    if(typeof(number1) == 'number' && typeof(number2) == 'number'){
        if(operation.value == 'Add'){
            result.innerText = number1 + number2;
        }else if(operation.value == 'Multiply'){
            result.innerText = number1 * number2;
        }else if(operation.value == 'Subtract'){
            result.innerText = number1 - number2;
        }else if(operation.value == 'Divide'){
            result.innerText = number1 / number2;
        }
    }
}

function walkTheDOM(node){
    ni = document.createNodeIterator(document.documentElement, NodeFilter.SHOW_ELEMENT);

    while(node = ni.nextNode()) {
        console.log(node.nodeName);
    }
}