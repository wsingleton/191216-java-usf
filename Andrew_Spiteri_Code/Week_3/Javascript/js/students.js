
let idCounter = 1;
function* idGenerator(){
    
    while(true){
        yield idCounter++;
    }
}

function addStudent(){
    //get input field values
    let studentNameInputField = document.getElementById('name');

    let studentName = document.getElementById('name').value;
    let studentMajor = document.getElementById('major').value;

    //Validate the values (ensure they are not empty strings)
    if(studentName && studentMajor){

        //Create a row and cells for the students table
        let row = document.createElement('tr');
        let studentIdCell = document.createElement('td');
        let studentNameCell = document.createElement('td');
        let studentMajorCell = document.createElement('td');

        //Append cells to the row
        row.appendChild(studentIdCell);
        row.appendChild(studentNameCell);
        row.appendChild(studentNameCell);

        //Append the row to the pre-existing table
        document.getElementById('students').appendChild(row);

        //Add student info to the newly appended row
        studentIdCell.innerText = idGenerator();
        studentNameCell.innerText = studentName;
        studentMajorCell.innerText = studentMajor;

        // Clear the input for the fields, for future values to be provided
        studentNameInputField.value = '';
        document.getElementById('major').value = '';
    }
}


//Create an eventy listener  that will fire off when the button is clicked
document.getElementById('add').addEventListener('click', addStudent); //<--- example of a callback