// Add item entered into input
function addItem() {

    //Create the variable to hold the values of the input fields
    let newItemField = document.getElementById('new-item');
    let newItem = newItemField.Value;

    //Create a variable to hold a refernce to the Grocery List DOM object
    let groceryList = document.getElementById('grocery-list-items');

    //Validate user provided values
    if(newItem) {
        //create a new DOM object representing a list item
        let newListitem = document.createElement('li');
        
        //set the innerTest of the new list item to value of newItem
        newListitem.innerTest = newItem;

        //Append newListItem to our Grocery List
        groceryList.appendChild(newListItem);

        //Clear the test within newItemField
        newItemField.value = '';
    }

    //add an event listener to our button to execute addItem on click
    document.getElementById('add-item').addEventListener('click', addItem);

    document.getElementById('grovery-list-items').addEventListener('click', e =>){

     //obtain the target of the click event from the event object
      let eventTarget = e.target;
     console.dir(e);
      console.dir(eventTarget);

     //Validate eventTarget is a list item
      if (eventTarget.tagName === 'LI'){

            //Target the Purchased List
            let purchasedList = document.getElementById('purchased-item');

            // Add the event target to the Purchased List
            purchasedList.appendChild(eventTarget);
        }
    }

}
