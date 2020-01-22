const outerDiv = document.getElementById("outer");
const middleDiv = document.getElementById("middle");
const innerDiv = document.getElementById("inner");

function innerFunction (e) {
    alert('Inner!')

    //no other listeners will be called, neither those attached on the same elements, not those attached to elements which will be traversed later(event specific)
    // e.stopImmediatePropagation();
    //it allows other listeners(chain events will still fire off) that are on the same elements to be called(target specific)
    e.stopPropagation();
    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget)
}

function middleFunction (e) {
    alert('Middle!')
    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget)
}

function outerFunction (e) {
    alert('Outer!')
    console.dir(e.target);
    console.log(e.eventPhase);
    console.dir(e.currentTarget)
}
//default 3rd param will use bubbling(false) could be capturing()
innerDiv.addEventListener("click", innerFunction);
middleDiv.addEventListener("click", middleFunction);
outerDiv.addEventListener("click", outerFunction);