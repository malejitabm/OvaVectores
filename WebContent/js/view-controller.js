function enableRepo(){
    var repository = document.getElementsByClassName('repository');
    repository[0].style.display = 'inline-block';
    return false;
}

function enableHome(){
    var repository = document.getElementsByClassName('home');
    repository[0].style.display = 'inline-block';
    return false;
}
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
            	console.log("Entre por none");
                elements[i].style.display='inline';
            }else{
            	console.log("Entre por el otro");
                elements[i].style.display='none';
            }
        }else{
            elements[i].style.display='none';
        }
    }
    return false;
}