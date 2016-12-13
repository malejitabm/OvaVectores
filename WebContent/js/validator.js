function loadAlertMessage(message,color){
	var element = document.getElementById("message");
	element.innerHTML = "";
	element.innerHTML = "<div class='animated fadeOut alert' style='background-color:"+color+";'><p id='alertMessage' class='alert-message center'>"+message+"</p></div>";
}

function retrieveAccess(){
	event.preventDefault();
	var xhttp;
	if(window.XMLHttpRequest){
		xhttp = new XMLHttpRequest();
	}else{
		//Code for IE5, IE6
		xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			sendAccess(this);
		}
	};
	var username = document.getElementById("username").value;
	console.log(username);
	var password = document.getElementById("password").value;
	console.log(password);
	xhttp.open("POST","login?username="+username+"&password="+password,true);
	xhttp.send();
}
function sendAccess(response){
	
	if(response.responseText == 'n'){
		loadAlertMessage('Datos Invalidos','#e74c3c');
	}else{
		window.location.href = response.responseText;
	}
}