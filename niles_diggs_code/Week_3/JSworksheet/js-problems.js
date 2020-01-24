// 1. Leap Year
function leapYear(year) {
if (year % 4 == 0 && (year % 100 == 0 && year % 400 == 0)) {
    return true;
}
    return false;
}

// 2. Email Validation

function validateEmail(email) {

    // w3resource expression for email validation ' /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ '

    let emailStructure = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (email.value.match(emailStructure)) {
        return true;
    }   
    return false;
}

// 3. Remove a Character

function removeChar(word, postition) {
    let newWord;
    newWord = word.replace(word[postition], "");
    return newWord;
}

// 4. Seeing if the word contains "Script"

function minusScript(word) {
    if (word.includes("Script")) {
        return word.replace("Script", "");
    }
    return word;
}

// 5. Replacing each letter with the one next to it

function nextChar(word) {
    let newWord = "";
    for (i = 0; i < word.length; i++) {
        newWord += word.fromCharCode(word.fromCharCode(i) + 1);
    }
    return newWord;
}

// 6. Vowel Counter
function countVowel(word) {
    let vowels = 'aeiouyAEIOUY';
    let vowelCount = 0;

    for(i = 0; i < word.length; i++) {
        if (vowels.indexOf(word[i]) !== -1) {
            vowelCount += 1;
        }
    }

    return vowelCount;
}

// 7. Reverse a String 

function reverse(word) {
    let newWord = "";
    for (i = word.length - 1; i >= 0; i--) {
        newWord = newWord + word.charAt(i);
    }
    return newWord;
}

// 8. Adding Arrays

function addArrays(arr1, arr2) {

    let arr3 = [];
    let arrDiff;

    if (arr1.length < arr2.length) {
        arrDiff = arr2.length - arr1.length;
        arr1.length += arrDiff;
        for (i = 0; i < arr2.length; i++) {
            arr3[i] = arr1[i] + arr2[i];
        }

    } else if (arr2.length < arr1.length) {
        arrDiff = arr1.length - arr2.length;
        arr2.length += arrDiff;
        for (i = 0; i < arr2.length; i++) {
            arr3[i] = arr1[i] + arr2[i];
        }

    } else {

        for (i = 0; i < arr2.length; i++) {
            arr3[i] = arr1[i] + arr2[i];
        }

    }

    return arr3
    
}

// 9. Longest String in String Array

function bigString(arr1) {
    let biggest = "";

    for (i = 0; i < arr1.length; i++) {

        if (biggest == "") {
            biggest == arr1[i];

        } else if (biggest.length < arr1[i].length) {

            biggest == arr1[i]
        }
    }

    return biggest;
}


// 10. Area of a triangle

function equilateralArea(side1, side2, side3) {
    if (side1 < 0 || side1 != side2 && side2 != side3) {
        return undefined;
    }
        return (Math.sqrt(3)/4) * side1**2;
}

// 11. Similar polygons

function areSimilar(arr1, arr2) {
    if (arr1.length != arr2.length) {
        return false;
    }

    // compare ratio of side lengths

    
}

// 12. Equivalen arrays

// 13. Tic Tac Toe
function tictactoe(array) {

    let x = "X";
    let o = "O";
    let empty = "empty";

    let arr1 = array[0];
    let arr2 = array[1];
    let arr3 = array[2];

    if (arr1 != [x,x,x] || )
}


