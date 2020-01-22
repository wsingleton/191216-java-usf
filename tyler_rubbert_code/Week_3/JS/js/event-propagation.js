const OUTER_DIV = document.getElementById('outer');
const MIDDLE_DIV = document.getElementById('middle');
const INNER_DIV = document.getElementById('inner');

function innerFunction(e) {
    alert('INNER!');

    /*
        e.stopImmediatePropagation()

            For this particular even, no other listeners will be called. Neither 
            those attached on the same element, or those attached to elements 
            which will be traversed later (capture phase or in a bubbling phase).
    */
//    e.stopImmediatePropagation();

    /*
        e.stopPropagation()

            Same as e.stopImmediatePropagation, except chained events attached to 
            the same target object will still fire off.
    */
//    e.stopPropagation();

    printEventStuff(e);
}

function innertPrompt(e) {
    prompt('INNER PROMPT');
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
    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget);
}

// ALL BUBBLING (w/o specifiying a 3rd param for .addEventListener(), it is false by default)
// Order of alerts: INNER -> MIDDLE -> OUTER
INNER_DIV.addEventListener('click', innerFunction);
INNER_DIV.addEventListener('click', innertPrompt);
MIDDLE_DIV.addEventListener('click', middleFunction);
OUTER_DIV.addEventListener('click', outerFunction);
//-----------------------------------------------------------------------
// ALL CAPTURING (3rd param = true)
// Order of alerts: OUTER -> MIDDLE -> INNER
// INNER_DIV.addEventListener('click', innerFunction, true);
// MIDDLE_DIV.addEventListener('click', middleFunction, true);
// OUTER_DIV.addEventListener('click', outerFunction, true);
//-----------------------------------------------------------------------
// INNER = bubbling, MIDDLE & OUTER = capturing
// Order of alerts: OUTER -> MIDDLE -> INNER
// The Capturing phase takes prededent over the bubbling phase!
// INNER_DIV.addEventListener('click', innerFunction);
// MIDDLE_DIV.addEventListener('click', middleFunction, true);
// OUTER_DIV.addEventListener('click', outerFunction, true);
//-----------------------------------------------------------------------
// INNER & middle = bubbling, OUTER = capturing
// Order of alerts: OUTER -> INNER -> MIDDLE
// INNER_DIV.addEventListener('click', innerFunction);
// MIDDLE_DIV.addEventListener('click', middleFunction);
// OUTER_DIV.addEventListener('click', outerFunction, true);