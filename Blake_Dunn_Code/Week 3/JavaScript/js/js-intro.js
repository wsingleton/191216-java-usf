// Single line

/*
    Multi-line
    comments.
*/

/*
    What is JavaScript?

        - https://github.com/getify/You-Dont-Know-JS/tree/1st-ed
        - https://github.com/getify/You-Dont-Know-JS/tree/2nd-ed

        - It is the language of the Internet
            + a lightweight, interpreted programming language with first-class functions
            + loosely-type; types exist, but are not declared explictly
            + not technically an OO language, but referred to as an OB language (Object-Based)
            + originally Brenden Eich of Netscape (Mozilla) in days
            + is most commonly run in web browsers (Google Chrome V8 Engine)
            + Server-side JS is possible with Node.js (more of that later...)
            
        - It is unrelated to Java
            - "Java is to JavaScript as ham is to hamsters." -- Jeremy Keith, 2009
            - name is a marketing ploy to gain attention from the existing Java community
            - syntatctic similarities are superficial, as most C-derived languages look similar

        - It is an implementation of the ECMAScript standard
            + made official in TC39 (TC = Technical Committee)
            + current version is ECMAScript 2019 (ES10)
            + standard: https://www.ecma-international.org/ecma-262/10.0/index.html
            + https://developer.mozilla.org/en-US/docs/Web/JavaScript

        - It uses a single-threaded memory model
            + consists of the Stack, Heap, Event Table, Event Queue, and the Event Loop
            + the Event Loop gives JS the illusion of running tasks concurrently
            + Event Loop video: https://www.youtube.com/watch?v=8aGhZQkoFbQ
            + https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop    
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
            + the value of a variable that has been declared, but not intialized

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



//--------------------------------------------------------------------------

let today = new Date();
let currentHour = today.getHours();
let greeting;

if (currentHour > 18) {
    greeting = 'Good evening';
} else if (currentHour > 12) {
    greeting = 'Good afternoon';
} else if(currentHour > 0) {
    greeting = 'Good morning';
} else {
    greeting = 'Welcome'
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
        + provides the ability of an inner function to access the scope of it outer/parent function
        + often referred to as "closure" scope
*/

// var location = 'https://google.com'; // sends us to Google (same as change value of window.location)
// let location = 'https://google.com'; // SyntaxError

/* 
    Variable Declarative Keywords

        - var
            + can be scoped globally or locally
            + cannot be block scoped
            + subject to hoisting phenomenon
            + used when declaring a simple mutable variable

        - let
            + scoped to the global, local or the block level
            + introduced ES2015 (ES6)
            + used when declaring a simple mutable variable

        - const
            + scoped to the global, local or the block level
            + introduced in EC2015
            + used when declaring an immutable variable
            + must be intialized upon declaration (no deferred assignment)

        - (global)
            + lack of a keyword
            + values declared in such a way are bound to the browser's window object
            + bad practice to use; causes memory leaks
*/

// Does not work, constant values can not be reassigned
// const MEANING_OF_LIFE = 42;
// MEANING_OF_LIFE = 43;

// Does not work, no deferred assignments allow for constant variables
// const PI;
// PI = 3.14;

function test1() {

    console.log(x); // undefined
    // console.log(y); // throws ReferenceError
    // console.log(z); // throws ReferenceError

    if(true) {
        var x = 5;
        let y = 10;
        const z = 20;
    }

    console.log(x); // 5
    // console.log(y); // throws ReferenceError
    // console.log(z); // throws ReferenceError
}

test1();

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

let z = 1 + 1 + '1';
console.log(z); // '21'

let z = '1' + 1 + 1;
console.log(z); // '111'

let y = (1 == '1');
console.log(y); // true

let y = (1 === '1');
console.log(y); // false

console.log(0 == '0'); // true
console.log(0 == ''); // true (because of type coercion and truthy/falsy values)
console.log('' == ' '); // false
console.log(NaN == null); // false (NaN is NEVER equal to anything)
console.log(NaN == NaN); // not even itself...

let yourValue;
if (yourValue) {
    console.log('truthy') // technically semicolons are not required, but use them anyway (best practice)
} else {
    console.log('falsy')
}

yourValue = 'jello';
if (yourValue) {
    console.log('truthy');  
} else {
    console.log('falsy');
}

yourValue = [];
if (yourValue) {
    console.log('truthy');  
} else {
    console.log('falsy');
}

yourValue = {};
if (yourValue) {
    console.log('truthy') 
} else {
    console.log('falsy')
}

yourValue = 10 / 0;
if (yourValue) {
    console.log('truthy') // truthy because infinity is defined
} else {
    console.log('falsy')
}

yourValue = 10 / 'jello';
if (yourValue) {
    console.log('truthy') 
} else {
    console.log('falsy')
}

