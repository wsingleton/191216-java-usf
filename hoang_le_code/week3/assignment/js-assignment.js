// Q1
function leapyear(Date)
{
    var year = Date.getYear();
    return (year % 100 === 0) ? (year % 400 === 0) : (year % 4 === 0);
}


var Xmas = new Date('December 25, 2017 23:15:00');
console.log(leapyear(Xmas));

//Q2
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

var email = 'hoangle'
let email2 = 'abc@xzy.com'
console.log(validateEmail(email));
console.log(validateEmail(email2));

//Q3
function remove_character(str, char_pos) 
 {
  part1 = str.substring(0, char_pos);
  part2 = str.substring(char_pos + 1, str.length);
  return (part1 + part2);
 }

 console.log(remove_character("Hoangle",1));
console.log(remove_character("Hoangle",3));
console.log(remove_character("Hoangle",5));

//Q4
function check_script(string){
    let a = '';
    a= string.replace(/Script/gi,"");
    return a;
}

console.log(check_script("JavaScriptabc"));
console.log(check_script("CoffeeScript"));

//Q5
function LetterChanges(text) {
    
    var s = text.split('');
    for (var i = 0; i < s.length; i++) {
    
    switch(s[i]) {
    case ' ':
    break;
    case 'z':
    s[i] = 'a';
    break;
    case 'Z': 
    s[i] = 'A';
    break;
    default:
    s[i] = String.fromCharCode(1 + s[i].charCodeAt(0));
    }
    
    switch(s[i]) {
    case 'a': case 'e': case 'i': case 'o': case 'u':
    s[i] = s[i].toUpperCase();
    }
    }
    return s.join('');
    }
    console.log(LetterChanges("java"));
    console.log(LetterChanges("Hoang"));
    console.log(LetterChanges("1234"));

//Q6

function vowel_count(str1)
{
  var vowel_list = 'aeiouAEIOU';
  var vcount = 0;
  
  for(var x = 0; x < str1.length ; x++)
  {
    if (vowel_list.indexOf(str1[x]) !== -1)
    {
      vcount += 1;
    }
  
  }
  return vcount;
}
console.log(vowel_count("hello this is hoang le drom revature"));


//Q7
function reverseArr(array) { 
  
    var new_arr = array.reverse(); 
    return array;
} 

var arr = [34, 234, 567, 4]; 
console.log(reverseArr(arr));

//Q8

function addArr(...arrays) {
    const n = arrays.reduce((max, xs) => Math.max(max, xs.length), 0);
    const result = Array.from({ length: n });
    return result.map((_, i) => arrays.map(xs => xs[i] || 0).reduce((sum, x) => sum + x, 0));
  }


var arr = [1,2,3,4,5];
var arr2 = [1,1,1,2];
console.log(addArr(arr,arr2));

//q9
function longestStr(array){
    let a = 0 ;
    let b = 0;
    for(let i = 0; i< array.length; i++){
        if (array[i].length > a){
            a = array[i].length;
            b= i;
               
        }
    }
    return b;
}
let at = ["123qqq","1234","asd","asdaa","12","asdasd","asdfasdasdasd","aaasd"];
console.log(longestStr(at));

//Q10
function triangle(A,B,C) {
	
	var sideAsqrd = A*A;//side A squared for pythagorean theorem
	var sideBsqrd = B*B;//side B squared
	var sideCsqrd = C*C;//side C squared
	var AB = A +B;//side A + B to check if a triangle can be formed
	var AC = A + C;//side A + C
	var BC = B+ C;//side B + C
	var A2B2 = sideAsqrd + sideBsqrd;
	var A2C2 = sideAsqrd + sideCsqrd;
	var B2C2 = sideBsqrd + sideCsqrd;
	if ((AB > C) && (AC > B) && (BC > A)) {
		var s = (A + B + C)/2;
        var area =  Math.sqrt(s*((s-A)*(s-B)*(s-C)));
        return s;
	}
	if ((sideAsqrd == B2C2) || (sideBsqrd == A2C2) || (sideCsqrd == A2B2)) {
		var s = (A + B + C)/2;
        var area =  Math.sqrt(s*((s-A)*(s-B)*(s-C)));
        return area;
	}
	else {
		return "These 3 sides can not form a triangle.";
	}
	
		
}

console.log(triangle(3,3,3));
console.log(triangle(1,2,4));

//Q11
function areSimilar(arr, arr1){
    


    if(arr.length == arr1.length){
        let check = arr.length-2;
        let check2 = 0;
        for(let i = 0 ; i < arr.length;i++){
            if((arr[i]/arr1[i]) == (arr[i+1]/arr1[i+1])){
                check2 = i;
                console.log("asdasd" + i);
            }
            else{
                break
            }
        }

        if (check2 == check){
            return true;
        }
        else{
            return false;
        }
        

    }
    else{
        return false;
    }

}

var arr3 = [1,2,3,4,3];
var arr4 = [2,3,1,5,1];
var arr5 = [4,6,2,10,2];
console.log(areSimilar(arr3,arr4));
console.log(areSimilar(arr5,arr4));


//q12
function equvArr(arr11, arr22) {

    if (!Array.isArray(arr11) || ! Array.isArray(arr22) || arr11.length !== arr22.length)
      return false;

    var arry1 = arr11.concat().sort();
    var arry2 = arr22.concat().sort();

    for (var i = 0; i < arry1.length; i++) {

        if (arry1[i] !== arry2[i])
            return false;

    }

    return true;

}
console.log(equvArr([4,2,8,4,7],[7,4,4,2,8]));
console.log(equvArr([4,2,8,4,7],[7,5,4,2,8]));

//q13

function tictactoe(array){

}






