$(function(){

    $('#login').click(function(){
        var username = $('#username').val();
        var password = $('#password').val();
        console.log('why');

        if(username==''||password==''){
            layer.msg('用户信息不能为空');
        }else{
            var userdata = {
                username:username,
                password:password
            };

            $.ajax({
                url: '/login',
                type: 'POST',
                dataType:'json',
                data:JSON.stringify(userdata),
                contentType: "application/json",
                success:function(result){
                    if(result.status==1){
                      layer.msg(result.message);
                      window.sessionStorage.setItem('username',result.data.username);
                      setTimeout(function(){
                          window.location.href="index.html";
                      },1500);
                    }else{
                      layer.msg(result.message);
                    }
                },
                error:function(){
                    alert("error");
                    layer.msg('登陆失败，请检查网络连接');
                }
              });
        }
    })


})