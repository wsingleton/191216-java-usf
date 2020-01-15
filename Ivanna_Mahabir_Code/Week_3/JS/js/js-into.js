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

