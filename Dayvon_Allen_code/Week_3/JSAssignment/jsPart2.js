

let planets = document.querySelectorAll("#planet");
let pluto = planets[0].options[3];
pluto.setAttribute("disabled", true);
let alienWords = document.querySelectorAll("p")[5];

function alienText() {
    alienWords.removeAttribute("hidden");
}
alienText();


function getInput() {
    let firstName = firstOrLastNameValidation(document.getElementById("firstname")).value;
    let lastName = firstOrLastNameValidation(document.getElementById("lastname")).value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let birthday = document.getElementById("bday").value;
    let favColor = document.getElementById("color").value;
    let info = [firstName, lastName, email, phone, birthday];
    let invalidData = false;
    let favAct = document.querySelectorAll(".activity");
    let gender = document.getElementsByName("gender");
    info[0] = firstOrLastNameValidation(info[0])
    info[1] = firstOrLastNameValidation(info[1])
    info.map(i => {
        if (i.length === 0) {
            console.log("Invalid data")
            invalidData = true;
        }
        console.log(i)
    })

    if (invalidData === true) {
        return;
    }
    else {
        let actArr = [];
        let row = document.createElement("tr");
        let list = document.createElement("ul");
        let name = document.createElement("td");
        let emailRow = document.createElement("td");
        let phoneRow = document.createElement("td");
        let birthdayRow = document.createElement("td");
        let favoriteColor = document.createElement("td");
        let genderRow = document.createElement("td");
        document.querySelector("tbody").appendChild(row);
        row.appendChild(name);
        row.appendChild(emailRow);
        row.appendChild(phoneRow);
        row.appendChild(birthdayRow);
        row.appendChild(favoriteColor);
        row.appendChild(genderRow);
        row.appendChild(list);

        name.innerText = firstName;
        emailRow.innerText = email;
        phoneRow.innerText = phone;
        birthdayRow.innerText = birthday;
        favoriteColor.innerText = favColor;



        for (let i = 0; i < gender.length; i++) {
            if (gender[i].checked === true) {
                genderRow.innerText = gender[i].value;
                gender[i].checked = false;
            }
        }
        console.log(favAct.length);
        console.log(favAct);

        for (let i = 0; i < favAct.length; i++) {
            if (favAct[i].checked === true) {
                actArr.push(favAct[i]);
                let li = document.createElement("li");
                list.appendChild(li);
                li.innerText = actArr[0].value;
                actArr.pop();
                favAct[i].checked = false;
            }

        }

         document.getElementById("firstname").value = "";
         document.getElementById("lastname").value = "";
         document.getElementById("email").value = "";
         document.getElementById("phone").value = "";
         document.getElementById("bday").value = "";
         document.getElementById("color").value = "";


    }

}


// document.getElementById("form-sub").addEventListener("mouseout", () => {
//     getInput();
//     let checker = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//     if (!checker.test(document.getElementById("email").value)) {
//         console.log("1");
//         document.getElementById("form-sub").setAttribute("disabled", true)
//     }
//     else if (document.getElementById("firstname").value === "" || document.getElementById("firstname").value.length() < 2) {
//         console.log("2");
//         document.getElementById("form-sub").setAttribute("disabled", true)
//     }
//     else if (document.getElementById("lastname").value === "" || document.getElementById("lastname").value.length() < 2) {
//         console.log("3");
//         document.getElementById("form-sub").setAttribute("disabled", true)
//     }
//     // else if(document.getElementById("birthday").value === ""){
//     //     document.getElementById("form-sub").setAttribute("disabled", true)
//     // }
//     else {
//         document.getElementById("form-sub").setAttribute("disabled", false);
//     }
// })

function firstOrLastNameValidation(name) {
    if (name.length < 2) {
        return "";
    }
    else {
        return name;
    }
}

function openDetail() {
    document.querySelector("details").setAttribute("open", true);
}

document.getElementById("form-sub").addEventListener("click", getInput)

document.querySelector("details").addEventListener("mouseover", openDetail);
document.querySelector("details").addEventListener("mouseout", () => {
    document.querySelector("details").removeAttribute("open");
});

function concatSpan() {
    let result = "";
    let spans = document.querySelectorAll("span");
    for (let i = 0; i < spans.length; i++) {
        result += spans[i].innerText;
    }

    return result;
}

console.log(concatSpan());
let showTime = false;
function displayEarthTime() {
    let day = new Date();
    let h = day.getHours();
    let m = day.getMinutes();
    let time = h + ":" + m;
    console.log(time);
    showTime = !showTime;
    if (showTime === true) {
        document.getElementById("earth_time").innerText = time;
    }
    else {
        document.getElementById("earth_time").innerText = "";
    }

}

document.getElementById("earth_time_check").addEventListener('click', displayEarthTime);
document.querySelector("h1").addEventListener('click', changeColor);

function randomNum() {
    let random = Math.floor(Math.random() * 254 + 1);
    return random;
}
function changeColor() {
    setTimeout(() => {
        document.querySelector("h1").style.backgroundColor = `rgb(${String(randomNum())}, ${String(randomNum())}, ${String(randomNum())})`
    }, 3000)
}

document.querySelector("#n1").addEventListener("blur", () => {
    let selected = document.getElementById('operation');
    let selectedValue = selected.options[selected.selectedIndex].value;
    let results = Number(document.querySelector("#n1").value) + Number(document.querySelector("#n2").value);
    let results2 = Number(document.querySelector("#n1").value) - Number(document.querySelector("#n2").value);
    let results3 = Number(document.querySelector("#n1").value) * Number(document.querySelector("#n2").value);
    let results4 = Number(document.querySelector("#n1").value) / Number(document.querySelector("#n2").value);
    if (results !== results) {
        document.querySelector("#result").innerText = "Please Enter a valid number"
    }
    else {
        if(selectedValue === "Add"){
        document.querySelector("#result").innerText = results
        }
        else if( selectedValue === "Subtract" ) {
            document.querySelector("#result").innerText = results2;
        }
        else if( selectedValue === "Multiply" ) {
            document.querySelector("#result").innerText = results3;
        }
        else if( selectedValue === "Divide" ) {
            document.querySelector("#result").innerText = results4;
        }
    }
})
document.querySelector("#n2").addEventListener("blur", () => {
    let selected = document.getElementById('operation');
    let selectedValue = selected.options[selected.selectedIndex].value;
    let results = Number(document.querySelector("#n1").value) + Number(document.querySelector("#n2").value);
    let results2 = Number(document.querySelector("#n1").value) - Number(document.querySelector("#n2").value);
    let results3 = Number(document.querySelector("#n1").value) * Number(document.querySelector("#n2").value);
    let results4 = Number(document.querySelector("#n1").value) / Number(document.querySelector("#n2").value);  
    if (results !== results) {
        document.querySelector("#result").innerText = "Please Enter a valid number"
    }
    else {
        if(selectedValue === "Add"){
            document.querySelector("#result").innerText = results
            }
            else if( selectedValue === "subtract" ) {
                document.querySelector("#result").innerText = results2;
            }
            else if( selectedValue === "multiply" ) {
                document.querySelector("#result").innerText = results3;
            }
            else if( selectedValue === "divide" ) {
                document.querySelector("#result").innerText = results4;
            }    }
})

function walkTheDom() {
    let dom = document.getElementsByTagName("*");
    for (let i = 0; i < dom.length; i++) {
        console.log(dom[i]);
    }
}
// walkTheDom();


