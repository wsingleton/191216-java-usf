/*
Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar..,,,M

Create a function that checks for a valid email format.

Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string return the string without "Script" otherwise return the original one.

Write a JavaScript function to replace every character in a given string with the character following it in the alphabet.

Write a JavaScript function to count the number of vowels in a given string.

Write a JavaScript function to reverse the elements of a given array.

Write  JavaScript function that adds the values of arrays, even if the arrays are different sizes. 
	addArr([1,2,3],[3,2,1]) = [4,4,4]
	addArr([1,2,3,4,5],[1,2,3]) = [2,4,6,4,5]

Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.

Write a JavaScript function which accepts three integers representing side lengths of a triangle. The function should validate that the integers make a geometrically accurate. If the three integers could not make a triangle, return undefined. Otherwise calculate and return the area of the triangle.

Write a JavaScript function which accepts two arrays, representing the side lengths of polygons. Return true if the polygons are similar, false if they are not.

Check if two arrays have the same size and contents (including if content order is not the same).
	equivArr([4,2,8,4,7],[7,4,4,2,8]) = true
equivArr([4,2,8,4,7],[7,5,4,2,8]) = false
equivArr([4,2,8,4],[7,5,4,2,8]) = false

Create a function which takes a 3x3 2D array. Validate that each array index holds only a value of “X”, “O”, or be empty. Have the function evaluate a game of tic tac toe represented by the 2D array.  Should have a result for a tie, each winner, or an invalid game.

	tictactoe([[“X”, “X”, “X”],[“O”, “O”, “O”],[“X”, “O”, “X”]]) 
prints “Invalid result”

tictactoe([[“X”, “X”, “X”],[“X”, “X”, “X”],[“X”, “O”, “X”]]) 
prints “Invalid result” 

	tictactoe([[“X”, “O”, “X”],[“O”, “X”, “O”],[“X”, “O”, “X”]]) 
Prints “X is the winner”

tictactoe([[empty, “O”, “X”],[“X”, “O”, empty],[empty, “O”, “X”]]) 
Prints “O is the winner”

		tictactoe([[“X”, empty, “X”],[“O”, empty, empty],[empty, “O”, empty]]) 
Prints “No winner yet”
	

*/

/* 1. Leap Year */

function leapYear(date){
let baseYear = parseInt(date);
if(baseYear%4 == 0){
return true;
}
return false;
}
//console.log(leapYear(2000));

/* 2. Email Validation */ 

function isEmail(string){
    let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let email = string;
    let check = mailformat.test(email);
    return check;
}
//console.log(isEmail("1234@ertrtr.[3rw"));

/* 3. Remove Character */

function removeChar(string, position){
    let newString = string.replace(string.charAt(position), "");
    return newString;
}
        
/* 4. Remove "Script" */

function removeScript(string){
    let given = string;
    if(given.includes(" Script")){
        let alteredStr = given.replace(" Script", "");
        return alteredStr;
    } else if (given.includes(" script")){
        let alteredStr2 = given.replace(" script", "");
        return alteredStr2;
    }
    return given;
}

/* 5. Letter Shift */

function letterShift(string){
    let result = "";
    for (let i = 0; i < string.length; i++) {
        // handle "z"
        if (122 == string.charCodeAt(i)) {
            result += "a";
        // handle "Z"
        } else if (90 == string.charCodeAt(i)) {
            result += "A";
        // handle all other letter characters
        } else if ((65 <= string.charCodeAt(i) && string.charCodeAt(i) <= 89) ||
                   (97 <= string.charCodeAt(i) && string.charCodeAt(i) <= 121)) {
            result += String.fromCharCode(string.charCodeAt(i) + 1);
        // append all other characters unchanged
        } else {
            result += string.charAt(i);
        }
    }
    return result;
}

/* 6. Vowel Count */

function vowelCount(str){
    //let vowelsArr = ["a", "i", "u", "o", "e"];
    let count = 0;
    let string = str.toLowerCase();
    string.split("");
    for (let i =0; i<string.length; i++){
        if(string[i] == "a" || string[i] == "i" || string[i] == "u" || string[i] == "o" || string[i] == "e"){
            count += 1;
        }
    }
    return count;
}

