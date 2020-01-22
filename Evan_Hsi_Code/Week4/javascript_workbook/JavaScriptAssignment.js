window.onload = () => {
    document.getElementsByName('google')[0].setAttribute('href', 'https://www.google.com');
    document.getElementsByName('twitter')[0].setAttribute('href', 'https://www.twitter.com');
    document.getElementsByName('slack')[0].setAttribute('href', 'https://www.slack.com');
    document.getElementsByName('javadocs')[0].setAttribute('href', 'https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html');

    document.getElementById("planet").options[3].disabled = true;
    let planets = document.getElementById("planet");
    planets.addEventListener('change', alienText);

    let button = document.getElementById("form-sub");
    button.addEventListener('click', validate);

    let detail = document.getElementsByTagName('details')[0];
    console.log(detail);
    detail.addEventListener('mouseover', openDetails);
    detail.addEventListener('mouseleave', closeDetails);
    catSpan();
    document.getElementById('earth_time_check').addEventListener('click', earthTime);
    let ighead = document.querySelector(
        'div.container > h4'
    );
    console.log(ighead);
    ighead.onclick = cctime;

    document.getElementById('n1').addEventListener('mouseleave', displayCalc);
    document.getElementById('n2').addEventListener('mouseleave', displayCalc);
    document.getElementById('operation').onchange = displayCalc;

    //walkTheDom(document.body, walkTheDom);


}

function displayCalc() {
    let n1 = parseInt(document.getElementById('n1').value);
    let n2 = parseInt(document.getElementById('n2').value);
    if((n1 + n2) !== (n1 + n2)) {
        document.getElementById('result').innerHTML = "Invalid Numbers";
        return;
    }
    let op = document.getElementById('operation');
    let opval = op.options[op.selectedIndex].value;

    if(opval === 'Add') {
        document.getElementById('result').innerHTML = (n1 + n2);
    } else if(opval === 'Subtract') {
        document.getElementById('result').innerHTML = (n1 - n2);
    } else if(opval === 'Multiply') {
        document.getElementById('result').innerHTML = (n1 * n2);
    } else if(opval === 'Divide') {
        document.getElementById('result').innerHTML = (n1 / n2);
    }

}

function walkTheDom(node, func) {
    console.log(node);
    for (let i = 0; i < node.childNodes.length; i++) {
        func(node.childNodes[i], walkTheDom);
      }
}

function random_bg_color() {
    var x = Math.floor(Math.random() * 256);
    var y = Math.floor(Math.random() * 256);
    var z = Math.floor(Math.random() * 256);
    var bgColor = "rgb(" + x + "," + y + "," + z + ")";
    
    return bgColor;
}

function cctime() {
    setTimeout(colorChange, 3000);
}

function colorChange() {
    let ighead = document.querySelector(
        'div.container > h4'
    );
    console.log(ighead);
    ighead.style.background = random_bg_color();
}

function earthTime() {
    let et = document.getElementById('earth_time');
    let date = new Date();
    et.innerHTML = date.toISOString();
}

function catSpan() {
    let spans = document.getElementsByTagName('span');
    let spanstring = "";
    for(let i = 0; i < spans.length; i++) {
        spanstring += spans[i].innerHTML;
    }
    console.log(spanstring);
}

function openDetails() {
    console.log('openDetails')
    document.getElementsByTagName('details')[0].open = true;

}

function closeDetails() {
    console.log('closeDetails')
    document.getElementsByTagName('details')[0].open = false;
}

function validate() {
    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let bday = document.getElementById('bday').value;
    let color = document.getElementById('color').value;
    let gender = document.querySelectorAll('form.form-group > input[name^="gender"]:checked');
    let activities = document.querySelectorAll('.activity:checked');
    if(nameVal(firstname, lastname) == false) { return; }
    if(emailVal(email) == false) { return; }
    if(phVal(phone) == false) { return; }
    if(gender.length == 0) { return; }
    if(activities.length == 0) { return; }
    
    let row = document.createElement('tr');
    let nameTable = document.createElement('td');
    let emailTable = document.createElement('td');
    let phoneTable = document.createElement('td');
    let bdayTable = document.createElement('td');
    let colorTable = document.createElement('td');
    let genderTable = document.createElement('td');
    let actTable = document.createElement('td');
    let actList = document.createElement('ul');

    document.querySelector('tbody').appendChild(row);
    row.appendChild(nameTable);
    row.appendChild(emailTable);
    row.appendChild(phoneTable);
    row.appendChild(bdayTable);
    row.appendChild(colorTable);
    row.appendChild(genderTable);
    //row.appendChild(actTable);
    row.appendChild(actList);

    nameTable.innerText = firstname;
    emailTable.innerText = email;
    phoneTable.innerText = phone;
    bdayTable.innerText = bday;
    colorTable.innerText = color;
    genderTable.innerText = gender[0].value;

    for(let i = 0; i < activities.length; i++) {
        let ele = document.createElement('li');
        actList.appendChild(ele);
        console.log(activities);
        ele.innerText = activities[i].innerHTML;
    }

    document.getElementById('firstname').value = "";
    document.getElementById('lastname').value = "";
    document.getElementById('email').value = '';
    document.getElementById('phone').value = '';
    document.getElementById('bday').value = '';
    document.getElementById('color').value = '#000000';
    let cleargender = document.querySelectorAll('form.form-group > input[name^="gender"]:checked');
    let clearact = document.querySelectorAll('.activity:checked');
    for(let i = 0; i < clearact.length; i++) {
        clearact[i].checked = false;
    }
    cleargender[0].checked = false;

}

function nameVal(fname, lname) {
    let regex = /^([a-z ,.'-]{2,})+$/i;
    if(fname.match(regex) && lname.match(regex)) {
        return true;
    }
    else return false;
}

function emailVal(email) {
    let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(email.match(regex)){
        return true;
    }
    else return false;

}

function phVal(phone) {
    let regex = /^([0-9]{10})+$/;
    if(phone.match(regex)) { return true; }
    else return false;
}



function alienText() {
    let d = document.getElementsByClassName('container')[0]
    let p = d.getElementsByTagName('p')
    for(let i = 0; i < p.length; i++) {
        p[i].removeAttribute('hidden');
    }
}