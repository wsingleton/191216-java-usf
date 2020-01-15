//

/*
*/

function getArea(width, height = 1){
    return width * height;
}

console.log(getArea(2,4));

(function(width, height){
    console.log(width,height);
    return width * height;
})(6,90);


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
    console.log(x); // undefined
    var x = 6;
}

function hoist_test4(){
    console.log(x); //reference Error
    let x = 0;
}

function hoist_test5(){
    console.log(x); //reference Error
    const x = 0;
}

let counter = 0;

function incrementCounter(){
    return counter++;
}


function incrementCounter_v2(){
    let my_counter = 0;
    return ++my_counter;
}

function incrementCounter_v3(){
    let my_counter = 0;
    return function (){
        return ++my_counter;
    }
}

let count = incrementCounter_v3;

console.log(count());



