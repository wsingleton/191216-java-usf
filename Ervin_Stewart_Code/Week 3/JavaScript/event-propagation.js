const OUT_DIV = document.getElementById('outer');
const MIDDLE_DIV = document.getElementById('middle');
const INNER_DIV = document.getElementById('inner');

function innerFunction(e){
    alert('INNER!');
    console.log(e);
    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget);

}

function middleFunction(e){
    alert('MIDDLE!');
    console.log(e);
    

}
function outerFunction(e){
    alert('OUTER!');
    console.log(e);
    

}
function printEventStuff(e){

    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget);

}
// All Bubbling
//order of alerts:
INNER_DIV.addEventListener('click', innerFunction, false);
MIDDLE_DIV.addEventListener('click', middleFunction, false);
OUTER_DIV.addEventListener('click', outerFunction,true);