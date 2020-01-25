function createReimb(){
    let xhttp = new XMLHttpRequest();
    let amount = document.getElementById('reimb_amount').value;
    let desc = document.getElementById('description').value;
    let receipt = document.getElementById('receipt').value;
    let type = document.getElementById('type').value;
    if(amount && type){
        xhttp.open('POST', 'http://localhost:8080/ers-app/reimb', true);
        let data = JSON.stringify({''})
    }
}