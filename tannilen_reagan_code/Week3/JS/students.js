let idCounter=1;
function* idGenerator() {
    while(true) {
        yield idCounter++;
    }
}

function addStudent() {
    //get values
    let studentName=document.getElementById("name").value;
    let studentMajor=document.getElementById("major").value;
    //validate values
    if (studentName && studentMajor) {
        //create a row and cells for the table
        let row=document.createElement("tr");
        let studentIdCell=document.createElement("td");
        let studentNameCell=document.createElement("td");
        let studentMajorCell=document.createElement("td");
        //append cells to the row
        row.appendChild(studentIdCell);
        row.appendChild(studentNameCell);
        row.appendChild(studentMajorCell);
        //append the row to the table
        document.getElementById("students").appendChild(row);
        //populate the row
        studentIdCell.innerText=idGenerator().next().value;
        studentNameCell.innerText=studentName;
        studentMajorCell.innerText=studentMajor;
        //clear the input fields for future values
        document.getElementById("name").value="";
        document.getElementById("major").value="";
    }
}
document.getElementById("add").addEventListener("click", addStudent);