/* 1. Leap Year */

function leapYear(date) {
    if(date % 4 === 0 && (date % 400 === 0 && date % 100 === 0)){
        return true;
    }
    return false;
}

/* 2. Email Validation */

function isEmail(string) {
    
}

/* 3. Remove Character */

function removeChar(string, position) {
    let newStr;
    newStr = string.replace(string[position], "");
    return newStr;
}

/* 4. Remove "Script" */

function removeScript(string) {
    if(string.includes("Script")){
        return string.replace("Script", "")
    }
    else{
        return string;
    }
}
/* 5. Letter Shift */

function letterShift(string) {
   let arr = string.split("");
   let newChar = "";

    for (let i = 0; i < arr.length; i++) {
        newChar += String.fromCharCode(string.charCodeAt(i) + 1);
    }
    return newChar;
}


/* 6. Vowel Count */

function vowelCount(string) {
    let count = 0;
    let arr = string.toLowerCase().split("")
    let holder = arr.map(c => {
        if(c === "a" || c === "e" || c === "i" || c === "u")
        count++;
    })
    return count;
}


/* 7. Reverse Array */

function reverseArr(array) {
    let arr = array.reverse();
    return arr;
}



/* 8. Add Array */

function addArr(array1, array2) {
    let arr = array1;
    let arr2 = [...array2];
    let count = 0
    let newArr = []; 
    
    arr.map(n => {
        if(count < array2.length){
            newArr.push(n + array2[count])
            arr2.shift();
        }
        else {
            newArr.push(n);
        }
        count++;
    })

    if(arr2.length !== 0){
        for(let i = 0; i < arr2.length; i++){
            newArr.push(arr2[i]);
        }
    }
    return newArr;
}

/* 9. Longest String */

function longestStr(array) {
    let longest = "";
    let arr = [...array];
    arr.map(n => {
        if(n.length > longest.length){
            longest = n;
        }
    })
    console.log(longest);
    return array.indexOf(longest);
}


/* 10. Area of a Triangle */

function area(number1, number2, number3) {
    //equilateral triangle
    if(number1 === number2 && number1 === number3){
        return(Math.sqrt(3)/4) * number1**2;
    }
    return undefined;
}
// console.log(area(20.8,20.8,20.4));
/* 11. Similar Polygons */

function areSimilar(array1, array2) {

    
}



/* 12. Equivalent Arrays */

function equvArr(array1, array2) {
    if(array1.length !== array2.length){
        return false
    }
    let unique = new Set(array1);
    let unique2 = new Set(array2);
    let arr = [...unique].sort();
    let arr2 = [...unique2].sort();
    let same = true;

    if(arr.length !== arr2.length){
        return false;
    }
    
   arr.map(c => {
      if(!arr2.includes(c)){
          same = false
      }
   })
    return same;
}

console.log(equvArr([1,1,5,6,3], [1,2,5,6,3]));


/* 13. Tic Tac Toe */

function tictactoe(array) {

}



