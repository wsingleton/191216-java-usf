const OUT_DIV=document.getElementById("outer");
const MID_DIV=document.getElementById("mid");
const IN_DIV=document.getElementById("inner");
function innerFunction(e) {
    alert("INNER");
    // e.stopImmediatePropagation();
    // e.stopPropagation();
    eventPrint(e);
}
function innerPrompt(e) {
    prompt("INNER PROMPT");
    eventPrint(e)
}
function middleFunction(e) {
    alert("MIDDLE");
    eventPrint(e);
}
function outerFunction(e) {
    alert("OTTER");
    eventPrint(e);
}
function eventPrint(e) {
    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget);
}
// OUT_DIV.addEventListener("click", outerFunction);
// MID_DIV.addEventListener("click", middleFunction);
// IN_DIV.addEventListener("click", innerFunction);
// OUT_DIV.addEventListener("click", outerFunction,true);
// MID_DIV.addEventListener("click", middleFunction,true);
// IN_DIV.addEventListener("click", innerFunction,true);
// OUT_DIV.addEventListener("click", outerFunction,true);
// MID_DIV.addEventListener("click", middleFunction,true);
// IN_DIV.addEventListener("click", innerFunction);
// OUT_DIV.addEventListener("click", outerFunction);
// MID_DIV.addEventListener("click", middleFunction,true);
// IN_DIV.addEventListener("click", innerFunction);
// OUT_DIV.addEventListener("click", outerFunction);
// MID_DIV.addEventListener("click", middleFunction,true);
// IN_DIV.addEventListener("click", innerFunction,true);
// OUT_DIV.addEventListener("click", outerFunction);
// MID_DIV.addEventListener("click", middleFunction);
// IN_DIV.addEventListener("click", innerFunction,true);
// OUT_DIV.addEventListener("click", outerFunction,true);
// MID_DIV.addEventListener("click", middleFunction);
// IN_DIV.addEventListener("click", innerFunction);
OUT_DIV.addEventListener("click", outerFunction);
MID_DIV.addEventListener("click", middleFunction);
IN_DIV.addEventListener("click", innerFunction);
IN_DIV.addEventListener("click",  innerPrompt);