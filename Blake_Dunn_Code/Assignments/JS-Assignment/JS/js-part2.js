window.onload = () => {

    let string = 'html';
    walkTheDOM(string);
    
/* +---------- Task 1 ----------+ */

    document.getElementsByTagName('a')[0].setAttribute('href', 'https://www.google.com/');
    document.getElementsByTagName('a')[0].setAttribute('target', '_blank');
    document.getElementsByTagName('a')[0].innerHTML = 'Google';
    document.getElementsByTagName('a')[1].setAttribute('href', 'https://twitter.com/');
    document.getElementsByTagName('a')[1].setAttribute('target', '_blank');
    document.getElementsByTagName('a')[1].innerHTML = "Twitter";
    document.getElementsByTagName('a')[2].setAttribute('href', 'https://slack.com/');
    document.getElementsByTagName('a')[2].setAttribute('target', '_blank');
    document.getElementsByTagName('a')[2].innerHTML = "Slack";
    document.getElementsByTagName('a')[3].setAttribute('href', 'https://docs.oracle.com/en/java/');
    document.getElementsByTagName('a')[3].setAttribute('target', '_blank');
    document.getElementsByTagName('a')[3].innerHTML = 'JavaDocs';


/* +---------- Task 2 ----------+ */

    document.getElementById('planet').options[3].disabled = true;

    document.getElementsByTagName('table')[0].setAttribute('id', 'myTable');
    document.getElementsByTagName('p')[5].setAttribute('id', 'hidden');
    document.getElementById('hidden').innerHTML = 'Beep boop, are you ready for your anal probe?';
    
};


/* +---------- Task 3 ----------+ */

function alienText() {
    let select = document.getElementById('planet');
    let planet = select.options[select.selectedIndex].innerHTML;
    
    if (planet === 'Earth') {
        document.getElementById('hidden').hidden = true;
    }else if (planet === 'Mars' || planet === 'Proxima Centauri b') {
        document.getElementById('hidden').hidden = false;
    }
    
};

document.getElementById('form-sub').addEventListener('click', alienText);



/* +---------- Task 4 ----------+ */

function addNewRow() {
    let firstName = document.getElementById('firstname').value;
    let lastName = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let bDay = document.getElementById('bday').value;
    let genderChecked = document.getElementsByName('gender');
    let gender = '';
    for (let i = 0; i < genderChecked.length; i++) {
        
        if (genderChecked[i].checked) {
            gender = genderChecked[i].value;
        }
    }
    let color = document.getElementById('color').value;
    let activity = document.getElementsByClassName('activity');
    let actList = document.createElement('ul');
    for (let i = 0; i < activity.length; i++ ) {
        if (activity[i].checked){
           let x = document.createElement('li');
            x.innerHTML = activity[i].value;
            actList.append(x);
        }
    }

    console.log(firstName, lastName, email, phone, bDay, gender, color, activity);

    if((checkLength(firstName)) && (checkLength(lastName)) && (isEmail(email)) && (isPhoneNumber(phone)) && bDay && gender && color && activity) {

        let row = document.createElement('tr');
        let nameCell = document.createElement('td');
        let emailCell = document.createElement('td');
        let phoneCell = document.createElement('td');
        let bDayCell = document.createElement('td');
        let colorCell = document.createElement('td');
        let genderCell = document.createElement('td');
        let activitiesCell = document.createElement('td');
        
        row.appendChild(nameCell);
        row.appendChild(emailCell);
        row.appendChild(phoneCell);
        row.appendChild(bDayCell);
        row.appendChild(colorCell);
        row.appendChild(genderCell);
        row.appendChild(activitiesCell); 

        document.getElementsByTagName("table")[0].appendChild(row);

        nameCell.innerText = firstName + " " + lastName;
        emailCell.innerText = email;
        phoneCell.innerText = phone;
        bDayCell.innerText = bDay;
        colorCell.innerText = color;
        genderCell.innerText = gender;
        activitiesCell.appendChild(actList);
      
    }
    document.getElementById('firstname').value = '';
        document.getElementById('lastname').value = '';
        document.getElementById('email').value = '';
        document.getElementById('phone').value = '';
        document.getElementById('bday').value = '';
        document.getElementsByName('gender').checked = false;
        document.getElementsByClassName('activity').checked = false;

}

