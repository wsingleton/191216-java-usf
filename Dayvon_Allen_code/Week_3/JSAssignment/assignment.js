/* 1. Leap Year */

function leapYear(date) {
    if (date % 4 === 0 && (date % 400 === 0 && date % 100 === 0)) {
        return true;
    }
    return false;
}

/* 2. Email Validation */

function isEmail(string) {
    let checker = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return checker.test(String(string));
}

/* 3. Remove Character */

function removeChar(string, position) {
    let newStr;
    newStr = string.replace(string[position], "");
    return newStr;
}

/* 4. Remove "Script" */

function removeScript(string) {
    if (string.includes("Script")) {
        return string.replace("Script", "")
    }
    else {
        return string;
    }
}
/* 5. Letter Shift */

function letterShift(string) {
    let arr = string.split("");
    let newChar = "";

    for (let i = 0; i < arr.length; i++) {
        if ((String.fromCharCode(string.charCodeAt(i) > 64 && String.fromCharCode(string.charCodeAt(i)) < 91) || (String.fromCharCode(string.charCodeAt(i)) < 123 && String.fromCharCode(string.charCodeAt(i)) > 96))) {

            if (string.charCodeAt(i) + 1 === 91) {
                newChar += String.fromCharCode(string.charCodeAt(i) - 25);
            }
            else if (string.charCodeAt(i) + 1 === 123) {
                newChar += String.fromCharCode(string.charCodeAt(i) - 25);
            }
            else {
                newChar += String.fromCharCode(string.charCodeAt(i) + 1);
            }
        }
    }
    return newChar;
}

console.log(letterShift("zBbcAZ"));


/* 6. Vowel Count */

function vowelCount(string) {
    let count = 0;
    let arr = string.toLowerCase().split("")
    let holder = arr.map(c => {
        if (c === "a" || c === "e" || c === "i" || c === "u")
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

    if (array1 === null || array2 === null) {
        return false;
    }
    else {
        let arr = array1;
        let arr2 = [...array2];
        let count = 0
        let newArr = [];
        arr.map(n => {
            if (count < array2.length) {
                newArr.push(n + array2[count])
                arr2.shift();
            }
            else {

                newArr.push(n);
            }
            count++;
        })

        if (arr2.length !== 0) {
            for (let i = 0; i < arr2.length; i++) {
                newArr.push(arr2[i]);
            }
        }
        return newArr;
    }


}

/* 9. Longest String */

function longestStr(array) {
    let longest = "";
    let arr = [...array];
    arr.map(n => {
        if (n.length > longest.length) {
            longest = n;
        }
    })
    console.log(longest);
    return array.indexOf(longest);
}

/* 10. Area of a Triangle */

function area(number1, number2, number3) {
    //equilateral triangle
    if (number1 === number2 && number1 === number3) {
        return (Math.sqrt(3) / 4) * number1 ** 2;
    }
    return undefined;
}

/* 11. Similar Polygons */

function areSimilar(array1, array2) {
    //it has to be more than 3 sides, one can be smaller than the other, 2 side have to have the same ratio
    // what ever the max side is (1 2 3 have to be greater than)
}



/* 12. Equivalent Arrays */

function equvArr(array1, array2) {
    if (array1.length !== array2.length) {
        return false
    }
    let unique = new Set(array1);
    let unique2 = new Set(array2);
    let arr = [...unique].sort();
    let arr2 = [...unique2].sort();
    let same = true;

    if (arr.length !== arr2.length) {
        return false;
    }

    arr.map(c => {
        if (!arr2.includes(c)) {
            same = false
        }
    })
    return same;
}

// console.log(equvArr([1,1,5,6,3], [1,2,5,6,3]));


/* 13. Tic Tac Toe */

function tictactoe(array) {
    for (let i = 0; i < array.length; i++) {
        if (array[i] !== "X" || array[i] !== "O" || array[i] !== "") {
            console.log("Invalid result");
            return;
        }
        if (array.lastIndexOf(array[i]) !== array.indexOf(array[i])) {
            console.log("Invalid result");
            console.log("one");
            return;
        }
        if (array.lastIndexOf(array[1][i]) !== array.indexOf(array[1][i])) {
            console.log("Invalid result");
            console.log("two");
            return;
        }
        if (array.lastIndexOf(array[2][i]) !== array.indexOf(array[2][i])) {
            console.log("Invalid result");
            console.log("three");
            return;
        }
        console.log("Success");
    }
}

// tictactoe([["X","","O"],["O", "X",""],["X", "O", ""]]);


