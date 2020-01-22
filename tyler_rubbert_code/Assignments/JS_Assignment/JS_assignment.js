/* 1. Leap Year */

function leapYear(date){
    return (date % 100 === 0) ? (date % 400 === 0) : (date % 4 === 0)
}

/* 2. Email Validation */ 

function isEmail(string){

    let format = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if (string.value.match(format)){
        return true;
    }
    else {
        alert("you have entered an invalid email");
        return false;
    }

}

/* 3. Remove Character */

function removeChar(string, position){
    beforePosition = string.substring(0, position);
    afterPosition = string.substring(position + 1, string.length);
    return (beforePosition + afterPosition);
}
        
/* 4. Remove "Script" */

function removeScript(string){

    let temp = string.replace("Script", "");

    return temp;

}

/* 5. Letter Shift */

function letterShift(string){

var temp = string.split('');
for (let i = 0;i < temp.length; i++){
    switch(temp[i]){
        case '':
            break;
        case 'z':
            temp[i] = a;
            break;
        case 'Z':
            temp[i] = A;
            break;
        default:
            temp[i] = String.fromCharCode(1 + temp[i].charCodeAt(0));
    }
}
return temp.join('');

}

/* 6. Vowel Count */

function vowelCount(string){

    // remove everything but vowels and return length
    return string.replace(/[^aeiouAEIOU]/g, "").length

}

/* 7. Reverse Array */

function reverseArr(array){
    let temp = array.reverse();
    return array;
}

/* 8. Add Array */

function addArr(array1, array2){
    let solution = [];
    let clone1 = [];
    let clone2 = [];
    // if statements to make clone 1 the bigger array if lengths differ
    if (array1.length < array2.length){
        clone1 = array2;
        clone2 = array1;
    }
    if (array1.length > array2.length){
        clone1 = array1;
        clone2 = array2;
    }
    if (array1.length == array2.length){
        clone1 = array1;
        clone2 = array2;
    }
    // add values from cloned arrays until smaller array reaches end, then
    // set values equal to longer arrays values
    for (let i = 0; i < clone1.length; i++){
        if (i < clone2.length){
            solution[i] = clone1[i] + clone2[i];
        }
        else{
            solution[i] = clone1[i];
        }
    }
    return solution;

}

/* 9. Longest String */

function longestStr(array){
    let length = 0;
    for (let i = 0; i < array.length; i++){
        if(array[i].length > length){
            length = array[i].length;
            
        }
    }
    return length;
}

/* 10. Area of a Triangle */

function area(number1, number2, number3){
     if (number1 + number2 < number3 || number1 + number3 < number3 || number2 + number3 < number1){
         return 'invalid lengths for triangle';
     }
     else {
         let p = (number1 + number2 + number3)/2;
         let area = Math.sqrt(p*(p-number1)*(p-number2)*(p-number3));
         return area;
     }
}

/* 11. Similar Polygons */

function areSimilar(array, array){

}

/* 12. Equivalent Arrays */

function equvArr(array1, array2){
    if (array1 === array2){
        return true;
    }
    if (array1 == null || array2 == null){
        return false;
    }
    if (array1.length != array2.length){
        return false;
    }
    else {
        let clone1 = array1;
        let clone2 = array2;
        clone1.sort();
        clone2.sort();
        if(clone1 === clone2) {
            return true;
        }
        else {
            return false;
        }
    }
}

/* 13. Tic Tac Toe */

function tictactoe(array){

}
