function enableContent(number){
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
