// window.onload=getQuiz();
// let queryData;
// function getQuiz() {
//     let xhttp=new XMLHttpRequest();
//     // communication requires endpoint, verb, optional boolean to specify if you want the request to be completed asynchronously
//     xhttp.open("GET", "https://api.myjson.com/bins/1cn3jq", true);
//     xhttp.send();
//     xhttp.onreadystatechange=function() {
//         if(xhttp.readyState==4 && xhttp.status==200) {
//             console.log("connection validated");
//             queryData = JSON.parse(xhttp.responseText);
//             console.log(xhttp.responseText);
//             populateButton();
//         }
//     }
// }
// function populateButton() {
//     let submitBtn=document.createElement("button");
//     submitBtn.setAttribute("class", "btn btn-secondary");
//     submitBtn.setAttribute("value", "GRADE QUIZ");
//     document.body.prepend(submitBtn);
//     submitBtn.addEventListener("click", console.log("Grading will go here"));
//     makePage();
// }
// function makePage(queryData) {
//     let quiz=document.createElement("div");
//     quiz.setAttribute("id", "quiz");
//     let title=document.createElement("h3");
//     title.setAttribute("id", "title")
//     document.body.prepend(quiz);
//     document.getElementById("quiz").appendChild(title);
//     document.getElementById("title").innerText="JavaScript Quiz";
//     populateQuestions(queryData)
// }
// function populateQuestions(queryData) {
//     let i=0;
//     let question;
//     let answerA;
//     let answerB;
//     let answerC;
//     let quizBlock;
//     queryData.forEach(element => {
//         quizBlock=document.createElement("div");
//         quizBlock.setAttribute("id", "question"+i)
//         answerA=document.createElement("input");
//         answerA.setAttribute("type", "radio");
//         answerA.setAttribute("name", "answer"+i);
//         answerA.setAttribute("value", "a");
//         answerB=document.createElement("input");
//         answerB.setAttribute("type", "radio");
//         answerB.setAttribute("name", "answer"+i);
//         answerB.setAttribute("value", "b");
//         answerC=document.createElement("input");
//         answerC.setAttribute("type", "radio");
//         answerC.setAttribute("name", "answer"+i);
//         answerC.setAttribute("value", "c");
//         question=queryData.question;
//         let ansA=queryData.a;
//         let ansB=queryData.b;
//         let ansC=queryData.c;
//         document.getElementById("quiz").appendChild(quizBlock)
//         document.getElementById("question"+i).innerText=question;
//         document.getElementById("question"+i).appendChild(answerA);
//         document.getElementById("question"+i).appendChild(answerB);
//         document.getElementById("question"+i).appendChild(answerC);
//         document.getElementById("answers"+i).innerText=ansA;
//         document.getElementById("answers"+i).innerText=ansB;
//         document.getElementById("answers"+i).innerText=ansC;
//     });
// }
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
    submitBtn.setAttribute('class', 'btn btn-secondary');
    submitBtn.setAttribute("disabled", true);
    // Add some text to display within the submit button
    submitBtn.innerText = 'Submit Quiz';
    // Add the newly created elements to the body of the page
    buttonDiv.appendChild(submitBtn);
    document.body.prepend(resultsDiv);
    document.body.prepend(buttonDiv);
    document.body.prepend(quizDiv);

    // Add event listeners for validating and grading the quiz
    buttonDiv.addEventListener('mouseenter', isQuizValid);
    submitBtn.addEventListener('click', showResults);

    retrieveQuestions();
};
let quizQuestions=[];
function retrieveQuestions() {
    let xhr=new XMLHttpRequest();
    // communication requires endpoint, verb, optional boolean to specify if you want the request to be completed asynchronously
    xhr.open("GET", "https://api.myjson.com/bins/1cn3jq", true);
    xhr.send();
    xhr.onreadystatechange = function() {
        if(xhr.readyState===4 && xhr.status===200) {
            quizQuestions=JSON.parse(xhr.responseText);
            buildQuiz(quizQuestions);
        }
    }
}
function buildQuiz(questions) {
    console.log(questions);
    let quizBox=document.getElementById("quiz");
    const OUTPUT=[];
    questions.forEach((currentQuestion, index)=>{
        const ANSWERS=[];
        for (let letter in currentQuestion.answers) {
            ANSWERS.push(`
            <label>
            <input type="radio" name="question-${index}" value="${letter}"/>
            <b>${letter}:</b> ${currentQuestion.answers[letter]}
            </label><br/>
            `);
        }
        OUTPUT.push(`
        <br/>
        <div class="question"><strong>${currentQuestion.question}</strong></div>
        <div class="answers">${ANSWERS.join("")}</div>
        `);
    });
    quizBox.innerHTML=OUTPUT.join("");
}
function isQuizValid() {
    let submitBtn=document.getElementById("submit");
    let selectedAnswers=document.querySelectorAll("div.answers>label>input[name^=\"question-\"]:checked");
    let myQuestions=document.querySelectorAll("div.question");
    if(selectedAnswers.length==myQuestions.length) {
        submitBtn.removeAttribute("disabled");
    }
}
function showResults() {
    let resultBox=document.getElementById("results");
    let selectedAnswers=document.querySelectorAll("div.answers>label>input[name^=\"question-\"]:checked");
    let correct=0;
    quizQuestions.forEach((currentQuestion, index) => {
        console.log(selectedAnswers);
        let userAnswer=(selectedAnswers[index] || {}).value;
        let answerLabel=userAnswer.parentElement || {};
        if (userAnswer===currentQuestion.correctAnswer) {
            correct+=1;
            (answerLabel.style||{}).color="green";
        }
        else {
            (answerLabel.style||{}).color="red";
        }
    });
    let userScore=((correct/quizQuestions.length)*100).toFixed(2);
    resultBox.innerText=`${correct} correct out of ${quizQuestions.length}\nFinal score: ${userScore}%`;
}