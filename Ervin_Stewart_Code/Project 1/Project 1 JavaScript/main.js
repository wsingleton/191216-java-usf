window.onload = () =>{
    loadLogin();
    document.getElementById('logout').addEventListener('click',logout);
    document.getElementById('register').addEventListener('click',loadRegister);
 }
    
    function loadLogin(){
        
        
        console.log('in loadLogin()');
        
        
        let xhr = new XMLHttpRequest();
        xhr.open(GET,'login.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                document.getElementById("login").addEventListener("click", login);
            }
        }
   
   
    }
    
    function loadRegister(){
        
        
        console.log('in loadRegister()');
        
        
        let xhr = new XMLHttpRequest();
        xhr.open(GET,'registerscreen.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                document.getElementById("register-submit").addEventListener("click", register);
            }
        }
   
   
    }

    function loadDashboard(){
        
        
        console.log('in loadDashboard()');
        
        
        let xhr = new XMLHttpRequest();
        xhr.open(GET,'dashboard.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                // document.getElementById("logout").addEventListener("click", logout);
                //document.getElementById("dashboard").addEventListener("click", loadDashboard);
                //document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                //document.getElementById("help").addEventListener("click", loadHelpScreen);
                
            }
        }
   
   
    }
    
    function loadReimbursement(){
        
        
        console.log('in loadReimbursement()');
        
        
        let xhr = new XMLHttpRequest();
        xhr.open(GET,'reimbursement.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                // document.getElementById("logout").addEventListener("click", logout);
                //document.getElementById("dashboard").addEventListener("click", loadDashboard);
                //document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                //document.getElementById("help").addEventListener("click", loadHelpScreen);
                
            }
        }
   
   
    }

    function loadloadHelpScreen(){
        
        
        console.log('in loadDashboard()');
        
        
        let xhr = new XMLHttpRequest();
        xhr.open(GET,'dashboard.view',true);
        xhr.send();
        xhr.onreadystatechange = () =>{
            if(xhr.readyState === 4 && xhr.status ===200){
                document.getElementById("root").innerHTML = xhr.responseText;
                //implement all button functionality
                // document.getElementById("logout").addEventListener("click", logout);
                //document.getElementById("dashboard").addEventListener("click", loadDashboard);
                //document.getElementById("new-expense").addEventListener("click", loadReimbursement);
                //document.getElementById("help").addEventListener("click", loadHelpScreen);
                
            }
        }
   
   
    }
    
    

    function register(){
        
        
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        let firstName = document.getElementById('firstname').value;
        let lastName = document.getElementById('lastname').value;
        let email = document.getElementById('email').value
    
    let newUser = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email
    };
    let userJSON =JSON.stringify(newUser);
    
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'users', true);
    xhr.send(userJSON)
    xhr.onreadystatechange = () => {
        if(xhr.readyState ===4){
             if(xhr.status===200){
   
                let user = JSON.parse(xhr.responseText);
                    console.log(user);
                    // loadDashboard();

                }

                if (xhr.status === 401) {
                    document.getElementById('login-message').innerText = 'Login failed!';
                }
            }
        }

}
    

    function login(){
        
        
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
    
    let creds = {
        username: username,
        password: password
    };
    let credJSON =JSON.stringify(creds);
    
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'auth', true);
    xhr.send(credJSON)
    xhr.onreadystatechange = () => {
        if(xhr.readyState ===4){
             if(xhr.status===200){
   
                let user = JSON.parse(xhr.responseText);
                    console.log(user);
                    // loadDashboard();

                }

                if (xhr.status === 401) {
                    document.getElementById('login-message').innerText = 'Login failed!';
                }
            }
        }

}
    
setTimeout(()=>{
    console.log("the rows are " +rows + " after the 500 miliseconds") 
    accesstable();
          
}, 500);
    
