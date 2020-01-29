let arr = [1, 4, 2, 8, 5, 7];

/*
    .map()

    .filter()

    .reduce()
*/

// simple example of .map

let valsSquared = arr.map(val => Math.pow(val, 2));
console.log(valsSquared); // [1, 16, 4, 64, 25, 49]
console.log(arr); // should be the same as line 1

// simple example of .filter

let evens = arr.filter(val => val % 2 === 0);
console.log(evens) // [4, 2, 8]
console.log(arr); // should be the same as line 1

// simple example of .reduce()

let sum = arr.reduce((a, b) => a + b, 0);
console.log(sum); // 27
console.log(arr); // should be the same as line 1