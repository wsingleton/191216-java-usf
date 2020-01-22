/*

java script 
it is the language of the internet 
    a lightweight, interpreted programing language with first class functions
    loosely-type, type exits, but are not declared explicity
    not technically an OO language, but referred to as an OB language(object based)
    originally Brenden Eich of netscape in 10 days
    is mos commonly ry in web browe (google chrome v8 engine)
    server-side JS is possible with node.js (more or that later..)

it is unrelated to Java
    - "java is to javascript as ham is to hamster " Jeremy Keith, 2000
    - name is a marketing ploy to gain attention from the existing java community 
    - sysntactic similarlities are superficial, at most c-derived languages look similiar 
it is an implementation of the ECMAScruipt standard 
    - made official in tc30 (tc = technical comittee)
    - current version is ECMAScript 2019(ES10) 
    - standard : https://www.ecma-international.org/ecma-262/10.0/index.html
    - https://developer.mozilla.org/en-US/docs/Web/JavaScript
it uses a single-threaded memory model 
    - consists of the stack, heap, event table, event queuem and the event loop 
    - the event loop gives JS the illution of running tasks concurrently
    -https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop

*/


/*
JS data type
    -boolean
        + true or false
    -number
        + represent a 64-bit floating point number
    -String
        + texttual data
    -undefines
        +the value of a variable that has been declared , but not initialized 

    - Null 
        + represents the intentional absence of any object value 
    -sumbol 
        + represents a guaranteed unique value
    -object
        + refers to a data structure containing states and behaviors 
        + subtypes: array and functions  
*/

let x = 'color';
console.log(typeof(x));
x = 5 ;
console.log(typeof(x));
x= 3> 5
console.log(typeof(x));
x = {},
console.log(typeof(x));
x = [];
console.log(typeof(x));


let today = new Date;
let currentHour = today.getHours;
let greeting;
if (currentHour > 18 ){
    greeting = 'good evening';
}else if(currentHour >12){
    greeting = 'good afternoon';
}else if(currentHour> 0){
    greeting ='good morning';
}else{
    greeting = 'hello';
}

// we can use the 'document' object to inject ibto our web page
document.write();

/*

    -global 
        + the scopetha cpntains , and is visible in , all other scopes 

    - local 
        any new scope create inside of the global scope
        as a resulr , some times rederred to as"function" scope
    - block 
        any new scope created in side local scope 
        accomplished through : IF, While,Switch, Try, Catch, For
    lexical 
        + provides the ability of an inner function to access of its outer/parent function 
        + often referred to as "closure" scope
*/

//var location  = 'https://www.google.com';// send us to google ( same as change value od window.location )
//let location  = 'https://www.google.com';// error, cecause lecation is already a property of window


/*
Variable declaration 
    let
        scoped to the local or the block level 
        instroduced ES2015 (ES6)
        used when declaring a simple mutable variable


    var
        can be scoped globally or locally 
        cannot be block scoped 
        subject to hoisting phenomenon
        used when decalaring a simple mutable variable 

    const
        scoped to the global, local or block level
        instroduced in ES2015 
        used when declaring a imutable variable
        must be initialize upon declaration (no deferred assignment)


    (global)
        lack of keyword
        values declared in such a way are bound to the browser 
        bad practice to use , cause memory leaks

*/


// not work , const cant change 
//const ab = 2;
//ab = 3;



/*

Type coercion & truthy/falsy value

    type coercion
        the automatic , or impitvit , conversion a data type to another 
        ex 7 + 7 +'7" = '147'
    truthy/falsy value
        all variable, regardless of the datatype of the value, can be evaluated as boolean
        there are 6 falsu values, everything else is truthy 
        falsy value:
            false
            NaN
            0
            Null
            undefined
            ""

*/
/*

Guard and default operators 

    Guard 
        &&
        ex: return authUser && username
        A && B will return B if A is truthy 
        basically , a short- circult AND with some neat side effects

    Default
        If
        ex: let authUSer = authenticate(creds) || ();
        A || B will return A if A is truthy, other wise it default to B
        basically , a short-circuit Or with some neat side effects 


*/

/*
Functions 
    type of functions 
        standard function declareations 
        anonumous dunctions and funtion expresssion 
        immediate-invoked function expression (IIFE)
        arrow function
        general funtion 
    function are first class member in the language
        functions can be assign to a variable
        function can be passed as a parameter to other functions (callback)
        function can be declared inside of other functions (closure)
        function can return another function 
    anonumous function and function expression 
        a variable can be assign to the logic of a function 
        functions on the right of the assignment operator do not require declared names 
        the logic of the function is invoked using the variable to which it was assigned

    IIFEs
        an implementation of a self excuting anonumous function design pattern
        anonumous functions that are executed as soon as the interpreter comes acrossthem
         https://developer.mozilla.org/en-US/docs/Glossary/IIFE

    gennerator function 
        uses the function declaration systx
        return a Generator object
        can be used to generatr values,can be finite or infinite
        https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/function*

    Arrow function 
        introcted in ES2015
        a syntactically compact alternative to regular function expression
        no binging to the "this", 'argusment', 'super, ''new.target' keyword






*/


function getArea(width,height){
    console.log(width,height);
    return width * height;
}

let myArea = getArea(5,10);
console.log(myArea); //50 

myArea = getArea('5',10);
console.log(myArea); //50 

myArea = getArea('five',10);
console.log(myArea); //NAN

function getSize(width,height,depth){
    let area = getArea(width,height);
    let volume = area * depth;
    return (area,volume);
}

let result = getSize(1,2,3);
console.log(result[0],result[1]);

let area = function (width,height){
    return width * height;
}

console.log(area);
console.log(area(5,10));



// IIFE
myArea = (function (width,height){
    console.log(width,height)
    return width*height;
})(5,20)
console.log(myArea)

/*
Hoisting 
    -a general way of thinking about how execution context (specifically the creation and excuting pases)
    work in JS. the JS interpreter does not execute scripts sequentially (line by line) . but instead whenever a script enters into 
    a new excution context there are 2 phases of activity 

        1 prepareation/ creation 
            the new scope is created
            declare cariable and finctions ( and thier argusmetn) are created (memory allocated on stack)
        2 execution 
            assignment of values to variables 
            runs function invocations 
            evaluate expressions



*/


test();
function test(){
    consolelog('function was hoisted')
}


