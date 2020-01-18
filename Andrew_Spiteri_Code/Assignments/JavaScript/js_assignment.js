/* 1. Leap Year */ //wrong

function leapYear(date){
    let dateObject = new Date(date);
    let year = dateObject.getFullYear();
    if(year % 400 === 0){
        return true;
    }else if(year % 4 === 0){
        return true;
    }else{
        return false;
    }
}

/* 2. Email Validation */ 

function isEmail(string){  

 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(string))
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}

/* 3. Remove Character */ //wrong

function removeChar(string, position){
    string[position] = ' '; 
    string.trim();
    return string[position];   
}
        
/* 4. Remove "Script" */ //correct

function removeScript(string){
    string = string.replace(/Script/gi,"");
    return string;
}

/* 5. Letter Shift */

function letterShift(string){
    let first = string[0];
    for(let i = 0; i < string.length; i++){
        if(i === string.length - 1){
            string[i] = first;
            break;
        }
        string[i] = string[i+1]
    }
    return string;
}

/* 6. Vowel Count */ //correct

function vowelCount(string){
    let count = 0;
    for(let i = 0; i < string.length; i++){
        switch(string[i]){
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                count++;
                break;
            default:
                break;
        }
    }
    return count;
}

/* 7. Reverse Array */ //correct

function reverseArr(array){
    array = array.reverse(); 
    return array;   
}


/* 8. Add Array */ //correct

function addArr(array1, array2){
    let array3 = [];
    if(array1.length === array2.length){
        for(let i = 0; i < array1.length; i++){
            array3.push(array1[i]+array2[i]);
        }
        return array3;
    }else if(array1.length > array2.length){
        let holder = 0;
        for(let i = 0; i < array2.length; i++){
            array3.push(array1[i]+array2[i]);
            holder = i;
        }holder++;
        for(holder; holder < array1.length; holder++){
            array3.push(array1[holder]);
        }        
        return array3;
    }else if(array1.length < array2.length){
        let holder = 0;
        for(let i = 0; i < array1.length; i++){
            array3.push(array1[i]+array2[i]);
            holder = i;
        }holder++;
        for(holder; holder < array2.length; holder++){
            array3.push(array2[holder]);
        }        
        return array3;
    }

}

/* 9. Longest String */

function longestStr(array){
    for()
}

/* 10. Area of a Triangle */

function area(number1, number2, number3){

}

/* 11. Similar Polygons */

function areSimilar(array, array){

}

/* 12. Equivalent Arrays */

function equvArr(array, array){

}

/* 13. Tic Tac Toe */

function tictactoe(array){

}
