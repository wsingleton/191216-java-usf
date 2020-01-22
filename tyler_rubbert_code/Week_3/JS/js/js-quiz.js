// https://api.myjson.com/bins/19lsd2

window.onload = () => {

    // Dynamically create HTML elements needed for the page
    let quizDiv = document.createElement('div');
    let resultsDiv = document.createElement('div');
    let buttonDiv = document.createElement('div');
    let submitButton = document.createElement('button');

    // Set attributes on the newly created elements
    quizDiv.setAttribute('id', 'quiz');
    resultsDiv.setAttribute('id', 'results');
    buttonDiv.setAttribute('id', 'button-container');
    buttonDiv.style.padding = '2px';
    buttonDiv.style.cssFloat = 'left';
    submitButton.setAttribute('id', 'submit');
    submitButton.setAttribute('class', 'btn btn-primary');

    // Add some text to display within the Submit button
    submitButton.innerText = 'Submit Quiz';

    // Add the newly created elements to the body of the page
    buttonDiv.appendChild(submitButton);
    document.body.prepend(resultsDiv);
    document.body.prepend(buttonDiv);
    document.body.prepend(quizDiv);

    // Add event listeners for validating and grading the quiz
    buttonDiv.addEventListener('mouseover', isQuizValid);
    submitButton.addEventListener('click', showResults);
    
    retrieveQuestions();

};

function BuildQuiz(questions) {
    console.log('building quiz...');
    
    // Convenience references for our HTML elements
    let quizContainer = document.getElementById('quiz');

    // Create an array which can hold the HTML we will eventually render
    const output = [];

    // Loop throough questions to build HTML for each question
    questions.forEach((currentQuestion, questionNumber) => {

        // create an array for storing this questions answers
        const answers = [];

        // for each available answer in this question
        for (let letter in currentQuestion.answers) {
            answers.push(`
                <label>
                    <input type="radio" name="question-${questionNumber}" value="${letter}"/>
                    ${letter}: ${currentQuestion.answers[letter]}
                </label>
            `);
        }

        // add this question and its answers to the output array
        output.push(`
        <br/>
        <div class="question">${currentQuestion.question}</div>
        <div class="answers">${answers.join('')}</div>
        `)

    });

    quizContainer.innerHTML = output.join('');

}

function isQuizValid() {
    console.log('validating quiz...');
    let submitButton = document.getElementById('submit');
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');
    let myQuestions = document.querySelectorAll('div.question');

    if (selectedAnswers.length != myQuestions.length) {
        submitButton.setAttribute('disabled', true);
    } else {
        submitButton.removeAttribute('disabled');
    }
}

function showResults() {
    
    // Convenience reference for our resultsConstainer
    let resultsConstainer = document.getElementById('results');

    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');

    //Create a variable to keep track of the number correct
    let numCorrect = 0;

    // For each question in quizQuestions
    quizQuestions.forEach((currentQuestion, questionNumber) => {
        console.log(selectedAnswers);
        let userAnswer = (selectedAnswers[questionNumber] || {}).value;
        let answerLabel = userAnswer.parentElement || {};

        if (userAnswer === currentQuestion.correctAnswer) {
            numCorrect++;
            (answerLabel.style || {}).color = 'green';
        } else {
            (answerLabel.style || {}).color = 'red';
        }
    });

    // Calculate the user's score
    let userScore = ((numCorrect / quizQuestions.length) * 100).toFixed(2);

    // Display the calculated score onto the page
    resultsConstainer.innerText = `${numCorrect} correct out of ${quizQuestions.length} (${userScore})`

}

function retrieveQuestions() {
    console.log('fetching quiz questions...');
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'https://api.myjson.com/bins/19lsd2');
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let question = JSON.parse(xhr.responseText);
            BuildQuiz(question)
        }
    }
}










// window.onload = function() {
//     document.getElementById(submitButton).addEventListener('click', checkAnswers);
// }

// let div1 = document.createElement('div');
// let submitButton = document.createElement('button');
// let para = document.createElement('p');
// let test = document.createTextNode('test');


// let body = document.body;
// body.appendChild(div1);

// div1.appendChild(para);
// div1.appendChild(button);
// para.appendChild(test);


// function getQuestions() {


//     let xhttp = new XMLHttpRequest();
//     xhttp.open('GET', 'https://api.myjson.com/bins/19lsd2', true);


// }

// function checkAnswers() {

// }