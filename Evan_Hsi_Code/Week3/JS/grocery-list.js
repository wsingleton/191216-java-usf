//Add item entered into input field to the grocery list
function addItem() {

    // Create the variable to hold the values of the input fields
    let newItemField = document.getElementById('new-item');
    let newItem = newItemField.value;

    // Create a variable to hold a reference to the Grocery List DOM object
    let groceryList = document.getElementById('grocery-list-items');

    // Validate userprovided values
    if(newItem) {
        // create a new DOM object representing a list item
        let newListitem = document.createElement('li');

        // Set the innerText of the new list item to value of newItem 
        newListitem.innerText = newItem;

        // Append newListItem to our Grocery List
        groceryList.appendChild(newListItem);

        //Clear the text within newItemField
        newItemField.value = '';
    }

}

// Add an event listener to our button to execute addItem on click
document.getElementById('add-item').addEventListener('click', addItem);

document.getElementById('grocery-list-items').addEventListener('click', e => {
    // obtain the target of the click event from the event object
    let eventTarget = e.target;
    console.dir(e);
    console.dir(eventTarget);

    // Validate eventTarget is a list item 
    if (eventTarget.tagName.toLowerCase() === 'li') {
        
        // Target the Purchased List
        let purchasedList = document.getElementById('purchased-items');

        // Add the event target to purchasedList
        purchasedList.appendChild(eventTarget);
    }
});

document.getElementById('purchased-items').addEventListener('click', e=> {
    if(e.target.tagName === 'LI') {
        document.getElementById('grocery-list-items').appendChild(e.target);
    }
})