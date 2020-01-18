/* 1. Leap Year */ //correct

function leapYear(date){
    let dateObject = new Date(date);
    let year = dateObject.getFullYear();
    year += 1;
    if(year % 400 == 0){
        return true;
    }else if(year % 4 == 0){
        return true;
    }else{
        return false;
    }
}

/* 2. Email Validation */ //correct

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
    let holder, concatString = '';
    string.split('').forEach(function (c) {
        holder = c.charCodeAt(0);
        holder += 1;
        concatString = concatString + String.fromCharCode(holder);
    });
    return concatString;
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

/* 9. Longest String */ //correct

function longestStr(array){
    let holder = 0;
    let longStr;
    for(let i = 0; i < array.length; i++){
        if(array[i].length > holder){
            holder = array[i].length;
            longStr = i;
        }
    }
    return longStr;
}

/* 10. Area of a Triangle */ //correct

function area(number1, number2, number3){
    if(number1+number2>number3 && number1+number3>number2 && number2+number3>number1){
        let s = (number1+number2+number3)/2;
        let area = Math.sqrt(s*(s-number1)*(s-number2)*(s-number3));
        return area;
    }
    return 'Is not a triangle';
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
