/*
*An addEventListner for a logout button
*/

let button = document.querySelector("#Logout");

button.addEventListener("click", function(){
    document.location.href = 'http://localhost:9000/loginPage';
});