function* idGenerator() {
    let idCounter = 1;
    while(true) {
        yield idCounter++;
    }
}

function addStudent() {

    // Get input field values
    let studentNameInputField = document.getElementById('name');

    let studentName = document.getElementById('name').value;
    let studentMajor = document.getElementById('major').value;
    

    // Validate the values (ensure they are not empty strings)
    if (studentName && studentMajor) {

        // Create a row and cells for the students table
        let row = document.createElement('tr');
        let studentIdCell = document.createElement('td');
        let studentNameCell = document.createElement('td');
        let studentMajorCell = document.createElement('td');

        // Append cells to the row
        row.appendChild(studentIdCell);
        row.appendChild(studentNameCell);
        row.appendChild(studentMajorCell);

        // Append the row to the pre-existing table
        document.getElementById('students').appendChild(row);

        // add student info to the newly appended row
        studentIdCell.innerText = idGenerator().next().value;
        studentNameCell.innerText = studentName;
        studentMajorCell.innerText = studentMajor;

        // Clear the input for the fields, for future values to be provided
        studentNameInputField.value = '';
        document.getElementById('major').value = '';

    }
    
    // Create an event listener that fires off when the button is pressed
    document.getElementById('add').addEventListener('click', addStudent); // <--- example of a callback

}