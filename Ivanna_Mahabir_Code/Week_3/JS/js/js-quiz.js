window.onload = function(){
    //Dynamically create HTML elements needed for the page
    // let main = document.createElement("div", id="main");
    // let result = document.createElement("div", id="result");
    // let buttondiv = document.createElement("div", id="button-container");
    // let button = document.createElement("button", id="submit");

    let quiz = document.createElement("div");
    let result = document.createElement("div");
    let buttondiv = document.createElement("div");
    let button = document.createElement("button");

    //set attributes on the newly created elements    
    quiz.setAttribute('id', 'quiz');
    result.setAttribute('id', 'result');
    buttondiv.setAttribute('id', 'button-container')
    buttondiv.style.padding = '2px';
    buttondiv.style.cssFloat = 'left';
    button.setAttribute('id', 'submit');
    button.setAttribute('class', 'btn btn-primary');

    //add some text to the display within the submit button
    button.innerText = 'Submit Quiz';

    //add newly created elements to the body of the page
    buttondiv.appendChild(button);
    document.body.prepend(result);
    document.body.prepend(buttondiv);
    document.body.prepend(quiz)

    //add event listners to the submit botton
    buttondiv.addEventListener('mouseover', isQuizValid);
    button.addEventListener('click', showResults);

    retrieveQuestions();
};

//functionbuild quiz
function getQuiz(ques){
    console.log(ques);

    //Covenience references for our HTML elements
    let quizContainer = document.getElementById('quiz');

    //Create an array which can hold the HTML we will eventually render
    const output = [];

    //Loop through questions to build HTML for each ques
    ques.forEach((currentQues, quesNumber) =>{
        const answers = [];

        //for each avaliable answer in this question
        for(let letter in currentQues.answers){
            answers.push(`
            <label>
            <input type="radio" name="question-${quesNumber}" values="${letter}"/>
            ${letter}: ${currentQues.answers[letter]}
            </label>
            `)
        }

        //add this question and its answer to the output array
        output.push(`
        <br/>
        <div class="question">${currentQues.question}</div>
        <div class="answers">${answers.join('')}</div>
        `)

    });

    //combine our output
    quizContainer.innerHTML = output.join('');
}

function isQuizValid(){
    console.log('is valid');

    let submitBut = document.getElementById('submit');
    let selectedAns = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');
    let myQues = document.querySelectorAll('div.question');

    if(selectedAns.length != myQues.length){
        submitBut.setAttribute('disabled', true);
    } else{
        submitBut.removeAttribute('disabled');
    }
}

function showResults(){
    console.log(quizQues);
    //Convenience reference for our resultsContainer
    let resultsContainer = document.getElementById('results');

    //Gather user selected answers from the quiz into an array
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');

    //Create a variable to keep track of the number correct
    let numCorrect = 0;

    //For each question in quizQuestions
    quizQues.forEach((currentQues, quesNumber) =>{
        console.log(selectedAnswers);
        let useAnswer = (selectedAnswers[quesNumber] || {}).value;
        let answerLabel = useAnswer.parentElement || {};

        if(useAnswer === currentQues.correctAnswer){
            numCorrect++;
            (answerLabel.style || {}).color = 'green';
        } else{
            (answerLabel.style || {}).color = 'red';
        }
    });

    let userScore = ((numCorrect/quizQues.length)*100).toFixed(2);

    //Display the calculated score onto the page
    resultsContainer.innerText = `${numCorrect} correct out of ${quizQues.length} (${userScore})`;


}

function retrieveQuestions(){
    console.log('questions');

    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", 'https://api.myjson.com/bins/1dtyra');
    xhttp.send();
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status == 200){
            quizQues = JSON.parse(xhttp.responseText);
            getQuiz(quizQues);
        }
    }
}

let quizQues = [];