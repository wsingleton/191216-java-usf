const OUTER_DIV = document.getElementById('outer');
const MIDDLE_DIV = document.getElementById('middle');
const INNER_DIV = document.getElementById('inner');

function innerFunction(e) {
    alert('INNER!');

    /*
        e.stopImmediatePropagation();

            For this particular event, no other listeners will be called, neither those
            attached on the same element, nor those attached to elements which will be
            traversed later (capture phase or in a bubbling phase).
    */

    //e.stopImmediatePropagation();

    /*
        e.stopPropagation();
        
            same as e.stopImmediatePropagation, except chained events attached to 
            the same traget object will still fire off.
    */

   e.stopPropagation

    printEventStuff(e);
}

function innerPrompt(e) {
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
    console.log(e.target);
    console.log(e.eventPhase);
    console.log(e.currentTarget);
}

// ALL BUBBLING 
// Order of alerts; in->out

INNER_DIV.addEventListener('click', innerFunction);
INNER_DIV.addEventListener('click', innerPrompt)
MIDDLE_DIV.addEventListener('click', middleFunction);
OUTER_DIV.addEventListener('click', outerFunction);


// ALL CAPTURING out-> in

// Inner bubbling, middle & outer capturing outer -> middle -> inner
/*
INNER_DIV.addEventListener('click', innerFunction, false);
MIDDLE_DIV.addEventListener('click', middleFunction, true);
OUTER_DIV.addEventListener('click', outerFunction, true);
*/