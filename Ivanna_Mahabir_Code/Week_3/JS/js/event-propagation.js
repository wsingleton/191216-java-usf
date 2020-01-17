const OUTER_DIV = document.getElementById('outer');
const MIDDLE_DIV = document.getElementById('middle');
const INNER_DIV = document.getElementById('inner');

function innerFunction(e){
    alert('INNER!');
    /*
        e.stopImmediatePropagation()
            For this particular event, no other listners will be called. Neither
            those attached on the smae element, nor those attached to elements
            which will be transversd later (capture phase or in a buble phase)
            (event specific)
    */
        e.stopImmediatePropagation();

    /*
        e.stopPropagation
            Same as e.stopImmediatePropagation(), except chained events attached
            to the same target 
            (target specific)
    */
        e.stopPropagation();

    printEventStuff(e);
}

function innerPrompt(){
    prompt('INNER PROMPT');
    printEventStuff(e);
}

function middleFunction(e){
    alert('MIDDLE!');
    printEventStuff(e);
}

function outerFunction(e){
    alert('OUTER!');
    printEventStuff(e);
}

function printEventStuff(e){
    console.dir(e.target);
    console.log(e.eventPhase);
    console.log(e.currentTarget);
}

// ALL BUBBLING (w/o specifiying a 3rd param for .addEventListner(), it is false by default)
// Order of allerts: INNER -> MIDDLE -> OUTER
INNER_DIV.addEventListener('click', innerFunction);
INNER_DIV.addEventListener('click', innerPrompt);
MIDDLE_DIV.addEventListener('click', middleFunction);
OUTER_DIV.addEventListener('click', outerFunction);

// ALL BUBBLING (w/o specifiying a 3rd param for .addEventListner(), it is false by default)
// Order of allerts: INNER -> MIDDLE -> OUTER
// INNER_DIV.addEventListener('click', innerFunction);
// MIDDLE_DIV.addEventListener('click', middleFunction);
// OUTER_DIV.addEventListener('click', outerFunction);

//-----------------------------------------------------------

// ALL CAPTURING (3rd param = true) (takes precedence over bubbling)
// Order of alerts: OUTER -> MIDDLE -> INNER
// INNER_DIV.addEventListener('click', innerFunction, true);
// MIDDLE_DIV.addEventListener('click', middleFunction, true);
// OUTER_DIV.addEventListener('click', outerFunction, true);

//-----------------------------------------------------------

// INNER = bubbling, MIDDLE, & OUTER = capturing
// Order of alerts: OUTER -> MIDDLE -> INNER
// Capturing takes precedence over bubbling!
// INNER_DIV.addEventListener('click', innerFunction, false);
// MIDDLE_DIV.addEventListener('click', middleFunction, true);
// OUTER_DIV.addEventListener('click', outerFunction, true);

//-----------------------------------------------------------

// INNER & MIDDLE = bubbling, OUTER = capturing
// Order of alerts: OUTER -> INNER -> MIDDLE
// Capturing takes precedence over bubbling!
// INNER_DIV.addEventListener('click', innerFunction, false);
// MIDDLE_DIV.addEventListener('click', middleFunction, false);
// OUTER_DIV.addEventListener('click', outerFunction, true);
