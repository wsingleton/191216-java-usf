

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