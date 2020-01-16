/* 1. Leap Year */

function leapYear(date){
    let year = date.getYears();
    if(year % 400 === 0){
        return true;
    }else if(year % 4 === 0){
        return true;
    }else{
        return false;
    }
}

/* 2. Email Validation */ 

function isEmail(string){  

 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(string))
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}

/* 3. Remove Character */

function removeChar(string, position){
    string[position] = ''; 
    return string;   
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
