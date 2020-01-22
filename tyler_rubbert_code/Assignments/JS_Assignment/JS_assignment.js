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

}

/* 5. Letter Shift */

function letterShift(string){

}

/* 6. Vowel Count */

function vowelCount(string){

}

/* 7. Reverse Array */

function reverseArr(array){

}

/* 8. Add Array */

function addArr(array, array){

}

/* 9. Longest String */

function longestStr(array){

}

/* 10. Area of a Triangle */

function area(number, number, number){
     
}

/* 11. Similar Polygons */

function areSimilar(array, array){

}

/* 12. Equivalent Arrays */

function equvArr(array, array){

}

/* 13. Tic Tac Toe */

function tictactoe(array){

}
