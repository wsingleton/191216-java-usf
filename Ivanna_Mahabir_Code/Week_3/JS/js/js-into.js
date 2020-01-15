/*
    WHat is JavaScript?
    - It is the language of the Internet
        = a lightweight, interpreted programming language with first-class functions
        = loosely-type; types exist, but are not declared explictly
        = not technically an OO language, but referred to as an OB language (Object-Based)
        = originally Brenden Eich of Netscape (Mozilla) in 10 days
        = is most commonly run in web browsers (Google CHrome V8 Engine) (know)
        = Serve-side JS is possible with Node.js (more details later...)
    
    - It is unrelated to Java
        = "Java is to JavaScript as ham is to hamster." -- Jeremy Keith, 2009
        = name is a marketing ploy to gain attention from the existing Java community
        = syntactic similarities are superficial, as most C-derived languages look similar

    - It is an implementation of the ECMAScript standard
        = made official in TC39 (TC= Technical Committee)
        = current version is ECMAScript 2019 (ES10)
        = standard: https://www.ecma-international.org/ecma-262/10.0/index.html
        = https://developer.mozilla.org/en-US/docs/Web/JavaScript
    
    - It uses a single-threaded memory model
        = consists of the Stack, Heap, Event Table, Event Queue, and the Event Loop
        = the Event Loop gives JS the illusion of running tasks concurrently
        = https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop
        = https://www.youtube.com/watch?v=8aGhZQkoFbQ

*/

/*
    JS Datatypes

        - Boolean
            = represents a logical entity having one of two values: true or false

        - Number
            = represents a 64-bit floating point number
        
        - String
            = represents textual data
        
        - Undefined
            = the value of a variable that has been declared, but not initialized

        - Null
            = represents the intentional absence of any object value

        - Symbol
            = represents a guaranteed unique value

        - Object
            = refers to a data structure containing states and behaviors
            = subtypes: arrays and functions
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

x = function() {};
console.log(typeof(x));

//-----------------------------------------------------------

let today = new Date();
let currentHour = today.getHours();
let greeting;

if(currentHour > 18){
    greeting = "Good Evening";
} else if (currentHour > 12){
    greeting = "Good Afternoon";
} else if (currentHour > 0){
    greeting = "Good Morning";
}else {
    greeting = "Welcome";
}



/*
    - global
        = the scope that contains, and is visible in, all other scopes

    - local
        = any new scope created inside of the global scope
        = as a result sometimes referred to as "function" scope
    
    - block
        = any new scope created inside of a local scope
        = accomplished through: if, while, switch, try, catch, for
    
    - lexical
        = provides the ability of an inner function to access the scope of its outer/parent function
        = often referred to as "closure" scope
*/

//var location = "https://www.google.com"; // sneds us to Google (same as change value of window.location)
//variable declared var in the global scope will be bound to the window


//var location = "https://www.google.com"; // SyntaxError, 

/*
    Variable Declarative

    - var
        = can be scoped globally or locally
        = cannot be block scoped
        = subject to hoisting phenomenon
        = used when declaring a simple mutable variable
    
    - let
        = scoped to the global, local or the block level
        = introduced in ES2015 (ES6)
        = used when declaring a simple mutable variable

    - const
        = scoped to the global, local or block level
        = introduced in ES2015
        = used when declaring an immutable variable
        = must be initailised upon declaration (no deferred assignments)

    - (global)
        = lack of a keyword
        = values declared in such a way are bound to the browser's window object
        = bad practice, to use, causes memory leaks
*/

/*
    Type Coercion & Truthy/Falsy Values

    - Type coercion
        = the automatic for implicit, converison of values from one datatype to another
        = eg: 7 + 7 + '7' = '147'

    - Truthy/Falsy values
        = all variables, regardless of the datatype of value can be evaluated as booleans
        = there are six falsy values, everything else is truthy
        = falsy values:
            - false
            - Nan
            - 0
            - null
            - undefined
            - ""
*/
let youValue;
if(yourValue){
    console.log('truthy');
} else{
    console.log('falsy');
}



/*
    Guard and Default Operators
        - Guard
            = &&
            - eg: return authUser && username;
            = A && B will return B if A is truthy
            = basically, a short-circuit AND with some neat side effects

        - Default
            = || 
            = eg: let authUser = authenticate(creds) || ();
            = A || B will return A if A is truthy, otherwise it defaults to B
            = basically, a short-circuit OR with some neat side effects    
*/

/*
    Functions

        - Types of functions
            = Standard function declaration
            = Anonymous functions and function expression
            = Immediate-invoked function expressions (IIFEs)
            = Callback functions
            = Arrow functions
            = Generator function

        - Functions are FIRST_CLASS MEMBERS in the language
            = functions can be assigned to a variable
            = functions can be passed as a parameter to other functions (callbacks)
            = functiona can be declared inside of other functions (closures)
            = functions can return another function 

        - Anonymous functions and function expressions
            = a variable can be assigned to the logic of a function
            = functions on the right side of the assignment operator do not require declared names
            = the logic of the function is invoked using the variable to which it was assigned

        - IIFEs
            = an implementation of the Self-Executing Anonymous Function design pattern
            = anonymous functions that are executed as soon as the interpreter comes across them
            = https://developer.mozilla.org/en-US/docs/Glossary/IIFE

        - Generator functions
            = uses the function* declaration syntax
            = return a Generator object
            = can be used to generate values, can be finite or infinte
            = https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/function*

        - Arrow functions
            = introduced in ES2015
            = sytactically compact alternative to regular function expressions
            no bindings to the 'this', 'arguments', 'super', 'new.target', keywords

*/

// Standard functions
function getArea(width, height) {
    return width * height;
}


//Anonymous functions
let area = function(width, height){
    return width * height;
}
console.log(area);
console.log(area(5,10))


/*
    Hoisting

        A general way of thinking about how execution context (specifically the creation 
        and execution phases) work in JS. The JS interpreter does not execute scripts
        sequentially (line by line), but instead whenever a script enters into a new
        execution context, there are two phases of activity:

        1. Preparation/Creation
            - the new scope is created
            - declared variables and functions (and their arguments) are created (memory allocated on Stack)
        
        2. Execution
            - assignment of values to variables
            - runs funtion invocationss
            -evaluate expressions

        Note: only var will be affected can 
*/


/*
    Arrow function
*/

let elements= [
    'Hydrogen',
    'Helium',
    'lithium',
    'Beryllium'
];

console.log(elements[0]); //'hydrogen


/*
    Creating Objects

    - Object literal notation
        = uses{} to encapsulate states and behavours of the object
        = property/key names are separated from their values using a colon (:)
        = key/value pairs are separated from one another by a comma(,)
    
    - Constructor notation
        = can be creted using the Object constructor, and configured separately
        = a "class" function can be used to create instances of an object

    - Class syntax
        = introduced in ES2015 (ES6)
        = sugar syntax; effectively a cleaner implementation of "class" functions
        = class declarations are not subject to hoisting
        = capable of containing static methods
        = cleaner inheritance configuration using the 'extends' keyword ("subclassing")

*/

//Object literals
let hotel = {
    name: 'Marriott',
    rooms: 180,
    booked: 162,
    available: function(){
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

document.write(`<h2>${hotel.name}</h2>`)
document.write(`<ul
                    <li> Total Rooms: ${hotel.rooms}</li>
                    <li> Booked Rooms: ${hotel.booked}</li>
                    <li> Available Rooms: ${hotel.available()}</li>
                </ul>`);


                