document.getElementById('form-sub').addEventListener('click', addNewRow);

function isEmail(string){

    let x = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(string);

    return x;

};

function isPhoneNumber(string){

    let str = string;
    let x;
    if (str.length === 10) {
        x = /^[0-9]+$/.test(str);
    }else {
        return false;
    }

    return x;

};

function checkLength (string) {
    if (string.length < 2) {
        return false;
    }
    return true;
}



/* +---------- Task 5 ----------+ */

function openDetails() {
    let detailsTag = document.getElementsByTagName('details')[0];

    if (detailsTag.open === true) {
        detailsTag.open = false;
    }else {
        detailsTag.open = true;
    }
}

document.getElementsByTagName('details')[0].addEventListener('mouseover', openDetails);
document.getElementsByTagName('details')[0].addEventListener('mouseleave', openDetails);



/* +---------- Task 6 ----------+ */

function concatSpan() {
    let string = '';
    let spanString = document.getElementsByTagName('span');
    for (let i = 0; i < 7; i++) {
        let str = spanString[i].innerHTML;
        string += str;
    }
    return string;
};

console.log(concatSpan());



/* +---------- Task 7 ----------+ */

function startTime() {
    let date = new Date();
    let time = date.toLocaleTimeString();
    document.getElementById('earth_time').innerHTML = time;
}

document.getElementById('earth_time_check').addEventListener('click', startTime);



/* +---------- Task 8 ----------+ */

function changeBackground(){
    let colors = ['red', 'blue', 'green', 'grey'];
    let randColor = colors[Math.floor(Math.random() * colors.length)];
    document.body.style.backgroundColor = randColor;
}

function delayedColor() {
    setTimeout(changeBackground, 3000);
}

document.getElementsByTagName('h1')[0].addEventListener('click', delayedColor);



/* +---------- Task 9 ----------+ */

document.getElementById('n1').addEventListener('input', checkValue1);
document.getElementById('n2').addEventListener('input', checkValue2);

function checkValue1() {
    let number1 = document.getElementById('n1').value;
    
    if (number1 === '' || number1 === 'string' || number1 instanceof String || number1 === NaN 
        || number1 === null || number1 === false || number1 === true) {
            return false;
    }else {
        return true;
    }
}

function checkValue2() {
    let opName = document.getElementById('operation');
    let operation = opName.options[opName.selectedIndex].text;
    console.log(operation);
    let number1 = document.getElementById('n1').value;
    let number2 = document.getElementById('n2').value;
    let result;

    if (number2 === '' || number2 === 'string' || number2 instanceof String || number2 === NaN 
        || number2 === null || number2 === false || number2 === true) {
            return false;
    }else {
        if (operation === 'Add'){
            result = parseInt(number1) + parseInt(number2);
        }else if (operation === 'Subtract'){
            result = parseInt(number1) - parseInt(number2);
        }else if (operation === 'Divide') {
            result = parseInt(number1) / parseInt(number2);
        }else if (operation === 'Multiply'){
            result = parseInt(number1) * parseInt(number2);
        }

        document.getElementById('result').innerHTML = result;

    }
}

/* +---------- Task 10 ----------+ */

function walkTheDOM(string) {
    let str = string;
    const docElements = document.querySelector(str);
    let children = docElements.childNodes;
    for (let i = 0; i < children.length;){
        if (children[i] != null) {
            console.log(children[i].nodeName);
        }
        if (children[i].hasChildNodes){
            let newChild = children[i].childNodes;
            func(newChild);
        }
        i++;
    }

}

function func(node) {

    for (let i = 0; i < node.length;){
        if(node[i].hasChildNodes){
            console.log(node[i].nodeName);
            let newChild = node[i].childNodes;
            func(newChild);
        }else {
            console.log(node[i].nodeName);
        
        }
        i++;
    } 

}



