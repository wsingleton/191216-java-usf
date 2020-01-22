//link : https://api.myjson.com/bins/11v5hy
let answersArray = [];
let elements = [];
window.addEventListener('load', createNewQuestion);
function createNewQuestion(){
    let div = document.createElement("div");
    console.log(document.body);
    let xhttp = new XMLHttpRequest(); 
    xhttp.open("GET", 'https://api.myjson.com/bins/11v5hy', true);
    xhttp.send(); 
    xhttp.onreadystatechange = function() {
        let button = document.createElement("button");
        button.setAttribute("id", "button")
        button.innerText = "Submit";
       if(xhttp.readyState === 4 && xhttp.status === 200){
           let quizObject = JSON.parse(xhttp.responseText);
           //if steps 4 and 5 are succesful, we got our pokemon object
           console.log(quizObject);
           let count = 1;
           quizObject.forEach(element => {
                answersArray.push(element.correctAnswer);
                // let radioItem = document.createElement("input")
                elements.push(element)
                console.log(element.answers);
                let questions = [element.answers["a"], element.answers["b"], element.answers["c"]];
                
                let newElement = document.createElement("p");
                let options = document.createElement("input");
                let form = document.createElement("form");
                options.setAttribute("type", "radio")
                let fieldset = document.createElement("fieldset");
                // let fieldset2 = document.createElement("fieldset");
                // let fieldset3 = document.createElement("fieldset");

                Array(questions.map(e => {
                    let radioItem = document.createElement("input")
                    document.body.appendChild(div)
                    radioItem.setAttribute("name", `${count}`)
                    radioItem.setAttribute("value", e);
                    radioItem.setAttribute("type", "radio");
                    console.log(radioItem);
                    //append order
                    fieldset.setAttribute("name", `${count}`)
                    fieldset.append(radioItem);
                    fieldset.setAttribute("id", count);
                    fieldset.append(document.createElement("span").innerHTML = " ");
                    fieldset.append(document.createElement("p").innerHTML = e);
                    fieldset.append(document.createElement("br"));
                    form.appendChild(fieldset);
                    
                }))
                count++
            
                newElement.innerText = element.question;
                console.log(newElement);
                div.appendChild(newElement);
                div.appendChild(form);
                div.appendChild(document.createElement("br"))
                div.appendChild(button);

                console.log(div);
                console.log(div);
                console.log(document.getElementById("1").children[0]);

           });
       }
    }
    
    
}
let answer = [0,0,0,0, 0,0];

function submitQuiz(e){
    
    console.log(e);
    console.log(e.target.value);
    console.log(e.target.target);
   if(e.target.checked === true){
       answer[parseInt(e.target.name) - 1] = e.target.value;
   }

    console.log(answer);

}



// document.getElementById('button').addEventListener("mouseover", () => {
//     answer.map(e => {
//         if(e === 0){
//         document.getElementById('button').setAttribute("disabled", true);
//         }
//     });
    
// })

window.addEventListener('click', submitQuiz);

window.addEventListener('click', checkQuiz);
function checkQuiz() {
    // answers = [answers]
    invalid = false
    answersArray.map(e => {

        console.log(e);
        if(e === 0){
            invalid = true;
        }
        else {
            // if(e === answers){}
        }
    })


    console.log(answersArray);
}

