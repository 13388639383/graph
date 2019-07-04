$(function(){
    $('#getfile').click(function(){
            $.ajax({
                url: '/getfile',
                type: 'POST',
                dataType:'json',
                contentType: "application/json",
                success:function(root){
                    if(root.status==1){
                        alert('识别成功！');
                    }
                    else{
                        alert('识别失败,请联系管理员！');
                    }
                },
                error:function(){
                    alert('识别失败,请联系管理员！');
                }
            });
    })


})