window.onload = function(){
document.getElementsByName("#google").addEventListener("click", function(){
    window.location.href = "https://www.google.com";
});

document.getElementsByName("twitter").addEventListener("click", 
    window.open('https://twitter.com/?lang=en', 'blank')
);

document.getElementsByName("slack").addEventListener("click", function(){
    window.open('https://slack.com/', 'blank')
});

document.getElementsByName("javadocs").addEventListener("click", function(){
    window.open('https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html', 'blank')
});

}