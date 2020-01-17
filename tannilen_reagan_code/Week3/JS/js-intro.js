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

/*
    Type Coersion and Truthy/Falsy Values
        - Type Coercion
            + Automatic or implicit conversion of values from one datatype to another
            + JS is your friend.  It's just trying to help you.
            + ex: 7 + 7 + '7' = '147'
        
        -Truthy/Falsy values
            + all variables can be evaluated as booleans
            + there are only 6 'false' values
                - false
                - 0
                - NaN
                - null
                - undefined
                - ""
*/

/*
    NaN is the only thing that will never be equal to itself.
*/

/*
    - Guard
        + &&
        + ex.: return authUser && username;
        + A && B will return B if A is truthy
        + introduced in ES2015
    - Default
        + ||
        + ex.: let authUser = authenticate(creds) || {};
        + A || B will return A if A is true.  Otherwise, it defaults to B.
*/

/*
    - Types of Functions
        + standard function declarations
        + anonymous functions and function expressions
        + immediate-invoked function expressions (IFFEs)
        + callback functions
        + arrow functions
        + generator functions
    
    - Functions as first class members
        + functions can be assigned to a variable
        + functions can be passed as a parameter to other functions (callback)
        + functions can be declared inside of other functions (closures)
        + functions can return other functions
    
    - Anonymous functions and function expressions
        + a variable can be assigned to the logic of a function
        + functions on the rifght side of the assignment operator do not require delared names
        + the logic of the function is invoked using the variable to which it was assigned

    - IIFEs
        + an implementation of the self-executing anonymous function design pattern
        + anonymous functions that are executed as soon as the interpreter comes across them
        + syntax:
            (function () {
                //function logic
            })();
        + IFFEs are used for events that are only called one time
    
    - Generator functions
        + uses the function* declaration syntax
        + always return a Generator object
        + can be used to generate values, finite or infinite
    
    - Arrow functions
        + syntax: ()=>{};
        + introduced in ES2015
        + syntactically compact alternative to regular function expressions
        + no bindings to the 'this', 'arguments', 'super', or 'new.target' keywords
*/

function getArea(width, height=0) {
    return width*height;
}
//  Javascript don't care.
getArea('5', 7);
getArea(5, 7);
getArea(5,7,85)

//example of an IIFE
let thisArea = (function (width, height) {
    console.log(width, height);
    return width*height;
})(5, 7);

console.log(thisArea);

const PI=3.141592654;

// function test1() {
//     console.log(x); //=> undefined
//     console.log(y); //=> throws ReferenceError
//     console.log(z); //=> throws ReferenceError
//     if (true) {
//         var x = 5;
//         let y = 10;
//         const z = 20;
//     }
//     console.log(x); //=> 5
//     console.log(y); //=> throws ReferenceError
//     console.log(z); //=> throws ReferenceError
// }

// test1();

/*
    Hoisting
        A general way of thinking about how execution context (specifically the creation and execution phases) work in JS.
        The JS interpreter does not execut scripts sequentially, but instead whenever a script enters into a new execution
        context, there are two phases of activity:
            1. Preparation/Creation
                - the new scope is created
                - declared variables and functions (and their arguments) are created (memory allocated on the stack)
            2.  Execution
                - assignment of values to variables
                - run function invocations
                - evaluate expresions
*/

// testFunctionHoist();

// function testFunctionHoist() {
//     console.log('Function was hoisted!');
// }

// function hoist_test1() {
//     var x;
//     x=6;
//     console.log(x);
// }

// function hoist_test2() {
//     var x;
//     console.log(x);
//     x=6;
// }

// function host_test3() {
//     console.log(x);
//     var x=6;
// }
let elements = ["hydrogen", "helium", "lithium", "boron", "tin", "", "beryllium"];
//pre-ES2015
elements.forEach(function(element) {
    console.log(element);
});
//ES2015+
elements.forEach((element) => {
    console.log(element);
});
elements.forEach(element => console.log(element));
let myMap=elements.map(element => element.length);
console.log(myMap);

/*
    According to MDN, a closure is the combination fo a function, bundled together with references to its surrounding state (the lexical environment).

    -gives an inner function an outer function's scope
        + even if the inner fucntion was the returned value of the outer function
        + an effective way of employing encapsulation within JS
*/
let counter=0
function incrementCounter() {
    return counter++;
}

function incrementCounter_v2() {
    let mycounter=0;
    return mycounter++;
}

function incrementCounter_v3() {
    let mycounter=0;
    return function() {
        return ++mycounter;
    }
}

let count=incrementCounter_v3;

// fun fun function on Youtube

/*
    Template literals
        - introduced in ES2015
        - allows for value or expression interpolation
*/

