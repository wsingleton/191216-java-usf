// 3. (1 +2 completed on html) alien text function


// would have to change the source code to js-problems2.js to implement these solutions
function alienText() {
    // if Planet of residency != Earth - not sure how to call this
    hiddenWords.removeAttribute("hidden");
}

// 4.

function firstAndLastName() {

}



document.getElementById("firstname").value = "";
document.getElementById("lastname").value = "";
document.getElementById("email").value = "";
document.getElementById("phone").value = "";
document.getElementById("bday").value = "";
document.getElementById("color").value = "";

// 5.

// 7. 
document.getElementById("earth_time").addEventListener("click", new Date());


// 10.

function walkTheDom() {

    let DOM = document.getElementsByTagName("*");
    for (let i = 0; i < DOM.length; i++) {
        console.log(dom[i]);

    }

}