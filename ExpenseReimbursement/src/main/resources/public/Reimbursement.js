/**
 * 
 */
 
// console.log("test from reimbursement");

//this is the ajax portion:
 
 function getRequest(){
	
}


let button = document.getElementById("requestSubmit");

button.addEventListener('click', getAllRequests);


function getAllRequests(){
	let ReimbursementUrl = "http://localhost:9000/Reimbursements";
	
	let xhttp = new XMLHttpRequest();
	
	
	xhttp.open("Get", ReimbursementUrl);
	
	xhttp.send();
	
	xhttp.onreadystatechange = function(){
		
		if(this.readyState == 4 && this.status == 200){
			
			let reimbursementArray = JOSON.parse(this.respnseText);
			
			console.log(reimbursementArray);
		}
	}
	
	
}

function addRows(Request){
	
}


function addAllRequests(RequestsArray){
	
}