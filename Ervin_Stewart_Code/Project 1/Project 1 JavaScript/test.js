window.onload = function(){addElements();}

function addElements(){
let submitElement = `<button class="btn btn-outline-primary" id="reimbSubmit" >Submit</button>`;
let labelReimbSubmit = document.createElement("label");
            labelReimbSubmit.setAttribute("for", "#reimbSubmit");
            labelReimbSubmit.innerHTML = submitElement;
            

let reimbursementOptionsElement = `
            <select id='newStatus'>
                            <option selected value="3">Pending</option>
                            <option  value="2">Approved</option>
                            <option value="1">Denied</option>
                        </select>
            
            
            `;
            let labelReimbStatus = document.createElement("label");
            labelReimbStatus.setAttribute("for", "select-options");
            labelReimbStatus.innerHTML = reimbursementOptionsElement;
            document.getElementsByTagName('body')[0].append(labelReimbStatus);
            document.getElementsByTagName('body')[0].append(labelReimbSubmit);
            // document.createElement("select");
            // reimbursementOptionsElement.setAttribute('id','newStatus');

            // let pending =  document.createElement('option');
            // pending.setAttribute('value','pending');
            // let pendingText = document.createTextNode("Pending");
            // pending.appendChild(pendingText);
            

            // reimbursementOptionsElement.options[0].appendChild(pending);
            // // denied.innerHTML ="DENIED";
            
            // let bodyElement = document.createElement('p');
            // // bodyElement.appendChild(submitElement);
            // bodyElement.appendChild(reimbursementOptionsElement);

            

            // // pending.innerHTML = "PENDING";
            // let approved =  document.createElement("option");
            // approved.setAttribute('value',"approved");
            // let approvedText = document.createTextNode("APPROVED");
            // approved.appendChild(approvedText);

            // // approved.innerHTML = "APPROVED";
            // let denied = document.createElement("option");
            // denied.setAttribute('value', "1");
            // let deniedText = document.createTextNode("denied");
            // denied.appendChild(deniedText);
            

            // document.getElementById('newStatus').appendChild(pending);
            // document.getElementById('newStatus').appendChild(approved);
            // document.getElementById('newStatus').appendChild(denied);
            
}            
