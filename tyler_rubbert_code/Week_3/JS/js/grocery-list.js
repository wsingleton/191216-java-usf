// Add item intered into input field to the Grocery List
function addNewItem() {

    //Create the variables to hold the values of the input fields
    let newGroceryItemInputField = document.getElementById('new-item');
    let newGroceryItem = newGroceryItemInputField.value;

    //Create a variable to hold the reference to the Grocery List DOM object
    let groceryList = document.getElementById('grocery-list-items');

    // Validate user-provided values
    if (newGroceryItem) {

        // Create a new DOM object representing a list item
        let newListItem = document.createElement('li');

        // Set the innerText of the newListItem to the value provided by our user
        newListItem.innerText = newGroceryItem;

        // Append newListItem to our Grocery List
        groceryList.appendChild(newListItem);

        // Clear the text within newGroceryItemInputField
        newGroceryItemInputField.value;
    }
    
}

// Add an even listener to our button 
document.getElementById('add-item').addEventListener('click', addNewItem);

document.getElementById('grocery-list-items').addEventListener('click', e => {

    // Obtain the target of the click event from the Event object
    let eventTarget = e.target;
    console.dir(e);
    console.dir(eventTarget);

    // Determine if the tag name of the event target is a list item
    if(eventTarget.tagName === 'LI') {

        // Target the Purchased List
        let purchasedList = document.getElementById('purchased-items');

        // Add the event target to the Purchased List
        purchasedList.appendChild(eventTarget);
    }
})

document.getElementById('purchased-items').addEventListener('click', e => {
    if (e.target.tagName === 'LI') {
        document.getElementById('grocery-list-items').appendChild(e.target);
    }
})
