// Part 1: Basic JavaScript



// Script
// ..
//1. Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar..,,,M

const leapyear=(year)=>{
    return(year % 100===0)? (year % 400 ===0) : (year % 4 ===0);
}

console.log(leapyear(2016));



//2. Create a function that checks for a valid email format.
//
//3. Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

//can probably use slice method....

let string = "hello world";

console.log(string.slice(0, 3))
console.log(string.slice(4))

const removeCharacterByIndex=(str, index)=>{
    if (index==0){
        return str.slice(1)
    } else {
        return str.slice(0, index-1) + str.slice(index);
    }
}

console.log(removeCharacterByIndex("hello", 0))

// Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string return the string without "Script" otherwise return the original one.

// Write a JavaScript function to replace every character in a given string with the character following it in the alphabet.

// Write a JavaScript function to count the number of vowels in a given string.
const countVowels=(str)=>{
    let count = str.match(/[aeiou]/g);
    return count === null ? 0 : count.length;

}

console.log(countVowels("banana"));

// Write a JavaScript function to reverse the elements of a given array.
let arr=[]
let revArr = arr.reverse();

// Write  JavaScript function that adds the values of arrays, even if the arrays are different sizes. 
// 	addArr([1,2,3],[3,2,1]) = [4,4,4]
// 	addArr([1,2,3,4,5],[1,2,3]) = [2,4,6,4,5]

let addArr=(arr1, arr2)=>{
    newArr = arr1.concat(arr2);
}


// Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.
const longestStr =(arr)=>{
    let maxStr = arr[0].length
    arr.map(a=>maxStr = Math.max(max, a.length));
    result = arr.filter(a=> a.length == maxStr)
}


// Write a JavaScript function which accepts three integers representing side lengths of a triangle. The function should validate that the integers make a geometrically accurate. If the three integers could not make a triangle, return undefined. Otherwise calculate and return the area of the triangle.
//this is so off
findTriangle=(a, b, c)=>{
    let parameter = (a +b+c)/2;
    if(a+b>c){
        let area = Math.sqrt(parameter*(parameter-a)*(parameter-b)*(parameter-c));

        return area
    } else 
    return undefined;

}
// Write a JavaScript function which accepts two arrays, representing the side lengths of polygons. Return true if the polygons are similar, false if they are not.
//do we need to account for the polygon sides or just for the arrays?
polygon=(arr1, arr2)=>{
    if(arr1.length === arr2.length){
        return true;
    } else{
        return false;
    }
}



// Check if two arrays have the same size and contents (including if content order is not the same).
// 	equivArr([4,2,8,4,7],[7,4,4,2,8]) = true
// equivArr([4,2,8,4,7],[7,5,4,2,8]) = false
// equivArr([4,2,8,4],[7,5,4,2,8]) = false

// Create a function which takes a 3x3 2D array. Validate that each array index holds only a value of “X”, “O”, or be empty. Have the function evaluate a game of tic tac toe represented by the 2D array.  Should have a result for a tie, each winner, or an invalid game.

// 	tictactoe([[“X”, “X”, “X”],[“O”, “O”, “O”],[“X”, “O”, “X”]]) 
// prints “Invalid result”

// tictactoe([[“X”, “X”, “X”],[“X”, “X”, “X”],[“X”, “O”, “X”]]) 
// prints “Invalid result” 

// 	tictactoe([[“X”, “O”, “X”],[“O”, “X”, “O”],[“X”, “O”, “X”]]) 
// Prints “X is the winner”

// tictactoe([[empty, “O”, “X”],[“X”, “O”, empty],[empty, “O”, “X”]]) 
// Prints “O is the winner”


// 		tictactoe([[“X”, empty, “X”],[“O”, empty, empty],[empty, “O”, empty]]) 
// Prints “No winner yet”
	
