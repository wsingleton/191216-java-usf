window.onload = () => {
    //Dynamically create HTML elements needed for the page
    let quizDiv = document.createElement('div');
    let resultsDiv = document.createElement('div');
    let buttonDiv = document.createElement('div');
    let submitBtn = document.createElement('button');

    //Set attributes on the newly created elements
    quizDiv.setAttribute('id', 'quiz');
    resultsDiv.setAttribute('id', 'results');
    buttonDiv.setAttribute('id', 'btnContainer');
    buttonDiv.style.padding = '2px';
    buttonDiv.style.cssFloat = 'left';
    submitBtn.setAttribute('id', 'submit');
    submitBtn.setAttribute('class', 'btn btn-primary');

    //Add some text to display within the submit button
    submitBtn.innerText = 'Submit Quiz';

    //Add the newly created elements to the body of the page
    buttonDiv.appendChild(submitBtn);
    document.body.prepend(resultsDiv);
    document.body.prepend(buttonDiv);
    document.body.prepend(quizDiv);
    


    //Add event listeners to the submit button for grading
    buttonDiv.addEventListener('mouseover', isQuizValid);
    submitBtn.addEventListener('click', showResults);

    retrieveQuestions();
}

function buildQuiz(questions){
    console.log("building quiz...");
    console.log(questions);  
    //Convenience references for our HTML elements
    let quizContainer = document.getElementById('quiz');

    //Create an array that will hold some of the HTML we will eventually render
    const output = [];

    questions.forEach((currentQuestion, questionNumber) => {
        //create an array for storing this question's answers
        const answers = [];

        //for each available answer in this question
        for(let letter in currentQuestion.answers){
            answers.push(
                `<label>
                    <input type='radio' name='question-${questionNumber}' value='${letter}'/>
                    ${letter}: ${currentQuestion.answers[letter]}
                </label>`
            )
        }
        //add this question and answers to output array
        output.push(
            `<br/>
            <div class="question">${currentQuestion.question}</div>
            <div class="answers">${answers.join('')}</div>
            `
        );
    });   
    quizContainer.innerHTML = output.join('');
}

function isQuizValid(){
    console.log("validating quiz...");
    let submitBtn = document.getElementById('submit');
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');
    let myQuestions = document.querySelectorAll('div.question');

    if(selectedAnswers.length != myQuestions.length){
        console.log('not valid')
        submitBtn.setAttribute('disabled', true)
    }else{
        console.log('is valid')
        submitBtn.removeAttribute('disabled');
    }
}

function showResults(){
    console.log("showing results...");
    //Convenience reference for our resultsContainer
    let resultsContainer = document.getElementById('results');

    //Gather user selected anserts from the quiz into an arrat
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');

    //Create a variable to keep track of the number correct
    let numCorrect = 0;

    //For each question in quizQuestions
    quizQuestions.forEach((currentQuestion, questionNumber) => {
        console.log(selectedAnswers);
        let userAnswer = (selectedAnswers[questionNumber] || {}).value;
        let answerLabel = userAnswer.parentElement || {};

        if(userAnswer === currentQuestion.correctAnswer){
            numCorrect++;
            (answerLabel.style || {}).color = 'green';
        }else{
            (answerLabel.style || {}).color = 'red';
        }
    });
    //Calculate user's score
    let userScore = ((numCorrect / quizQuestions.length) * 100).toFixed(2);

    //Display the calculated score to the page
    resultsContainer.innerText = `${numCorrect} correct out of ${quizQuestions.length} (${userScore})`;
}

function retrieveQuestions(){
    console.log("retrieving questions...");
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'https://api.myjson.com/bins/sc7ti/', true);
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let questions = JSON.parse(xhr.responseText);
            buildQuiz(questions);
            quizQuestions = questions;
        }
    }
}

let quizQuestions = [];