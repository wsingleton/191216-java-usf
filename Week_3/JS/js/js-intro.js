// Single line comments

/*
    Multi-line
    comments.
*/

/*
    What is JavaScript?

        - It is the language of the Internet
            + a lightweight, interpreted programming language with first-class functions
            + loosely-type; types exist, but are not declared explicitly
            + not technically an OO language, but referred to as an OB language (Object-Based)
            + originally Brenden Eich of Netscape (Mozilla) in 10 days
            + is most commonly run in web browser (Google Chrome V8 Engine)
            + server-side JS is possible with Node.js (more or that later...)

        - It is unrelated to Java
            + "Java is to JavaScript as ham is to hamster." -- Jeremy Keith, 2009
            + name is a marketing ploy to gain attention from the existing Java community
            + syntactic similarities are superficial, as most C-derived languages look similar

        - It is an implementation of the ECMAScript standard
            + made official in TC39 (TC = Technical Committee)
            + current version is ECMAScript 2019 (ES10)
            + standard: https://www.ecma-international.org/ecma-262/10.0/index.html
            + https://developer.mozilla.org/en-US/docs/Web/JavaScript

        - It uses a single-threaded memory model
            + consists of the Stack, Heap, Event Table, Event Queue, and the Event Loop
            + the Event Loop gives JS the illusion of running tasks concurrently
            + https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop
            + https://www.youtube.com/watch?v=8aGhZQkoFbQ
            
*/

/*
    JS Datatypes

        - Boolean
            + represents a logical entity having one of two values: true or false
        
        - Number
            + represents a 64-bit floating point number

        - String
            + represents textual data

        - Undefined
            + the value of a variable that has been declared, but not initialized

        - Null
            + represents the intentional absence of any object value

        - Symbol
            + represents a guaranteed unique value

        - Object
            + refers to a data structure containing states and behaviors
            + subtypes: arrays and functions
*/

let x = 'color';
console.log(typeof(x));

x = 5;
console.log(typeof(x));

x = 3 > 5;
console.log(typeof(x));

x = {};
console.log(typeof(x));

x = [];
console.log(typeof(x));

x = function () {};
console.log(typeof(x));

//-----------------------------------------------------

let today = new Date();
let currentHour = today.getHours();
let greeting;

if (currentHour > 18) {
    greeting = 'Good evening';
} else if (currentHour > 12) {
    greeting = 'Good afternoon';
} else if (currentHour > 0) {
    greeting = 'Good morning';
} else {
    greeting = 'Welcome';
}

// We can use the 'document' object to inject HTML into our web page
document.write('<h3>' + greeting + '</h3>');

/*

    - global
        + the scope that contains, and is visible in, all other scopes

    - local
        + any new scope created inside of the global scope
        + as a result, sometimes referred to as "function" scope

    - block
        + any new scope created inside of a local scope
        + accomplished through: if, while, switch, try, catch, for

    - lexical
        + provides the ability of an inner function to access the scope of its outer/parent function
        + often referred to as "closure" scope

*/

// var location = 'https://www.google.com'; // sends us to Google (same as change value of window.location)
// let location = 'https://www.google.com'; // SyntaxError, because location is already a property of window

/*
    Variable Declarative Keywords

        - var
            + can be scoped globally or locally
            + cannot be block scoped
            + subject to hoisting phenomenon
            + used when declaring a simple mutable variable

        - let
            + scoped to the global, local, or the block level
            + introduced in ES2015 (ES6)
            + used when declaring a simple mutable variable

        - const
            + scoped to the global, local, or block level
            + introduced in ES2015
            + used when declaring an immutable variable
            + must be initialized upon declaration (no deferred assignment)

        - (global)
            + lack of a keyword
            + values declared in such a way are bound to the browser's window object
            + bad practice to use; causes memory leaks

*/

/*
    Type Coercion & Truthy/Falsy Values

        - Type coercion
            + the automatic, or implicit, conversion of values from one datatype to another
            + ex: 7 + 7 + '7' = '147'

        - Truthy/Falsy values
            + all variables, regardless of the datatype of their value, can be evaluated as booleans
            + there are six falsy values, everything else is truthy
            + falsy values:
                - false
                - NaN
                - 0
                - null
                - undefined
                - ""

*/

/*
    Guard and Default Operators

        - Guard
            + &&
            + ex: return authUser && username;
            + A && B will return B if A is truthy
            + basically, a short-circuit AND with some neat side effects

        - Default
            + ||
            + ex: let authUser = authenticate(creds) || {};
            + A || B will return A if A is truthy, otherwise it defaults to B
            + basically, a short-circuit OR with some neat side effects
*/