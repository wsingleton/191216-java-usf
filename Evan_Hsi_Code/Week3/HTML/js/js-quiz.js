/*
window.onload = getQuiz();

function getQuiz() {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", 'https://api.myjson.com/bins/1eyot2', true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            let quiz = JSON.parse(xhttp.responseText);
            console.log(quiz);
            makeQuiz(quiz);
        }
    }
}

function makeQuiz(quiz) {
    console.log('hello');
    let div = document.createElement("div");
    
    document.body.prepend(div);
    let button = document.createElement("input");
    let quizList = document.createElement("ol");
    div.appendChild(quizList);

    for(let i = 0; i < quiz.size(); i++) {

    }

    button.type = "submit";
    button.id = "grade";
    button.placeholder = "submit for grading";
    button.class = "form-control btn btn-success";
    div.appendChild(button);
}

*/

window.onload = () => {
    let quizDiv = document.createElement('div');
    let resultsDiv = document.createElement('div');
    let buttonDiv = document.createElement('div');
    let submitBtn = document.createElement('button');

    quizDiv.setAttribute('id', 'quiz');
    resultsDiv.setAttribute('id', 'results');
    buttonDiv.setAttribute('id', 'button-container');
    buttonDiv.style.padding = '2px';
    buttonDiv.style.cssFloat = 'left';
    submitBtn.setAttribute('id', 'submit');
    submitBtn.setAttribute('class', 'btn btn-primary');

    submitBtn.innerText = 'Submit Quiz';

    buttonDiv.appendChild(submitBtn);
    document.body.prepend(resultsDiv);
    document.body.prepend(buttonDiv);
    document.body.prepend(quizDiv);

    retrieveQuestions();

    //buttonDiv.addEventListener('mouseover', isQuizValid);
    submitBtn.addEventListener('click', showResults);

}

function buildQuiz(questions) {
    console.log('Building Quiz...');
    let quizContainer = document.getElementById('quiz');
    const output = [];
    questions.forEach((currentQuestion, questionNumber) => {

        const answers = [];

        for(let letter in currentQuestion.answers) {
            answers.push(`
            <label>
                <input type="radio" name="question-${questionNumber}" value="${letter}"/>
                ${letter}: ${currentQuestion.answers[letter]}
            </label>
            `);
            
        }
        output.push(`

        <br/>
        <div class="question">${currentQuestion.question}</div>
        <div class="answers">${answers.join('')}</div>
        `);

    })
    quizContainer.innerHTML = output.join('');
}

function isQuizValid() {
    console.log('Validating Quiz...');

    let submitBtn = document.getElementById('submit');
    let SelectedAnswers = document.querySelectorAll(
        'div.answers > label > input[name^="question-"]:checked');
    console.log(SelectedAnswers);
    let myQuestions = document.querySelectorAll('div.question');

    if(SelectedAnswers.length != myQuestions.length) {
        submitBtn.setAttribute('disabled', true);
    } else {
        submitBtn.removeAttribute('disabled');
    }


}

function showResults() {
    console.log('Grading Quiz...');
    

}

function retrieveQuestions() {
    console.log('Retrieving Quiz...');
    let xhr = new XMLHttpRequest();
    xhr.open("GET", 'https://api.myjson.com/bins/1eyot2', true);
    xhr.send();
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            let quiz = JSON.parse(xhr.responseText);
            console.log(quiz);
            buildQuiz(quiz);
        }
    }
}