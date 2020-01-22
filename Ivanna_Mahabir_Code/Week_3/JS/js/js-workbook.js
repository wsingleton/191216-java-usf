window.onload = function() {
    let initDate = document.getElementById("dateSubmit").addEventListener("click", isLeapYear);
    let initEmail = document.getElementById("emailSubmit").addEventListener("click", isEmailValid);
    let initString = document.getElementById("removeSubmit").addEventListener("click", removeChara);
    let initScript = document.getElementById("scriptSubmit").addEventListener("click", removeScript);
    //let initABC = document.getElementById("abcSubmit").addEventListener("click", replaceABC);
    let initCounter = document.getElementById("vowelSubmit").addEventListener("click", vowelCounter);
    let initlongString = document.getElementById("longSubmit").addEventListener("click", longestString);
    let initTriangle = document.getElementById("triangleSubmit").addEventListener("click", calcTriangle);
    let initPolygon = document.getElementById("polygonSubmit").addEventListener("click", polygon);
    let initComparator = document.getElementById("arrSubmit").addEventListener("click", equiArray);
   

function isLeapYear(){
    let date = document.getElementById("date").value;
    let year = parseInt(date.substring(0, 4),10);

    if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 === 0)){
        document.getElementById("leap").innerText = "True";
        console.log((true));
    }
    else{
        document.getElementById("leap").innerText = "False";
        console.log("false");
    }
}

function isEmailValid(){
    let email = document.getElementById("email").value;
    let mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(email.match(mailFormat)){
        document.getElementById("isEmail").innerText = "True";
        console.log("True");
    }
    else{
        document.getElementById("isEmail").innerText = "False";
        console.log("False");
    }
}

function removeChara(){
    let input = document.getElementById("string").value;
    let number = document.getElementById("num").value;

    let sub = input.slice(0, number-1) + input.slice(number,input.length);
    document.getElementById("removeChar").innerText = sub;
}

function removeScript(){
    let input = document.getElementById("script").value;
    let script = input.replace('Script', '');
    document.getElementById("removeScript").innerText = script;
}
/*
function replaceABC(){
    let input = document.getElementById("abc").value;
    let result = "";
    for(let i= 0; 1 < input.length; i++){
        if(122 == input.charCodeAt(i)){
            result += "a";
        }
        else if(90 == input.charCodeAt(i)){
            result += "A";
        }
        else if(96 < input.charCodeAt(i) && input.charCodeAt(i)<123){
            result += String.fromCharCode(input.charCodeAt(i)+1);
        }
    }
    document.getElementById("removeNext").innerText = result;
}
*/
function vowelCounter(){
    let input = document.getElementById("vowel").value;
    let vowels = 'aeiouAEIOU';
    let counter = 0;
    for(let i=0; i < input.length; i++){
        if(vowels.indexOf(input[i]) !== -1){
            counter++;
        }
    }
    document.getElementById("numVowel").innerText = counter;
}

// Reverse Array
let arrInput = ['apple', 'banana', 'mango', 'orange', 'watermelon'];
let reverse = [];
document.getElementById("origArr").innerText = arrInput;

for(let i = arrInput.length-1; i >=0 ; i-- ){
    reverse.push(arrInput[i])
}
document.getElementById("reverseArr").innerText = reverse;


// Add Arrays
function addArrays(){
let size = document.getElementById("size").value;
let inputArrA = [];
let inputArrB = [];

for(let i = 0; i<size; i++){
    inputArrA[i] = prompt('Enter Element ' + (i+1));    
}
document.getElementById("arrayA").innerText = inputArrA;

for(let i = 0; i<size; i++){
    inputArrB[i] = prompt('Enter Element ' + (i+1)); 
}
document.getElementById("arrayB").innerText = inputArrB;
let resultArr = inputArrA.map((num, i) => parseInt(num) + parseInt(inputArrB[i]));  
document.getElementById("addArr").innerText = resultArr;
}

// longest string
function longestString(){
    let size = document.getElementById("siz").value;
    let stringArr = [];
    
    
    for(let i = 0; i<size; i++){
        stringArr[i] = prompt('Enter Element ' + (i+1));    
    }
    document.getElementById("inputArray").innerText = stringArr;
    

    let longestArr = stringArr.reduce(function(a, b){return a.length > b.length ? a : b;});
    document.getElementById("longestArr").innerText = longestArr;
    }

// Triangle
function calcTriangle(){
    let lengthA = document.getElementById("lengthA").value;
    let lengthB = document.getElementById("lengthB").value;
    let lengthC = document.getElementById("lengthC").value;

    let s = ((parseInt(lengthA) + parseInt(lengthB) + parseInt(lengthC)) / 2);
    console.log(s);

    let partA = s - lengthA;
    let partB = s - lengthB;
    let partC = s - lengthB;

    if(s > 0 && partA > 0 && partB > 0 && partC > 0){
        let area = Math.sqrt(s*(partA)*(partB)*(partC));   
        document.getElementById("triangleArea").innerText = area;
    }
    else{
        document.getElementById("triangleArea").innerText = "Not a Triangle";
        return undefined;
    }
}

//polygon
function polygon(){
    let size = document.getElementById("length").value;
    let polyA = [];
    let polyB = [];

    for(let i = 0; i<size; i++){
        polyA[i] = prompt('Enter Element ' + (i+1));    
    }
    for(let i = 0; i<size; i++){
        polyB[i] = prompt('Enter Element ' + (i+1));    
    }
    if(polyA.sort().join(',') === polyB.sort().join(',')){
        document.getElementById("poly").innerText = "True";
        return true;
    }
    else{
        document.getElementById("poly").innerText = "False";
        return false;
    }
}

function equiArray(){
    let inputA = parseInt(document.getElementById("arrA"));
    let inputB = parseInt(document.getElementById("arrB"));

    if(inputA.length === inputB.length){
        if(inputA.sort().join(',') === inputB.sort().join(',')){
            document.getElementById("poly").innerText = "True";
        return true;
        }
    }
    else{
        document.getElementById("poly").innerText = "False";
    }
}
    
}

