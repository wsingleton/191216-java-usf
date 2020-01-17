
// add items


$("#add").on('click', function getItem(){
    event.preventDefault();
    var item = $("#add-item").val().trim();
    var list = $("#items-added");

    function isEmail(email){
        if (email.search("@") == 0){
            alert("Not an email. '@' sign not detected");
        }
         else if(email.indexOf("@") > email.lastIndexOf(".")){
            alert("the '@' sign and '.' not properly aligned");
        }
        else if(Number.isInteger(parseInt(email.substring(email.indexOf("@")+1, email.indexOf("."))))){
            alert("Email domain name can't be a number");
        }
        else if(Number.isInteger(parseInt(email.substring(email.indexOf(".")+1, email.length)))){
            alert("Email signature can't be a number");
        }
        else if(Number.isInteger(parseInt(email.charAt(email.length - 1)))){
            alert("You cant't end an email with numbers");
        }
        else if(!email.includes(".")){
            alert("No dot detected");
        }
        else if(email.charAt(email.length -1) == "."){
            alert("emails can't end with a dot");
        }
        else if(email.includes("/") || email.includes("`") || email.includes("*") || email.includes("+")|| email.includes("=")
        || email.includes("#") || email.includes("\\")){
            alert("Invalid signs detected. Invalid email");
        }
        else{
            alert("Email check passed!");
        }
    }
    isEmail(item);
    console.log(item.substring(item.indexOf("@") +1, item.indexOf(".")));
    // list.append(`<li> ${item}`);
    //item.val("");
    console.log(`Item with value  ${item} was added to the DOM`)
});


