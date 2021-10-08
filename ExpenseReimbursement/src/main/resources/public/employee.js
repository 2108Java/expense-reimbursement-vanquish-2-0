/**
 * 
 */

function getAllEmployee(){
	
	let employeeId= document.getElementById("employeeId").value;
	
	let fullUrl= "http://localhost:9007/api/employee";
	//let fullUrl = basedURL + employeeId;
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(this.status == 200 && this.readyState == 4){
		console.log(this.responseText);
		let fullObject = JSON.parse(this.responseText);
		console.log(fullObject);
		addAllEmployees(fullObject);
            //fullObject.id = employeeId;
             //addRow(fullObject);
		}
		else if(this.status == 404 && this.readyState == 4){
			console.log("The request was not found by the server")
		}}
	xhttp.open("GET", fullUrl);
	xhttp.send();
	
}
// getAllEmployee();

let button = document.getElementById("employeeSubmit");
button.addEventListener('click', getAllEmployee);

window.onload = function(){
	 getAllEmployee();
	
}


function addRow(employeeRequest){
	
	console.log(employeeRequest);
	let tableBody = document.getElementById("starTableBody");
	let tableRow = document.createElement("tr");
	
	let EmailColumn = document.createElement("td");
    let Reimbursement_typeColumn = document.createElement("td");
    let DescriptionColumn = document.createElement("td");
    let StatusColumn = document.createElement("td");
    let TimeofRequestColumn = document.createElement("td");
    let AmountColumn = document.createElement("td");

    EmailColumn.innerText = employeeRequest.email;
    Reimbursement_typeColumn.innerText = employeeRequest.retype;
    DescriptionColumn.innerText = employeeRequest.description;
    StatusColumn.innerText = employeeRequest.status;
    TimeofRequestColumn.innerText = employeeRequest.timeOfRequest;
    AmountColumn.innerText = employeeRequest.amount;
    
    

    //attach the columns to our newly created row 
    tableRow.appendChild(EmailColumn);
    tableRow.appendChild(Reimbursement_typeColumn);
    tableRow.appendChild(DescriptionColumn);
    tableRow.appendChild(StatusColumn);
    tableRow.appendChild(TimeofRequestColumn);
    tableRow.appendChild(AmountColumn);

    //attach the row itself to the table
    tableBody.appendChild(tableRow);
    
}
function addAllEmployees(fullObject){
	
	for(let employeeRequest of fullObject){
		addRow(employeeRequest);
	}}