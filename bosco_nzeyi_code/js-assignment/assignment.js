/*
Part 2: Interacting with the DOM

Working with the “js-part2.html” file, include solutions in an external JavaScript file named “JavaScriptAssignment.js” for the following:

1. Make each link direct the user to its respective website (see id)

2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)

3. Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, 
execute this function.

4. When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, 
check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue 
to work for multiple entries and rows. 

5. Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. 
The details should be hidden when the mouse is removed from the summary.

6. Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.

7. Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when 
“Earth time” button is clicked. 

8. Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to a random color. 
Make sure this color is never black so we can still read our black text! (there are other dark colors it could change to where 
we also couldn’t see the text but it’s enough to just accommodate for a black background)

9. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. 
Display the result in the element with id result.


10. Define function walkTheDom(node, func)
	This function should traverse every node in the DOM. 

*/


// 1) Make each link direct the user to its respective website (see id)
    // google
let google = document.getElementsByName("google");
google[0].innerHTML = "Google";
google[0].setAttribute("href", "https://google.com");
google[0].setAttribute("target", "_blank");

    //twitter
let twitter = document.getElementsByName("twitter");
twitter[0].innerHTML = "Twitter";
twitter[0].setAttribute("href", "https://twitter.com");
twitter[0].setAttribute("target", "_blank");

    // slack
let slack = document.getElementsByName("slack");
slack[0].innerHTML = "Slack";
slack[0].setAttribute("href", "https://slack.com");
slack[0].setAttribute("target", "_blank");

   // javadocs
let javadocs = document.getElementsByName("javadocs");
javadocs[0].innerHTML = "Java docs";
javadocs[0].setAttribute("href", "https://javadocs.com");
javadocs[0].setAttribute("target", "_blank"); 

// 2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
let planets = document.getElementById("planet");
planets.options[3].disabled = true;
console.log(planets.options[3]);

// 3. Define a function alienText() which shows the hidden element displaying an alien message. 
//When any planet other than Earth is selected, execute this function.

document.getElementById("planet").addEventListener("change", alienText);

function alienText(){
    let planet = document.getElementById("planet");
    let hiddenPId;
   let p= document.getElementsByTagName("p");
   for(let i = 0; i<p.length; i++){
       if(p[i].hidden == true){
           hiddenPId = i;
           // set an id for the hidden p to be able to reference it later. 
           p[hiddenPId].setAttribute("id", "hidden");
       }
   }
   let hiddenP = document.getElementById("hidden");
   if(planet.options[planet.selectedIndex].text == "Earth"){
       hiddenP.hidden = true;
   } else{
       hiddenP.hidden = false;
   }
}

/*
4. When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, 
check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue 
to work for multiple entries and rows. 
*/
//document.getElementById("firstname").required = true;
document.getElementById("form-sub").addEventListener("click", getInput);


function getInput(){

    let fname = document.getElementById("firstname").value;
    let lname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bday = document.getElementById("bday").value;

    let gender;

    let genderOption = document.getElementsByName("gender");
    for(let i = 0; i<genderOption.length; i++){
        if(genderOption[i].checked){
            gender = genderOption[i].value;
        }
    }

    let color = document.getElementById("color").value;

    let activities = document.createElement("ul");

    let activityItem = document.getElementsByClassName("activity");
    let checker = false;
    for(let i = 0; i<activityItem.length; i++){
        if(activityItem[i].checked){
            checker = true;
            let activity = document.createElement("li");
            activity.innerText = activityItem[i].value;
            activities.appendChild(activity);
        }
    }

    if(fname.trim() == "" || lname.trim() =="" || gender== null || email.trim() =="" || phone.trim() =="" ||
    bday == "" || checker == false || color == ""){
        alert("All form fields must be filled");
    } else if(fname.length < 2 || fname < 2){
        alert("Names must be 2 or more characters long");
    } else if(isNaN(fname) == false || isNaN(lname) == false){
        alert("Names should be in string format");
    } else if(isNaN(phone) || phone.length != 10){
        alert("Invalid phone number");
    } else if(isEmail(email) == false){
        alert("Invalid email");
    } else{  

    let nameCell = document.createElement("td");
    let emailCell = document.createElement("td");
    let phoneCell = document.createElement("td");
    let bdayCell = document.createElement("td");
    let genderCell = document.createElement("td");
    let colorCell = document.createElement("td");
    let activityCell = document.createElement("td").appendChild(activities);

    let tableRow = document.createElement("tr");
    tableRow.appendChild(nameCell);
    tableRow.appendChild(emailCell);
    tableRow.appendChild(phoneCell);
    tableRow.appendChild(bdayCell);
    tableRow.appendChild(colorCell);
    tableRow.appendChild(genderCell);
    tableRow.appendChild(activityCell);

// append this new row to the table
    document.getElementsByClassName("table")[document.getElementsByClassName("table").length - 1].appendChild(tableRow);
    //table.appendChild(tableRow);

    let fullName = fname + " " + lname;
    nameCell.innerText = fullName;
    emailCell.innerText = email;
    phoneCell.innerText = phone;
    bdayCell.innerText = bday;
    genderCell.innerText = gender;
    colorCell.innerText = color;
    
    // clear the table
    document.getElementById("firstname").value = "";
    document.getElementById("lastname").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("bday").value = "";
    document.getElementById("color").value = "#000000";
    // uncheck activities
    for(let i = 0; i<activityItem.length; i++){
        if(activityItem[i].checked){ activityItem[i].checked = false}
    }
    // uncheck gender
    for(let i = 0; i<genderOption.length; i++){
        if(genderOption[i].checked){genderOption[i].checked = false;}
    }

    }

    /* Email Validation */ 
function isEmail(string){
    let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let email = string;
    let check = mailformat.test(email);
    return check;
}
}

