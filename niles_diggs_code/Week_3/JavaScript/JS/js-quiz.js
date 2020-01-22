/*
    Things that are going to be required

    - event listener for the click for each question

    - buttons for answering questions and submitting

    - populating quiz to show the correct answer after creation




    Wez steps

    dynamically create html elements needed for the page

    set the attributes on the newly create element

    add text to display within the submit button

    add the newly created elements to the body of the page

    build the quiz

    add event listeners to submit button for grading
*/

window.onload = function() {
let qdiv = document.createElement('div');
qdiv.setAttribute('id', 'qcontainer')
document.body.appendChild(qdiv);

let bdiv = document.createElement('div');
bdiv.setAttribute('id', 'bcontainer')
bdiv.style.padding = '2px';
bdiv.style.cssFloat = 'left';
document.body.appendChild(bdiv);

let rdiv = document.createElement('div');
rdiv.setAttribute('id', 'rcontainer')
document.body.appendChild(rdiv);

let sbutton = document.createElement('button');
sbutton.setAttribute('id', 'submit')
sbutton.setAttribute('class', 'btn btn-primary');
sbutton.innerText = 'Submit Quiz'; //never use HTML text when you have user provided data
bdiv.appendChild(sbutton);


document.body.prepend(rdiv);
document.body.prepend(bdiv);
document.body.prepend(qdiv);

bdiv.addEventListener('mouseover', isQuizValid)
bdiv.addEventListener('click', showResults)

retrieveQuestions();

};
function buildQuiz(question) {
    console.log('building quiz');
    console.log(question)
    let qcontainer = document.getElementById('quiz');

    const output = [];
    questions.array.forEach(element => {
        
    });

}

function isQuizValid() {
    console.log('validating quiz');
    

    let sbutton = document.getElementById('submit');
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');
    let myQuestions = document.querySelectorAll('div.question');

    if(selectedAnswers.length != myQuestions.length) {
        sbutton.setAttribute('disabled', true);
    } else {
        sbutton.removeAttribute('disbaled');
    }


}

function showResults() {
    console.log('showing quiz');



}

function retrieveQuestions() {
    console.log('retrieving quiz');
    //now using AJAX

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'https://api.myjson.com/bins/fato6', true); //always true unless it is specified otherwise
    xhr.send();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let question = JSON.parse(xhr.responseText);
            buildQuiz(question);
        }
    }


}



