function addItem(){
    let item = document.getElementById("new-item").value;
    if(item !== ""){
    let list = document.getElementById("grocery-list-items");
    let newListItem = document.createElement("li");
    newListItem.innerText = item
    list.appendChild(newListItem);
    }
    
}

function addItemToPurchased() {
    let item = document.querySelectorAll("li");
    // if(item)

}


document.getElementById("grocery-list-items").addEventListener('click', addItemToPurchased);