/*
    Guard and Default Operators

        - Guard 
            + &&
            + ex: return authUser && username;
            + A && B will l return B if A is truthy
            + basically, a short-curcuit AND with some neat side effects

        - Default
            + ||
            + ex: let authUser = authenticate(creds) || {};
            + A || B will return A if A is truthy, otherwise it defaults to B
            + basically, a short-circuit OR with some neat side effects
*/

/*
    Functions

        - Types of functions
            + Standard function declarations
            + Anonymous functions and function expressions
            + Immdiate-invoked function expressions (IIFEs)
            + Callback funtions
            + Arrow functions
            + Generator function

        - Functions are FIRST-CLASS MEMEBERS in the language
            + functions can be assigned to a variable
            + functions can be passed as a parameter to other functions (callback)
            + functions can be declared inside of other functions (closures)
            + functions can return another function 

        - Anonymous functions and function expressions
            + a variable can be assigned to the logic of a function
            + functions on the right side of the assignment operator do not require declared names
            + the logic of the function is invoked using the variable to which it was assigned

        - IIFEs
            + an implementation of the Self-Executing Anonymous Function design patter
            + anonymous functions that are executed as soon as the interpreter comes across them
            + https://developer.mozilla.org/en-US/docs/Glossary/IIFE

        - Generator functions
            + uses the function* declaration syntax
            + return a Generator object
            + can be used to generate values, finite or infinite
            + https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/function*

        - Arrow functions
            + introduced in ES2015
            + a syntactically compact alternative to regular function expressions
            + no bindings to the 'this', 'arguments', 'super', 'new.target' keywords
            + https://dev.to/ycmjason/let-me-explain-to-you-what-is-this-javascript-44ja
*/

function getArea(width, height) {
    return width * height;
}

let myArea = getArea(5,10);
console.log(myArea); // 50

myArea = getArea('5', 10);
console.log(myArea); //50

myArea = getArea('five', 10);
console.log(myArea); //NaN

function getSize(width, height, depth) {
    let area = getArea(width, height);
    let volume = area * depth;
    return [area, volume]; // returning multiple values from a function
}

let result = getSize(7, 5, 10);
console.log(result[0], result[1]);

// Anon functions
let area = function (width, height) {
    return width * height;
}

console.log(area);
console.log(area(5,10));

// IIFE

myArea = (function (width, height) {
    console.log(width, height);
    return width * height;
})(5,20);

console.log(myArea);

// Arrow functions

let elements = [
    'Hydrogen',
    'Helium',
    'Lithium',
    'Beryllium'
];

console.log(elements[0]); // 'Hydrogen'

// Pre - ES2015
elements.forEach(function(element) {
    console.log(element);
});

console.log('+---------------+');

elements.forEach((element) => {
    console.log(element);
});

console.log('+---------------+');


elements.forEach(element => console.log(element));


console.log('+---------------+');


elements.forEach((element) => console.log(element));


console.log('+---------------+');


let myMap = elements.map(element => element.length);
console.log(myMap);

/*
    Hoisting

        A general way of thinking about how execution context (specifically the creation 
        and execution phases) work in JS. The JS interpretor does not execute scripts
        sequentially (line by line), but instead whenever a script enters into a new 
        execution context, there are two phases of activity:

            1. Preparation/Creation
                - the new scope is created
                - declared variables and functions (and their arguments) are created (memory allocated on Stack)

            2. Executions
                - assignment of values to variables
                - runs function invocations
                - evaluate expressions
 */

 testFunctionHoist();

 function testFunctionHoist() {
     console.log('function was hoisted.');
 }

 function hoist_test1() {
     var x;
     x = 6;
     console.log(x);
 }

 function hoist_test2() {
     var x;
     console.log(x);
     x = 6;
 }

 function hoist_test3() {
    console.log(x);
    var x = 6;
}

function hoist_test4() {
    console.log(x); // throws ReferenceError
    let x = 6;
}

function hoist_test5() {
    console.log(X); // throws ReferenceError
    const X = 6;
}

function hoist_test6() {
    console.log(b); // throws ReferenceError
    b = 6;
}

// hoist_test7(); // throws ReferenceError: at this point, hoist_test7 is not visible at all 
let hoist_test7 = function() {
    console.log(x);
    var x = 6;
}

// hoist_test8(); // throws TypeError: hoist_test8 is declared, but is not yet a function 
var hoist_test7 = function() {
    console.log(x);
    var x = 6;
}

function hoist_test9() {

    console.log(b); // throws ReferenceError

    function innerFunction() {
        console.log(b); // undefined
        var x = 6;
        console.log(b); // 6
    }
    console.log(b); // throws ReferenceError
}

