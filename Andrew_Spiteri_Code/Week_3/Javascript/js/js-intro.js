//Single line comment
/*
    Multi-line comments
*/
/*
    What is Javascript?

        It is the language of the Internet
            -a lightweight, interpreted language with first-class functions
            -loosely typed language; types exist but are not declared explicitly
            -not technically an OO language but referred to as Object Based language
            -originally Brenden Eich of Netscape (Mozilla) in 10 days
            -is most commonly run in web browsers (Google Chrome V8 Engine)
            -server-side JS is possible with Node.js

        Unrelated to Java
            -"Java is to JS as ham is to hamsters" -- Jeremy Keith, 2009
            -marketing ploy to attention from existing Java community
            -syntactic similarities are superficial, most C-derived languages similar

        Is is an implemnetation of ECMAscript standard
            -made official in TC39
            -current version is ECMAscript 2019 (ES10)
            -standard found at https://www.ecma-international.org/ecma-262/10.0/index.html
            - Mozilla web docs https://developer.mozilla.org/en-US/docs/Web/JavaScript

        It uses a single-threaded memory model
            -consists of the Stack, Heap, Event Table, Event Queue, and Event Loop
            -the Event Loop gives JS the illusion of running tasks concurrently
                -allows for non-blocking operations
            -Event Loop video https://www.youtube.com/watch?v=8aGhZQkoFbQ
            -Event Loop Mozilla docs https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop

        JS Datatypes
            -Boolean
                +represents a logical entity having one of two values: true or false

            -Number
                +represents a 64 bit floating point number

            -String
                +represents textual data

            -Null
                + intentional absence of an object value
            
            -Undefined
                + the value of a variable that has been declared but not initialized
            
            -Symbol
                + represents a guaranteed unique value
            
            -Object
                + refers to a data structure containing states and behaviors
                + subtypes: arrays and functions          

*/
 let x = 'color';
 console.log(typeof(x));
 
x = function(){}
console.log(typeof(x));
 //----------------------------------------------

 let today = new Date();
 let currentHour = today.getHours();
 let greeting;
 if(currentHour > 18){
     greeting = 'Good evening';
 }else if(currentHour > 12){
     greeting = 'Good afternoon';
 }else if(currentHour > 0){
     greeting = 'Good morning';
 }else{
     greeting = 'Welcome'
 }
 //We can user the 'document' object to inject html into the webpage
 document.write('<h3>'+greeting+'</h3>');


 /*
    -global
        +THE SCOPE THAT CONTAINS, AND IS VISIBLE IN, ALL OTHER SCOPES
    -local
        +any new scope created inside of the global scope
        +as result, sometimes referred to as function scope

    -block
        +any new scope created inside of a local scope
        +accomplished through if statements, while loops, trys, catches, for loops

    -lexical 
        +provides the ability of an inner function to access the scope of its outer or parent 
            function
        +often referred to as 'closure' scope
 */

 //var location = 'https://www.google.com' //sends us to Google same asa changing value of window.location
 //let location  //syntax error, b/c  location already defined in global scope

 /*

 Variable scopes
    -var
        +can scoped globally or locally
        +cannot be block scoped
        +subject to hoisting
        +used when wanted to declare a simple mutable variable

    -let
        +scoped to the local or the block level 
        +introduced ES2015 (ECMAscript) (ES6)
        +used when declaring a simple mutable variable

    -const
        +scoped to global, local, or block level
        +introduced in ES2015
        +used when declaring an immutable variable
        +must be initialized upon declaration (no deferred assignments)

    -(global)
        +values declared in such a way are bound to the window object
        +very bad practice, often causes memory leaks        
 */

//  const MEANING_OF_LIFE = 42;
// MEANING_OF_LIFE = 43;

//  //Does nto work, no deferred initialization allowed
//  const PI;
//  PI = 3.14;

 /*
    Type Coersion and Truthy/Falsy Values

        -Type Coersion
            +the automatic or implicit conversion of values from one datatype to another
            + ex: 7 + 7 + '7' = '147'

        -Truthy/Falsy values
            +all variables, regardless of the datatype of their value, can be evaluated as booleans
            +there are six falsy values:
                -false
                -NaN
                -0
                -null
                -undefined
                -""

 */

let z = 1 + 1 + '1'; //21
console.log(z);

