//1. link manipulation
document.getElementsByTagName('a')[0].setAttribute("href", "https://www.google.com");
document.getElementsByTagName('a')[2].setAttribute("href", "https://www.slack.com");
document.getElementsByTagName('a')[1].setAttribute("href", "https://www.twitter.com");
document.getElementsByTagName('a')[3].setAttribute("href", "https://www.javadocs.com");

//2.Remove Pluto From List
document.getElementById('planet').options[3].disabled= true;

//3. Function to display hidden alien message
document.getElementById('form-sub').addEventListener("click", alienText);

function alienText(){
    
if(document.getElementById('planet').options[1].selected===true ){
    document.getElementsByTagName('p')[5].hidden = false;
}else if(document.getElementById('planet').options[2].selected===true){
     document.getElementsByTagName('p')[5].hidden = false; 
}else if (document.getElementById('planet').options[0].selected===true){
    document.getElementsByTagName('p')[5].hidden = true;
}
}


//4.
function addToDirectory(){

    let newFirstNameField = document.getElementById('firstname');
    let newFirstName = newFirstNameField.value;
    let newLastNameField = document.getElementById('lastname');
    let newLastName = newLastNameField.value;
    let name = newFirstName.concat(" ",newLastName);
    let email = document.getElementById('email').value;
    let phoneNumber = document.getElementById('phone').value;
    let birthday = document.getElementById('bday').value;
    let homePlanet = document.getElementById('planet').value;
    let gender = null;
    if(document.getElementsByName('gender').value==='male'){gender = documeent.getElementsByName('gender').value;}
    else if(document.getElementsByName('gender').value=== 'female'){gender = documeent.getElementsByName('gender').value;}
    else if(document.getElementsByName('gender').value==='other'){gender = documeent.getElementsByName('gender').value;}

    let groceryList = document.getElementById('grocery-list-items');

    
    if (newItem){
        let newListItem = document.createElement('li');
       
        newListItem.innerText = newItem;

        groceryList.appendChild(newListItem);

        newItemField.value = '';
        
    }

 }

 document.getElementById('add-item').addEventListener('click', addItem);

 document.getElementById('grocery-list-items').addEventListener('click', e=>{

    let eventTarget = e.target;
    if (eventTarget.tagname === 'LI'){

        let purchaseList = document.getElementById('purchased-items');

        purchasedList.appendChild(eventTarget);
    }
 });

document.getElementById('purchased-items').addEventListener('click', e=>{
    if(e.target.tagName === 'LI'){
        document.getElementById('grocery-list-items').appendChild(e.target);
    }
});

//5.


//6.


//7.



//8.


//9.



//10.