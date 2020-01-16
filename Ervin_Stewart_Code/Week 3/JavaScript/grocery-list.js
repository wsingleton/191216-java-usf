
function addItem(){

    let newItemField = document.getElementById('new-item');
    
    let newItem = newItemField.value;
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