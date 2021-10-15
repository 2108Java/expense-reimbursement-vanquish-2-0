/**
 * 
 */
 
function getRequest(){ //getting a single request

    let requestId = document.getElementById("requestId").value;
    
    let baseUrl = "http://localhost:9000/request/";
    
    let fullRequestUrl = baseUrl +requestId;
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function(){
        
        if(this.status == 200 && this.readyState == 4){
            let request = JSON.parse(this.responseText);
            console.log(request);
            
            addRow(request);
        }
    }
    
    xhttp.open("GET",fullRequestUrl);
    
    xhttp.send();
    
}

function getAllRequests(){ //getting all the requests
    
    

    let requestsUrl = "http://localhost:9000/requests";
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function (){ 
        //fat arrow notation does not support "this" keyword
        
        console.log(this.readyState);
        
        if(this.readyState == 4 && this.status == 200){
            
            let requestArray = JSON.parse(this.responseText);
            console.log(requestArray);
            
            addAllRequests(requestArray);
            
        }
    }
    
    xhttp.open("GET",requestsUrl);
    
    xhttp.send();
    
}

let button = document.getElementById("requestSubmit");
button.addEventListener('click',getRequest);

window.onload = function(){

    getAllRequests();
    
//This functions get invoked when the page is loaded in!
}

function addRow(request){
    //Append this onto my table, 
    
   
    let tableBody = document.getElementById("requestTableBody");

    //Creating a table row
    let tableRow = document.createElement("tr");

    //Create the columns
    let requestIdColumn = document.createElement("td");
    let requestTypeColumn = document.createElement("td");
    let amountColumn = document.createElement("td");
    let descriptionColumn = document.createElement("td");
    let requestStatusColumn = document.createElement("td");
    let requestDateColumn = document.createElement("td");
    let fkEmployeeIdColumn = document.createElement("td");

    //assigning the "text value" to our columns 

    requestIdColumn.innerText = request.requestId;
    requestTypeColumn.innerText = request.requestType;
    amountColumn.innerText = request.amount;
    descriptionColumn.innerText = request.description;
    requestStatusColumn.innerText = request.requestStatus;
    requestDateColumn.innerText = request.requestDate;
    fkEmployeeIdColumn.innerText = request.fkEmployeeId;

    //attach the columns to our newly created row 
    tableRow.appendChild(requestIdColumn);
    tableRow.appendChild(requestTypeColumn);
    tableRow.appendChild(amountColumn);
    tableRow.appendChild(descriptionColumn);
    tableRow.appendChild(requestStatusColumn);
    tableRow.appendChild(requestDateColumn);
    tableRow.appendChild(fkEmployeeIdColumn);
    

    //attach the row itself to the table
    tableBody.appendChild(tableRow);
    
}

function addAllRequests(requestArray){
    
    for(let request of requestArray){
        addRow(request);
    }
    
    
}