// Add item entered into input field to the Grocery List
function addItem() {

    // Create the variables to hold the values of the input fields
    let newItemField = document.getElementById('new-item');
    let newItem = newItemField.value;

    // Create a variable to hold a reference to the Grocery List DOM object
    let groceryList = document.getElementById('grocery-list-items');

    // Validate user-provided values
    if (newItem) {

        // Create a new DOM object representing a list item
        let newListItem = document.createElement('li');

        // Set the innerText of newListItem to the value provided by our user
        newListItem.innerText = newItem;

        // Append newListItem to our Grocery List
        groceryList.appendChild(newListItem);

        // Clear the text within newItemField
        newItemField.value = '';

    }

}

// Add an event listener to our button to execute addItem on click
document.getElementById('add-item').addEventListener('click', addItem);

document.getElementById('grocery-list-items').addEventListener('click', e => {

    // Obtain the target of the click event from the Event object
    let eventTarget = e.target;
    console.dir(e);
    console.dir(eventTarget);

    // Determine if the tag name of the event target is a list item
    if (eventTarget.tagName === 'LI') {
        
        // Target the Purchased List
        let purchasedList = document.getElementById('purchased-items');

        // Add the event target to the Purchased List
        purchasedList.appendChild(eventTarget);

    }
});

document.getElementById('purchased-items').addEventListener('click', e => {
    if (e.target.tagName === 'LI') {
        document.getElementById('grocery-list-items').appendChild(e.target);
    }
});

let array = ['a', 'b', 'c', 'd'];
console.table(array);