/*
    Guard and Default Operators
        -Guard 
            +&&
            +ex: return authUser && username;
            + A && B will return B if A is truthy
            +basically, a short-circuit AND with some neat side effects
        
        -Default
            +|| 
            +ex: let authUser = authenticate(creds) || {};
            +A || B will return A if A is truthy, otherwise it defaults to B
            +basically, a short-circuit OR with come neat side effects
*/
/*
    Functions

        -Types of functions
            +Standard function declarations
            +Anonymous functions and function expressions
            +Immediate-invoked function expressions (IIFEs)
            +Arrow functions
            +Generator functions
            +Callback functions

        -Functions are first class members in the language
            +functions can be assigned to a variable
            +functions can be passed as a parameter to other functions (callback)
            +functions can be declared inside of other functions (closures)
            +functions can return another function

        -Anonymous functions and function expressions
            +a variable can be assigned to the logic of a function
            +functions on the right-side of the assignment operator do not require declared names
            +the logic of the functioin is invoked using the variable to which it was assigned
        
        -IIFEs
            +an implementation of the self-executing anonymous function design pattern
            +anonymous functions that are executed as soon as the interoreter comes across them
            +https://developer.mozilla.org/en-US/docs/Glossary/IIFE

        -Generator functions
            +uses the function* generator syntax
            +return a Generator object
            +can be used to generate values, finite or infinite
            +https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/function*

        -Arrow functions
            +introduced in ES2015
            +a syntactically compact alternative to regular function expressions
            +no bindings to the 'this', 'arguments', 'super', 'new.target' keywords

*/

//Standard function declarations
function getArea(width, height){
    return width * height;
}

let myArea = getArea(5, 10);

function getSize(width, height, depth){
    let area = getArea(width, height);
    let volume = area * depth;
    return [area, volume]; //returning multiple values from a function
}

let result = getSize(7 ,5, 10);
console.log(result[0], result[1]);

//Anon functions
let area = function (width, height){
    return width * height;
}
console.log(area);
console.log(area(5,10));

//IIFE
myArea = (function(width, height){
    console.log(width,height);
    return width *height;
    
})(5, 10);
console.log(myArea);

//Arrow functions
let elements = [
    'Hydrogen',
    'Helium',
    'Lithium',
    'Beryllium'
];
console.log(elements[0]); //'Hydrogen'

elements.forEach(function(element){
    console.log(element);
})

elements.forEach((element) => {
    console.log(element);
});

elements.forEach(element => console.log(element));

let myMap = elements.map(element => element.length);
console.log(myMap);



//Hoisting
function test1(){
    console.log(x); //undefined
    console.log(y); //ReferenceError
    console.log(z); //ReferenceError

    if(true){
        var x = 5;
        let y = 10;
        const z = 20;
    }

    console.log(x); //5
    console.log(y); //ReferenceError
    console.log(z); //ReferenceError
}

/*
    Hoisting
        A general way of thinking about hwo execution context, (specifically the creation and execution
        phases) work in JS.  The JS interpreter does not execute scripts sequentially (line by line).  but instead whenever
        a script enters into a new execution context, there are two phases of activity:

            1. Preparation/Creation
                -the new scope is created
                -declared variables and functions (and their arguments) are created (memory allocated on Stack)

            2. Execution
                -assignment of values to variables
                -runs function invocations
                -evaluate expressions

*/
testFunctionHoist();

function testFunctionHoist(){
    console.log('function was hoisted')
}

function hoist_test1(){
    var x;
    x = 6;
    console.log(x);
}

function hoist_test2(){
    var x;
    console.log(x);
    x = 6;
}

function hoist_test3(){
    console.log(x);
    var x = 6;
}

function hoist_test4(){
    console.log(x);
    let x = 6;
}

function hoist_test5(){
    console.log(X);
    const X = 6;
}

function hoist_test6(){
    console.log(b); //ReferenceError
    b=6;
}

function hoist_test19(){
    console.log(b); //hoisted
    window.b=6;
}

hoist_test7(); //ReferenceError
let hoist_test7 = function(){
    console.log(x);
    var x = 6;
}

hoist_test8(); //TypeError, hoist_test8 is declared but is not yet a function
var hoist_test8 = function(){
    console.log(x);
    var x = 6;
}

function hoist_test9(){
    console.log(b); //throws ReferenceError
    function innerFunction(){
        console.log(b); 
        var b = 6;
        console.log(b);
    }
    console.log(x);
}

//Javascript this keyword
https://dev.to/ycmjason/let-me-explain-to-you-what-is-this-javascript-44ja

/*
    Closures
        Accounding to MDN, a closure if the combination of a function bundled together (enclosed)
        with references to its surrounding state (the lexical environment).

        -gives an inner function access to an outer function's scope
            +evne if the inner function was the reurned value of the outer function
            +an effective way of employing encapsulation within JS
*/

//Create some counter
let counter = 0;

function incrementCounter(){
    return counter++;
}

function incrementCounter_v2(){
    let myCounter = 0;
    return ++counter;
}

function incrementCounter_v3(){
    let myCounter = 0;
    return function(){
        return ++myCounter;
    };
}
let count = incrementCounter_v3();

console.dir(count);

//fun fun function Youtuber

//Template Literals

/*
    Introduced in ES2015
    Allows for value interpolation (think System.out.printf())

*/

let age = 29;
let name = 'Andrew';
console.log(name + ' is ' + age);

/*
    Creating Objects
*/