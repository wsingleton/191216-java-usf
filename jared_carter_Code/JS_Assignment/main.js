
//1
window.onload = function(){
 let googleLink = document.getElementsByName('google')
 googleLink.forEach(element => {
     element.setAttribute('href', 'https://www.google.com/')
     element.innerText = 'GOOGLE'
 })
let twitterLink = document.getElementsByName('twitter')
 twitterLink.forEach(element => {
element.setAttribute('href', 'https://twitter.com')
  element.innerText = 'TWITTER'
 })

  let slackLink = document.getElementsByName('slack')
  slackLink.forEach(element => {  element.setAttribute('href', 'https://slack.com/')
      element.innerText = 'SLACK'
  })


 javadocsLink = document.getElementsByName('javadocs')
      javadocsLink.forEach(element => {
          element.setAttribute('href', 'https://docs.oracle.com/')
          element.innerText = 'JAVADOCS'

})
}
//2
let disablePlutoOption = document.getElementById('planet');
let disablePlanet = disablePlutoOption.children;
disablePlanet[3].setAttribute('disabled', true);
//3
document.getElementById("planet").addEventListener("change",alienText);
//4
//5
//6

function concatAllSpan(){

    let span = document.getElementsByTagName("span")
    spans = " "
    for(let i = 0; i < span.length; i++){
        spans += span [i].innerHTML;
    }

}



//7


document.getElementById("earth_time_check").addEventListener("click", displayEarthTime);

function displayEarthTime(){
var earthDate = new Date();
var currentTime = date.toLocaleTimeString

document.getElementById("earth_time").innerHTML = dt.toLocaleTimeString();
}
//8

//9



//10

function walkTheDom(node, func) {
    var children = node.childNodes;
    for (var i = 0; i < children.length; i++) 
        walk(children[i], func);
    func(node);
 }