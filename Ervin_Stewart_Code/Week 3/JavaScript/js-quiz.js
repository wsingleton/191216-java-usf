window.onload = () =>{
    //dynamically create htnl elements needed for this page
let quizDiv = document.createElement('div');
let buttonDiv = document.createElement('div')
let resultsDiv = document.createElement('div');
let btn = document.createElement('button');
    //set attributes for elements
quizDiv.setAttribute('id','quiz');
resultsDiv.setAttribute('id','results');
buttonDiv.setAttribute('id','button-container');
buttonDiv.style.padding = '2px';
buttonDiv.style.cssFloat='left';
btn.setAttribute('id', 'submit');
btn.setAttribute('class', 'btn btn-primary');

btn.innerHTML = "Submit Answers";

//add crreated elements to html
buttonDiv.appendChild(btn);
document.body.prepend(resultsDiv);
document.body.prepend(buttonDiv);
document.body.prepend(quizDiv);


//build quiz
retrieveQuestions();

buttonDiv.addEventListener('mouseover', isQuizValid);
btn.addEventListener('click', getScore);
}






function buildQuiz(questions){
console.log('building quiz....');
//let questions = retrieveQuestions();
let quizContainer = document.getElementById('quiz');
const output =[];
questions.forEach((currentQuestion, questionNumber) =>{
    const answers = []; 
for(let letter in currentQuestion.answers){
    answers.push(`
<label>
    <input type = "radio" name="question-${questionNumber}" value="${letter}"/>
    ${letter}: ${currentQuestion.answers[letter]}
    </label>`);

}
output.push(`<br/>
<div class="question">${currentQuestion.question}</div>
<div class="answers">${answers.join('')}</div>`
);

});
quizContainer.innerHTML = output.join('');
}


function retrieveQuestions(){
//console.log('blah blah blah.....')
let xhr = new XMLHttpRequest();
xhr.open('GET', 'https://api.myjson.com/bins/18j7h2',true);
xhr.send();
xhr.onreadystatechange = function (){
if(xhr.readyState === 4 && xhr.status === 200){

    let quizQuestions = JSON.parse(xhr.responseText);
    buildQuiz(quizQuestions);
}

}}





function isQuizValid(){
console.log('Titties...');
let btn = document.getElementById('submit');
let selectedAnswers = document.querySelectorAll('div.answers >label >input[name^="question-"]:checked');
let myQuestions = document.querySelectorAll('div.questions');

if(selectedAnswers.length != myQuestions.length){
    btn.setAttribute('disabled', true);
}else {btn.removeAttribute('disabled');}
console.log(selectedAnswers);
}

let quizQuestions =[];





function getScore(){

console.log('getting results...');

let resultContainer = document.getElementById('results');

let selectedAnswers = document.querySelectorAll('div.answers > label > input[name ="question-"]:checked');
let numCorrect = 0;
quizQuestions.forEach((currentQuestion, questionNumber)=>{

    console.log(selectedAnswers);
    let userAnswer = (selectedAnswers[questionNumber]|| {}).nodeValue;
    let answerLabel = userAnswer.parentElement||{};

    if(userAnswer === currentQuestion.correctAnswer){
numCorrect++;
(answerLabel.style || {}).color='green';
    }else{
        (answerLabel.style|| {}).color = 'red';
    }
});
 let userScore = ((numCorrect/quizQuestions.length)*100).toFixed(2);
 resultsContainer.innerText = `${numCorrect} correct out of ${quizQuestions.length} (${userScore})`;
//     let grade = 0
// if(correctAnswers == 6){
// let grade = "100% Grade A, good job!!";
// document.getElementById("FinalGrade").innerHTML = grade.name;
// } else if (correctAnswers == 5){let grade = "83% Grade B, Decent job!!";
// document.getElementById("FinalGrade").innerHTML = grade.name;
// }else if(correctAnswers == 4){let grade = "67% Grade C, OOO room for improvement pal!!";
// document.getElementById("FinalGrade").innerHTML = grade.name;
// }else if(correctAnswers == 3){
// let grade = "50% Grade D, ooooo Boi Hella room for improvement!!";
// document.getElementById("FinalGrade").innerHTML = grade.name;
// }else if(correctAnswers < 3){

//     document.getElementById("FinalGrade").innerHTML = grade.name;
// }

}

