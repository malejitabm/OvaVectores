
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
	document.getElementById('theory').innerHTML = "";
}

enableContent(1);