/* 7. Reverse Array */

function reverseArr(array){
    let givenArray = array;
    let reversedArr = givenArray.reverse();
    return reversedArr;
}

/* 8. Add Array */

function addArr(array, array2){
    let sumArr = [];
    if (array.length == array2.length){
        array.map((number, index) =>{
            sumArr.push(number + array2[index]);
        })
        return sumArr
    } else if (array.length < array2.length){
        array.map((number, index) =>{
            sumArr.push(number + array2[index]);
        })
        for (let i = array.length; i<array2.length; i++){
            sumArr.push(array2[i]);
        }
        return sumArr;
    }else if (array2.length < array.length){
        array2.map((number, index) =>{
            sumArr.push(number + array[index]);
        })
        for (let i = array2.length; i<array.length; i++){
            sumArr.push(array[i]);
        }
        return sumArr;
    }
}

/* 9. Longest String */

function longestStr(array){
    let lengthArr = [];
    for(let i = 0; i<array.length; i++){
        lengthArr.push(array[i].length)
    }
    let longStr = Math.max(...lengthArr);
    return lengthArr.indexOf(longStr); 
}

/* 10. Area of a Triangle */

function area(number, number2, number3){

    if (number + number2 < number3 || number+ number3 < number2 || number2 + number3 < number) {
        return false;
    }
    let perimeter = (number + number2 + number3)/2;
    let area = Math.sqrt(perimeter*(perimeter-number)*(perimeter-number2)*(perimeter-number3));
    return area;
}

/* 11. Similar Polygons */

function areSimilar(array, array2){
    let max1 = Math.max(...array);
    let max2 = Math.max(...array2);
    let sum1 = loop(array);
    let sum2 = loop(array2);

    function loop(arr){
        let max = Math.max(...arr);
        let sum = 0;
        for(let i = 0; i<arr.length; i++){
            if(arr[i] != max){
                sum +=arr[i];
            }
        }
        return sum;
    }
    if(array.length != array2.length || max1 > sum1 || max2 > sum2){
        return false;
    } else{
        let ratios = [];
        let test;
        for(let i = 0; i<array.length; i++){
            let r = array2[i]/array[i];
            ratios.push(r);
        }
        let baseRatio = ratios[0];
        test= ratios.every(ratio =>{
            if(ratio == baseRatio){
                return true;
            } else {return false}; 
        })
        return test;  
    }
}

/* 12. Equivalent Arrays */

function equvArr(array, array2){

    if(array.length != array2.length){
        return false;
    } else{
        let sortArr1 = array.sort((a, b) => a -b);
        let sortArr2 = array2.sort((a, b) => a -b);
        for(let i = 0; i<sortArr1.length; i++){
            if(sortArr1[i] == sortArr2[i]){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

/*
13. Create a function which takes a 3x3 2D array. Validate that each array index holds only a value of “X”, “O”, or be empty. 
Have the function evaluate a game of tic tac toe represented by the 2D array. 
Should have a result for a tie, each winner, or an invalid game.
*/
function tictactoe(array){
    let arr1 = array[0];
    let arr2 = array[1];
    let arr3 = array[2];
    let p1 = "X";
    let p2 = "O";
    let e = "";
    if(!arr1.includes(p2) && !arr2.includes(p1) && arr3.includes(p2)){console.log("Invalid result")} else
    if(!arr1.includes(p2) && !arr2.includes(p2) && arr3.includes(p2)){console.log("Invalid result")} else
    if(arr1[0] == p1 && arr1[1] == p2 && arr1[2] == p1 && arr2[0] == p2 && arr2[1] == p1 && arr2[2] == p2 && arr3[0] == p1 &&
        arr3[1] == p2 && arr3[2] == p1){console.log(p1 + " is the winner")}else
    if(arr1[0]==e && arr1[1] == p2 && arr1[2] == p1 && arr2[0]==p1 && arr2[1]==p2 && arr2[2]==e && arr3[0]==e &&
        arr3[1]==p2 && arr3[2]==p1){console.log(p2 + " is the winner")} else
    if(arr2[1]== e && arr2[2]==e){console.log("No winner yet")} else{console.log("Game lost")}
}
