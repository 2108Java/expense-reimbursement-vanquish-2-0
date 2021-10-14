/**
 * 
 */

function getEmployee(){
	
	let employeeId= document.getElementById("employeeId").value;
	
	let basedURL= "http://localhost:9103/api/employee/";
	let fullUrl = basedURL + employeeId;
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(this.status == 200 && this.readyState == 4){
		console.log(this.responseText);
		let fullObject = JSON.parse(this.responseText);
            fullObject.id = employeeId;
             addRow(fullObject);
		}
		else if(this.status == 404 && this.readyState == 4){
			console.log("The request was not found by the server")
		}}
	xhttp.open("GET", fullUrl);
	xhttp.send();
	
}
 

let button = document.querySelector("#employeeSubmit");
button.addEventListener('click',getEmployee);


function addRow(EmployeeRequest){
	let tableBody = document.getElementById("starTableBody");
	let tableRow = document.createElement("tr");
	
	//let IdColumn = document.createElement("td");
	let EmailColumn = document.createElement("td");
    let Reimbursement_typeColumn = document.createElement("td");
    let DescriptionColumn = document.createElement("td");
    let StatusColumn = document.createElement("td");
    let TimeofRequestColumn = document.createElement("td");
    let AmountColumn = document.createElement("td");

    
    //IdColumn.innerText = EmployeeRequest.request_id;
    EmailColum.innerText = EmployeeRequest.email;
    Reimbursement_typeColumn.innerText = EmployeeRequest.retype;
    DescriptionColumn.innerText = EmployeeRequest.description;
    StatusColumn.innerText = EmployeeRequest.status;
    TimeofRequestColumn.innerText = EmployeeRequest.timeOfRequest;
    AmountColumn.innerText = EmployeeRequest.amount;
    
    

    //attach the columns to our newly created row 
    //tableRow.appendChild(IdColumn);
    tableRow.appendChild(EmailColumn);
    tableRow.appendChild(Reimbursement_typeColumn);
    tableRow.appendChild(DescriptionColumn);
    tableRow.appendChild(StatusColumn);
    tableRow.appendChild(TimeofRequestColumn);
    tableRow.appendChild(AmountColumn);

    //attach the row itself to the table
    tableBody.appendChild(tableRow);
    
}