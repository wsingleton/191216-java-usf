window.onload = () => {

    let button = document.createElement('button');
    button.setAttribute('id', 'button');
    button.setAttribute('class', 'btn btn-primary');
    button.innerText = "CLICK HERE DUMMY";

    let p = document.createElement('h1');
    p.setAttribute('id', 'h1');

    document.body.prepend(p);
    document.body.prepend(button);

    button.addEventListener('click', dosomething);
}

function dosomething() {
    let tag = document.getElementById('h1');
    tag.innerText = "You're so smart good job";
}