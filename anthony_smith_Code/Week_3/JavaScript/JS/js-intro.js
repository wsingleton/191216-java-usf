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


//String
let x = 'color';
console.log(typeof(x));

//Number
x = 5
console.log(typeof(x));

//boolean
x = 3 > 5
console.log(typeof(x));

//object
x = {};
console.log(typeof(x));

// object
x = [];
console.log(typeof(x));

//function
x = function(){};
console.log(typeof(x));

let today = new Date();
let currentHour = today.getHours();
let greeting;

if (currentHour > 18){
    greeting = 'Good Evening'
} else if (currentHour > 12){
    greeting = 'Good Afternoon'
} else if (currentHour > 0){
    greeting = 'Good Moring'
} else {
greeting = 'Welcome'
}

console.log(greeting);

function leapYear(date){

}




//use the .document object to inject HTML into our web page
document.write('<h3>' + greeting + '</h3>');




/*
    Variable Scopes

    - global
         + the scope that contains, and is visible in, all other scopes
    - local
        + any new scope created inside of the global scope
        + as a result, sometimes referred to as "function" scope
    -  block
        + any new scope created inside of a local scope
        + accomplished through: if, while, switch, try, catch, for
    - lexical
        + provides the ability of an inner function to access the scope of its outer/parent
          function
        + often referred to as "closure" scope
*/


/*
    Variable Declarative Keywords
- var

booleans
    + can be scoped globally or locally
    + cannot be block scoped
    + subject to hoisting phenomenon
    + used when declaring a simple mutable variable
- let
+ scoped to the global, local, or the block level + introduced in ES2015 (ES6)
+ used when declaring a simple mutable variable
- const
+ scoped to the global, local, or block level
+ introduced in ES2015
+ used when declaring an immutable variable
+ must be initialized upon declaration (no deferred assignment)
- (global)
+ lack of a keyword
+ values declared in such a way are bound to the browser's window object + bad practice to use; causes memory leaks

*/

// Does not work, constant values can not be reassigned
// const MEANING_OF_LIFE = 42;
// MEANING_OF_LIFE = 43;

// Does not work, no deferred assignments allow for constant variables
// const PI;
// PI = 3.14;

function test1(){

    console.log(x); // undefine 
   // console.log(y); 
  //  console.log(z);

    if(true){
        var x = 5;
        let y = 10;
        const z = 20;
    }

    console.log(x); 
  //  console.log(y);
  //  console.log(z);
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
console.log(z);

z = '1'+1+1
console.log(z);

//let y = (1 == '1');
//console.log(y);

let y = (1 === '1');
console.log(y);

console.log(0 == '0'); // true
console.log(0 == ''); // true (because of type coercion and truthy/falsy values)
console.log('' == ' '); // false
console.log(NaN == null); // false (NaN is NEVER equal to anything)
console.log(NaN == NaN); // not even itself..


let yourvalue;
// false becuase no value has been assign to your value 
if (yourvalue){
    console.log('truthy');    
} else {
    console.log('falsy');
}

//true
yourvalue = 'if you want somke you can get it for free';
if (yourvalue){
    console.log('truthy');
}else{
    console.log('falsy');
}

// truuuuuuuu
yourvalue = [];
if (yourvalue){
    console.log('truthy');
}else{
    console.log('falsy');
}

// truuuuuuu
yourvalue = {};
if (yourvalue){
    console.log('truthy');
}else{
    console.log('falsy');
}

// true
yourvalue = 10/0;
if (yourvalue){
    console.log('truthy');
}else{
    console.log('falsy');
}

//false , result is NaN (not a number) ?
yourvalue = 10/ 'jello'
if (yourvalue){
    console.log('truthy');
}else{
    console.log('falsy');
}

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

/*
    Functions

        - Types of functions
            + Standard function declarations
            + Anonymous functions and function expressions
            + Immediate-invoked function expressions (IIFEs)
            + Callback functions
            + Arrow functions
            + Generator function

        - Functions are FIRST-CLASS MEMBERS in the language
            + functions can be assigned to a variable
            + functions can be passed as a parameter to other functions (callbacks)
            + functions can be declared inside of other functions (closures)
            + functions can return another function

        - Anonymous functions and function expressions
            + a variable can be assigned to the logic of a function
            + functions on the right side of the assignment operator do not require declared names
            + the logic of the function is invoked using the variable to which it was assigned

        - IIFEs
            + an implementation of the Self-Executing Anonymous Function design pattern
            + anonymous functions that are executed as soon as the interpreter comes across them
            + https://developer.mozilla.org/en-US/docs/Glossary/IIFE

        - Generator functions
            + uses the function* declaration syntax
            + return a Generator object
            + can be used to generate values, can be finite or infinite
            + https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/function*

        - Arrow functions
            + introducted in ES2015
            + a syntactically compact alternative to regular function expressions
            + no bindings to the 'this', 'arguments', 'super', 'new.target' keywords

*/

//standard function 

function getArea(width, height){
    return width * height;
}

let myArea = getArea(10,20);
console.log(myArea);


let myArea2 = getArea('10',20);
console.log(myArea2);

let myArea3 = getArea('ten',20);
console.log(myArea3)




function getSize(width, height, depth) {
    let area = getArea(width, height);
    let volume = area * depth;
    return [area, volume]; // returning multiple values from a function
}



getSize(10,30,5);


let result = getSize(7, 5, 10);
console.log(result[0], result[1]);



// 1.	Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.





function leapYear(date){
    if (date % 4 == 0){
        console.log('This year is a leap year')
    } else {
        console.log('This year is not a leap yeat')
    }
}

leapYear(2020);

leapYear(2021);

function isEmail(string) 
{
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.emailAddr.value))
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}


isEmail('asmithjr89@me.com');