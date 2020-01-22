/* 1. Leap Year */

function leapYear(date){
    let year = date.getFullYear();
    if(year%4 == 0) {
        if(year%100 == 0) {
            if(year%400 == 0) {
                return true;
            }
            else return false;
        }
        else return true;
    }
    else return false
}

/* 2. Email Validation */ 

function isEmail(string){
    let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(string.match(regex)){
        return true;
    }
    else return false;
}

/* 3. Remove Character */

function removeChar(string, position){
    let newstring = string.slice(0,position) + string.slice(position + 1, string.length);
    return newstring;

}
        
/* 4. Remove "Script" */

function removeScript(string){
    return string.replace(/script/gi, "");

}

/* 5. Letter Shift */

function letterShift(string){
    let s = string.split('');
    for(let i = 0; i < string.length; i++) {
        if(s[i] == 'z') {s[i] = 'a';}
        else if(s[i] == 'Z') {s[i] = 'A';}
        else if(s[i] == ' '){continue;}
        else {
            s[i] = String.fromCharCode(1 + s[i].charCodeAt(0));
        }
    }
    let returnString = "";
    for(let j = 0; j < s.length; j++) {
        returnString += s[j];
    }
    return returnString;
}

/* 6. Vowel Count */

function vowelCount(string){
    let s = string.split('');
    let count = 0;
    let vowelReg = /[aeiou]/gi;
    for(let i = 0; i < string.length; i++) {
        if(s[i].match(vowelReg)) count++;
    }
    return count;
}

/* 7. Reverse Array */

function reverseArr(array){
    return array.reverse();
}

/* 8. Add Array */

function addArr(array1, array2){
    let a;
    let b;
    if(array1.length > array2.length) {
        a = array1;
        b = array2;
    }
    else {
        b = array1;
        a = array2;
    }
    for(let i = 0; i < b.length; i++) {
        a[i] += b[i];
    }
    return a;
}

/* 9. Longest String */

function longestStr(array){
    let maxLen = -1;
    let maxInd = 0;
    for(let i = 0; i < array.length; i++) {
        if(array[i].length > maxLen) {
            maxLen = array[i].length;
            maxInd = i;
        }
    }
    return maxInd;
}

/* 10. Area of a Triangle */

function area(number1, number2, number3){
    let a, b, c;
    if(number1 >= number2 && number1 >= number3) {
        a = number1;
        b = number2;
        c = number3;
    } else if(number2 >= number1 && number2 >= number3) {
        a = number2;
        b = number1;
        c = number3;
    } else if(number3 >= number1 && number3 >= number2) {
        a = number3;
        b = number2;
        c = number1;
    }
    if(a > b + c) return null;

    let s = (a + b + c)/2;
    return Math.sqrt(s * (s-a) * (s-b) * (s-c));
}

/* 11. Similar Polygons */

function areSimilar(array1, array2){
    let ratio = array1[0]/array2[0];
    for(let i = 1; i < array1.length; i++) {
        if(array1[i]/array2[i] != ratio) return false;
    }
    return true;
}

/* 12. Equivalent Arrays */

function equvArr(array1, array2){
    if(array1.length != array2.length) return false;
    array1.sort();
    array2.sort();
    for(let i = 0; i < array1.length; i++) {
        if(array1[i] != array2[i]) return false;
    }
    return true;
}

/* 13. Tic Tac Toe */

function tictactoe(array){
    let tempwinner = '';
    let winner = '';
    for(let i = 0; i < array.length; i++) {
        for(let j = 0; j < array[0].length; j++) {
            switch(array[i][j]) {
                case 'X':
                case 'O':
                case '':
                    break;
                default:
                    return false;
            }
        }
    }
    if(array[0][0] != '') {
        if(array[0][0] == array[1][1] && array[0][0] == array[2][2]) {
            tempwinner = array[0][0];
            if(winner == '' | winner == tempwinner) winner = array[0][0];
            else { 
                console.log('Invalid result');
                return;
            }

        }
        if(array[0][0] == array[0][1] && array[0][0] == array[0][2]) {
            tempwinner = array[0][0];
            if(winner == '' | winner == tempwinner) winner = array[0][0];
            else { 
                console.log('Invalid result');
                return;
            }
        }
        if(array[0][0] == array[1][0] && array[0][0] == array[2][0]) {
            tempwinner = array[0][0];
            if(winner == '' | winner == tempwinner) winner = array[0][0];
            else { 
                console.log('Invalid result');
                return;
            }
        }
    }
    if(array[1][0] != '') {
        if(array[1][0] == array[1][1] && array[1][0] == array[1][2]) {
            tempwinner = array[1][0];
            if(winner == '' | winner == tempwinner) winner = array[0][0];
            else { 
                console.log('Invalid result');
                return;
            }
        }
    }
    if(array[2][0] != '') {
        if(array[2][0] == array[2][1] && array[2][0] == array [2][2]) {
            tempwinner = array[2][0];
            if(winner == '' | winner == tempwinner) winner = array[0][0];
            else { 
                console.log('Invalid result');
                return;
            }
        }
    }
    if(array[0][1] != '') {
        if(array[0][1] == array[1][1] && array[0][1] == array[2][1]) {
            tempwinner = array[0][1];
            if(winner == '' | winner == tempwinner) winner = array[0][0];
            else { 
                console.log('Invalid result');
                return;
            }
        }
    }
    if(array[0][2] != '') {
        if(array[0][2] == array[1][2] && array[0][2] == array[2][2]) {
            tempwinner = array[0][2];
            if(winner == '' | winner == tempwinner) winner = array[0][0];
            else { 
                console.log('Invalid result');
                return;
            }
        }
    }
    console.log(winner + ' is the winner');
}
