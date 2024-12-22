function myFunctions() {
var currentDate = new Date();
var timeNow = + currentDate.getHours() + ":"
            + currentDate.getMinutes() + ":"
            + currentDate.getSeconds();
const dataTime = document.getElementById("dataTime").innerHTML = timeNow
}