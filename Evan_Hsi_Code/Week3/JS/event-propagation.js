const OUTER_DIV = document.getElementById('outer');
const MIDDLE_DIV = document.getElementById('middle');
const INNER_DIV = document.getElementById('inner');

function innerFunction(e) {
    alert('INNER!');
    printEventStuff(e);
}

function middleFunction(e) {
    alert('MIDDLE!');
    printEventStuff(e);
    
}

function outerFunction(e) {
    alert('OUTER!');
    printEventStuff(e);
    
}

function printEventStuff(e) {
    console.log(e.target);
    console.log(e.eventPhase);
    console.log(e.currentTarget);
}

// ALL BUBBLING 
// Order of alerts;
INNER_DIV.addEventListener('click', innerFunction);
MIDDLE_DIV.addEventListener('click', middleFunction);
OUTER_DIV.addEventListener('click', outerFunction);