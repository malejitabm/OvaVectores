// Fisher–Yates shuffle
function shuffle(array) {
  var currentIndex = array.length, temporaryValue, randomIndex;

  // While there remain elements to shuffle...
  while (0 !== currentIndex) {

    // Pick a remaining element...
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex -= 1;

    // And swap it with the current element.
    temporaryValue = array[currentIndex];
    array[currentIndex] = array[randomIndex];
    array[randomIndex] = temporaryValue;
  }

  return array;
}

function enableContent(number){
	disableVideoContent();
    var elements = document.getElementsByClassName('hidden-content');
    for(var i = 0;i<elements.length;i++){
        if(i == (number-1)){
            elements[i].style.display='block';
        }else{
            elements[i].style.display='none';
        }
    }
    return false;
}
function enableSubItem(number){
    var elements = document.getElementsByClassName('hidden-menu');
    for(var i = 0;i<elements.length;i++){
        if(i == (number-1)){
            if(elements[i].style.display == 'none' || elements[i].style.display == ''){
                elements[i].style.display='block';
            }else{
                elements[i].style.display='none';
            }
        }else{
            elements[i].style.display='none';
        }
    }
    return false;
}

function enableHomeContent(){
	enableContent(1);
	//<iframe width='470' height='402' src=\"http://edpuzzle.com/embed/media/582a8f7774b4fef43e81229f\" frameborder='0' allowfullscreen></iframe>
	document.getElementById('home-video-content').innerHTML = "<iframe width=\"640\" height=\"480\" src=\"https://www.youtube.com/embed/_lelYbs47pw?controls=1\" frameborder='0' allowfullscreen></iframe>";
	return false;
}

function retrieveVideoContent(videoId){
	var xhttp;
	if(window.XMLHttpRequest){
		xhttp = new XMLHttpRequest();
	}else{
		//Code for IE5, IE6
		xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			enableContent(4);
			sendVideoSource(this);
		}
	};
	
	xhttp.open("GET","videoloader?videoId="+videoId,true);
	xhttp.send();
	return false;
}

function retrieveFinal(){
	var xhttp;
	if(window.XMLHttpRequest){
		xhttp = new XMLHttpRequest();;
	}else{
		//Code for IE5, IE6
		xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			enableContent(3);
			sendFinal(this);
		}
	};
	
	xhttp.open("GET","final",true);
	xhttp.send();
	return false;
}

function sendFinal(json){
	var json = JSON.parse(json.responseText);
	var i,j;
	var final = "<form onsubmit='verifyFinal()'><div class='center'><br> <br> <br><h1 class='content-title'>Evaluación Final</h1></div><br>";
	var questionsLength = json.questions.length;
	final +="<div class='questions-container'><ol>";
	for(i = 0;i < questionsLength;i++){
		final += "<li><h3>"+json.questions[i].description+"</h3>";
		var sortOptions = shuffle(json.questions[i].options);
		var optionsLength = sortOptions.length;
		for(j = 0;j<optionsLength;j++){
			final +="<div class='radio-option'><input class='checkbox' type='radio' name="+sortOptions[j].question+" value="+sortOptions[j].id+"> "+sortOptions[j].description+"</input></div>";
		}
		final += "</li>";
		
	}
	final +="</ol></div><div class='center'><button class='login-button' style='margin-bottom:30px;' type='submit' value='Enviar'>Enviar</button></div></form>";
	document.getElementById('final-exam').innerHTML = "";
	document.getElementById('final-exam').innerHTML = final;
}
/*
function sendVideoSource(json){
	var json = JSON.parse(json.responseText);
	var video = "";
	video += "<br><br><br>";
	video += "<h1 class='content-title center'>"+json.title+"</h1>";
	video += "<video id='video-content' width='640px' height='480px' controls><source src="+"\""+json.filename+"\""+" type=\"video/mp4\"/></video>";
	disableVideoContent();
	document.getElementById('theory').innerHTML = video;
}
*/
function sendVideoSource(json){
	var json = JSON.parse(json.responseText);
	var video = "";
	video += "<br><br><br>";
	video += "<h1 class='content-title center'>"+json.title+"</h1>";
	//<iframe width=\"420\" height=\"345\" src=\"https://www.youtube.com/embed/_lelYbs47pw?controls=1\"></iframe>
	video += "<iframe id='video-content' width='640px' height='480px' src="+"\""+json.url+"\""+" frameborder='0' allowfullscreen></iframe>";
	disableVideoContent();
	document.getElementById('theory').innerHTML = video;
}
function disableVideoContent(){
	document.getElementById('home-video-content').innerHTML = "";
	document.getElementById('theory').innerHTML = "";
}

