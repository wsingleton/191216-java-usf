

/* 1. Leap Year */

function leapYear(date){
    if (date % 4 == 0){
        console.log('This year is a leap year')
    } else {
        console.log('This year is not a leap year')
    }
}

/* 2. Email Validation */ 

function isEmail(string) 
{
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.emailAddr.value))
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}


/* 3. Remove Character */

function removeChar(string, position){

    part1 = string.substring(0, position);
    part2 = string.substring(position +1, string.length);
    return (part1 + part2);
}
        
/* 4. Remove "Script" */

function removeScript(string){
    
    var str = string;
    var res = str.replace('Script', '');
    console.log(res);
 }






/* 5. Letter Shift */

function letterShift(string){

}



/* 6. Vowel Count */

function vowelCount(string){


    str = string 
    vowelNum = 0;

    str.split("");

    for(i = 0; i < str.length; i ++){
        if(i === 'a' || 'e' || 'i' || 'u' || 'o'){
            vowelNum = vowelNum+1;
        }
    }

    console.log(vowelNum)

}



/* 7. Reverse Array */

function reverseArr(array){

    array.reverse()

}









/* 8. Add Array */

function addArr(array1, array2){

    const result = [];
    let ctr = 0;
    let x=0;

  
   while (ctr < array1.length && ctr < array2.length) 
    {
      result.push(array1[ctr] + array2[ctr]);
      ctr++;
    }
  
   if (ctr === array1.length) 
   {
      for (x = ctr; x < array2.length; x++)   {
        result.push(array2[x]);
      }
    } 
    else
    {
    for (x = ctr; x < array1.length; x++) 
      {
        result.push(array1[x]);
      }
    }
    return result;

}



/* 9. Longest String */

function longestStr(array){

    let max = array[0].length;
    array.map(v => max = Math.max(max, v.length));
    result = array.filter(v => v.length == max);
    return result;
}



/* 10. Area of a Triangle */

function area(number1, number2, number3){

    var s =(number1 + number2 + number3)/2;

    var area = Math.sqrt(s*((s-number1)*(s-number2)*(s-number3)));

    console.log(area);
}

function areSimilar(array1, array2){

    isSimilar = false;

    if(array1 == array2){
        isSimilar = true;
    }else{
        isSimilar = false;
    }

    console.log(isSimilar)

}

/* 12. Equivalent Arrays */

function equvArr(array, array){

}

/* 13. Tic Tac Toe */

function tictactoe(array){

}
