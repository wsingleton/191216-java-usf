// sinlg eline commentd
/* 
multi line comments

what is javaScript?
-language of the internet
-lightweight interpreted programming language with first class functions
- loosely- typed types existcbut are not declared explicitly
-not technically a OO language but reffered to as an OB language (Object-Based)
-originally Brendan Eich of Netscape (Mozilla)
-most commonly run in web browser(Google Chrome V8 Engine)
-server side JS is possible with Node.JS

-It is unrelated to Java
-name is a marketing plow to gain attention from existing Java community
-syntactic similarities are superficial as most C-based languages look similar

-it is an implementationof the ECMAScript standard
made official in TC39 (TC- Technical Committe)
current version is ECMAScript 2019(ES10)


JS Datatypes
-Boolean
    +represents a logical entity having one or two values:true or false
    -Number
        represents a 64-bit floating point number
    -String
        +represents a textual data
    -Undefined
        +the value of a variable that has been declared but nt intialized
    -Null
        +the lack of an object value
    -Symbol
        +represents a garaunteed unique value
    -Object
        +refers to a data structure containing states and behaviors
        +Subtypes:
            +arrays
            +functions

*/

let x = 'color';
console.log(typeof(x));

x= 5;
console.log(typeof(x));
x = 3>5;
console.log(typeof(x));
x = {};
console.log(typeof(x));
x = [];
console.log(typeof(x));
x = function (){};
console.log(typeof(x));
let today = new Date();
let currentHour = today.getHours();
let greeting;
if(currentHour> 18){
    greeting = 'good evening';
}else if (currentHour > 12){
    greeting ='good afternoon';

}else if (currentHour > 0){
greeting = 'goodmorning';
}else{ greeting ='hello';}

document.write('<her>' +greeting+'</h3>')
/*
global
    +the scoe that contains ans is visible in all scopes
local
    +any new scope created inside of the global scope
    +as a result, sometimes refferred to as 'function' scope
block
    +any new scope created inside of a local scope
    +accomplished through: if,While, switch,try,catch,for
lexical
    +provides the ability of an inner function to access the scope of it outer/parent function
    +often referred to as 'closure' scope
*/

/*Variable dlecartive keywords

-var
    + can be scoped globally or locally
    +cannot be block scope
    +subject to hoisting phenmenon
    +used when declaring a simple mutable variable
-let
    +scoped to the local or block level
    +introduced ES2015 (ES6)
    +used when delcaring s imple mutable variable
-const
    +scoped to the global local or block level
    +introduced in ES2015
    +used when declaring an immutable variable
    +must be initialized upon declartion(no deferred assignment)
-(Global)
    +lack of a keyword
    +values declared in such a way are bound to the browser's window object
    +bad practice to use; couses memory leaks
    */

    /*Type coercion & Truthy/Falsy Values 
    -Type coercion
        +the automatic or implicit conversion of values from one datatype to another
        example 7+7+'7'='147'
    -Truthy/Falsy Values
        +all varibale, regardless of the datatype of their value, can be evaluated as booleans
        +there are six falsy values, everything else is truthy
            -false
            -NAN
            -0
            -null
            -undefined
            -""(empty string)


    -Guard and Default Operators
        -guard
            +&&
            +ex return authUser && username;
            +A && B will return if A is truthy
            +basically a short circuit AND with some neat side effects
        -Default
            + ||
            + ex let authUser = authenticate(cred) || {};
            + A || B will return A if A is truthy, otherwise it defaults to B
    
    */
