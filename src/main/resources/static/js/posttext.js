$(function(){

    $('#posttext').click(function(){
        var inputtext = $('#inputtext').val();


        if(inputtext==''){
            alert('输入为空');
        }else{
            var inputdata = {
                input:inputtext
            };

            $.ajax({
                url: '/input',
                type: 'POST',
                dataType:'json',
                data:JSON.stringify(inputdata),
                contentType: "application/json",
                success:function(root){
                    if(root.status==1){
                        var artname = root.data.artname;
                        var artinfo = root.data.artinfo;
                        var artclass = root.data.artclass;
                        $("li.name").append(artname);
                        $("li.info").append(artinfo);
                        $("li.class").append(artclass);
                    }
                    else{
                        window.location.href="login.html";
                    }
                },
                error:function(){
                    alert('识别失败,请联系管理员！');
                }
            });
        }
    })


})