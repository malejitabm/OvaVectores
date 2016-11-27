
function enableContent(number){
	disableVideoContent()
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
	document.getElementById('home-video-content').innerHTML = "<iframe width='470' height='402' src=\"http://edpuzzle.com/embed/media/582a8f7774b4fef43e81229f\" frameborder='0' allowfullscreen></iframe>";
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

function sendVideoSource(response){
	var filename = response.responseText;
	var video;
	console.log(response.responseText);
	video = "<video id='video-content' width='640px' height='480px' controls><source src="+"\""+filename+"\""+" type=\"video/mp4\"/></video>";
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
	
	var cuestionary = "<form action='cuestionary' method='post'><div class='center'><br> <br> <br><h1 class='content-title'>Cuestionario: " + json.name + "</h1></div><br><div class='center'><p>"+json.description+"</p></div><br>"
	var questionsLength = json.questions.length;
	cuestionary +="<div class='questions-container'><ol>";
	for(i = 0;i < questionsLength;i++){
		cuestionary += "<li><h3>"+json.questions[i].description+"</h3>";
		var optionsLength = json.questions[i].options.length;
		for(j = 0;j<optionsLength;j++){
			cuestionary +="<div class='radio-option'><input type='radio' name="+json.questions[i].options[j].question+" value="+json.questions[i].options[j].id+"> "+json.questions[i].options[j].description+"</input></div>";
		}
		cuestionary += "</li>";
		
	}
	cuestionary +="</ol></div><div class='center'><button class='login-button' style='margin-bottom:30px;' type='submit' value='Enviar'>Enviar</button></div></form>";
	document.getElementById('questions').innerHTML = "";
	document.getElementById('questions').innerHTML = cuestionary;
	
}

enableHomeContent();