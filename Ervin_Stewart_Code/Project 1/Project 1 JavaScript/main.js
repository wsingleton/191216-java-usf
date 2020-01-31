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
                // document.getElementById("login").addEventListener("click", login);
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
    function createClosedEmployeeReimbursementTable(){

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
    