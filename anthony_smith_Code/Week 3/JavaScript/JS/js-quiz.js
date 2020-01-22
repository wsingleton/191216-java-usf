

window.onload = () => {
    // Dynamically create HTML elements needed for the page
    let quizDiv = document.createElement('div');
    let resultsDiv = document.createElement('div');
    let buttonDiv = document.createElement('div');
    let submitBtn = document.createElement('button');
   
    // Set attributes on the newly created elements
    quizDiv.setAttribute('id', 'quiz');
    resultsDiv.setAttribute('id', 'results');
    buttonDiv.setAttribute('id', 'button-container');
    buttonDiv.style.padding = '2px';
    buttonDiv.style.cssFloat = 'left';
    submitBtn.setAttribute('id', 'submit');
    submitBtn.setAttribute('class', 'btn btn-primary');
   
    // Add some text to display within the submit button
    submitBtn.innerText = 'Submit Quiz';
   
    // Add the newly created elements to the body of the page
    buttonDiv.appendChild(submitBtn);
    document.body.prepend(resultsDiv);
    document.body.prepend(buttonDiv);
    document.body.prepend(quizDiv);
   
    // Build the quiz
    buildQuiz();
   
    // Add event listeners for validating and grading the quiz
    buttonDiv.addEventListener('mouseover', isQuizValid);
    submitBtn.addEventListener('click', showResults);


    retriveQuestions();
};



function bulidQuiz(){
    console.log('Buliding quiz...');

    
    let quizContainer = document.getElementById('Quiz');

    const output = [];


questions.forEach((currentQuestion, questionNumber) => {

  //  array for each question answer
    const answer = [];

    for(let letter in currentQuestion.answer){
        answer.push(`
            <label>
                <input type="radio" name="question-${questionNumber}" value="${letter}"/>
                ${letter}: $
            </label>

        `)
    }

    // add this question and answers to the output array
    output.push(`
    <br/>
    <div class ="question">${currentQuestion.questions}</div>
    <div class="answer">${answer.join('')}</div>
    `)
};


function isQuizValid(){

    console.log('vaildating quiz .....')
    
    let submitBtn = document.getElementById('submit');
    let selectedAnswer = document.querySelectorAll('div.answer > label  > input[name^="question-"]:checked');
    let myQuestions = document.querySelectorAll('div');

    if (selectedAnswer.length !- myQuestions.length){

    }else{
        submitBtn.removeAttribute('disable');
    }

};



function retriveQuestions(){
console.log('fetching quiz questions');
let xhr = new XMLHttpRequest();
xhr.open('GET', 'https://api.myjson.com/bins/vdj06', true);   
xhr.send();
xhr.onreadystatechange = function(){

     if (xhr.readyState === 4 && xhr.status === 200) {
            let questions = JSON.parse(xhr.responseText);
            buildQuiz(questions)}
};


function showResults(){

    // Convenice refrence for our resultConstainer 
    let resultConstainer = document.getElemenetByID('result');
    let selectedAnswer = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');


    console.log(selectedAnsers);
    let userAnswer = (selectedAnswer [])
selectedAnswer.length

    let userScore = ((numCorrect / quizQuestion))



    console.log('grading quiz ....');

    console.log(questions)
};


let quizQuestion = []
