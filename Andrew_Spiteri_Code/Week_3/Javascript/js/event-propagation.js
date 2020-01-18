const OUTER_DIV = document.getElementById('outer');
const MIDDLE_DIV = document.getElementById('middle');
const INNER_DIV = document.getElementById('inner');

function innerFunction(e){
    alert('INNER');
    /*
        e.stopImmediatePropagation()
            For this particular event, no onther listeners will be called. Neither
            those attached on the same element, nor those attached to elements
            which will be traversed later (capture phase or in a bubbling phase).
    */
    // e.stopImmediatePropagation();

   /*
        e.stopPropagation()
            Same as e.stopImmediatePropagation(); except chained events attached to 
            the same target object will still fire off
   */
    e.stopPropagation();
    printEventStuff(e);
}
function innerPrompt(){
    prompt('INNER PROMPT');
    printEventStuff(e);
}

function middleFunction(e){
    alert('MIDDLE');
    printEventStuff(e);
}
function outerFunction(e){
    alert('OUTER');
    printEventStuff(e);
}
function printEventStuff(e){
    console.log(e);
    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget);
}
//ALL BUBBLING (w/o specifying a third param for our addEventListener, it is false by default)
//Order of alerts: INNER -> MIDDLE -> OUTER
INNER_DIV.addEventListener('click', innerFunction);
MIDDLE_DIV.addEventListener('click', middleFunction);
OUTER_DIV.addEventListener('click', outerFunction);
//-------------------------------------------------------------
//ALL CAPTURING (3rd param = true)
// //Order outer -> middle -> inner
// INNER_DIV.addEventListener('click', innerFunction, true);
// MIDDLE_DIV.addEventListener('click', middleFunction, true);
// OUTER_DIV.addEventListener('click', outerFunction, true);
//-------------------------------------------------------------
//INNER = BUBBLING, MIDDLE & OUTER = CAPTURING
//Order of alerts: outer -> middle -> inner
//The capturing  phase takes precedent over the bubbling phase
// INNER_DIV.addEventListener('click', innerFunction);
// MIDDLE_DIV.addEventListener('click', middleFunction, true);
// OUTER_DIV.addEventListener('click', outerFunction, true);
//-------------------------------------------------------------
//inner & middle = bubbling, outer = capturing
// INNER_DIV.addEventListener('click', innerFunction);
// MIDDLE_DIV.addEventListener('click', middleFunction);
// OUTER_DIV.addEventListener('click', outerFunction, true);