/*
5. Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. 
The details should be hidden when the mouse is removed from the summary.
*/
document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
document.getElementsByTagName("details")[0].addEventListener("mouseout", openDetails);


function openDetails(){
    let details = document.getElementsByTagName("details")[0];
    if(details.open == false){
        details.open =true;
    } else{
        details.open = false;
    }
}

// 6. Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
function concatSpan(){
    let span = "";
    let el = document.getElementsByTagName("span");
    for (let i =0; i<el.length; i++){
        span += el[i].innerHTML;
    }
    return span;
}

/*
7. Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when 
“Earth time” button is clicked. 
*/
document.getElementById("earth_time_check").addEventListener("click", displayEarthTime);

function displayEarthTime(){
    let date = new Date;
    let currentTime = date.toLocaleTimeString();
    console.log(currentTime);
    document.getElementById("earth_time").innerHTML = (`<span>${currentTime}</span>`);
}

/*
8. Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to a random color. 
Make sure this color is never black so we can still read our black text! (there are other dark colors it could change to where 
we also couldn’t see the text but it’s enough to just accommodate for a black background)
*/
document.getElementsByTagName("h1")[0].addEventListener("click", timer);

function timer (){
    setTimeout(() => {
    setBackgroundColor();
}, 3000);
}
function setBackgroundColor(){
    let rdm = Math.floor(Math.random() * 0xFFFFFF);
    let color =  "#" + ("000000" + rdm.toString(16)).substr(-6);
    if(color != "#000000"){
        document.getElementsByTagName("h1")[0].style.backgroundColor = color;
        console.log(color);
    }  
}

/*
9. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. 
Display the result in the element with id result.
*/

document.getElementById("n2").addEventListener("change", calculator);
document.getElementById("n1").addEventListener("change", calculator);
document.getElementById("operation").addEventListener("change", calculator);
function calculator(){
    let operations = document.getElementById("operation");
    let o = operations.options[operations.selectedIndex].value;
    let n1 = document.getElementById("n1").value;
    let n2 = document.getElementById("n2").value;
    let res = document.getElementById("result");
    let result;
    if (n1 != null && n2 != null){
    if(o == "Add"){
        result = parseFloat(n1) + parseFloat(n2);
        res.innerHTML =result;
    }
    if (o == "Subtract"){
        result = parseFloat(n1) - parseFloat(n2);
        res.innerHTML =result;
    }
    if (o == "Divide"){
        result = parseFloat(n1) / parseFloat(n2);
        res.innerHTML =result;
    }
    if (o == "Multiply"){
        result = parseFloat(n1) * parseFloat(n2);
        res.innerHTML =result;
    }
} else{
    res.innerHTML = "";
}
}

/*
10. Define function walkTheDom(node, func)
	This function should traverse every node in the DOM.
*/
function walkTheDom(){
    let dom = document.querySelectorAll("*");
    dom.forEach(node => {console.log(node.tagName);})
}