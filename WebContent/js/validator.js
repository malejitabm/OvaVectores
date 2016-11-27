function showAlertMessage(message){
	var alert = document.getElementById('message');
	alert.style.display='block';
	var alertMessage = document.getElementById('alertMessage');
	alertMessage.innerHTML = message;
}