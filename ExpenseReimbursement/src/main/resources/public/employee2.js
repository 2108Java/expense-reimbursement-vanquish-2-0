/**
 * 
 */

function getStatus(){
	let employeeid= document.getElementById("employeeId").value;
	let basedURL= "http://localhost:9303/api/employee/";
	let fullUrl = basedURL + employeeid;
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		
		if(this.status == 200 && this.readyState == 4){
			//console.log(JSON.parse(this.responseText));
			let employee = JSON.parse(this.responseText);
			employee.id=employeeid;
			console.log(employee);
			
			addRow(employee);
			//addAllEmployees(employee);
		}
	}
	
	xhttp.open("GET",fullUrl);
	
	xhttp.send();
	
	
	
}
let button = document.getElementById("employeeSubmit");


button.addEventListener('click', getStatus);

window.onload=function(){
	
	getStatus();
}
function addRow(employeeRequest){

	
	//console.log(employeeRequest);
	let tableBody = document.getElementById("starTableBody");
	let tableRow = document.createElement("tr");
	
	
	//let IdColumn = document.createElement("td");
	let EmailColumn = document.createElement("td");
    let Reimbursement_typeColumn = document.createElement("td");
    let DescriptionColumn = document.createElement("td");
    let StatusColumn = document.createElement("td");
    let TimeofRequestColumn = document.createElement("td");
    let AmountColumn = document.createElement("td");

    //IdColumn.innerText = employeeRequest.request_id;
    EmailColumn.innerText = employeeRequest.email;
    Reimbursement_typeColumn.innerText = employeeRequest.reimbursment_type;
    DescriptionColumn.innerText = employeeRequest.description;
    StatusColumn.innerText = employeeRequest.status;
    TimeofRequestColumn.innerText = employeeRequest.timeOfRequest;
    AmountColumn.innerText = employeeRequest.amount;
    
    

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