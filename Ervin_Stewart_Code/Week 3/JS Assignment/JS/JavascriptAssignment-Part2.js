//1. link manipulation
document.getElementsByTagName('a')[0].setAttribute("href", "https://www.google.com");
document.getElementsByTagName('a')[2].setAttribute("href", "https://www.slack.com");
document.getElementsByTagName('a')[1].setAttribute("href", "https://www.twitter.com");
document.getElementsByTagName('a')[3].setAttribute("href", "https://www.javadocs.com");

//2.Remove Pluto From List
document.getElementById('planet').options[3].disabled= true;

//3. Function to display hidden alien message
document.getElementById('form-sub').addEventListener("click", alienText);

function alienText(){
    
if(document.getElementById('planet').options[1].selected===true ){
    document.getElementsByTagName('p')[5].hidden = false;
}else if(document.getElementById('planet').options[2].selected===true){
     document.getElementsByTagName('p')[5].hidden = false; 
}else if (document.getElementById('planet').options[0].selected===true){
    document.getElementsByTagName('p')[5].hidden = true;
}
}


//4.
function addToDirectory(){

    let newFirstNameField = document.getElementById('firstname');
    let newFirstName = newFirstNameField.value;
    let newLastNameField = document.getElementById('lastname');
    let newLastName = newLastNameField.value;
    //let name = newFirstName.concat(" ",newLastName);
    let email = document.getElementById('email').value;
    let phoneNumber = document.getElementById('phone').value;
    let birthday = document.getElementById('bday').value;
    let homePlanet = document.getElementById('planet').value;

    let genderCheck = document.getElementsByName('gender');
    let gender = null;
    for(let i = 0; i<genderCheck.length; i++){
        if(genderCheck[i].checked){
            gender = genderCheck[i].value;
        }

    }

    let color = document.getElementById('color').value;
    let hobby = document.getElementsByClassName('activity');
    let hobList = document.getElement('ul');
    for(let i = 0; i<hobby.length; i++){
        if(hobby[i].checked){
            let y = document.createElement('li')
            y.innerHTML = hobby[i].value;
            hobList.append(y);
        }
    }


    if((checkLength(newFirstName)) &&(checkLength(newLastName)) && (isPhoneNumber(phoneNumber)) && birthday && gender && color && hobby){
        let row = document.createElement('tr');
        let nameCell = document.createElement('td');
        let emailCell = document.createElement('td');
        let phoneCell = document.createElement('td');
        let bdayCell = document.createElement('td');
        let colorCell = document.createElement('td');
        let genderCell = document.createElement('td');
        let hobbyCell = document.createElement('td');

        row.appendChild(nameCell);
        row.appendChild(emailCell);
        row.appendChild(phoneCell);
        row.appendChild(bdayCell);
        row.appendChild(colorCell);
        row.appendChild(genderCell);
        row.appendChild(hobbyCell);

        document.getElementsByTagName('table')[0].appendChild(row);

        nameCell.innerText = newFirstName+ " " + newLastName;
        emailCell.innerText = email;
        phoneCell.innerText = phone;
        bdayCell.innerText = birthday;
        colorCell.innerText = color;
        genderCell.innerText = gender;
        hobbyCell.appendChild(hobList);
    }
    document.getElementById('firstname').value = '';
    document.getElementById('lastname').value = '';
    document.getElementById('email').value = '';
    document.getElementById('phone').value = '';
    document.getElementById('bday').value = '';
    document.getElementById('gender').value= '';
    document.getElementById('gender').value = '';
    document.getElementById('activity').checked = false;

 }
 document.getElementById('form-sub').addEventListener('click',addNewRow);
 
 function isEmail(string){
    let re = /\S+@\S+\.\S+/;
    return re.test(string);

 };

 function isPhoneNumber(string){
let str = string;
let x;
if(str.length ===10){
    x= /^[0-9]+$/.test(str);
}else {return false;}
return x;
 }

 function checkLength(String){
if(string.length <2){
    return false;
}return true;
 }

//5.
function openDetails(){
    let detailsTag = document.getElementsByTagName('details')[0];
    if(detailsTag.open ===true){
        detailsTag.open = false;
    }else {
        detailsTag.open = true;
    }
}
document.getElementsByTagName('details')[0].addEventListener('mouseover',openDetails);
document.getElementsByTagName('details')[0].addEventListener('mouseleave',openDetails);
//6.
function concatSpan(){
let string = '';
let spanStrings = document.getElementsByTagName('span');
for(let i = 0;i<7;i++){
    let str =spanStrings[i].innerText;
    string += str;
}
return string;
}
console.log(concatSpan());
//7.
function startTime(){
let date = new Date();
let time = date.toLocaleTimeString();
document.getElementById('earth_time').innerHTML = time;
}
document.getElementById('earth_time_check').addEventListener('click',startTime);

//8.
function changeBackground(){
let colors=['red','blue','green','grey'];
let newColor = colors[Math.floor(Math.random()* colors.length)];
document.body.style.backgroundColor = newColor
}

function delayColor(){
setTimeout(changeBackground,3000);

}
document.getElementsByTagName('h1')[0].addEventListener('click',delayColor);
//9.
document.getElementById('n1').addEventListener('input',checkValue1);
document.getElementById('n2').addEventListener('input', checkValue2);

function checkValue1(){
let number1 = document.getElementById('n1').value;

if(number1 === '' || number1 === 'string'|| number1 instanceof String|| number1 === NaN
|| number1 === null || number1=== false || number1 === true){
    return false;
}else{ return true;}

}

function checkValue2(){
    let operationNumber = document.getElementById('operation');
let operation = operationNumber.options[operationNumber.selectedIndex].text;
console.log(operation);
let number1 = document.getElementById('n1').value;
let number2 = document.getElementById('n2').value;
let result;
    if(number2 === '' || number2 === 'string'|| number2 instanceof String|| number2 === NaN
    || number2 === null || number2=== false || number2 === true){
        return false;
    }else{ if(operation === 'Add'){
        result = parseInt(number1)+parseInt(number2);
    }else if(operation === 'Subtract'){
        result = parseInt(number1) - parseInt(number2);
    }else if(operation === 'Divide'){
        result = parseInt(number1)/parseInt(number2);
    }else if(operation === 'Multiply'){
        result = parseInt(number1)*parseInt(number2);
    }
    
    
    document.getElementById('result').innerHTML = result;}
    

}

//10.
function walkTheDOM(string){
    let str = string;
    const
}
