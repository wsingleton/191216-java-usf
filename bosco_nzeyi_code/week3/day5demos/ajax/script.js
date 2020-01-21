// function loadDoc() {
//     let xhttp = new XMLHttpRequest();
//     xhttp.onreadystatechange = function() {
//       if (this.readyState == 4 && this.status == 200) {
//        //document.getElementById("question-field").innerHTML = this.responseText;
//        //console.log(this.responseText);

//        let response = this.response;
//        console.log(response);

//     //    for(let i = 0; i<response.length; i++){
//     //        let questiondiv
//     //    }
//       }
//     };
//     xhttp.open("GET", "https://api.myjson.com/bins/1abiae", true);
//     xhttp.send();
//   }
//   loadDoc();
  //console.log(loadDoc());
//   loadDoc;
//   console.log(loadDoc);
//   let xhttp = new XMLHttpRequest();
//   xhttp.open("GET", "https://api.myjson.com/bins/1abiae", true);
//   xhttp.send();
//   if(xhttp.readyState == 4 && this.status == 200){
//     console.log(xhttp.onload.responseText);
//   } else {
//       console.log("HTTP CALLS FAILED");
//   }
  
window.onload = () =>{

    getQuestions();

    let quizDiv = document.createElement("div");
    let resultDiv = document.createElement("div");
    let buttonDiv = document.createElement("div");
    let submitBtn = document.createElement("button");

    quizDiv.setAttribute("id", "quiz");
    resultDiv.setAttribute("id", "results");
    buttonDiv.setAttribute("id", "button-container");
    submitBtn.setAttribute("class", "btn btn-primary");
    submitBtn.setAttribute("id", "submt");
    submitBtn.innerHTML = "Submit";

    quizDiv.appendChild(resultDiv);
    //resultDiv.appendChild(buttonDiv);
    buttonDiv.prepend(submitBtn);

let resultHTML = document.getElementById("question-field");
resultHTML.appendChild(quizDiv);
//quizDiv.prepend(resultHTML);

function getQuestions(){
    let httpReq = new XMLHttpRequest();
    httpReq.open("GET", "https://api.myjson.com/bins/1abiae", true);
    httpReq.send();

    httpReq.onreadystatechange = function (){

        if(this.readyState == 4 && this.status == 200){
            //console.log(this.responseText);
            let questions = JSON.parse(this.response);
for(let i = 0; i<questions.length; i++){
    let questionAsked = questions[i];

    //for(let j = 0; j<questionAsked; j++){
        let qst = questionAsked.question;
        //console.log(qst);
        let answer1 = questionAsked.answers.a;
        let answer2 = questionAsked.answers.b;
        let answer3 = questionAsked.answers.c;
        console.log(qst);
        console.log(answer1);
        console.log(answer2);
        console.log(answer3);

        //let questionDetails = document.createElement('div');
        let answersDOM = document.createElement("div");
        answersDOM.innerHTML = 
            '<p>'+ qst +'</p>'+
            '<input type = "radio" name = "answer">'+ answer1 + "<br>" +
            '<input type = "radio" name = "answer">'+ answer2 + "<br>" +
            '<input type = "radio" name = "answer">'+ answer3 + "<br>"
        ;
answersDOM.appendChild(buttonDiv);
resultDiv.appendChild(answersDOM);

    //}
    
    // questions[i].forEach(questionAsked => {

    // });
    
    //console.log(questions[i]);

}

            // questionBank.forEach(element => {
            //     let questionDetails = document.createElement("div");
            //     questionDetails.innerHTML = element;
            //     resultDiv.appendChild(questionDetails);
            //     console.log(element);
            // });
        }

    }
}

}