function retrieveCuestionary(subtopic){
	var xhttp;
	if(window.XMLHttpRequest){
		xhttp = new XMLHttpRequest();
	}else{
		//Code for IE5, IE6
		xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			enableContent(5);
			enableCuestionary(this);
		}
	};
	
	xhttp.open("GET","cuestionary?subtopic="+subtopic,true);
	xhttp.send();
	return false;
}

function enableCuestionary(json){
	var json = JSON.parse(json.responseText);
	var i,j;
	
	var cuestionary = "<form onsubmit='verifyCuestionary()'><div class='center'><br> <br> <br><h1 class='content-title'>Cuestionario: " + json.name + "</h1></div><br><div class='center'><p>"+json.description+"</p></div><br>"
	var questionsLength = json.questions.length;
	cuestionary +="<input id='cuestionary' type='hidden' name='cuestionary' value="+json.id+"></input>"
	cuestionary +="<div class='questions-container'><ol>";
	for(i = 0;i < questionsLength;i++){
		cuestionary += "<li><h3>"+json.questions[i].description+"</h3>";
		var sortOptions = shuffle(json.questions[i].options);
		var optionsLength = sortOptions.length;
		for(j = 0;j<optionsLength;j++){
			cuestionary +="<div class='radio-option'><input class='checkbox' type='radio' name="+sortOptions[j].question+" value="+sortOptions[j].id+"> "+sortOptions[j].description+"</input></div>";
		}
		cuestionary += "</li>";
		
	}
	cuestionary +="</ol></div><div class='center'><button class='login-button' style='margin-bottom:30px;' type='submit' value='Enviar'>Enviar</button></div></form>";
	document.getElementById('questions').innerHTML = "";
	document.getElementById('questions').innerHTML = cuestionary;
	
}

function verifyCuestionary(){
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
			showCuestionaryMessage(this);
		}
	};
	var idCuestionary = document.getElementById("cuestionary").value;
	var i;
	var text = "{\"options\":[";
	var options = document.getElementsByClassName("checkbox");
	for(i = 0;i < options.length;i++){
		if(options[i].checked){
			text += "{\"option\":"+options[i].value+",\"question\":"+options[i].name+"},";
		}
	}
	if(options.length > 0){
		text = text.slice(0,-1);
	}
	text += "]}";
	xhttp.open("POST","cuestionary?cuestionary="+idCuestionary+"&answers="+text,true);
	xhttp.send();
}
function showCuestionaryMessage(response){
	if(response.responseText == 'blank'){
		loadAlertMessage("Faltan Preguntas por Responder","#e67e22");
	}else if(response.responseText == 'incorrect'){
		loadAlertMessage("Has Reprobado","#e74c3c");
	}else{
		loadAlertMessage("Has Aprobado","#2ecc71");
	}
}
function verifyFinal(){
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
			showCuestionaryMessage(this);
		}
	};
	var i;
	var text = "{\"options\":[";
	var options = document.getElementsByClassName("checkbox");
	for(i = 0;i < options.length;i++){
		if(options[i].checked){
			text += "{\"option\":"+options[i].value+",\"question\":"+options[i].name+"},";
		}
	}
	if(options.length > 0){
		text = text.slice(0,-1);
	}
	text += "]}";
	xhttp.open("POST","final?answers="+text,true);
	xhttp.send();
}
function retrieveUsers(){
	var xhttp;
	if(window.XMLHttpRequest){
		xhttp = new XMLHttpRequest();
	}else{
		xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			enableContent(3);
			showUsers(this);
		}
	};
	
	xhttp.open("GET","user",true);
	xhttp.send();
	return false;
}
function showUsers(json){
	var json = JSON.parse(json.responseText);
	var i;
	var container = "<br> <br> <br><h1 class='content-title center'>Consultar Estudiante</h1><br><div class='toolbar cloud-background'><select id='checkbox'>";
	var usersLength = json.users.length;
	for(i = 0;i < usersLength;i++){
		container += "<option value="+json.users[i].id+">"+json.users[i].id+" - "+json.users[i].name+"</option>";
	}
	container += "</select><button id='check-button' type='submit' value='Consultar'>Consultar</button></div>";
	document.getElementById('show-history').innerHTML = "";
	document.getElementById('show-history').innerHTML = container;
}

enableHomeContent();