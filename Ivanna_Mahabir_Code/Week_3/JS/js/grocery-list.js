function addItem(){
    let x = document.getElementById('new-item');
    let newItem = x.value;

    let groceryList = document.getElementById('grocery-list-items');

    if(newItem){
        let newList = document.createElement('li');
        newList.innerText = newItem;

        groceryList.appendChild(newList);

        x.value = '';
    }
}

document.getElementById('add-item').addEventListener('click', addItem);

