function pagger_Books(id,gap,totalPage,pageIndex)
{
    var container = document.getElementById(id);
    result = '';
    if(pageIndex - gap > 1){
        result += '<li class="page-item"><a class="page-link" href="#">First</a></li>';
    }
    // mới thêm
    if(pageIndex > 1){
        result += '<li class="page-item"><a class="page-link" href="#">Previous</a></li>';
    }
    for(var i = pageIndex - gap; i < pageIndex; i++){
        if(i > 0)
         result += '<li class="page-item"><a class="page-link" href="#">'+i+'</a></li>';
    }
    result += '<span>'+pageIndex+'</span>';
    for(var i = pageIndex + 1; i <= pageIndex + gap; i++){
        if(i <= totalPage)
         result += '<li class="page-item"><a class="page-link" href="#">'+i+'</a></li>';
    }
     // mới thêm
    if(pageIndex < totalPage){
        result += '<li class="page-item"><a class="page-link" href="#">Next</a></li>';
    }
    if(pageIndex + gap < totalPage){
        result += '<li class="page-item"><a class="page-link" href="#">Last</a></li>';
    }
    container.innerHTML = result;
 }