hoist_test9();

/*
    Closures

        According to MDN, a closure is the combination of a function bundled together (enclosed) 
        with references to its surrounding state (the lexical environment)

        - gives an inner function access to an outer function's scope
            + even if the inner function was the returned value of the outer function
            + an effective way of employing encapsulation within JS

*/

// Create counter
let counter = 0;

function incrementCounter() {
    return counter++;
}

function incrementCounter_v2() {
    let myCounter = 0;
    return myCounter++;
}

function incrementCounter_v3 () {

    let myCounter = 0;

    return function() {
        return ++myCounter;
    }
}

let count = incrementCounter_v3();


/*
    Template Literals

        - introduced in ES2015 (ES6)
        - allows for value/expression interpolation (think System.out.printf())
*/

let name = 'Blake';
let age = 27;
console.log(name + 'is' + age);
console.log(`${name} is ${age}`); // interpolation
console.log(`${name} will be ${age + 1} next year.`); // can be used with expressions

// Any included whitespace is kept
console.log(`<p>
                ${name}
            </p>`);

/*
    Creating Objects

        - Object literal notation
            + uses {} to encapsulate states and behaviors of the object
            + property/key names are separated from their values using a colon (:)
            + key/value pairs are separated from one another by a comma (,)

        - Constructor notation
            + can be created using the Object constructor, and configured separately
            + a "class" function can be used to create instances of an object

        - Class syntax 
            + introduced in ES2015
            + sugar syntax; effectively a cleaner implementation of "class" functions
            + class declarations are not subject to hoisting
            + capable of containing static methods
            + cleaner inheritance configuration using the 'extends' keyword ("subclassing")

 */

 // Object literals

let hotel = {
    name: 'Marriot',
    rooms: 180,
    booked: 162,
    available: function() {
        return this.rooms - this.booked;
    }
};

let myHotel = {
    name: 'Ritz',
    rooms: 300,
    booked: 150,
    available() {
        return this.rooms - this.booked;
    }
};

document.write(`<h2>${hotel.name}</h2>`);
document.write(`<ul>
                    <li>Total Rooms: ${hotel.rooms}</li>
                    <li>Booked Rooms: ${hotel.booked}</li>
                    <li>Available Rooms: ${hotel.available()}</li>
                </ul>`);

/*
    JSON

        - stands for: JavaScript Object Notation
        - syntactically similar to JS object literal notation, hence the name...
        - note the syntactic differences (props are encapsulated w/in quotations, no functions/methods are represented)
        - used as a "data interchange format"; helps us to send data from JS <-> Java (as an alternative to XML)

*/

let hotelJSON = JSON.stringify(hotel);
console.log(hotelJSON);
console.log(typeof(hotelJSON), hotelJSON);

// Constructor notation
let newHotel = new Object();
console.dir(newHotel);
newHotel.name = 'Four Seasons';
newHotel.rooms = 300;
newHotel.booked = 190;
newHotel.available = () => {
    return this.rooms - this.booked;
};

console.dir(newHotel);

// "Class" function

function Hotel(name, rooms, booked) {
    this.name = name;
    this.rooms = rooms;
    this.booked = booked;
    this.available = function () {
        return this.rooms - this.booked;
    }
};

let yourHotel = new Hotel('Holiday Inn', 100, 75);
console.dir(yourHotel);
console.log(yourHotel.name, yourHotel.available());


// Class syntax

class Animal {
    static x = 5;

    //no such thing as constructor overloading in JS (there can be only one!)
    constructor(name) {
        this.name = name;
    }

    speak() {
        console.log(this);
        console.log(this.name + 'speaks...');
    }

 }

 class Dog extends Animal {

    constructor(name) {
        this.name = name;
    }

    speak() {
        console.log(this);
        console.log(this.name + 'barks...');
    }

    wagTail = () => {
        console.log(this);
        console.log('The good boy is wagging his tail');
    }
 }

 let spot = new Dog('Spot');
 spot.speak();
 spot.wagTail();
 console.log(Animal.x);

 


 // Spread operator



 // Destructuring operator
 let j, k, rest;
 [j, k] = [10, 20];

 console.log(j);
 console.log(k);

// Comibing the spread operator with the destructuring operator
 [j, k, ...rest] = [10, 20, 30, 40, 50];
 console.log(j);
 console.log(k);
 console.log(rest);

 //Using the destructuring with object

 let obj = {
     p: 42,
     q: true
 };

 let {p, q} = obj;
 console.log(p);
 console.log(q);



 // -------------------------------

 // Error handling

 function throwsError() {
     throw new Error('oop. error');
 }

 try {
     throwsError();
 } catch (Error) {
     console.log('error caught')
 }

 class CustomError extends Error {
     
 } 