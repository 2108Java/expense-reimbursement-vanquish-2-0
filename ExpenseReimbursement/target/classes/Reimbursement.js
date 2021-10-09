/**
 * 
 */
 
// console.log("test from reimbursement");

//this is the ajax portion:
 
 function getRequest(){
	
}

//setting communications between html/js and java

let button = document.getElementById("requestSubmit");

button.addEventListener('click', getAllRequests);


//implementation of the callback function inside the eventListner triggered by submit with id "submitRequest"
function getAllRequests(){
	
	let ReimbursementUrl = "http://localhost:9000/ReimbursementRequests/";
	
	let xhttp = new XMLHttpRequest();
	

	xhttp.open("Get", ReimbursementUrl);
	
	xhttp.send();
	
	xhttp.onreadystatechange = function(){
		
		if(this.readyState == 4 && this.status == 200){
			
			let reimbursementArray = JOSON.parse(this.responseText);
			
			//console.log(reimbursementArray);
			
			addAllRequests(reimbursementArray);
		}
	}
	
	
}

//ReimbursementRequest request = new ReimbursementRequest();

function addRow(request){
	
	//appending onto table:
	let tableBody = documetn.getElementById("ReimbursementsTableBody");
	
	//creating a table row
	let tableRow = document.createElement("tr");
	
	//create the columns:
	
	let idColumn = document.createElement("td");
	let requestTypeColumn = document.createElement("td");
	let amountColumn = document.createElement("td");
	let descriptionColumn = document.createElement("td");
	let statusColumn = document.createElement("td");
	let time_of_request_column = document.createElement("td");
	let fk_username_column = document.createElement("td");
	
	
	
	//assigning the "text value" to columns:
	
	idColumn.innerText = Reimursement.id;
	requesTypeColumn.innerText = Request.reimbursementType;
	amountColumn.innerText = request.amount;
	descriptionColumn.innerText = ReimbursementRequest.description;
	statusColumn.innerText = request.status;
	time_of_request_column.innerText = request.timeOfRequest;
	fk_username_column.innerText = request.fk_username;
	
	//attach the columns to the newly created row:
	
	tableRow.appendChild(idColumn);
	tableRow.appendChild(requestTypeColumn);
	tableRow.appendChild(amountColumn);
	tableRow.appendChild(descriptionColumn);
	tableRow.appendChild(statusColumn);
	tableRow.appendChild(time_of_request_column);
	tableRow.appendChild(fk_username_column);
	
	//attach the row to the table:
	
	tableBody.appendChild(tableRow);
		
	
}

function addAllRequests(reimbursementArray){
	for(request of reimbursementArray){
		addRow(request);
	}
}

function addAllRequests(RequestsArray){
	
}