let age = 34;
let name = "Tann";
console.log(name + "is" + age);
console.log(`${name} is ${age}`);
console.log(`${name} will be ${age + 1} next year`);

/*
    Object literal notation
        - uses {} to encapsulate states and behaviours of the object
        - property/key names are separated from their valuese using a colon
        - key-value pairs are separated from one another by a comma
    Constructor notation
        - can be created using the Object constructor and configured separately
        - a "class" function can be used to create instances of an object
    Class syntax
        - introduced in ES2015
        - sugar syntax
        - cleaner implementation of class functions
        - not subject to hoisting
        - capable of containing static methods
        - cleaner inheritance configuration using the 'extends' keyword
*/
let hotel= {
    name: "Marriott", rooms: 180, booked: 162, available: function() {return this.rooms-this.booked;}
}

let myHotel={
    name: "Ritz Carleton", rooms: 300, booked: 182, available() {return this.rooms-this.booked;}
}
document.write(`<h2>${hotel.name}</h2>`);
document.write(
    `<ul>
    <li><b>Total Rooms:</b> ${hotel.rooms}</li>
    <li><b>Booked Rooms:</b> ${hotel.booked}</li>
    <li><b>Available Rooms:</b> ${hotel.available()}</li>
    </u>`
)

let hotelJSON=JSON.stringify(myHotel);
console.log(hotelJSON);

// Most RESTful APIs are sent using JSON, as JSON is extremely easy to parse
// used as an alternative to XML as an interchange format between JS <=> Java

let newHotel=new Object();
newHotel.name="Four Seasons";
newHotel.rooms=300;
newHotel.booked=190;
newHotel.available=() => this.rooms-this.booked;
console.dir(newHotel);
console.log(newHotel.available);

function HotelBuilder(name, rooms, booked) {
    this.name=name;
    this.rooms=rooms;
    this.booked=booked;
    this.available=rooms-booked;
}
let yourHotel= new HotelBuilder("Best Western", 280, 170);
console.dir(yourHotel);

class Animal {
    static x=5
    constructor(name) {
        this.name=name;
    }
    speak() {
        console.log(this);
        console.log(this.name + " speaks!");
    }
}
class Dog extends Animal {
    constructor(name) {
        super(name);
    }
    speak() {
        console.log(this.name + " barks!");
    }
    wagTail=() => {
        console.log(this);
        console.log("The goodest boy wags his tail~")
    }
}
let spot=new Dog("Spot");
spot.speak();
spot.wagTail();
// console.log(animal.x);
let fido=new Animal;
fido.speak();

function sum(x, y, z) {
    return x+y+z;
}
let numbers=[1,2,3];
let mySum=sum(numbers[0], numbers[1], numbers[2]);
console.log(mySum);
let yourSum=sum(...numbers);
console.log(yourSum);

let j, k, rest;
[j,k]=[10,20];
console.log(j);
console.log(k);
[j, k, ...rest]=[10,20,30,40,50];
console.log(j);
console.log(k);
console.log(rest);
let obj={p:42, q:true};
let {p, q}=obj;
console.log(p);
console.log(q);
// JavaScript does allow you to do error handling!
function throwsError() {
    throw new Error('Oops!  There was an error!')
}
try {
    throwsError
}
catch {
    console.log('Caught the error!  Huzzah!')
}
class CustomError extends Error {
    constructor() {
        super("Hey, look!  A custom error!")
    }
}
let myError = new CustomError();
console.log(myError);
/*
    Prototypal Inheritance
        -   JS's inhernitance mechanism is not tquite the same as Java's, which uses a class-based inheritance system.
            Instead, JS is known for its use of "prototypal inheritance".
                +   Each object has a private property which holds a link to another object called its "prototype",
                    represented by the __proto__ property.
                +   The prototype object had a prototype of its own, which has a prototype of its own, and so on,
                    until an object is reached that has null as its prototype.
                +   Methods can be added to objects as properties, and any object has access to to its prototype's
                    properties.  These properties can be redeclared with new implementation as a sort of "method
                    overriding".
*/
let bestHotel=new HotelBuilder("Test", 200, 123);
console.dir(bestHotel);
/*
    Spread/Rest Operator
        - Spread/rest syntax allows an iterable such as an array expression or string to be expanded in places where
          zero or more arguments (for function calls) or elements (for array literals) are expected, or an object
          expression to be expanded in places where zero or more key/value pairs (for object literals) are expected.
*/
/*
    for..of and for..in
        - for..of
            + uses an object-specific iterator and loops over its generated value
        - for..in
            + loop over enumerated property names of an object
*/

const myArray=[10, 20, 30];
for (const value of myArray) {
    console.log(value);
}
let myObject = {
    x: 1, y: 2, z: 3
};
for (const property in myObject) {
    console.log(`myObject.${property} = ${myObject[property]}`);
}