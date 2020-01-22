/* 1. Leap Year */

function leapYear(date){
    let year=date.getFullYear();
    if (year%4==0) {
        return true;
    }
    else {
        return false;
    }
}

/* 2. Email Validation */ 

function isEmail(string){
    let emailRegEx=/\w+@\w+\.\w+/;
    let valid=emailRegEx.test(string);
    return valid;
}

/* 3. Remove Character */

function removeChar(string, position){
    let newString;
    if (position==string.length) {
        newString=string.slice(0, string.length-1);
    }
    else if (position===0) {
        newString=string.slice(1, string.length);
    }
    else {newString=string.slice(0, position - 1) + string.slice(position, string.length);}
    return newString
}
        
/* 4. Remove "Script" */

function removeScript(string){
    if ((string.indexOf("Script") !== -1)) {
        let newString=string.replace("Script", "");
        return newString;
    }
    else {return string;}
}

/* 5. Letter Shift */

function letterShift(string){
    //just for the record, it's weird that we're coding a ROT1 cipher.
    let alphabet="abcdefghijklmopqrstuvwxyz";
    for(i=0;i<26;i++) {
        string=string.replace(alphabet.charAt(i), i+" ");
    }
    string=string.replace("25 ", "");
    for(j=25;j>-1;j--) {
        string=string.replace(j, alphabet.charAt(j+1));
    }
    string=string.replace(/ /g, "")
    return string;

}

/* 6. Vowel Count */

function vowelCount(string){
    let i=0;
    string=string.toLowerCase();
    for(x=0;x<string.length;x++) {
        if (string.charAt(x)=="a" || string.charAt(x)=="e" || string.charAt(x)=="i" || string.charAt(x)=="o" || string.charAt(x)=="u") {
            i++;
        }
    }
    return i;
}

/* 7. Reverse Array */

function reverseArr(array){
    let reversed=array.reverse();
    return reversed;
}

/* 8. Add Array */

function addArr(array, array2){
    let x;
    if (array.length>array2.length) {
        x=array.length;
    }
    else {
        x=array2.length;
    }
    let newArray=[];
    for (i=0;i<x;i++) {
        let sum=(array[i]+array2[i] || array[i]+0 || array2[i]+0);
        newArray.push(sum);
    }
    return newArray;
}

/* 9. Longest String */

function longestStr(array){
    let x;
    let a=0;
    let b=1;
    let y=array.length;
    while (b<y) {
        if (array[a].length>array[b].length) {
            x=a;
            b++
        }
        else {
            x=b;
            a=b;
            b++;
        }
    }
    return x;
}

/* 10. Area of a Triangle */

function area(number1, number2, number3){
    //Full disclosure, I absolutely had to look up how to calculate the area of a triangle without the height.  Any mistakes in the equation are 100% me not reading the formula right.
    if (number1+number2<number3 || number1+number3<number2 || number2+number3<number1) {
        return undefined;
    }
    else {
        let p=(number1+number2+number3)/2;
        let res=Math.sqrt(p*((p-number1)*(p-number2)*(p-number3)));
        return res;
    }
}

/* 11. Similar Polygons */

function areSimilar(array, array2){
    //From what I've been reading, without the angles, we can't actually tell if they're similar, so this is really not accurate, but hey hey, here we go!
    if (array.length!==array2.length) {
        return false;
    }
    let a1=array.sort(function(a, b){return b - a}); //syntax for numeric sorting algorithm courtesy of W3Schools
    let a2=array2.sort(function(a, b){return b - a});
    let x=a1[0]/a2[0];
    let y=a1.length;
    let t=true;
    for (i=0;i<y;i++){
        if (x!=a1[i]/a2[i]) {
            t=false;
        }
    }
    return t;
}

/* 12. Equivalent Arrays */

function equvArr(array, array2){
    let a1=array.sort();
    let a2=array2.sort();
    if (a1.length!==a2.length) {
        return false;
    }
    let ans=true;
    for (x=0;x<a1.length;x++) {
        if (a1[x]!==a2[x]) {
            ans=false;
        }
    }
    return ans;
}

/* 13. Tic Tac Toe */

function tictactoe(array){

}

//Begin DOM manipulation section

document.getElementsByName("google")[0].setAttribute("href", "https://www.google.com/");
document.getElementsByName("twitter")[0].setAttribute("href", "https://twitter.com/");
document.getElementsByName("slack")[0].setAttribute("href", "https://slack.com/");
document.getElementsByName("javadocs")[0].setAttribute("href", "https://docs.oracle.com/en/java/");

let planet=document.getElementById("planet");
planet.getElementsByTagName("option")[3].setAttribute("disabled", true);

// This HTML hurts so bad.  Why do you do this to me?
function alienText() {
    document.getElementsByClassName("container")[0].getElementsByTagName("p")[0].removeAttribute("hidden");
}
planet.addEventListener("change", e=>{
    let planetChoice=e.options[e.selectedIndex];
    console.log(planetChoice);
    if (planetChoice.tagName==="OPTION") {
    if (planetChoice!="<option>Earth</option>") {alienText()};
    }
})

