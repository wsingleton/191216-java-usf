function addItem() {
    //get values
    let groceryItem=document.getElementById("new-item").value;
    //validate values
    if (groceryItem) {
        //create a list item for the list
        let listSlot=document.createElement("li");
        //append the list item to the list
        document.getElementById("to-buy").appendChild(listSlot);
        //populate the list item
        listSlot.innerText=groceryItem;
        //clear the input field for future values
        document.getElementById("new-item").value="";
    }
}
document.getElementById("add-item").addEventListener("click", addItem);
document.getElementById("to-buy").addEventListener("click", e => {
    //get item value
    let targetItem=e.target;
    //ensure it is only a <li> item, not a <ul>
    if (targetItem.tagName==="LI") {
        //add item to purchased
        document.getElementById("purchased").appendChild(targetItem);
    }
})
document.getElementById("purchased").addEventListener("click", e => {
    if (e.target.tagName==="LI") {
        document.getElementById("to-buy").appendChild(e.target);
    }
})