/**
 * 
 */
 
function getRequest(){ //getting a single request

    let requestId = document.getElementById("requestId").value;
    
    let baseUrl = "http://localhost:8000/request/";
    
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
    
    

    let requestsUrl = "http://localhost:8000/requests";
    
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
    let idColumn = document.createElement("td");
    let nameColumn = document.createElement("td");
    let descColumn = document.createElement("td");
    let ringsColumn = document.createElement("td");

    //assigning the "text value" to our columns 

    idColumn.innerText = request.id;
    nameColumn.innerText = request.name;
    descColumn.innerText = request.description;
    ringsColumn.innerText = request.rings;

    //attach the columns to our newly created row 
    tableRow.appendChild(request_idColumn);
    tableRow.appendChild(request_taypeColumn);
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