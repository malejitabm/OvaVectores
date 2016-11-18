
function enableContent(number){
    var elements = document.getElementsByClassName('hidden-content');
    for(var i = 0;i<elements.length;i++){
        if(i == (number-1)){
            elements[i].style.display='inline-block';
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
                elements[i].style.display='inline';
            }else{
                elements[i].style.display='none';
            }
        }else{
            elements[i].style.display='none';
        }
    }
    return false;
}

function retrieveData(){
	var xhttp;
	if(window.XMLHttpRequest){
		xhttp = new XMLHttpRequest();
	}else{
		//Code for IE5, IE6
		xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

enableContent(1);