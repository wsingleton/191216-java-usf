function addGroceryItem(){
    //get input field values
    let newItemField = document.getElementById('new-item');

    let groceryItem = newItemField.value;

    let groceryList = document.getElementById('grocery-list-items');

    //Validate the values (ensure they are not empty strings)
    if(groceryItem){
        //Create a row and cells for the grocery list table
        let newListItem = document.createElement('li');

        // Set the innerText of newListItem to the value procided by our user
        newListItem.innerText = groceryItem;

        //Append newListItem
        groceryList.appendChild(newListItem);

        newItemField.value = '';

    }

    //Add an eventlistener to our button
    document.getElementById('add-item').addEventListener('click', addItem);

    document.getElementById("grocery-list-items").addEventListener('click',e =>{
        //Obtain the target of the click event
        let eventTarget = e.target;
        console.dir(e);
        console.dir(eventTarget);

        //Determine if the tag name of the event target is a list item
        if(eventTarget.tagName === 'LI'){
            //Target the Purchased List
            let purchasedList = document.getElementById('purchased-items');

            //Add the event target to the Purchased List
            purchasedList.appendChild(eventTarget);
        }
    });

    document.getElementById('purchased-items').addEventListener('click', e => {
        if(e.target.tagName === 'LI'){
            document.getElementById('grocery-list-items').appendChild(e.target);
        }
    })
}