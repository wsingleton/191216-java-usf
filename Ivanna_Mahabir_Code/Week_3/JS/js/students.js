function idGenerator(){
    let idCounter = 1;
    while (true){
        yield idCounter++;
    }
}

function addStudent(){
    //Get input field values
    let studentNameInputField = document.getElementById('name');


    let studentName = document.getElementById('name').value;
    let studentMajor = document.getElementById('najor').value;

    console.log(studentName, studentMajor);

    //validate the values(ensure they are not empty strings)
    if(studentName && studentMajor){

    

        //Create a row and cells for the students table

        
        //Append cells to the row


        //Append the row to the pre-existing table


        //Add student info to the newly appended row


        //Clear the input for the fields, for future values

    }
}