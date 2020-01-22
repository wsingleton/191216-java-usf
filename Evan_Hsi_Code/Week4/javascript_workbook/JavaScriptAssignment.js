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

    walkTheDom(document.body, walkTheDom);


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
    let submitBtn = document.getElementById("form-sub");
    let formCheck = document.querySelectorAll( 
        'form.form-group > input[name^="gender"]:checked');
    console.log(formCheck);
    if(formCheck.length == 0) {
        console.log('invalid');
    }

        
    
}

function alienText() {
    let d = document.getElementsByClassName('container')[0]
    let p = d.getElementsByTagName('p')
    for(let i = 0; i < p.length; i++) {
        p[i].removeAttribute('hidden');
    }
}