/* 1. Leap Year */
 
function leapYear(date){
if (date % 4 == 0 ){
    if ( date% 100 == 0){
         if(date % 400 ==0){ 
             return true;
        }else {return false;}
    }else {return true;}
}else{return false;}
}


/* 2. Email Validation */ 

function isEmail(string){
    let re = /\S+@\S+\.\S+/;
    return re.test(string);
}

/* 3. Remove Character */

function removeChar(string, position){
let newString = null;
let firsthalf = string.substr(0,position);
let secondHalf = string.substr(position+1);
newString =firsthalf.concat(secondHalf);
    return newString;
}
        
/* 4. Remove "Script" */

function removeScript(string){
 let newString = string.replace(/Script/g,'');
newString = newString.replace(/script/g,'');
 return newString;
}

/* 5. Letter Shift */

function letterShift(string){
let stringL = string.length;
let newStri = string.toLowerCase();
 let stringArr=newStri.split('');
 let nsstringArr =stringArr.join();
 for(i=0; i<stringL; i++){

if(stringArr[i] == 'a'){stringArr[i] = 'b'; continue;}
if(stringArr[i] == 'b'){stringArr[i] = 'c'; continue;}
if(stringArr[i] == 'c'){stringArr[i] = 'd';continue;}
if(stringArr[i] == 'd'){stringArr[i] = 'e';continue;}
if(stringArr[i] == 'f'){stringArr[i] = 'g';continue;}
if(stringArr[i] == 'g'){stringArr[i] = 'h';continue;}
if(stringArr[i] == 'h'){stringArr[i] = 'i';continue;}
if(stringArr[i] == 'i'){stringArr[i] = 'j';continue;}
if(stringArr[i] == 'j'){stringArr[i] = 'k';continue;}
if(stringArr[i] == 'k'){stringArr[i] = 'l';continue;}
if(stringArr[i] == 'l'){stringArr[i] = 'm';continue;}
if(stringArr[i] == 'm'){stringArr[i] = 'n';continue;}
if(stringArr[i] == 'n'){stringArr[i] = 'o';continue;}
if(stringArr[i] == 'o'){stringArr[i] = 'p';continue;}
if(stringArr[i] == 'p'){stringArr[i] = 'q';continue;}
if(stringArr[i] == 'q'){stringArr[i] = 'r';continue;}
if(stringArr[i] == 'r'){stringArr[i] = 's';continue;}
if(stringArr[i] == 's'){stringArr[i] = 't';continue;}
if(stringArr[i] == 't'){stringArr[i] = 'u';continue;}
if(stringArr[i] == 'u'){stringArr[i] = 'v';continue;}
if(stringArr[i] == 'v'){stringArr[i] = 'w';continue;}
if(stringArr[i] == 'w'){stringArr[i] = 'x';continue;}
if(stringArr[i] == 'x'){stringArr[i] = 'y';continue;}
if(stringArr[i] == 'y'){stringArr[i] = 'z';continue;}
if(stringArr[i] == 'z'){stringArr[i] = 'a';continue;}
if(stringArr[i]== ' '){stringArr[i] = ' ';continue;}
}
 let newString = stringArr.toString();
  return newString = newString.replace(/,/g,'');
}

/* 6. Vowel Count */

function vowelCount(string){
    let stringl = string.length;
    let vCount =0;
    let newStri = string.toLowerCase();
 let stringArr=newStri.split(" ");
 let nsstringArr =stringArr.join();
for(i=0; i<stringl; i++){
if(nsstringArr[i] == 'i'|| nsstringArr[i]=='a'||nsstringArr[i]=='o'||nsstringArr[i]=='u' ||nsstringArr[i]=='e'){vCount++;}
}
return vCount;
}

/* 7. Reverse Array */

function reverseArr(array){
let revArray = array.reverse();
return revArray;
}


/* 8. Add Array */

function addArr(array, array1){
let arrayL = array.length;
let array1L = array1.length;
let newArr = [];

    if(arrayL>array1L){    
        for(i=0;i<arrayL;i++){
            if(i == array1L && i != arrayL){array1.push(0);}
         newArr[i] = array[i] +array1[i];
        }return newArr;
    }else if(array1L>arrayL){
        for(i=0;i<array1L;i++){
            if(i == arrayL && i != array1L){array.push(0);}
            newArr[i] = array[i] +array1[i];
        }return newArr;
    }else{
        for(i=0;i<arrayL;i++){
            newArr[i] = array[i] +array1[i];
        }return newArr;
    }

}

/* 9. Longest String */

function longestStr(array){
 let arrayL = array.length;
 let comp1 =array[0].length;
 let comp2 =0;
 let idx =0;
   for(i=1;i<arrayL;i++){
       comp2 =array[i].length;
       
 let value = comp1-comp2;
 if(value > 0){continue;}
   else if(value <0){idx=i;comp1=array[i].length;continue;
}else continue;
}return idx;
}

/* 10. Area of a Triangle */

function area(number, number2, number3){
let triangleArea = number
}

/* 11. Similar Polygons */

function areSimilar(array, array1){
 
}

/* 12. Equivalent Arrays */

function equvArr(array, array1){
    let bool = false;
    
    if(array.length != array1.length){return false;}
    array.sort(function(a,b){return a-b});
        array1.sort(function(a,b){return a-b});
    for(i=0;i<array.length;i++){
            if(array[i] == array1[i]){bool = true;
            }else{bool = false; return bool;}
        }return bool;
}

/* 13. Tic Tac Toe */

function tictactoe(array){

}