function logout() {
        let xhr = new XMLHttpRequest();
        xhr.open('GET', 'auth', true);
        xhr.send();
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log('logout successful!')
            }
        }
    }

    function setValues(reimbSet){
        let reimbId = reimbSet.reimbId;
        let amount = reimbSet.amount;
        let submittedDate = reimbSet.submittedDate;
        let type = reimbSet.type;
        let status = reimbSet.status;
        let description = reimbSet.description;
        let receipt = reimbSet.receipt;
        let resolverId = reimbSet.resolverId;
        let authorId = reimbSet.authorId;
        let resolvedDate = reimbSet.resolvedDate;


        let row = document.createElement('tr');
        let reimbIdCell = document.createElement('td');
        let typeCell = document.createElement('td');
        let statusCell = document.createElement('td');
        let totalAmountCell = document.createElement('td');
        let dateCreatedCell = document.createElement('td');
        let resolvedDateCell = document.createElement('td');
        let descriptionCell = document.createElement('td');
        let receiptCell = document.createElement('td');
        let resolverCell = document.createElement('td');
        let authorIdCell = document.createElement('td');
        
        if(reimbStatus === 'pending'){
        let updatedStatusCell = document.createElement('td');
        let submitCell = document.createElement('td');

            let submitElement = document.createElement("button").setAttribute('id',reimbSubmit)            
            let reimbursementOptionsElement = `
            <select id='newStatus'>
                            <option selected value="3">Pending</option>
                            <option  value="2">Approved</option>
                            <option value="1">Denied</option>
                        </select>
            `;

            let labelReimbStatus = document.createElement("label");
            labelReimbStatus.setAttribute("for", "select-options");
            labelReimbStatus.innerHTML = reimbursementOptionsElement;
            
            let submitElement = `<button class="btn btn-outline-primary" id="reimbSubmit" >Submit</button>`;
            let labelReimbSubmit = document.createElement("label");
            labelReimbSubmit.setAttribute("for", "#reimbSubmit");
            labelReimbSubmit.innerHTML = submitElement;
        
            row.appendChild(updatedStatusCell);
            row.appendChild(submitCell);
            updatedStatusCell.innerText = labelReimbStatus;
            submitCell.innerText = labelReimbSubmit;
           
        }
    
            row.appendChild(reimbIdCell);
            row.appendChild(typeCell);
            row.appendChild(statusCell);
            row.appendChild(totalAmountCell);
            row.appendChild(dateCreatedCell);
            row.appendChild(authorCell)
            row.appendChild(resolvedDateCell);
            row.appendChild(descriptionCell);
            row.appendChild(receiptCell);
            row.appendChild(resolverCell);
            row.appendChild(authorIdCell);
            
            document.getElementsById('open-reimb')[0].appendChild(row);

            reimbIdCell.innerText = reimbId;
            typeCell.innerText = type;
            statusCell.innerText = status;
            totalAmountCell.innerText = amount;
            dateCreatedCell.innerText = submittedDate;
            resolvedDateCell.innerText =  resolvedDate;
            descriptionCell.innerText = description;
            receiptCell.innerText = receipt;
            resolverCell.innerText = resolverId;
            authorIdCell.innerText =authorId;
            
        
        
    }

    function createEmployeeReimbursementTable(){

        let xhttp = new XMLHttpRequest();
        xhttp.open("GET", 'reimbursements', true);
        xhttp.send();
        xhttp.onreadystatechange = function(){

        if(xhttp.readyState == 4 && xhttp.status == 200){
            let reimbSet = JSON.parse(xhttp.responseText);

            for(let i = 0;i<reimbSet.length; i++ ){
        setValues(reimbSet);
            }
    }
    

        
            
        }
        document.getElementById('firstname').value = '';
        document.getElementById('lastname').value = '';
        document.getElementById('email').value = '';
        document.getElementById('phone').value = '';
        document.getElementById('bday').value = '';
        document.getElementById('gender').value= '';
        document.getElementById('gender').value = '';
        document.getElementById('activity').checked = false;
    
     }
     document.getElementById('form-sub').addEventListener('click',addNewRow);
     
     function isEmail(string){
        let re = /\S+@\S+\.\S+/;
        return re.test(string);
    
     };
    
     function isPhoneNumber(string){
    let str = string;
    let x;
    if(str.length ===10){
        x= /^[0-9]+$/.test(str);
    }else {return false;}
    return x;
     }
    
     function checkLength(String){
    if(string.length <2){
        return false;
    }return true;
     }


     function createOpenEmployeeReimbursementTable(){

        let newFirstNameField = document.getElementById('firstname');
        let newFirstName = newFirstNameField.value;
        let newLastNameField = document.getElementById('lastname');
        let newLastName = newLastNameField.value;
        //let name = newFirstName.concat(" ",newLastName);
        let email = document.getElementById('email').value;
        let phoneNumber = document.getElementById('phone').value;
        let birthday = document.getElementById('bday').value;
        let homePlanet = document.getElementById('planet').value;
    
        let genderCheck = document.getElementsByName('gender');
        let gender = null;
        for(let i = 0; i<genderCheck.length; i++){
            if(genderCheck[i].checked){
                gender = genderCheck[i].value;
            }
    
        }
    
        let color = document.getElementById('color').value;
        let hobby = document.getElementsByClassName('activity');
        let hobList = document.getElement('ul');
        for(let i = 0; i<hobby.length; i++){
            if(hobby[i].checked){
                let y = document.createElement('li')
                y.innerHTML = hobby[i].value;
                hobList.append(y);
            }
        }
    
    
        if((checkLength(newFirstName)) &&(checkLength(newLastName)) && (isPhoneNumber(phoneNumber)) && birthday && gender && color && hobby){
            let row = document.createElement('tr');
            let reimbIdCell = document.createElement('td');
            let typeCell = document.createElement('td');
            let statusCell = document.createElement('td');
            let totalAmountCell = document.createElement('td');
            let dateCreatedCell = document.createElement('td');
            let descriptionCell = document.createElement('td');
            let receiptCell = document.createElement('td');
            let resolverCell = document.createElement('td');
            
    
            row.appendChild(nameCell);
            row.appendChild(emailCell);
            row.appendChild(phoneCell);
            row.appendChild(bdayCell);
            row.appendChild(colorCell);
            row.appendChild(genderCell);
            row.appendChild(hobbyCell);
    
            document.getElementsById('open-reimb')[0].appendChild(row);
    
            nameCell.innerText = newFirstName+ " " + newLastName;
            emailCell.innerText = email;
            phoneCell.innerText = phone;
            bdayCell.innerText = birthday;
            colorCell.innerText = color;
            genderCell.innerText = gender;
            hobbyCell.appendChild(hobList);
        }
        document.getElementById('firstname').value = '';
        document.getElementById('lastname').value = '';
        document.getElementById('email').value = '';
        document.getElementById('phone').value = '';
        document.getElementById('bday').value = '';
        document.getElementById('gender').value= '';
        document.getElementById('gender').value = '';
        document.getElementById('activity').checked = false;
    
     }
    

     function createClosedManagerReimbursementTable(){

        let newFirstNameField = document.getElementById('firstname');
        let newFirstName = newFirstNameField.value;
        let newLastNameField = document.getElementById('lastname');
        let newLastName = newLastNameField.value;
        //let name = newFirstName.concat(" ",newLastName);
        let email = document.getElementById('email').value;
        let phoneNumber = document.getElementById('phone').value;
        let birthday = document.getElementById('bday').value;
        let homePlanet = document.getElementById('planet').value;
    
        let genderCheck = document.getElementsByName('gender');
        let gender = null;
        for(let i = 0; i<genderCheck.length; i++){
            if(genderCheck[i].checked){
                gender = genderCheck[i].value;
            }
    
        }
    
        let color = document.getElementById('color').value;
        let hobby = document.getElementsByClassName('activity');
        let hobList = document.getElement('ul');
        for(let i = 0; i<hobby.length; i++){
            if(hobby[i].checked){
                let y = document.createElement('li')
                y.innerHTML = hobby[i].value;
                hobList.append(y);
            }
        }
    
    
        
            let row = document.createElement('tr');
            let reimbIdCell = document.createElement('td');
            let typeCell = document.createElement('td');
            let statusCell = document.createElement('td');
            let totalAmountCell = document.createElement('td');
            let dateCreatedCell = document.createElement('td');
            let descriptionCell = document.createElement('td');
            let receiptCell = document.createElement('td');
            let resolverCell = document.createElement('td');
            let authorCell = document.createElement('td');

            row.appendChild(reimbIdCell);
            row.appendChild(typeCell);
            row.appendChild(statusCell);
            row.appendChild(totalAmountCell);
            row.appendChild(dateCreatedCell);
            row.appendChild(descriptionCell);
            row.appendChild(receiptCell);
            row.appendChild(resolverCell);
            row.appendChild(authorCell);
    
            document.getElementsByTagName('table')[0].appendChild(row);
    
            nameCell.innerText = newFirstName+ " " + newLastName;
            emailCell.innerText = email;
            phoneCell.innerText = phone;
            bdayCell.innerText = birthday;
            colorCell.innerText = color;
            genderCell.innerText = gender;
            hobbyCell.appendChild(hobList);
        
        document.getElementById('firstname').value = '';
        document.getElementById('lastname').value = '';
        document.getElementById('email').value = '';
        document.getElementById('phone').value = '';
        document.getElementById('bday').value = '';
        document.getElementById('gender').value= '';
        document.getElementById('gender').value = '';
        document.getElementById('activity').checked = false;
    
     }
    
     function createOpenManagerReimbursementTable(){

        let newFirstNameField = document.getElementById('firstname');
        let newFirstName = newFirstNameField.value;
        let newLastNameField = document.getElementById('lastname');
        let newLastName = newLastNameField.value;
        //let fullName = newFirstName.concat(" ",newLastName);
        let email = document.getElementById('email').value;
        let phoneNumber = document.getElementById('phone').value;
        let birthday = document.getElementById('bday').value;
        let homePlanet = document.getElementById('planet').value;
        let denieButton = document.getElementById("denie-button").hidden = false;
        let approveButton = document.getElementById('apporve-button').hidden = false;
        let genderCheck = document.getElementsByName('gender');
        let gender = null;
        for(let i = 0; i<genderCheck.length; i++){
            if(genderCheck[i].checked){
                gender = genderCheck[i].value;
            }
    
        }
    
        let color = document.getElementById('color').value;
        let hobby = document.getElementsByClassName('activity');
        let hobList = document.getElement('ul');
        for(let i = 0; i<hobby.length; i++){
            if(hobby[i].checked){
                let y = document.createElement('li')
                y.innerHTML = hobby[i].value;
                hobList.append(y);
            }
        }
    
    
        
            let row = document.createElement('tr');
            let reimbIdCell = document.createElement('td');
            let typeCell = document.createElement('td');
            let statusCell = document.createElement('td');
            let totalAmountCell = document.createElement('td');
            let dateCreatedCell = document.createElement('td');
            let descriptionCell = document.createElement('td');
            let receiptCell = document.createElement('td');
            let resolverCell = document.createElement('td');
            let authorCell = document.createElement('td');
            let approveCell = document.createElement('td');
            let denieCell = document.createElement('td');

            row.appendChild(reimbIdCell);
            row.appendChild(typeCell);
            row.appendChild(statusCell);
            row.appendChild(totalAmountCell);
            row.appendChild(dateCreatedCell);
            row.appendChild(descriptionCell);
            row.appendChild(receiptCell);
            row.appendChild(resolverCell);
            row.appendChild(authorCell);
            row.appendChild(approveCell);
            row.appendChild(denieCell);
    
            document.getElementsByTagName('table')[0].appendChild(row);
    
            nameCell.innerText = newFirstName+ " " + newLastName;
            emailCell.innerText = email;
            phoneCell.innerText = phone;
            bdayCell.innerText = birthday;
            colorCell.innerText = color;
            genderCell.innerText = gender;
            denieCell.innerText = denieButton;
            approveCell.innerText = approveButton;
        
        document.getElementById('firstname').value = '';
        document.getElementById('lastname').value = '';
        document.getElementById('email').value = '';
        document.getElementById('phone').value = '';
        document.getElementById('bday').value = '';
        document.getElementById('gender').value= '';
        document.getElementById('gender').value = '';
        document.getElementById('activity').checked = false;
    
     }
    