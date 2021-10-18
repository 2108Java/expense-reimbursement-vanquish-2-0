/**
 * 
 */
function getAllEmployee(){
	let employeeUrl= "http://localhost:9303/api/employee";
	//let fullUrl = basedURL + employeeId;
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		//console.log(this.readyState);
		if(this.readyState == 4 && this.status == 200  ){
		
		let employeeArray = JSON.parse(this.responseText);
		console.log(employeeArray);
		addAllEmployees(employeeArray)
		}
		
		}
	xhttp.open("GET", employeeUrl);
	xhttp.send();
	
	
}
let button = document.getElementById("employeeSubmit");
button.addEventListener('click', getAllEmployee);

window.onload=function(){
	getAllEmployee();
	
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
function addAllEmployees(fullObject){
	
	for(let employeeRequest of fullObject){
		addRow(employeeRequest);
	}}
