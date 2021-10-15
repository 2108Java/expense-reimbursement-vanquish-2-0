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
    let request_idColumn = document.createElement("td");
    let request_typeColumn = document.createElement("td");
    let amountColumn = document.createElement("td");
    let descriptionColumn = document.createElement("td");
    let request_statusColumn = document.createElement("td");
    let request_dateColumn = document.createElement("td");
   

    //assigning the "text value" to our columns 

    request_idColumn.innerText = request.request_id;
    request_typeColumn.innerText = request.request_type;
    amountColumn.innerText = request.amount;
    descriptionColumn.innerText = request.description;
    request_statusColumn.innerText = request.request_status;
    request_dateColumn.innerText = request.request_date;

    //attach the columns to our newly created row 
    tableRow.appendChild(request_idColumn);
    tableRow.appendChild(request_typeColumn);
    tableRow.appendChild(amountColumn);
    tableRow.appendChild(descriptionColumn);
    tableRow.appendChild(request_statusColumn);
    tableRow.appendChild(request_dateColumn);
    

    //attach the row itself to the table
    tableBody.appendChild(tableRow);
    
}

function addAllRequests(requestArray){
    
    for(let request of requestArray){
        addRow(request);
    }
    
    
}