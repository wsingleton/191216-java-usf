/* 1. Leap Year */

function leapYear(date){

    if (date % 4 === 0) {

        if(date % 100 === 0) {

            if(date % 400 === 0) {
                return true;
            }

        } else {
            return true;
        }

    } else {

        return false;
    }
}



/* 2. Email Validation */ 

function isEmail(string){

    let x = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(string);

    return x;

};

/* 3. Remove Character */

function removeChar(string, position){

    if (position === 0){
        str = string.substring(1, string.length);
    }else {
        p1 = string.substring(0, position);
        p2 = string.substring(position + 1, string.length);
        str = p1.concat('', p2);
    }

    return str;

};
        
/* 4. Remove "Script" */

function removeScript(string){
    
    let str = string.toLowerCase();
    let substring = 'script';
    if (str.search(substring)) {
        newString = str.replace(substring, '');
    }else {
        newString = string;
    }

    return newString;

}

/* 5. Letter Shift */
// A = 65, Z = 90, a = 97, z = 122
function letterShift(string){

    let i = 0;
    let newString = '';
    for (i; i < string.length; i++) {

        if(90 == string.charCodeAt(i)) {
            newString += 'A';
        }else if (122 == string.charCodeAt(i)) {
            newString += 'a';
        }else {
            newString += String.fromCharCode(string.charCodeAt(i) + 1);
        }
    }
    
    return newString;

}

/* 6. Vowel Count */

function vowelCount(string){

    let x;
    let count = 0;
    for (i = 0; i < string.length; i++) {
        x = string.charAt(i);
        if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
            count++;
        }else if (x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U'){
            count++
        }
    }

    return count;

}

/* 7. Reverse Array */

function reverseArr(array){

    let i = 0;
    let j = array.length - 1;

    for (i ; i < j;) {

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
    }

    return array;
}

/* 8. Add Array */

function addArr(array, array1){

    let newArr = [];
    for (i = 0; i < Math.max(array.length, array1.length); i++) {
        newArr.push((array[i] || 0) + (array1[i] || 0));
    }

    return newArr;

}

/* 9. Longest String */

function longestStr(array){

    let i = 1;
    let x = array[0];

    for (i; i < array.length; i++){
        let y = array[i];
        if (x.length < y.length){
            x = array[i];
        }
    }
    return array.indexOf(O);
}

/* 10. Area of a Triangle */

function area(a, b, c){

    if (a + b < c || a + c < b || b + c < a) {
        return console.log('Those values will not make a triangle!!');
    }

    p = (a + b + c)/2;

    areaOfSides = Math.sqrt(p*(p-a)*(p-b)*(p-c));

    return areaOfSides;

}

/* 11. Similar Polygons */

function areSimilar(array, array1){

    let ratio = [];
    let test1 = 0;
    let test2 = 0;
    let max = Math.max.apply(null,array);
    let max1 = Math.max.apply(null, array1);

    if (array.length <= 2 || array1.length <= 2 || array.length != array1.length){
        return console.log('Fail');
    };

    for (i = 0; i < array.length; i++){
        if(array[i] != max) {
            test1 += array[i];
        }else {
            continue;
        }
    };

    for (i = 0; i < array1.length; i++){
        if(array1[i] != max1) {
            test2 += array1[i];
        }else {
            continue;
        }
    };

    if(test1 < max || test2 < max1){
        return console.log('Fail');
    }
    
    for(i = 0; i < array.length; i++) {
        ratio.push(array[i]/array1[i]);
    }

    for (i = 1; i < array.length; i++) {
        if (ratio[0] == ratio[i]){
            continue;
        }else {
            return false;
        }
    }
    
    return console.log(ratio, 'They are similar');
    
}

/* 12. Equivalent Arrays */

function equivArr(array, array1){

    if (array.length != array1.length) {
        return false;
    }

    array.sort();
    array1.sort();

    for(i=0; i < array.length; i++) {
        if (array[i] == array1[i]) {
            continue;
        }else{
            return false;
        }
    }
    return true;

}

/* 13. Tic Tac Toe */


function tictactoe(array){
    let arr = array;
    let c1 = 0;
    let c2 = 0;
    let c3 = 0;
    let count = 0
    let a1 = [];
    let a2 = []


    for (let i = 0; i < 3; i++){
        for(let j = 0; j < 3; j++){
            if (arr[i][j] === 'X'){
                c1++;
                a1.push(++count);
                
            }
            if (arr[i][j] === 'O'){
                c2++;
                a2.push(++count);
            }
            if (array[i][j] === 'empty'){
                c3++;
                ++count;
            }
        }
       
    }    
   
    if (c1 > 5 || c2 > 5) {
        return console.log('Invalid game');
    }
    if (c3 > 4) {
        return console.log('No winner yet');
    }
    if (c1 + c2 === 9){
        return console.log('Nobody wins')
    }

    if ((a1.includes(1) && a1.includes(2) && a1.includes(3)) ||
        (a1.includes(4) && a1.includes(5) && a1.includes(6)) ||
        (a1.includes(7) && a1.includes(8) && a1.includes(9)) ||
        (a1.includes(1) && a1.includes(4) && a1.includes(7)) ||
        (a1.includes(2) && a1.includes(5) && a1.includes(8)) ||
        (a1.includes(3) && a1.includes(6) && a1.includes(9)) ||
        (a1.includes(1) && a1.includes(5) && a1.includes(9)) ||
        (a1.includes(3) && a1.includes(5) && a1.includes(7))){

        console.log('X wins');
    }

    if ((a2.includes(1) && a2.includes(2) && a2.includes(3)) ||
        (a2.includes(4) && a2.includes(5) && a2.includes(6)) ||
        (a2.includes(7) && a2.includes(8) && a2.includes(9)) ||
        (a2.includes(1) && a2.includes(4) && a2.includes(7)) ||
        (a2.includes(2) && a2.includes(5) && a2.includes(8)) ||
        (a2.includes(3) && a2.includes(6) && a2.includes(9)) ||
        (a2.includes(1) && a2.includes(5) && a2.includes(9)) ||
        (a2.includes(3) && a2.includes(5) && a2.includes(7))){

        console.log('O wins');
    }
}
