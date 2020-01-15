//  Comments function like Java.
/*
    It's important to be able to comment.
*/
//  First-class functions can have variables assigned to them, and functions can be passed as a parameter, returned from other functions, or located inside of another function.
//  Types are not explicitely declared.  Loosely-typed.
//  Object Based (OB) but not Object Oriented
//  Brenden Eich built Javascript in 10 days
/*
    Most commonly run in web browsers (Google Chrome uses V8 Engine)
    Serverside JS is possible with Node.js
    Most js frameworks are not trusted on an enterprise level
    Exceptions exist: electron.js, react.js, angular.js, etc...
*/
//  JavaScript will use type-coersion to resolve type conflicts, which can get ... interesting.  For example: 7+7+'7'='147'
/*
    "Java is to JavaScript as ham is to hamster." -- Jeremy Keith, 2009
    Well... they are both made of meat...
    
    It is an implementation of the ECMAScript standard
        + made official in TC39 (TC = Technical Committee)
        + current version is ECMAScript 2019 (ES10)
        + ECMA = European Computer Manufacturers Association
        + JScript is another implementation of ECMAScript
    Kyle Simpson - You Don't Know Javascript (free on github)

    Cannot multithread.  Memory includes:
        + Stack, heap, event table, event queue, and event loop
        + Event loop gives the illusion of concurrent task completion
*/
/*
    JS has 7 datatypes
        Boolean - same as other languages
        Number - encompases all primitive numeric datatypes
        String - same as other languages
        Undefined - a declared variable that has not been initialized
        Null - intentional absence of an object value
        Symbol - gives a completely unique value, even when created using the same parameters/inputs
        Object - a data structure containing states and behaviours - arrays and functions are subtypes of object
*/

let x = "colour";
console.log(typeof(x));
x=5;
console.log(typeof(x));
x={}
console.log(typeof(x));
//----------------------
let today=new Date();
let currentHour = today.getHours();
let currentMinute = today.getMinutes();
let greeting;

if (currentHour > 18) {
    greeting="Good evening";
}
else if (currentHour>12) {
    greeting="Good afternoon";
}
else if (currentHour>0) {
    greeting="Good morning";
}
else {
    greeting="Welcome!"
}
document.write("<h2>" + greeting + "</h2>");
/*
    JS SCOPES:
        - global
            + contains and is visible to all other scopes
        - local
            + any new scope created inside of the global scope
            + sometimes referered to as function scope
        - block
            + any new scope created inside of a local scope
            + usually the result of if, while, switch, try, catch, for, and other statements inside of a local scope
        - lexical
            + provides the ability of an inner function to access the scope of its parent function
            + also referred to as closure scope
*/
/*
    Variable Declarative Keywords
        - var
            + can be scoped globally or locally
            + cannot be block scoped
            + subject to hoisting
            + used when a simple mutable variable was declared
        - let
            + scoped global, local, or block level
            + introduced in ES2015 (aka ES6)
            + used when declaring a simple mutable variable
            + not subject to hoisting
        - const
            + scoped global, local, or block level
            + introduced in ES2015
            + used when declaring an immutable variable
            + must be initialized upon declaration (no deferred assignment)
        - (global) - implicit
            + lack of a keyword
            + values declared in such a way are bound to the browser's window object
            + bad practice
            + often causes memory leaks
*/